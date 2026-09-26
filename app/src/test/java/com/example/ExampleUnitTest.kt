package com.example

import com.example.data.model.InteractionSeverity
import com.example.data.repository.ClinicalRepository
import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {
  @Test
  fun addition_isCorrect() {
    assertEquals(4, 2 + 2)
  }

  @Test
  fun testSingleDrugReturnsNoInteractions() {
    val result = ClinicalRepository.findInteractions(setOf("d36")) // Warfarin only
    assertTrue(result.isEmpty())
  }

  @Test
  fun testWarfarinAndDiclofenacContraindication() {
    val result = ClinicalRepository.findInteractions(setOf("d36", "d55")) // Warfarin + Diclofenac
    assertTrue(result.isNotEmpty())
    val match = result.find { it.severity == InteractionSeverity.CONTRAINDICATED }
    assertNotNull(match)
    assertTrue(match!!.effect.contains("Gastrointestinal Hemorrhage", ignoreCase = true) || match.effect.contains("bleeding", ignoreCase = true))
    assertTrue(match.sourceDatabase.isNotEmpty())
  }

  @Test
  fun testMeropenemAndValproateContraindication() {
    val result = ClinicalRepository.findInteractions(setOf("d32", "d52")) // Meropenem + Valproate
    assertTrue(result.isNotEmpty())
    val match = result.find { it.severity == InteractionSeverity.CONTRAINDICATED }
    assertNotNull(match)
    assertTrue(match!!.effect.contains("valproate", ignoreCase = true) || match.effect.contains("epilepticus", ignoreCase = true))
  }

  @Test
  fun testMultiDrugPolypharmacyRegimen() {
    // 3 drugs: Warfarin (d36), Diclofenac (d55), Ketorolac (d56)
    val result = ClinicalRepository.findInteractions(setOf("d36", "d55", "d56"))
    assertTrue("Should detect multiple interactions in polypharmacy regimen", result.size >= 2)
  }
}

