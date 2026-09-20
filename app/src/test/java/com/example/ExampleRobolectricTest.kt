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
}
