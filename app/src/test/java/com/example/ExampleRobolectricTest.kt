package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.calculator.ClinicalCalculators
import com.example.data.repository.ClinicalRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

    @Test
    fun `read string from context matches app name`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("DRUGs Nepal", appName)
    }

    @Test
    fun `verify clinical repository contains core nepalese medications`() {
        val drugs = ClinicalRepository.drugs
        assertTrue(drugs.isNotEmpty())
        val moxclave = drugs.find { it.genericName.contains("Amoxicillin") }
        assertNotNull(moxclave)
        assertTrue(moxclave!!.brandsNepal.any { it.name.contains("Moxclave") })
    }

    @Test
    fun `verify egfr cockcroft gault calculation`() {
        val res = ClinicalCalculators.calculateEgfr(
            age = 60,
            weightKg = 70.0,
            serumCrMgDl = 1.0,
            isFemale = false
        )
        // CrCl = (140 - 60) * 70 / (72 * 1.0) = 5600 / 72 = 77.77
        assertEquals(77.78, res.crcl, 0.1)
        assertTrue(res.stage.contains("Stage 2"))
    }

    @Test
    fun `verify paracetamol rumack matthew nomogram toxicity threshold`() {
        // At 4 hours, threshold is 150 ug/mL
        val toxicCase = ClinicalCalculators.evaluateParacetamolOverdose(hoursPostIngestion = 4.0, serumLevelUgMl = 180.0)
        assertTrue(toxicCase.isToxicityProbable)

        val safeCase = ClinicalCalculators.evaluateParacetamolOverdose(hoursPostIngestion = 4.0, serumLevelUgMl = 80.0)
        assertTrue(!safeCase.isToxicityProbable)
    }

    @Test
    fun `verify user name is removed by default and optional login works`() {
        val app = ApplicationProvider.getApplicationContext<android.app.Application>()
        val vm = com.example.viewmodel.ClinicalViewModel(app)
        val initialState = vm.uiState.value
        // Verify default is empty and logged out
        assertEquals("", initialState.doctorName)
        assertEquals("", initialState.doctorDegree)
        assertEquals("", initialState.doctorCouncilNo)
        assertEquals(false, initialState.isLoggedIn)

        // Verify login with optional fields
        vm.loginOrUpdateProfile(
            name = "Dr. Anel Kumar Sah",
            degree = "MBBS, MD",
            councilNo = "NMC-12345"
        )
        val loggedInState = vm.uiState.value
        assertEquals("Dr. Anel Kumar Sah", loggedInState.doctorName)
        assertEquals("MBBS, MD", loggedInState.doctorDegree)
        assertEquals("NMC-12345", loggedInState.doctorCouncilNo)
        assertEquals(true, loggedInState.isLoggedIn)

        // Verify logout
        vm.logout()
        val loggedOutState = vm.uiState.value
        assertEquals("", loggedOutState.doctorName)
        assertEquals("", loggedOutState.doctorDegree)
        assertEquals("", loggedOutState.doctorCouncilNo)
        assertEquals(false, loggedOutState.isLoggedIn)
    }

    @Test
    fun `verify brand vs generic mode switch toggles state and updates filtered drugs`() {
        val app = ApplicationProvider.getApplicationContext<android.app.Application>()
        val vm = com.example.viewmodel.ClinicalViewModel(app)
        assertEquals(com.example.viewmodel.SearchMode.BRAND, vm.uiState.value.searchMode)

        // Switch to GENERIC
        vm.setSearchMode(com.example.viewmodel.SearchMode.GENERIC)
        assertEquals(com.example.viewmodel.SearchMode.GENERIC, vm.uiState.value.searchMode)

        // Search for generic molecule
        vm.updateSearchQuery("Paracetamol")
        assertTrue(vm.uiState.value.filteredDrugs.isNotEmpty())
        assertTrue(vm.uiState.value.filteredDrugs.any { it.genericName.contains("Paracetamol", ignoreCase = true) })

        // Switch back to BRAND
        vm.setSearchMode(com.example.viewmodel.SearchMode.BRAND)
        assertEquals(com.example.viewmodel.SearchMode.BRAND, vm.uiState.value.searchMode)
    }

    @Test
    fun `verify pharmaceutical companies extraction and product listing`() {
        val companies = ClinicalRepository.getAllCompanies()
        assertTrue("Companies should not be empty", companies.isNotEmpty())
        
        val tims = companies.find { it.name.contains("Doctor Tims", ignoreCase = true) }
        assertNotNull("Doctor Tims Pharmaceuticals should exist", tims)
        assertTrue("Doctor Tims should have Azi Mx", tims!!.products.any { it.brand.name.contains("Azi Mx") })

        val nepalCompanies = companies.filter { it.country.contains("Nepal") }
        assertTrue("Nepal companies should exist", nepalCompanies.isNotEmpty())

        val indiaCompanies = companies.filter { it.country.contains("India") }
        assertTrue("India companies should exist", indiaCompanies.isNotEmpty())
    }

    @Test
    fun `verify sidebar drawer state transitions and navigation`() {
        val app = ApplicationProvider.getApplicationContext<android.app.Application>()
        val vm = com.example.viewmodel.ClinicalViewModel(app)
        assertEquals(false, vm.uiState.value.isSidebarOpen)

        // Open sidebar
        vm.openSidebar()
        assertEquals(true, vm.uiState.value.isSidebarOpen)

        // Close sidebar
        vm.closeSidebar()
        assertEquals(false, vm.uiState.value.isSidebarOpen)

        // Toggle sidebar
        vm.toggleSidebar()
        assertEquals(true, vm.uiState.value.isSidebarOpen)

        // Test navigation to COMPANIES screen
        vm.navigateTo(com.example.viewmodel.NavigationScreen.COMPANIES)
        assertEquals(com.example.viewmodel.NavigationScreen.COMPANIES, vm.uiState.value.currentScreen)

        // Test search mode by INDICATION
        vm.setSearchMode(com.example.viewmodel.SearchMode.INDICATION)
        assertEquals(com.example.viewmodel.SearchMode.INDICATION, vm.uiState.value.searchMode)
    }

    @Test
    fun `verify clinical calculator suite registry and interactive calculations`() {
        val allCalcs = com.example.data.calculator.ClinicalCalculatorRegistry.allCalculators
        assertTrue("Clinical Cal Suite must have at least 50 calculators", allCalcs.size >= 50)

        // Verify key MDCalc cornerstone calculators are present
        val meld = allCalcs.find { it.id == "meld_na" || it.id == "meld_score" }
        assertNotNull("MELD-Na calculator must be present", meld)

        val oakland = allCalcs.find { it.id == "oakland" }
        assertNotNull("Oakland Score must be present", oakland)

        val ganzoni = allCalcs.find { it.id == "ganzoni" }
        assertNotNull("Ganzoni Equation must be present", ganzoni)

        val wellsDvt = allCalcs.find { it.id == "wells_dvt" }
        assertNotNull("Wells DVT must be present", wellsDvt)

        val wellsPe = allCalcs.find { it.id == "wells_pe" }
        assertNotNull("Wells PE must be present", wellsPe)

        val snakebite = allCalcs.find { it.id == "snakebite" }
        assertNotNull("Nepal Snakebite ASV must be present", snakebite)

        // Verify Snakebite calculation
        val snakeRes = ClinicalCalculators.calculateSnakebiteDosing("Krait")
        assertEquals(10, snakeRes.initialAsvDoseVials)
        assertTrue(snakeRes.envenomationType.contains("Neurotoxic"))

        // Verify CKD-EPI 2021 calculation
        val ckdRes = com.example.data.calculator.ExtendedCalculators.calculateCkdEpi(
            age = 50,
            serumCr = 1.0,
            isFemale = false
        )
        assertTrue("CKD-EPI should return valid eGFR", ckdRes.egfr > 60.0)

        // Verify FENa calculation (Prerenal: < 1.0%)
        val fenaRes = com.example.data.calculator.ExtendedCalculators.calculateFena(
            urineNa = 15.0,
            serumNa = 140.0,
            urineCr = 80.0,
            serumCr = 2.0
        )
        // (15 * 2) / (140 * 80) * 100 = 30 / 11200 * 100 = 0.267%
        assertTrue("FENa should indicate prerenal azotemia", fenaRes.fenaPercent < 1.0)
        assertTrue(fenaRes.etiology.contains("Prerenal"))
    }

    @Test
    fun `verify calculator bookmarking and navigation in viewmodel`() {
        val app = ApplicationProvider.getApplicationContext<android.app.Application>()
        val vm = com.example.viewmodel.ClinicalViewModel(app)

        // Open calculator
        vm.openCalculator("oakland")
        assertEquals("oakland", vm.uiState.value.selectedCalculatorId)

        // Close calculator
        vm.closeCalculator()
        assertEquals(null, vm.uiState.value.selectedCalculatorId)

        // Toggle bookmark
        val initiallyBookmarked = vm.uiState.value.bookmarkedCalculatorIds.contains("oakland")
        vm.toggleBookmarkCalculator("oakland")
        assertEquals(!initiallyBookmarked, vm.uiState.value.bookmarkedCalculatorIds.contains("oakland"))
    }

    @Test
    fun `verify ai copilot model selection and chat features`() {
        val app = ApplicationProvider.getApplicationContext<android.app.Application>()
        val vm = com.example.viewmodel.ClinicalViewModel(app)

        assertEquals("gemini-3.5-flash", vm.uiState.value.aiSelectedModel)
        assertTrue(vm.uiState.value.isAiSearchGrounded)
        assertEquals("General Guidance", vm.uiState.value.aiConsultationMode)

        // Switch to Gemini 3.1 Pro Reasoner
        vm.setAiModel("gemini-3.1-pro-preview")
        assertEquals("gemini-3.1-pro-preview", vm.uiState.value.aiSelectedModel)

        // Switch to Gemini 3.1 Flash-Lite
        vm.setAiModel("gemini-3.1-flash-lite-preview")
        assertEquals("gemini-3.1-flash-lite-preview", vm.uiState.value.aiSelectedModel)

        // Test Consultation Mode switching
        vm.setAiConsultationMode("Nepal MoHP Protocols")
        assertEquals("Nepal MoHP Protocols", vm.uiState.value.aiConsultationMode)

        vm.setAiConsultationMode("Polypharmacy Check")
        assertEquals("Polypharmacy Check", vm.uiState.value.aiConsultationMode)

        // Toggle grounding
        vm.toggleAiSearchGrounded()
        assertEquals(false, vm.uiState.value.isAiSearchGrounded)

        // Send AI message
        vm.sendAiMessage("Anaphylaxis Epinephrine Dosing")
        val messages = vm.uiState.value.chatMessages
        assertTrue("Messages should contain user query", messages.any { it.text.contains("Anaphylaxis") })
    }
}
