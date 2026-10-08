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
import com.example.data.model.CalculatorSummary
import com.example.data.model.ChatMessage
import com.example.data.model.DiseaseProtocol
import com.example.data.model.Drug
import com.example.data.model.FontSizeScale
import com.example.data.model.GlobalSearchTab
import com.example.data.model.GroundingSource
import com.example.data.model.MedicalNewsItem
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
    CALCULATOR("Cal"),
    GEMINI("Gemini AI Assistant"),
    SETTINGS("App Settings"),
    COMPANIES("Pharmaceutical Companies"),
    MEDICAL_NEWS("Clinical Guidelines & Medical News"),
    CODE_BLUE("Emergency Resuscitation & Code Blue"),
    ANTIMICROBIAL_STEWARDSHIP("Antimicrobial & Stewardship Guide"),
    IV_COMPATIBILITY("IV Dilution & Y-Site Compatibility"),
    RENAL_ADJUSTER("Renal Dose Auto-Calculator"),
    ABG_ELECTROLYTE_SOLVER("ABG & Electrolyte Disturbance Solver"),
    ANESTHESIOLOGY("Anesthesiology & Perioperative"),
    CRITICAL_CARE("Critical Care & Emergency Dashboard"),
    SURGICAL_PREOP("Surgical Pre-Op Drug Clearance & Bridge"),
    LAB_VALUES("Critical Lab Values & Diagnostic Ratios")
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
    DDA_SCHEDULE_KA("🇳🇵 DDA Sch 'Ka' (क)"),
    FREE_HEALTH_POST("🏥 Free Govt Drugs (नि:शुल्क)"),
    EMPTY_STOMACH("🟡 Empty Stomach (खाली पेट)"),
    WITH_MEALS("🟢 With Meals (खानासँगै)"),
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
    val selectedProtocol: DiseaseProtocol? = null,
    val diseaseTab: Int = 1, // 0 = A-Z Indications, 1 = Clinical Protocols
    val selectedCalculatorId: String? = null,
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
    val themeMode: AppThemeMode = AppThemeMode.PITCH_BLACK,
    val fontSizeScale: FontSizeScale = FontSizeScale.NORMAL,
    // Prescriber Profile (Default empty, optional login)
    val isLoggedIn: Boolean = false,
    val doctorName: String = "",
    val doctorDegree: String = "",
    val doctorCollege: String = "",
    val doctorCouncilNo: String = "",
    val doctorMobile: String = "",
    val doctorPhotoAvatar: String = "👨‍⚕️",
    val isLoginDialogOpen: Boolean = false,
    val isSidebarOpen: Boolean = false,
    val isCompaniesModalOpen: Boolean = false,
    val filteredDrugs: List<Drug> = emptyList(),
    val filteredProtocols: List<DiseaseProtocol> = emptyList(),
    val filteredCalculators: List<CalculatorSummary> = emptyList(),
    val globalSearchTab: GlobalSearchTab = GlobalSearchTab.ALL,
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
    val aiSelectedModel: String = "gemini-3.5-flash",
    val isAiSearchGrounded: Boolean = true,
    // Nepal Medical News & Alerts with Search Grounding
    val medicalNewsList: List<MedicalNewsItem> = emptyList(),
    val isNewsLoading: Boolean = false,
    val newsCategoryFilter: String = "All",
    val newsSearchQueries: List<String> = emptyList(),
    val newsGroundingSources: List<GroundingSource> = emptyList(),
    val isNewsLiveGrounding: Boolean = false,
    val selectedNewsItem: MedicalNewsItem? = null,
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
    private val profilePrefs = application.getSharedPreferences("practitioner_profile_prefs", android.content.Context.MODE_PRIVATE)

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
            val genericText = "${drug.genericName} ${drug.drugClass} ${drug.specialInstructions} ${drug.researchNotes}".lowercase()
            val indicationText = drug.indications.lowercase()
            val systemText = drug.system.lowercase()
            val allText = "$brandText $genericText $indicationText $systemText ${drug.modeOfAction} ${drug.therapeuticClassTag}".lowercase()
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
        // Load saved practitioner profile from SharedPreferences
        val savedLoggedIn = profilePrefs.getBoolean("is_logged_in", false)
        val savedName = profilePrefs.getString("doc_name", "") ?: ""
        val savedDegree = profilePrefs.getString("doc_degree", "") ?: ""
        val savedCollege = profilePrefs.getString("doc_college", "") ?: ""
        val savedCouncil = profilePrefs.getString("doc_council", "") ?: ""
        val savedMobile = profilePrefs.getString("doc_mobile", "") ?: ""
        val savedAvatar = profilePrefs.getString("doc_avatar", "👨‍⚕️") ?: "👨‍⚕️"

        if (savedLoggedIn) {
            _uiState.update {
                it.copy(
                    isLoggedIn = true,
                    doctorName = savedName,
                    doctorDegree = savedDegree,
                    doctorCollege = savedCollege,
                    doctorCouncilNo = savedCouncil,
                    doctorMobile = savedMobile,
                    doctorPhotoAvatar = savedAvatar
                )
            }
        }

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
        fetchMedicalNews(false)

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
        _uiState.update {
            it.copy(
                currentScreen = screen,
                selectedProtocol = if (screen != NavigationScreen.DISEASE) null else it.selectedProtocol,
                selectedCalculatorId = if (screen != NavigationScreen.CALCULATOR) null else it.selectedCalculatorId,
                isDrugModalOpen = if (screen == NavigationScreen.SEARCH) false else it.isDrugModalOpen
            )
        }
    }

    fun openProtocol(protocol: DiseaseProtocol) {
        _uiState.update { it.copy(selectedProtocol = protocol, diseaseTab = 1) }
    }

    fun setDiseaseTab(tab: Int) {
        _uiState.update { it.copy(diseaseTab = tab) }
    }

    fun closeProtocol() {
        _uiState.update { it.copy(selectedProtocol = null) }
    }

    fun consultAiForIndication(indicationName: String) {
        val prompt = "Provide clinical pharmacology and guideline-directed treatment protocol for: $indicationName. Include first-line drugs, standard dosing, alternatives, and key monitoring parameters."
        navigateTo(NavigationScreen.GEMINI)
        sendAiMessage(prompt)
    }

    fun openCalculator(calcId: String) {
        if (calcId == "abg_solver") {
            navigateTo(NavigationScreen.ABG_ELECTROLYTE_SOLVER)
            return
        }
        if (calcId == "renal_adjuster") {
            navigateTo(NavigationScreen.RENAL_ADJUSTER)
            return
        }
        _uiState.update { it.copy(selectedCalculatorId = calcId, activeCalcTab = calcId) }
    }

    fun closeCalculator() {
        _uiState.update { it.copy(selectedCalculatorId = null) }
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
            val protos = filterProtocols(current.searchQuery)
            val calcs = filterCalculators(current.searchQuery)
            _uiState.update {
                it.copy(
                    filteredDrugs = filtered,
                    filteredProtocols = protos,
                    filteredCalculators = calcs
                )
            }
        }
    }

    fun setGlobalSearchTab(tab: GlobalSearchTab) {
        _uiState.update { it.copy(globalSearchTab = tab) }
    }

    fun openCalculatorFromSearch(calcId: String, calcTitle: String) {
        addRecentSearch(calcTitle)
        if (calcId == "abg_solver") {
            navigateTo(NavigationScreen.ABG_ELECTROLYTE_SOLVER)
            return
        }
        if (calcId == "renal_adjuster") {
            navigateTo(NavigationScreen.RENAL_ADJUSTER)
            return
        }
        _uiState.update {
            it.copy(
                currentScreen = NavigationScreen.CALCULATOR,
                selectedCalculatorId = calcId,
                activeCalcTab = calcId
            )
        }
    }

    fun openProtocolFromSearch(protocol: DiseaseProtocol) {
        addRecentSearch(protocol.name)
        _uiState.update {
            it.copy(
                currentScreen = NavigationScreen.DISEASE,
                selectedProtocol = protocol,
                diseaseTab = 1
            )
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

    fun openDrugByName(name: String) {
        val trimmed = name.trim().lowercase()
        val matched = ClinicalRepository.drugs.find { drug ->
            drug.genericName.lowercase().contains(trimmed) ||
            trimmed.contains(drug.genericName.lowercase()) ||
            drug.brandsNepal.any { it.name.lowercase().contains(trimmed) } ||
            drug.brandsIndia.any { it.name.lowercase().contains(trimmed) }
        }
        if (matched != null) {
            openDrug(matched)
        }
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
        val found = com.example.data.calculator.ClinicalCalculatorRegistry.allCalculators.find { it.id == calcKey }
        val title = found?.title ?: "Clinical Calculator ($calcKey)"
        val sub = found?.description ?: "Evidence-based formula"
        val cat = found?.category ?: "Clinical Tools"

        val current = _uiState.value.bookmarkedCalculatorIds.toMutableSet()
        if (current.contains(calcKey)) {
            current.remove(calcKey)
        } else {
            current.add(calcKey)
        }
        _uiState.update { it.copy(bookmarkedCalculatorIds = current) }

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
                val proto = ClinicalRepository.diseaseProtocols.find { it.id == item.targetId }
                _uiState.update {
                    it.copy(
                        currentScreen = NavigationScreen.DISEASE,
                        selectedProtocol = proto
                    )
                }
            }
            "CALCULATOR" -> {
                _uiState.update {
                    it.copy(
                        currentScreen = NavigationScreen.CALCULATOR,
                        selectedCalculatorId = item.targetId,
                        activeCalcTab = item.targetId
                    )
                }
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
        val protos = filterProtocols(current.searchQuery)
        val calcs = filterCalculators(current.searchQuery)
        _uiState.update {
            it.copy(
                searchMode = mode,
                filteredDrugs = filtered,
                filteredProtocols = protos,
                filteredCalculators = calcs
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

    fun setInteractionDrugs(drugIds: Collection<String>) {
        _uiState.update { it.copy(selectedInteractionDrugIds = drugIds.toSet()) }
    }

    fun addMultipleInteractionDrugs(drugIds: Collection<String>) {
        _uiState.update { it.copy(selectedInteractionDrugIds = it.selectedInteractionDrugIds + drugIds) }
    }

    fun openInteractionWithDrug(drugId: String) {
        _uiState.update {
            it.copy(
                isDrugModalOpen = false,
                currentScreen = NavigationScreen.INTERACTION,
                selectedInteractionDrugIds = it.selectedInteractionDrugIds + drugId
            )
        }
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

    fun toggleNextTheme() {
        val next = when (_uiState.value.themeMode) {
            AppThemeMode.PITCH_BLACK -> AppThemeMode.DARK
            AppThemeMode.DARK -> AppThemeMode.LIGHT
            AppThemeMode.LIGHT -> AppThemeMode.PITCH_BLACK
        }
        setThemeMode(next)
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

    fun loginOrUpdateProfile(
        name: String,
        degree: String,
        college: String = "",
        councilNo: String = "",
        mobile: String = "",
        avatar: String = "👨‍⚕️"
    ) {
        val trimmedName = name.trim()
        val trimmedDegree = degree.trim()
        val trimmedCollege = college.trim()
        val trimmedCouncil = councilNo.trim()
        val trimmedMobile = mobile.trim()
        val trimmedAvatar = avatar.trim().ifBlank { "👨‍⚕️" }

        profilePrefs.edit().apply {
            putBoolean("is_logged_in", true)
            putString("doc_name", trimmedName)
            putString("doc_degree", trimmedDegree)
            putString("doc_college", trimmedCollege)
            putString("doc_council", trimmedCouncil)
            putString("doc_mobile", trimmedMobile)
            putString("doc_avatar", trimmedAvatar)
            apply()
        }

        _uiState.update {
            it.copy(
                isLoggedIn = true,
                doctorName = trimmedName,
                doctorDegree = trimmedDegree,
                doctorCollege = trimmedCollege,
                doctorCouncilNo = trimmedCouncil,
                doctorMobile = trimmedMobile,
                doctorPhotoAvatar = trimmedAvatar,
                isLoginDialogOpen = false
            )
        }
    }

    fun logout() {
        profilePrefs.edit().clear().apply()
        _uiState.update {
            it.copy(
                isLoggedIn = false,
                doctorName = "",
                doctorDegree = "",
                doctorCollege = "",
                doctorCouncilNo = "",
                doctorMobile = "",
                doctorPhotoAvatar = "👨‍⚕️",
                isLoginDialogOpen = false
            )
        }
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

    fun setAiModel(model: String) {
        _uiState.update { it.copy(aiSelectedModel = model) }
    }

    fun toggleAiSearchGrounded() {
        _uiState.update { it.copy(isAiSearchGrounded = !it.isAiSearchGrounded) }
    }

    fun sendAiMessage(promptText: String? = null) {
        val text = (promptText ?: _uiState.value.aiInputText).trim()
        if (text.isBlank() || _uiState.value.isAiThinking) return

        val userMsg = ChatMessage(id = UUID.randomUUID().toString(), sender = MessageSender.USER, text = text)
        val updatedMsgs = _uiState.value.chatMessages + userMsg

        val model = _uiState.value.aiSelectedModel
        val grounded = _uiState.value.isAiSearchGrounded

        _uiState.value = _uiState.value.copy(
            chatMessages = updatedMsgs,
            aiInputText = "",
            isAiThinking = true
        )

        viewModelScope.launch {
            val responseText = GeminiClinicalService.queryClinicalAi(
                userQuery = text,
                model = model,
                enableSearchGrounding = grounded
            )
            val aiMsg = ChatMessage(
                id = UUID.randomUUID().toString(),
                sender = MessageSender.AI,
                text = responseText,
                searchQuerySuggestion = text
            )
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

    fun startAiChatWithPrompt(prompt: String) {
        _uiState.update { it.copy(currentScreen = NavigationScreen.GEMINI, isSidebarOpen = false) }
        sendAiMessage(prompt)
    }

    fun consultAiForDrug(drugName: String, specificQuestion: String? = null) {
        val prompt = if (!specificQuestion.isNullOrBlank()) {
            "Regarding $drugName: $specificQuestion. Please provide exact dosing, clinical precautions, and monitoring guidance."
        } else {
            "Please provide a comprehensive clinical guidance summary for $drugName: standard adult/pediatric dosing, renal & hepatic adjustments, high-alert precautions, significant drug interactions, and patient counseling pearls."
        }
        _uiState.update { it.copy(currentScreen = NavigationScreen.GEMINI, isDrugModalOpen = false, isSidebarOpen = false) }
        sendAiMessage(prompt)
    }

    // Medical News with Search Grounding
    fun fetchMedicalNews(forceRefresh: Boolean = false) {
        viewModelScope.launch {
            _uiState.update { it.copy(isNewsLoading = true) }
            val category = _uiState.value.newsCategoryFilter
            val result = GeminiClinicalService.fetchLiveNepalMedicalNews(category)
            _uiState.update {
                it.copy(
                    medicalNewsList = result.items,
                    isNewsLoading = false,
                    newsSearchQueries = result.searchQueries,
                    newsGroundingSources = result.sources,
                    isNewsLiveGrounding = result.isLiveGrounding
                )
            }
        }
    }

    fun setNewsCategoryFilter(category: String) {
        _uiState.update { it.copy(newsCategoryFilter = category) }
        fetchMedicalNews(false)
    }

    fun selectNewsItem(item: MedicalNewsItem?) {
        _uiState.update { it.copy(selectedNewsItem = item) }
    }

    fun askCopilotAboutNews(newsItem: MedicalNewsItem) {
        val prompt = "Provide clinical advice for doctors in Nepal regarding this medical update: '${newsItem.title}'. Summary: ${newsItem.summary}. Clinical takeaway: ${newsItem.clinicalTakeaway}. What specific diagnostic and therapeutic steps should clinicians take?"
        startAiChatWithPrompt(prompt)
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

    private fun normalizeMedicalQuery(raw: String): String {
        return raw.trim().lowercase()
            .replace("chlordiazopoxide", "chlordiazepoxide")
            .replace("chlordiazopo", "chlordiazepo")
            .replace("chlordiazap", "chlordiazep")
            .replace("chlordiazepoxid", "chlordiazepoxide")
            .replace("pantaprazole", "pantoprazole")
            .replace("pantoprazol", "pantoprazole")
            .replace("metformine", "metformin")
            .replace("ciprofloxin", "ciprofloxacin")
            .replace("ciprofloxacine", "ciprofloxacin")
            .replace("azithromicin", "azithromycin")
            .replace("moxclav", "moxclave")
            .replace("paracetmol", "paracetamol")
            .replace("diazapam", "diazepam")
            .replace("clonazapam", "clonazepam")
            .replace("mgso4", "magnesium sulfate")
            .replace("mag sulf", "magnesium sulfate")
            .replace("magnesium sulphate", "magnesium sulfate")
            .replace("phenobarbitone", "phenobarbital")
            .replace("phenobarb", "phenobarbital")
            .replace("largactil", "chlorpromazine")
            .replace("pacitane", "trihexyphenidyl")
            .replace("artane", "trihexyphenidyl")
            .replace("benzhexol", "trihexyphenidyl")
            .replace("ampicilin", "ampicillin")
            .replace("hctz", "hydrochlorothiazide")
            .replace("depo provera", "medroxyprogesterone")
            .replace("depoprovera", "medroxyprogesterone")
            .replace("sangini", "medroxyprogesterone")
            .replace("benadryl", "diphenhydramine")
            .replace("sorbitrate", "isosorbide dinitrate")
            .replace("isordil", "isosorbide dinitrate")
            .replace("ritalin", "methylphenidate")
            .replace("inspiral", "methylphenidate")
            .replace("falcigo", "artesunate")
            .replace("vermox", "mebendazole")
            .replace("charcoal", "activated charcoal")
            .replace("solian", "amisulpride")
            .replace("famocid", "famotidine")
            .replace("pepcid", "famotidine")
            .replace("norflox", "norfloxacin")
            .replace("fasigyn", "tinidazole")
            .replace("tiniba", "tinidazole")
            .replace("pexep", "paroxetine")
            .replace("paxil", "paroxetine")
    }

    fun filterProtocols(query: String): List<DiseaseProtocol> {
        val q = query.trim().lowercase()
        val normQ = normalizeMedicalQuery(q)
        if (q.isBlank()) return emptyList()
        return ClinicalRepository.diseaseProtocols.filter { proto ->
            proto.name.lowercase().contains(q) || proto.name.lowercase().contains(normQ) ||
            proto.category.lowercase().contains(q) ||
            proto.icd10.lowercase().contains(q) ||
            proto.keyDrugs.any { it.lowercase().contains(q) || it.lowercase().contains(normQ) } ||
            proto.diagnosticCriteria.lowercase().contains(q) || proto.diagnosticCriteria.lowercase().contains(normQ) ||
            proto.firstLine.lowercase().contains(q) || proto.firstLine.lowercase().contains(normQ) ||
            proto.secondLine.lowercase().contains(q) || proto.secondLine.lowercase().contains(normQ) ||
            proto.guidelines.lowercase().contains(q)
        }
    }

    fun filterCalculators(query: String): List<CalculatorSummary> {
        val q = query.trim().lowercase()
        val normQ = normalizeMedicalQuery(q)
        if (q.isBlank()) return emptyList()
        return ClinicalRepository.allCalculators.filter { calc ->
            calc.title.lowercase().contains(q) || calc.title.lowercase().contains(normQ) ||
            calc.category.lowercase().contains(q) ||
            calc.description.lowercase().contains(q) || calc.description.lowercase().contains(normQ) ||
            calc.formulaSummary.lowercase().contains(q) ||
            calc.aliases.any { it.lowercase().contains(q) || it.lowercase().contains(normQ) }
        }
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
        val normQ = normalizeMedicalQuery(q)

        fun String.matchesQuery(): Boolean =
            this.contains(q) || (normQ.isNotBlank() && this.contains(normQ))

        return indexedDrugs.asSequence().filter { item ->
            val drug = item.drug

            val matchesFilter = when (activeFilter) {
                DrugFilterType.ALL -> true
                DrugFilterType.NEPAL -> drug.brandsNepal.isNotEmpty()
                DrugFilterType.INDIA -> drug.brandsIndia.isNotEmpty()
                DrugFilterType.DDA_SCHEDULE_KA -> drug.resolvedDdaSchedule.contains("Ka", ignoreCase = true) ||
                        drug.resolvedDdaSchedule.contains("Controlled", ignoreCase = true) ||
                        drug.resolvedDdaSchedule.contains("Narcotic", ignoreCase = true) ||
                        drug.system.contains("CNS", ignoreCase = true) && (
                            drug.genericName.contains("Alprazolam", ignoreCase = true) ||
                            drug.genericName.contains("Tramadol", ignoreCase = true) ||
                            drug.genericName.contains("Clonazepam", ignoreCase = true) ||
                            drug.genericName.contains("Diazepam", ignoreCase = true) ||
                            drug.genericName.contains("Chlordiazepoxide", ignoreCase = true) ||
                            drug.genericName.contains("Morphine", ignoreCase = true) ||
                            drug.genericName.contains("Fentanyl", ignoreCase = true) ||
                            drug.genericName.contains("Lorazepam", ignoreCase = true) ||
                            drug.genericName.contains("Phenobarbital", ignoreCase = true) ||
                            drug.genericName.contains("Methylphenidate", ignoreCase = true)
                        )
                DrugFilterType.FREE_HEALTH_POST -> drug.isFreeHealthPostDrug ||
                        drug.resolvedNeml.contains("Free", ignoreCase = true)
                DrugFilterType.EMPTY_STOMACH -> drug.timing.contains("Empty", ignoreCase = true) ||
                        drug.timing.contains("Before", ignoreCase = true) ||
                        drug.timing.contains("खाली", ignoreCase = true) ||
                        drug.administration.contains("Empty", ignoreCase = true) ||
                        drug.specialInstructions.contains("Empty", ignoreCase = true) ||
                        drug.genericName.contains("Pantoprazole", ignoreCase = true) ||
                        drug.genericName.contains("Omeprazole", ignoreCase = true) ||
                        drug.genericName.contains("Levothyroxine", ignoreCase = true) ||
                        drug.genericName.contains("Entecavir", ignoreCase = true) ||
                        drug.genericName.contains("Penicillamine", ignoreCase = true) ||
                        drug.genericName.contains("Alendronate", ignoreCase = true)
                DrugFilterType.WITH_MEALS -> drug.timing.contains("Meal", ignoreCase = true) ||
                        drug.timing.contains("Food", ignoreCase = true) ||
                        drug.timing.contains("After", ignoreCase = true) ||
                        drug.timing.contains("खानासँगै", ignoreCase = true) ||
                        drug.administration.contains("Meal", ignoreCase = true) ||
                        drug.genericName.contains("Metformin", ignoreCase = true) ||
                        drug.genericName.contains("Diclofenac", ignoreCase = true) ||
                        drug.genericName.contains("Ibuprofen", ignoreCase = true) ||
                        drug.genericName.contains("Aceclofenac", ignoreCase = true) ||
                        drug.genericName.contains("Tenofovir", ignoreCase = true) ||
                        drug.genericName.contains("Pancreatin", ignoreCase = true) ||
                        drug.genericName.contains("Ursodeoxycholic", ignoreCase = true)
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
                SearchMode.BRAND -> item.brandIndex.matchesQuery() || item.genericIndex.matchesQuery()
                SearchMode.GENERIC -> item.genericIndex.matchesQuery() || item.brandIndex.matchesQuery()
                SearchMode.INDICATION -> item.indicationIndex.matchesQuery()
                SearchMode.HERBAL -> item.allIndex.matchesQuery()
            }
        }.map { it.drug }.toList()
    }
}
