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
}
