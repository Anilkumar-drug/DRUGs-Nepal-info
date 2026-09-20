package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.ai.GeminiClinicalService
import com.example.data.calculator.ClinicalCalculators
import com.example.data.model.AppThemeMode
import com.example.data.model.ChatMessage
import com.example.data.model.Drug
import com.example.data.model.FontSizeScale
import com.example.data.model.MessageSender
import com.example.data.repository.ClinicalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID

enum class NavigationScreen(val title: String) {
    SEARCH("Universal Drug Search"),
    SYSTEM("Browse by Organ System"),
    DISEASE("Disease & Protocols"),
    ANTIDOTE("Antidote & Toxicology"),
    CALCULATOR("MDCalc Clinical Suite"),
    GEMINI("Gemini AI Assistant"),
    SETTINGS("App Settings")
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
    val activeFilter: DrugFilterType = DrugFilterType.ALL,
    val selectedSystemFilter: String? = null,
    val selectedDrug: Drug? = null,
    val isDrugModalOpen: Boolean = false,
    val bookmarkedDrugIds: Set<String> = setOf("d1", "d4"),
    val patientWeightKg: Double = 60.0,
    // Theme & Settings
    val themeMode: AppThemeMode = AppThemeMode.DARK,
    val fontSizeScale: FontSizeScale = FontSizeScale.NORMAL,
    val doctorName: String = "Dr. Prabhat Sharma",
    val doctorNmc: String = "NMC-28491",
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
    val pedResult: ClinicalCalculators.PediatricDoseResult? = null
)

class ClinicalViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ClinicalUiState())
    val uiState: StateFlow<ClinicalUiState> = _uiState.asStateFlow()

    init {
        // Compute initial calculator results
        computeEgfr()
        computeBsa()
        computeChildPugh()
        computeParacetamol()
        computePediatric()
    }

    fun navigateTo(screen: NavigationScreen) {
        _uiState.value = _uiState.value.copy(currentScreen = screen)
    }

    fun updateSearchQuery(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun setFilter(filter: DrugFilterType) {
        _uiState.value = _uiState.value.copy(activeFilter = filter, selectedSystemFilter = null)
    }

    fun filterBySystem(systemName: String) {
        _uiState.value = _uiState.value.copy(
            currentScreen = NavigationScreen.SEARCH,
            selectedSystemFilter = if (systemName == "All Systems") null else systemName,
            activeFilter = DrugFilterType.ALL,
            searchQuery = ""
        )
    }

    fun openDrug(drug: Drug) {
        _uiState.value = _uiState.value.copy(
            selectedDrug = drug,
            isDrugModalOpen = true
        )
    }

    fun closeDrugModal() {
        _uiState.value = _uiState.value.copy(isDrugModalOpen = false)
    }

    fun toggleBookmark(drugId: String) {
        val current = _uiState.value.bookmarkedDrugIds.toMutableSet()
        if (current.contains(drugId)) {
            current.remove(drugId)
        } else {
            current.add(drugId)
        }
        _uiState.value = _uiState.value.copy(bookmarkedDrugIds = current)
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

    fun updateDoctorProfile(name: String, nmc: String) {
        _uiState.value = _uiState.value.copy(doctorName = name, doctorNmc = nmc)
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

    fun getFilteredDrugs(): List<Drug> {
        val state = _uiState.value
        val q = state.searchQuery.trim().lowercase()

        return ClinicalRepository.drugs.filter { drug ->
            val matchesSearch = if (q.isEmpty()) true else {
                drug.genericName.lowercase().contains(q) ||
                drug.system.lowercase().contains(q) ||
                drug.drugClass.lowercase().contains(q) ||
                drug.indications.lowercase().contains(q) ||
                drug.brandsNepal.any { it.name.lowercase().contains(q) || it.company.lowercase().contains(q) } ||
                drug.brandsIndia.any { it.name.lowercase().contains(q) || it.company.lowercase().contains(q) }
            }

            val matchesFilter = when (state.activeFilter) {
                DrugFilterType.ALL -> true
                DrugFilterType.NEPAL -> drug.brandsNepal.isNotEmpty()
                DrugFilterType.INDIA -> drug.brandsIndia.isNotEmpty()
                DrugFilterType.BLACK_BOX -> drug.blackBoxWarning != null
                DrugFilterType.BOOKMARKS -> state.bookmarkedDrugIds.contains(drug.id)
            }

            val matchesSystem = if (state.selectedSystemFilter == null) true else {
                drug.system.equals(state.selectedSystemFilter, ignoreCase = true)
            }

            matchesSearch && matchesFilter && matchesSystem
        }
    }
}
