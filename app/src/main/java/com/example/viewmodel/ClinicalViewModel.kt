package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ai.GeminiClinicalService
import com.example.data.calculator.ClinicalCalculators
import com.example.data.local.AppDatabase
import com.example.data.local.entity.SavedItemEntity
import com.example.data.model.AppThemeMode
import com.example.data.model.ChatMessage
import com.example.data.model.Drug
import com.example.data.model.FontSizeScale
import com.example.data.model.MessageSender
import com.example.data.repository.ClinicalRepository
import com.example.data.repository.SavedItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

enum class NavigationScreen(val title: String) {
    SEARCH("Universal Drug Search"),
    SYSTEM("Browse by Organ System"),
    DISEASE("Disease & Protocols"),
    PHARMACOLOGY_GUIDE("Pharmacology Review & MOA"),
    SAVED("Saved Clinical Favorites"),
    INTERACTION("Drug Interaction Checker"),
    ANTIDOTE("Antidote & Toxicology"),
    CALCULATOR("MDCalc Clinical Suite"),
    GEMINI("Gemini AI Assistant"),
    SETTINGS("App Settings"),
    COMPANIES("Pharmaceutical Companies")
}

enum class SearchMode(val title: String) {
    BRAND("Brand"),
    GENERIC("Generic"),
    INDICATION("Indication"),
    HERBAL("Herbal")
}

enum class DrugFilterType(val label: String) {
    ALL("All"),
    NEPAL("Nepal Brands"),
    INDIA("India Brands"),
    BLACK_BOX("FDA Black Box"),
    BOOKMARKS("Bookmarks")
}

data class ClinicalUiState(
    val currentScreen: NavigationScreen = NavigationScreen.SEARCH,
    val searchQuery: String = "",
    val searchMode: SearchMode = SearchMode.BRAND,
    val activeFilter: DrugFilterType = DrugFilterType.ALL,
    val selectedSystemFilter: String? = null,
    val selectedDrug: Drug? = null,
    val isDrugModalOpen: Boolean = false,
    val recentSearches: List<String> = listOf(
        "Moxclave 625", "Dolo-650", "Pantocid 40", "Azithromycin", "Amlodipine"
    ),
    val savedItems: List<SavedItemEntity> = emptyList(),
    val bookmarkedDrugIds: Set<String> = setOf("d1", "d4"),
    val bookmarkedProtocolIds: Set<String> = setOf("dp1", "dp3"),
    val bookmarkedCalculatorIds: Set<String> = setOf("egfr", "child_pugh"),
    val bookmarkedGuideIds: Set<String> = setOf("pg_insulin", "pg_corticosteroids"),
    val savedSearchQuery: String = "",
    val savedCategoryFilter: String = "All",
    val selectedInteractionDrugIds: Set<String> = setOf("d1", "d5"),
    val patientWeightKg: Double = 60.0,
    // Theme & Settings
    val themeMode: AppThemeMode = AppThemeMode.DARK,
    val fontSizeScale: FontSizeScale = FontSizeScale.NORMAL,
    // Prescriber Profile (Default empty, optional login)
    val isLoggedIn: Boolean = false,
    val doctorName: String = "",
    val doctorDegree: String = "",
    val doctorCouncilNo: String = "",
    val isLoginDialogOpen: Boolean = false,
    val isSidebarOpen: Boolean = false,
    val isCompaniesModalOpen: Boolean = false,
    val filteredDrugs: List<Drug> = emptyList(),
    // Gemini Chat
    val chatMessages: List<ChatMessage> = listOf(
        ChatMessage(
            id = "init_1",
            sender = MessageSender.AI,
            text = "Namaste Doctor! I am your **Gemini AI Clinical Collaborator**. " +
                    "I can assist you with drug-drug interactions, organ dose calculations, " +
                    "toxicology protocols, or international guideline comparisons (UpToDate, Medscape, KD Tripathi). " +
                    "How can I help you today?"
        )
    ),
    val isAiThinking: Boolean = false,
    val aiInputText: String = "",
    // Calculator States
    val activeCalcTab: String = "egfr", // egfr, bsa, child_pugh, rumack, pediatric
    // eGFR inputs
    val egfrAge: Int = 55,
    val egfrWeight: Double = 65.0,
    val egfrScr: Double = 1.2,
    val egfrIsFemale: Boolean = false,
    val egfrResult: ClinicalCalculators.EgfrResult? = null,
    // BSA inputs
    val bsaHeight: Double = 165.0,
    val bsaWeight: Double = 60.0,
    val bsaResult: ClinicalCalculators.BsaResult? = null,
    // Child-Pugh inputs
    val cpBilirubin: Double = 1.5,
    val cpAlbumin: Double = 3.6,
    val cpInr: Double = 1.2,
    val cpAscitesScore: Int = 1,
    val cpEncephScore: Int = 1,
    val cpResult: ClinicalCalculators.ChildPughResult? = null,
    // Paracetamol Nomogram inputs
    val apapHours: Double = 4.0,
    val apapLevel: Double = 160.0,
    val apapResult: ClinicalCalculators.ParacetamolToxicityResult? = null,
    // Pediatric Liquid inputs
    val pedWeight: Double = 14.0,
    val pedDoseMgKg: Double = 15.0,
    val pedSyrupMg: Double = 125.0,
    val pedSyrupMl: Double = 5.0,
    val pedResult: ClinicalCalculators.PediatricDoseResult? = null,
    // CHA2DS2-VASc inputs
    val chadsChf: Boolean = false,
    val chadsHypertension: Boolean = true,
    val chadsAgeGroup: Int = 1, // 0: <65, 1: 65-74, 2: >=75
    val chadsDiabetes: Boolean = true,
    val chadsStrokeTia: Boolean = false,
    val chadsVascular: Boolean = false,
    val chadsIsFemale: Boolean = false,
    val chadsResult: ClinicalCalculators.Cha2Ds2VascResult? = null,
    // CURB-65 inputs
    val curbConfusion: Boolean = false,
    val curbUrea: Boolean = false,
    val curbRespRate: Boolean = true,
    val curbBpLow: Boolean = false,
    val curbAge65: Boolean = true,
    val curbResult: ClinicalCalculators.Curb65Result? = null,
    // GCS inputs
    val gcsEye: Int = 4,
    val gcsVerbal: Int = 5,
    val gcsMotor: Int = 6,
    val gcsResult: ClinicalCalculators.GcsResult? = null
)

class ClinicalViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(ClinicalUiState())
    val uiState: StateFlow<ClinicalUiState> = _uiState.asStateFlow()

    private val appDb: AppDatabase = AppDatabase.getInstance(application.applicationContext)
    private val savedItemRepository: SavedItemRepository = SavedItemRepository(appDb.savedItemDao())

    private var searchJob: Job? = null

    private data class IndexedDrug(
        val drug: Drug,
        val brandIndex: String,
        val genericIndex: String,
        val indicationIndex: String,
        val allIndex: String
    )

    private val indexedDrugs: List<IndexedDrug> by lazy {
        ClinicalRepository.drugs.map { drug ->
            val nepBrands = drug.brandsNepal.joinToString(" ") { "${it.name} ${it.company}" }
            val indBrands = drug.brandsIndia.joinToString(" ") { "${it.name} ${it.company}" }
            val brandText = "$nepBrands $indBrands ${drug.genericName}".lowercase()
            val genericText = "${drug.genericName} ${drug.drugClass}".lowercase()
            val indicationText = drug.indications.lowercase()
            val systemText = drug.system.lowercase()
            val allText = "$brandText $genericText $indicationText $systemText".lowercase()
            IndexedDrug(
                drug = drug,
                brandIndex = brandText,
                genericIndex = genericText,
                indicationIndex = indicationText,
                allIndex = allText
            )
        }
    }

    init {
        // Initialize precomputed drug list
        _uiState.value = _uiState.value.copy(
            filteredDrugs = filterDrugs(
                searchQuery = "",
                searchMode = SearchMode.BRAND,
                activeFilter = DrugFilterType.ALL,
                selectedSystemFilter = null,
                bookmarkedDrugIds = _uiState.value.bookmarkedDrugIds
            )
        )
        // Compute initial calculator results
        computeEgfr()
        computeBsa()
        computeChildPugh()
        computeParacetamol()
        computePediatric()
        computeCha2Ds2Vasc()
        computeCurb65()
        computeGcs()

        // Observe saved items from Room DB reactively
        if (savedItemRepository != null) {
            viewModelScope.launch {
                savedItemRepository.allSavedItems.collect { items ->
                    val drugIds = items.filter { it.itemType == "DRUG" }.map { it.targetId }.toSet()
                    val protocolIds = items.filter { it.itemType == "PROTOCOL" }.map { it.targetId }.toSet()
                    val calcIds = items.filter { it.itemType == "CALCULATOR" }.map { it.targetId }.toSet()
                    val guideIds = items.filter { it.itemType == "GUIDE" }.map { it.targetId }.toSet()

                    _uiState.update { current ->
                        val filtered = filterDrugs(
                            searchQuery = current.searchQuery,
                            searchMode = current.searchMode,
                            activeFilter = current.activeFilter,
                            selectedSystemFilter = current.selectedSystemFilter,
                            bookmarkedDrugIds = if (drugIds.isNotEmpty()) drugIds else current.bookmarkedDrugIds
                        )
                        current.copy(
                            savedItems = items,
                            bookmarkedDrugIds = if (drugIds.isNotEmpty()) drugIds else current.bookmarkedDrugIds,
                            bookmarkedProtocolIds = if (protocolIds.isNotEmpty()) protocolIds else current.bookmarkedProtocolIds,
                            bookmarkedCalculatorIds = if (calcIds.isNotEmpty()) calcIds else current.bookmarkedCalculatorIds,
                            bookmarkedGuideIds = if (guideIds.isNotEmpty()) guideIds else current.bookmarkedGuideIds,
                            filteredDrugs = filtered
                        )
                    }

                    if (items.isEmpty()) {
                        seedDefaultFavorites()
                    }
                }
            }
        }
    }

    private fun seedDefaultFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            savedItemRepository?.let { repo ->
                ClinicalRepository.drugs.find { it.id == "d1" }?.let { drug ->
                    val brand = drug.brandsNepal.firstOrNull()?.name ?: drug.brandsIndia.firstOrNull()?.name ?: drug.genericName
                    repo.saveItem(
                        SavedItemEntity(
                            id = "drug_d1",
                            itemType = "DRUG",
                            targetId = "d1",
                            title = drug.genericName,
                            subtitle = "$brand • ${drug.drugClass}",
                            category = drug.system
                        )
                    )
                }
                ClinicalRepository.drugs.find { it.id == "d4" }?.let { drug ->
                    val brand = drug.brandsNepal.firstOrNull()?.name ?: drug.brandsIndia.firstOrNull()?.name ?: drug.genericName
                    repo.saveItem(
                        SavedItemEntity(
                            id = "drug_d4",
                            itemType = "DRUG",
                            targetId = "d4",
                            title = drug.genericName,
                            subtitle = "$brand • Analgesic & Antipyretic",
                            category = drug.system
                        )
                    )
                }
                ClinicalRepository.diseaseProtocols.find { it.id == "dp1" }?.let { proto ->
                    repo.saveItem(
                        SavedItemEntity(
                            id = "protocol_dp1",
                            itemType = "PROTOCOL",
                            targetId = "dp1",
                            title = proto.name,
                            subtitle = proto.firstLine.take(80) + "...",
                            category = proto.category
                        )
                    )
                }
                repo.saveItem(
                    SavedItemEntity(
                        id = "calc_egfr",
                        itemType = "CALCULATOR",
                        targetId = "egfr",
                        title = "eGFR (Cockcroft-Gault CrCl)",
                        subtitle = "Renal clearance & organ dose titration formula",
                        category = "Nephrology / Dosing"
                    )
                )
                repo.saveItem(
                    SavedItemEntity(
                        id = "guide_pg_insulin",
                        itemType = "GUIDE",
                        targetId = "pg_insulin",
                        title = "Insulin Preparations & Anti-Diabetic Agents",
                        subtitle = "Onset, duration, pH 4.0 rule & oral classes",
                        category = "Endocrinology"
                    )
                )
                repo.saveItem(
                    SavedItemEntity(
                        id = "guide_pg_corticosteroids",
                        itemType = "GUIDE",
                        targetId = "pg_corticosteroids",
                        title = "Corticosteroids & Synthesis Inhibitors",
                        subtitle = "Potency spectrum, GLUCOCORTICOIDS mnemonic & inhibitors",
                        category = "Endocrinology"
                    )
                )
            }
        }
    }

    fun navigateTo(screen: NavigationScreen) {
        _uiState.value = _uiState.value.copy(currentScreen = screen)
    }

    fun updateSearchQuery(query: String) {
        // Immediate UI feedback on the search text field
        _uiState.update { it.copy(searchQuery = query) }

        // Cancel previous search and filter on background coroutine
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.Default) {
            if (query.isNotBlank()) {
                delay(120) // Smooth debounce for fast keystrokes
            }
            val current = _uiState.value
            val filtered = filterDrugs(
                searchQuery = current.searchQuery,
                searchMode = current.searchMode,
                activeFilter = current.activeFilter,
                selectedSystemFilter = current.selectedSystemFilter,
                bookmarkedDrugIds = current.bookmarkedDrugIds
            )
            _uiState.update { it.copy(filteredDrugs = filtered) }
        }
    }

    fun setFilter(filter: DrugFilterType) {
        val current = _uiState.value
        val filtered = filterDrugs(
            searchQuery = current.searchQuery,
            searchMode = current.searchMode,
            activeFilter = filter,
            selectedSystemFilter = null,
            bookmarkedDrugIds = current.bookmarkedDrugIds
        )
        _uiState.update {
            it.copy(
                activeFilter = filter,
                selectedSystemFilter = null,
                filteredDrugs = filtered
            )
        }
    }

    fun filterBySystem(systemName: String) {
        val current = _uiState.value
        val sysFilter = if (systemName == "All Systems") null else systemName
        val filtered = filterDrugs(
            searchQuery = "",
            searchMode = current.searchMode,
            activeFilter = DrugFilterType.ALL,
            selectedSystemFilter = sysFilter,
            bookmarkedDrugIds = current.bookmarkedDrugIds
        )
        _uiState.update {
            it.copy(
                currentScreen = NavigationScreen.SEARCH,
                selectedSystemFilter = sysFilter,
                activeFilter = DrugFilterType.ALL,
                searchQuery = "",
                filteredDrugs = filtered
            )
        }
    }

    fun addRecentSearch(query: String) {
        val trimmed = query.trim()
        if (trimmed.isEmpty()) return
        val currentList = _uiState.value.recentSearches
        val updatedList = listOf(trimmed) + currentList.filterNot { it.equals(trimmed, ignoreCase = true) }
        _uiState.value = _uiState.value.copy(
            recentSearches = updatedList.take(5)
        )
    }

    fun openDrug(drug: Drug) {
        val drugLabel = drug.brandsNepal.firstOrNull()?.name
            ?: drug.brandsIndia.firstOrNull()?.name
            ?: drug.genericName
        addRecentSearch(drugLabel)
        _uiState.value = _uiState.value.copy(
            selectedDrug = drug,
            isDrugModalOpen = true
        )
    }

    fun closeDrugModal() {
        _uiState.value = _uiState.value.copy(isDrugModalOpen = false)
    }

    fun toggleBookmarkDrug(drugId: String) {
        val drug = ClinicalRepository.drugs.find { it.id == drugId } ?: return
        val brand = drug.brandsNepal.firstOrNull()?.name ?: drug.brandsIndia.firstOrNull()?.name ?: drug.genericName
        val repo = savedItemRepository
        if (repo != null) {
            viewModelScope.launch(Dispatchers.IO) {
                repo.toggleSave(
                    id = "drug_$drugId",
                    itemType = "DRUG",
                    targetId = drugId,
                    title = drug.genericName,
                    subtitle = "$brand • ${drug.drugClass}",
                    category = drug.system
                )
            }
        } else {
            val current = _uiState.value.bookmarkedDrugIds.toMutableSet()
            if (current.contains(drugId)) {
                current.remove(drugId)
            } else {
                current.add(drugId)
            }
            val curState = _uiState.value
            val filtered = filterDrugs(
                searchQuery = curState.searchQuery,
                searchMode = curState.searchMode,
                activeFilter = curState.activeFilter,
                selectedSystemFilter = curState.selectedSystemFilter,
                bookmarkedDrugIds = current
            )
            _uiState.update {
                it.copy(
                    bookmarkedDrugIds = current,
                    filteredDrugs = filtered
                )
            }
        }
    }

    fun toggleBookmark(drugId: String) {
        toggleBookmarkDrug(drugId)
    }

    fun toggleBookmarkProtocol(protocolId: String) {
        val proto = ClinicalRepository.diseaseProtocols.find { it.id == protocolId } ?: return
        val repo = savedItemRepository
        if (repo != null) {
            viewModelScope.launch(Dispatchers.IO) {
                repo.toggleSave(
                    id = "protocol_$protocolId",
                    itemType = "PROTOCOL",
                    targetId = protocolId,
                    title = proto.name,
                    subtitle = proto.firstLine.take(85) + "...",
                    category = proto.category
                )
            }
        } else {
            val current = _uiState.value.bookmarkedProtocolIds.toMutableSet()
            if (current.contains(protocolId)) {
                current.remove(protocolId)
            } else {
                current.add(protocolId)
            }
            _uiState.update { it.copy(bookmarkedProtocolIds = current) }
        }
    }

    fun toggleBookmarkCalculator(calcKey: String) {
        val (title, sub, cat) = when (calcKey) {
            "egfr" -> Triple("eGFR (Cockcroft-Gault CrCl)", "Renal clearance & organ dose titration formula", "Nephrology / Dosing")
            "bsa" -> Triple("Body Surface Area (BSA - Mosteller)", "Chemotherapy & fluid dosing standard", "Oncology / ICU")
            "child_pugh" -> Triple("Child-Pugh Score for Cirrhosis", "Severity of chronic liver disease & hepatic dosing", "Hepatology")
            "cha2ds2" -> Triple("CHA₂DS₂-VASc AFib Stroke Risk", "Atrial fibrillation thromboembolic risk score", "Cardiology")
            "curb65" -> Triple("CURB-65 Pneumonia Severity", "Mortality risk & inpatient/ICU stratification", "Pulmonology")
            "gcs" -> Triple("Glasgow Coma Scale (GCS)", "Acute neurological assessment & coma scale", "Neurology / Trauma")
            "rumack" -> Triple("Paracetamol Rumack-Matthew Nomogram", "Acute acetaminophen toxicity 4h-24h risk", "Toxicology")
            "pediatric" -> Triple("Pediatric Liquid Dose Calculator", "Weight-based suspension & drop dosing", "Pediatrics")
            else -> Triple("Clinical Calculator ($calcKey)", "Evidence-based formula", "Clinical Tools")
        }
        val repo = savedItemRepository
        if (repo != null) {
            viewModelScope.launch(Dispatchers.IO) {
                repo.toggleSave(
                    id = "calc_$calcKey",
                    itemType = "CALCULATOR",
                    targetId = calcKey,
                    title = title,
                    subtitle = sub,
                    category = cat
                )
            }
        } else {
            val current = _uiState.value.bookmarkedCalculatorIds.toMutableSet()
            if (current.contains(calcKey)) {
                current.remove(calcKey)
            } else {
                current.add(calcKey)
            }
            _uiState.update { it.copy(bookmarkedCalculatorIds = current) }
        }
    }

    fun toggleBookmarkGuide(guideId: String) {
        val guide = com.example.data.repository.PharmacologyReviewData.guides.find { it.id == guideId } ?: return
        val repo = savedItemRepository
        if (repo != null) {
            viewModelScope.launch(Dispatchers.IO) {
                repo.toggleSave(
                    id = "guide_$guideId",
                    itemType = "GUIDE",
                    targetId = guideId,
                    title = guide.title,
                    subtitle = guide.subtitle.take(85) + "...",
                    category = guide.category
                )
            }
        } else {
            val current = _uiState.value.bookmarkedGuideIds.toMutableSet()
            if (current.contains(guideId)) {
                current.remove(guideId)
            } else {
                current.add(guideId)
            }
            _uiState.update { it.copy(bookmarkedGuideIds = current) }
        }
    }

    fun removeSavedItem(id: String) {
        val repo = savedItemRepository
        if (repo != null) {
            viewModelScope.launch(Dispatchers.IO) {
                repo.removeItem(id)
            }
        } else {
            _uiState.update { it.copy(savedItems = it.savedItems.filterNot { item -> item.id == id }) }
        }
    }

    fun clearAllSaved() {
        val repo = savedItemRepository
        if (repo != null) {
            viewModelScope.launch(Dispatchers.IO) {
                repo.clearAll()
            }
        } else {
            _uiState.update {
                it.copy(
                    savedItems = emptyList(),
                    bookmarkedDrugIds = emptySet(),
                    bookmarkedProtocolIds = emptySet(),
                    bookmarkedCalculatorIds = emptySet(),
                    bookmarkedGuideIds = emptySet()
                )
            }
        }
    }

    fun setSavedSearchQuery(query: String) {
        _uiState.update { it.copy(savedSearchQuery = query) }
    }

    fun setSavedCategoryFilter(category: String) {
        _uiState.update { it.copy(savedCategoryFilter = category) }
    }

    fun openSavedItem(item: SavedItemEntity) {
        when (item.itemType) {
            "DRUG" -> {
                val drug = ClinicalRepository.drugs.find { it.id == item.targetId }
                if (drug != null) {
                    openDrug(drug)
                }
            }
            "PROTOCOL" -> {
                navigateTo(NavigationScreen.DISEASE)
            }
            "CALCULATOR" -> {
                setCalcTab(item.targetId)
                navigateTo(NavigationScreen.CALCULATOR)
            }
            "GUIDE" -> {
                navigateTo(NavigationScreen.PHARMACOLOGY_GUIDE)
            }
        }
    }

    fun setSearchMode(mode: SearchMode) {
        val current = _uiState.value
        val filtered = filterDrugs(
            searchQuery = current.searchQuery,
            searchMode = mode,
            activeFilter = current.activeFilter,
            selectedSystemFilter = current.selectedSystemFilter,
            bookmarkedDrugIds = current.bookmarkedDrugIds
        )
        _uiState.update {
            it.copy(
                searchMode = mode,
                filteredDrugs = filtered
            )
        }
    }

    fun toggleInteractionDrug(drugId: String) {
        val current = _uiState.value.selectedInteractionDrugIds.toMutableSet()
        if (current.contains(drugId)) {
            current.remove(drugId)
        } else {
            current.add(drugId)
        }
        _uiState.value = _uiState.value.copy(selectedInteractionDrugIds = current)
    }

    fun clearInteractionDrugs() {
        _uiState.value = _uiState.value.copy(selectedInteractionDrugIds = emptySet())
    }

    fun updatePatientWeight(weight: Double) {
        if (weight > 0) {
            _uiState.value = _uiState.value.copy(patientWeightKg = weight)
        }
    }

    // Theme & Setting Controls
    fun setThemeMode(mode: AppThemeMode) {
        _uiState.value = _uiState.value.copy(themeMode = mode)
    }

    fun setFontSizeScale(scale: FontSizeScale) {
        _uiState.value = _uiState.value.copy(fontSizeScale = scale)
    }

    // Practitioner Authentication / Profile
    fun openLoginDialog() {
        _uiState.value = _uiState.value.copy(isLoginDialogOpen = true)
    }

    fun closeLoginDialog() {
        _uiState.value = _uiState.value.copy(isLoginDialogOpen = false)
    }

    fun loginOrUpdateProfile(name: String, degree: String, councilNo: String) {
        _uiState.value = _uiState.value.copy(
            isLoggedIn = true,
            doctorName = name.trim(),
            doctorDegree = degree.trim(),
            doctorCouncilNo = councilNo.trim(),
            isLoginDialogOpen = false
        )
    }

    fun logout() {
        _uiState.value = _uiState.value.copy(
            isLoggedIn = false,
            doctorName = "",
            doctorDegree = "",
            doctorCouncilNo = "",
            isLoginDialogOpen = false
        )
    }

    // Sidebar Drawer Controls
    fun openSidebar() {
        _uiState.value = _uiState.value.copy(isSidebarOpen = true)
    }

    fun closeSidebar() {
        _uiState.value = _uiState.value.copy(isSidebarOpen = false)
    }

    fun toggleSidebar() {
        _uiState.value = _uiState.value.copy(isSidebarOpen = !_uiState.value.isSidebarOpen)
    }

    fun openCompaniesModal() {
        _uiState.value = _uiState.value.copy(isCompaniesModalOpen = true, isSidebarOpen = false)
    }

    fun closeCompaniesModal() {
        _uiState.value = _uiState.value.copy(isCompaniesModalOpen = false)
    }

    fun updateDoctorProfile(name: String, nmc: String) {
        loginOrUpdateProfile(name = name, degree = _uiState.value.doctorDegree, councilNo = nmc)
    }

    // Gemini Chat
    fun updateAiInput(text: String) {
        _uiState.value = _uiState.value.copy(aiInputText = text)
    }

    fun sendAiMessage(promptText: String? = null) {
        val text = (promptText ?: _uiState.value.aiInputText).trim()
        if (text.isBlank() || _uiState.value.isAiThinking) return

        val userMsg = ChatMessage(id = UUID.randomUUID().toString(), sender = MessageSender.USER, text = text)
        val updatedMsgs = _uiState.value.chatMessages + userMsg

        _uiState.value = _uiState.value.copy(
            chatMessages = updatedMsgs,
            aiInputText = "",
            isAiThinking = true
        )

        viewModelScope.launch {
            val responseText = GeminiClinicalService.queryClinicalAi(text)
            val aiMsg = ChatMessage(id = UUID.randomUUID().toString(), sender = MessageSender.AI, text = responseText)
            _uiState.value = _uiState.value.copy(
                chatMessages = _uiState.value.chatMessages + aiMsg,
                isAiThinking = false
            )
        }
    }

    fun clearChat() {
        _uiState.value = _uiState.value.copy(
            chatMessages = listOf(
                ChatMessage(
                    id = "init_reset",
                    sender = MessageSender.AI,
                    text = "Namaste Doctor! Gemini Clinical AI ready. Select a clinical module or type any clinical question."
                )
            ),
            aiInputText = "",
            isAiThinking = false
        )
    }

    // Calculators
    fun setCalcTab(tab: String) {
        _uiState.value = _uiState.value.copy(activeCalcTab = tab)
    }

    fun updateEgfrInputs(age: Int, weight: Double, scr: Double, isFemale: Boolean) {
        _uiState.value = _uiState.value.copy(
            egfrAge = age,
            egfrWeight = weight,
            egfrScr = scr,
            egfrIsFemale = isFemale
        )
        computeEgfr()
    }

    private fun computeEgfr() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculateEgfr(s.egfrAge, s.egfrWeight, s.egfrScr, s.egfrIsFemale)
        _uiState.value = _uiState.value.copy(egfrResult = res)
    }

    fun updateBsaInputs(height: Double, weight: Double) {
        _uiState.value = _uiState.value.copy(bsaHeight = height, bsaWeight = weight)
        computeBsa()
    }

    private fun computeBsa() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculateBsa(s.bsaHeight, s.bsaWeight)
        _uiState.value = _uiState.value.copy(bsaResult = res)
    }

    fun updateChildPughInputs(bili: Double, alb: Double, inr: Double, ascites: Int, enceph: Int) {
        _uiState.value = _uiState.value.copy(
            cpBilirubin = bili,
            cpAlbumin = alb,
            cpInr = inr,
            cpAscitesScore = ascites,
            cpEncephScore = enceph
        )
        computeChildPugh()
    }

    private fun computeChildPugh() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculateChildPugh(s.cpBilirubin, s.cpAlbumin, s.cpInr, s.cpAscitesScore, s.cpEncephScore)
        _uiState.value = _uiState.value.copy(cpResult = res)
    }

    fun updateParacetamolInputs(hours: Double, level: Double) {
        _uiState.value = _uiState.value.copy(apapHours = hours, apapLevel = level)
        computeParacetamol()
    }

    private fun computeParacetamol() {
        val s = _uiState.value
        val res = ClinicalCalculators.evaluateParacetamolOverdose(s.apapHours, s.apapLevel)
        _uiState.value = _uiState.value.copy(apapResult = res)
    }

    fun updatePediatricInputs(weight: Double, doseMgKg: Double, syrupMg: Double, syrupMl: Double) {
        _uiState.value = _uiState.value.copy(
            pedWeight = weight,
            pedDoseMgKg = doseMgKg,
            pedSyrupMg = syrupMg,
            pedSyrupMl = syrupMl
        )
        computePediatric()
    }

    private fun computePediatric() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculatePediatricLiquidDose(s.pedWeight, s.pedDoseMgKg, s.pedSyrupMg, s.pedSyrupMl)
        _uiState.value = _uiState.value.copy(pedResult = res)
    }

    // CHA2DS2-VASc
    fun updateCha2Ds2VascInputs(
        chf: Boolean,
        hypertension: Boolean,
        ageGroup: Int,
        diabetes: Boolean,
        strokeTia: Boolean,
        vascular: Boolean,
        isFemale: Boolean
    ) {
        _uiState.value = _uiState.value.copy(
            chadsChf = chf,
            chadsHypertension = hypertension,
            chadsAgeGroup = ageGroup,
            chadsDiabetes = diabetes,
            chadsStrokeTia = strokeTia,
            chadsVascular = vascular,
            chadsIsFemale = isFemale
        )
        computeCha2Ds2Vasc()
    }

    private fun computeCha2Ds2Vasc() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculateCha2Ds2Vasc(
            chf = s.chadsChf,
            hypertension = s.chadsHypertension,
            ageGroup = s.chadsAgeGroup,
            diabetes = s.chadsDiabetes,
            strokeTiaThromboembolism = s.chadsStrokeTia,
            vascularDisease = s.chadsVascular,
            isFemale = s.chadsIsFemale
        )
        _uiState.value = _uiState.value.copy(chadsResult = res)
    }

    // CURB-65
    fun updateCurb65Inputs(
        confusion: Boolean,
        urea: Boolean,
        respRate: Boolean,
        bpLow: Boolean,
        age65: Boolean
    ) {
        _uiState.value = _uiState.value.copy(
            curbConfusion = confusion,
            curbUrea = urea,
            curbRespRate = respRate,
            curbBpLow = bpLow,
            curbAge65 = age65
        )
        computeCurb65()
    }

    private fun computeCurb65() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculateCurb65(
            confusion = s.curbConfusion,
            ureaElevated = s.curbUrea,
            respRateElevated = s.curbRespRate,
            bloodPressureLow = s.curbBpLow,
            age65OrOlder = s.curbAge65
        )
        _uiState.value = _uiState.value.copy(curbResult = res)
    }

    // GCS
    fun updateGcsInputs(eye: Int, verbal: Int, motor: Int) {
        _uiState.value = _uiState.value.copy(
            gcsEye = eye,
            gcsVerbal = verbal,
            gcsMotor = motor
        )
        computeGcs()
    }

    private fun computeGcs() {
        val s = _uiState.value
        val res = ClinicalCalculators.calculateGcs(
            eye = s.gcsEye,
            verbal = s.gcsVerbal,
            motor = s.gcsMotor
        )
        _uiState.value = _uiState.value.copy(gcsResult = res)
    }

    fun getFilteredDrugs(): List<Drug> {
        return _uiState.value.filteredDrugs
    }

    private fun filterDrugs(
        searchQuery: String,
        searchMode: SearchMode,
        activeFilter: DrugFilterType,
        selectedSystemFilter: String?,
        bookmarkedDrugIds: Set<String>
    ): List<Drug> {
        val q = searchQuery.trim().lowercase()

        return indexedDrugs.asSequence().filter { item ->
            val drug = item.drug

            val matchesFilter = when (activeFilter) {
                DrugFilterType.ALL -> true
                DrugFilterType.NEPAL -> drug.brandsNepal.isNotEmpty()
                DrugFilterType.INDIA -> drug.brandsIndia.isNotEmpty()
                DrugFilterType.BLACK_BOX -> drug.blackBoxWarning != null
                DrugFilterType.BOOKMARKS -> bookmarkedDrugIds.contains(drug.id)
            }
            if (!matchesFilter) return@filter false

            val matchesSystem = if (selectedSystemFilter == null) true else {
                drug.system.equals(selectedSystemFilter, ignoreCase = true)
            }
            if (!matchesSystem) return@filter false

            if (q.isEmpty()) return@filter true

            when (searchMode) {
                SearchMode.BRAND -> item.brandIndex.contains(q)
                SearchMode.GENERIC -> item.genericIndex.contains(q)
                SearchMode.INDICATION -> item.indicationIndex.contains(q)
                SearchMode.HERBAL -> item.allIndex.contains(q)
            }
        }.map { it.drug }.toList()
    }
}
