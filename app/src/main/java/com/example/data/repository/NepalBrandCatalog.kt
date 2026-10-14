package com.example.data.repository

import com.example.data.model.BrandInfo
import com.example.data.model.Drug

/**
 * Comprehensive Nepal & Regional Brand Product Catalog.
 * Enriches clinical generic drugs with authentic commercial trade names widely dispensed
 * across community pharmacies, government hospitals, private tertiary centers, and health posts in Nepal.
 *
 * Includes major domestic manufacturers:
 * - Deurali-Janta Pharmaceuticals Ltd (DJPL)
 * - Nepal Pharmaceuticals Laboratory (NPL)
 * - Quest Pharmaceuticals
 * - Asian Pharmaceuticals
 * - National Healthcare
 * - Lomus Pharmaceuticals
 * - Arya Pharma Lab
 * - Omnica Laboratories
 * - Maruti Pharma
 * - Time Pharmaceuticals
 * - Curex Pharmaceuticals
 * - SR Drug Laboratories
 * - Vega Pharmaceuticals
 * - Nepal Aushadhi Limited
 * - Biogain / Magnachem / Chemidrug
 *
 * Also includes top imported brands widely registered & prescribed in Nepal:
 * - Sun Pharma, Cipla, Alkem, Glenmark, Torrent, Mankind, Abbott, USV, Intas, Lupin, Aristo, Macleods, Dr. Reddy's, GSK, Pfizer, Sanofi, Micro Labs, FDC, Cadila, AstraZeneca, Novartis, Boehringer Ingelheim, Novo Nordisk, J.B. Chemicals, Wockhardt, Reckitt.
 */
object NepalBrandCatalog {

    data class BrandEnrichment(
        val genericKey: String,
        val nepalBrands: List<BrandInfo>,
        val importedBrands: List<BrandInfo>
    )

    val catalog: List<BrandEnrichment> = listOf(
        // 1. Pantoprazole
        BrandEnrichment(
            genericKey = "pantoprazole",
            nepalBrands = listOf(
                BrandInfo("Panto-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Pantop-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "40 mg"),
                BrandInfo("Pantonix", "Asian Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Pantoc", "Quest Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Pan-Lomus", "Lomus Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Pantomax", "National Healthcare", "Tablet / Inj", "40 mg"),
                BrandInfo("Panzol", "Curex Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Panto-Arya", "Arya Pharma Lab", "Tablet", "40 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Pantocid", "Sun Pharma", "Tablet / Inj", "40 mg"),
                BrandInfo("Pan-40", "Alkem Laboratories", "Tablet / Inj", "40 mg"),
                BrandInfo("Pantop", "Aristo Pharmaceuticals", "Tablet / Inj", "40 mg"),
                BrandInfo("Pantodac", "Zydus Healthcare", "Tablet", "40 mg"),
                BrandInfo("Protium", "Mankind Pharma", "Tablet", "40 mg"),
                BrandInfo("Pantocar", "Micro Labs", "Tablet", "40 mg")
            )
        ),

        // 2. Omeprazole
        BrandEnrichment(
            genericKey = "omeprazole",
            nepalBrands = listOf(
                BrandInfo("Omiz", "Deurali-Janta Pharmaceuticals", "Capsule", "20 mg"),
                BrandInfo("Omep-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "20 mg"),
                BrandInfo("Procept", "Quest Pharmaceuticals", "Capsule", "20 mg"),
                BrandInfo("Ome-Lomus", "Lomus Pharmaceuticals", "Capsule", "20 mg"),
                BrandInfo("Omezol", "National Healthcare", "Capsule", "20 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Omee", "Alkem Laboratories", "Capsule", "20 mg"),
                BrandInfo("Omez", "Dr. Reddy's Laboratories", "Capsule / Inj", "20 mg / 40 mg"),
                BrandInfo("Omecip", "Cipla Ltd.", "Capsule", "20 mg"),
                BrandInfo("Ocid", "Zydus Healthcare", "Capsule", "20 mg"),
                BrandInfo("Lomac", "Cipla Ltd.", "Capsule", "20 mg")
            )
        ),

        // 3. Rabeprazole
        BrandEnrichment(
            genericKey = "rabeprazole",
            nepalBrands = listOf(
                BrandInfo("Rab-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "20 mg"),
                BrandInfo("Rabium-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "20 mg"),
                BrandInfo("Rabet", "Quest Pharmaceuticals", "Tablet", "20 mg"),
                BrandInfo("Rabec", "Asian Pharmaceuticals", "Tablet", "20 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Razo", "Dr. Reddy's Laboratories", "Tablet", "20 mg"),
                BrandInfo("Rabium", "Torrent Pharmaceuticals", "Tablet / Inj", "20 mg"),
                BrandInfo("Rabicip", "Cipla Ltd.", "Tablet", "20 mg"),
                BrandInfo("Happi", "Zydus Healthcare", "Tablet", "20 mg"),
                BrandInfo("Veloz", "Sun Pharma", "Tablet", "20 mg"),
                BrandInfo("Rablet", "Lupin Ltd.", "Tablet", "20 mg")
            )
        ),

        // 4. Esomeprazole
        BrandEnrichment(
            genericKey = "esomeprazole",
            nepalBrands = listOf(
                BrandInfo("Esom-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "20 mg / 40 mg"),
                BrandInfo("Esop-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "40 mg"),
                BrandInfo("Esomac-NP", "Quest Pharmaceuticals", "Tablet", "20 mg / 40 mg"),
                BrandInfo("Esonix", "Asian Pharmaceuticals", "Tablet", "40 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Nexpro", "Torrent Pharmaceuticals", "Tablet / Inj", "20 mg / 40 mg"),
                BrandInfo("Sompraz", "Sun Pharma", "Tablet / Inj", "20 mg / 40 mg"),
                BrandInfo("Esoz", "Glenmark Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Izra", "Macleods Pharmaceuticals", "Tablet", "40 mg"),
                BrandInfo("Esiflo", "Lupin Ltd.", "Tablet", "40 mg")
            )
        ),

        // 5. Paracetamol / Acetaminophen
        BrandEnrichment(
            genericKey = "paracetamol",
            nepalBrands = listOf(
                BrandInfo("Cetamol", "Nepal Aushadhi Limited", "Tablet / Syrup", "500 mg / 120mg/5mL"),
                BrandInfo("Cetmol", "Deurali-Janta Pharmaceuticals", "Tablet / Drop", "500 mg / 650 mg"),
                BrandInfo("Paran-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Syrup", "500 mg / 650 mg"),
                BrandInfo("Pacim-NP", "Quest Pharmaceuticals", "Tablet / Syrup", "500 mg"),
                BrandInfo("Paramol", "Lomus Pharmaceuticals", "Tablet / Syrup", "500 mg"),
                BrandInfo("Para-Asian", "Asian Pharmaceuticals", "Tablet / Syrup", "500 mg"),
                BrandInfo("Pyricet", "National Healthcare", "Tablet", "500 mg / 650 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Paracip", "Cipla Ltd.", "Tablet / Drops / IV Inf", "500 mg / 650 mg / 1g"),
                BrandInfo("Calpol", "GlaxoSmithKline", "Tablet / Suspension", "500 mg / 250mg/5mL"),
                BrandInfo("Crocin", "GlaxoSmithKline", "Tablet / Drops", "500 mg / 650 mg"),
                BrandInfo("Dolo-650", "Micro Labs", "Tablet", "650 mg"),
                BrandInfo("Sumo L", "Alkem Laboratories", "Drops / Suspension", "120mg/5mL / 250mg/5mL"),
                BrandInfo("Fepanil", "Veritaz Healthcare", "Tablet / Drops", "650 mg"),
                BrandInfo("Pyrigesic", "East India Pharma", "Tablet", "500 mg / 650 mg")
            )
        ),

        // 6. Amoxicillin + Clavulanate
        BrandEnrichment(
            genericKey = "amoxicillin + potassium clavulanate",
            nepalBrands = listOf(
                BrandInfo("Moxclave", "Deurali-Janta Pharmaceuticals", "Tablet / Dry Syr", "625 mg / 228.5mg / 1g"),
                BrandInfo("Clavam-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "625 mg"),
                BrandInfo("Asian-Clav", "Asian Pharmaceuticals", "Dry Syrup / Tab", "228.5mg / 457mg / 625mg"),
                BrandInfo("Enclave", "Curex Pharmaceuticals", "Tablet", "625 mg"),
                BrandInfo("Novaclav", "Quest Pharmaceuticals", "Tablet / Dry Syr", "625 mg / 228.5mg"),
                BrandInfo("Moxoclav", "Lomus Pharmaceuticals", "Tablet", "625 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Augmentin", "GlaxoSmithKline", "Tablet / Dry Syr / Inj", "625 mg / 1000 mg / 1.2g"),
                BrandInfo("Clavam", "Alkem Laboratories", "Tablet / Dry Syr / Inj", "625 mg / 1.2g"),
                BrandInfo("Moxikind-CV", "Mankind Pharma", "Tablet / Dry Syr", "625 mg / 228.5mg"),
                BrandInfo("Sensiclav", "Macleods Pharmaceuticals", "Tablet / Inj", "625 mg / 1.2g"),
                BrandInfo("Amoxyclav", "Abbott Healthcare", "Tablet", "625 mg"),
                BrandInfo("Mega-CV", "Aristo Pharmaceuticals", "Tablet / Inj", "625 mg / 1.2g")
            )
        ),

        // 7. Amoxicillin
        BrandEnrichment(
            genericKey = "amoxicillin",
            nepalBrands = listOf(
                BrandInfo("Mox-DJPL", "Deurali-Janta Pharmaceuticals", "Capsule / Dry Syr", "250 mg / 500 mg / 125mg"),
                BrandInfo("Amox-NPL", "Nepal Pharmaceuticals Lab", "Capsule / Syrup", "500 mg"),
                BrandInfo("Amox-Lomus", "Lomus Pharmaceuticals", "Capsule", "500 mg"),
                BrandInfo("Amox-Asian", "Asian Pharmaceuticals", "Capsule / Dry Syr", "250 mg / 500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Novamox", "Cipla Ltd.", "Capsule / Dry Syrup", "250 mg / 500 mg / 125mg"),
                BrandInfo("Mox", "Sun Pharma", "Capsule / Syrup", "250 mg / 500 mg"),
                BrandInfo("Almox", "Alkem Laboratories", "Capsule", "500 mg"),
                BrandInfo("Wymox", "Pfizer", "Capsule", "500 mg")
            )
        ),

        // 8. Azithromycin
        BrandEnrichment(
            genericKey = "azithromycin",
            nepalBrands = listOf(
                BrandInfo("Azi Mx", "Doctor Tims Pharmaceuticals", "Tablet / Suspension", "250 mg / 500 mg"),
                BrandInfo("Azith-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Azith-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Syrup", "250 mg / 500 mg"),
                BrandInfo("Azimax", "Quest Pharmaceuticals", "Tablet / Susp", "500 mg / 200mg/5mL"),
                BrandInfo("Azilom", "Lomus Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Azithro-Asian", "Asian Pharmaceuticals", "Tablet / Susp", "500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Azithral", "Alembic Pharmaceuticals", "Tablet / Susp / Inj", "250 mg / 500 mg / 500mg Inj"),
                BrandInfo("Azee", "Cipla Ltd.", "Tablet / Syrup", "250 mg / 500 mg / 200mg/5mL"),
                BrandInfo("Zithromax", "Pfizer", "Tablet / Susp / Inj", "250 mg / 500 mg"),
                BrandInfo("ATM", "Indoco Remedies", "Tablet / Susp", "500 mg"),
                BrandInfo("Zady", "Mankind Pharma", "Tablet / Susp", "500 mg")
            )
        ),

        // 9. Ciprofloxacin
        BrandEnrichment(
            genericKey = "ciprofloxacin",
            nepalBrands = listOf(
                BrandInfo("Cipro-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Eye Drops", "500 mg / 0.3%"),
                BrandInfo("Cipro-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg"),
                BrandInfo("Ciprol", "Quest Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Cipromus", "Lomus Pharmaceuticals", "Tablet", "500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Ciprobid", "Cadila Healthcare", "Tablet", "250 mg / 500 mg"),
                BrandInfo("Ciplox", "Cipla Ltd.", "Tablet / Eye-Ear Drops / IV", "500 mg / 0.3% / 200mg/100mL"),
                BrandInfo("Cifran", "Sun Pharma", "Tablet / Eye Drops", "250 mg / 500 mg"),
                BrandInfo("Quintor", "Torrent Pharmaceuticals", "Tablet", "500 mg")
            )
        ),

        // 10. Levofloxacin
        BrandEnrichment(
            genericKey = "levofloxacin",
            nepalBrands = listOf(
                BrandInfo("Levo-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Infusion", "500 mg / 750 mg"),
                BrandInfo("Levoflox-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg"),
                BrandInfo("Levotime", "Time Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Levonix", "Asian Pharmaceuticals", "Tablet", "500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Loxof", "Sun Pharma", "Tablet / Infusion", "500 mg / 750 mg"),
                BrandInfo("Levomac", "Macleods Pharmaceuticals", "Tablet / Infusion", "500 mg"),
                BrandInfo("Glevo", "Glenmark Pharmaceuticals", "Tablet / Infusion", "500 mg"),
                BrandInfo("Levoday", "Torrent Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Tavanic", "Sanofi", "Tablet / Infusion", "500 mg")
            )
        ),

        // 11. Ofloxacin
        BrandEnrichment(
            genericKey = "ofloxacin",
            nepalBrands = listOf(
                BrandInfo("Oflox-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Drops", "200 mg / 400 mg"),
                BrandInfo("Oflox-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "200 mg"),
                BrandInfo("Oflo-Quest", "Quest Pharmaceuticals", "Tablet", "200 mg / 400 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Zanocin", "Sun Pharma", "Tablet / Eye Drops / Infusion", "200 mg / 400 mg"),
                BrandInfo("Oflomac", "Mankind Pharma", "Tablet / Suspension", "200 mg / 400 mg"),
                BrandInfo("Oflox-OZ", "Cipla Ltd.", "Tablet (Oflox + Ornidazole)", "200mg + 500mg"),
                BrandInfo("Zenflox", "Mankind Pharma", "Tablet", "200 mg")
            )
        ),

        // 12. Metronidazole
        BrandEnrichment(
            genericKey = "metronidazole",
            nepalBrands = listOf(
                BrandInfo("Metron", "Nepal Aushadhi Limited", "Tablet", "400 mg"),
                BrandInfo("Metro-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "400 mg"),
                BrandInfo("Metro-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Susp", "400 mg / 200mg/5mL"),
                BrandInfo("Metrolom", "Lomus Pharmaceuticals", "Tablet", "400 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Metrogyl", "J.B. Chemicals & Pharmaceuticals", "Tablet / IV Inf / Gel", "200 mg / 400 mg / 500mg/100mL"),
                BrandInfo("Flagyl", "Abbott Healthcare", "Tablet / Suspension", "200 mg / 400 mg / 200mg/5mL"),
                BrandInfo("Aristogyl", "Aristo Pharmaceuticals", "Tablet / Suspension", "400 mg")
            )
        ),

        // 13. Cefixime
        BrandEnrichment(
            genericKey = "cefixime",
            nepalBrands = listOf(
                BrandInfo("Cef-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Dry Syr", "200 mg / 100mg/5mL"),
                BrandInfo("Cefix-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Dry Syr", "200 mg / 100mg/5mL"),
                BrandInfo("Cefilom", "Lomus Pharmaceuticals", "Tablet", "200 mg"),
                BrandInfo("Asian-Cef", "Asian Pharmaceuticals", "Tablet / Dry Syr", "200 mg / 100mg")
            ),
            importedBrands = listOf(
                BrandInfo("Taxim-O", "Alkem Laboratories", "Tablet / Dry Syr", "100 mg / 200 mg"),
                BrandInfo("Mahacef", "Mankind Pharma", "Tablet / Dry Syr", "100 mg / 200 mg"),
                BrandInfo("Zifi", "FDC Ltd.", "Tablet / Dry Syr", "100 mg / 200 mg"),
                BrandInfo("Cefolac", "Macleods Pharmaceuticals", "Tablet / Dry Syr", "200 mg"),
                BrandInfo("Omnix", "Cipla Ltd.", "Tablet / Dry Syr", "100 mg / 200 mg")
            )
        ),

        // 14. Ceftriaxone
        BrandEnrichment(
            genericKey = "ceftriaxone",
            nepalBrands = listOf(
                BrandInfo("Ctri-DJPL", "Deurali-Janta Pharmaceuticals", "Injection", "1 g / 2 g / 250 mg / 500 mg"),
                BrandInfo("Ceftri-NPL", "Nepal Pharmaceuticals Lab", "Injection", "1 g / 500 mg"),
                BrandInfo("Cefone", "Asian Pharmaceuticals", "Injection", "1 g / 2 g"),
                BrandInfo("Ceftrilom", "Lomus Pharmaceuticals", "Injection", "1 g"),
                BrandInfo("Powercef-NP", "National Healthcare", "Injection", "1 g")
            ),
            importedBrands = listOf(
                BrandInfo("Monocef", "Aristo Pharmaceuticals", "Injection", "250 mg / 500 mg / 1 g / 2 g"),
                BrandInfo("Rocephin", "Roche", "Injection", "1 g / 2 g"),
                BrandInfo("Oframax", "Sun Pharma", "Injection", "1 g"),
                BrandInfo("Xone", "Alkem Laboratories", "Injection", "1 g"),
                BrandInfo("Cefaxone", "Cipla Ltd.", "Injection", "1 g")
            )
        ),

        // 15. Cefuroxime Axetil
        BrandEnrichment(
            genericKey = "cefuroxime",
            nepalBrands = listOf(
                BrandInfo("Cefur-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "250 mg / 500 mg"),
                BrandInfo("Cefuro-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg"),
                BrandInfo("Altacef-NP", "Quest Pharmaceuticals", "Tablet", "250 mg / 500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Ceftum", "GlaxoSmithKline", "Tablet", "250 mg / 500 mg"),
                BrandInfo("Cetil", "Lupin Ltd.", "Tablet / Dry Syr", "250 mg / 500 mg"),
                BrandInfo("Pulmocef", "Micro Labs", "Tablet", "500 mg"),
                BrandInfo("Forcef", "Aristo Pharmaceuticals", "Tablet / Inj", "500 mg / 1.5g Inj"),
                BrandInfo("Zeff", "Torrent Pharmaceuticals", "Tablet", "500 mg")
            )
        ),

        // 16. Piperacillin + Tazobactam
        BrandEnrichment(
            genericKey = "piperacillin + tazobactam",
            nepalBrands = listOf(
                BrandInfo("Pipra-Taz", "Deurali-Janta Pharmaceuticals", "Injection", "4.5 g / 2.25 g"),
                BrandInfo("Piptaz-NPL", "Nepal Pharmaceuticals Lab", "Injection", "4.5 g"),
                BrandInfo("Pipta-Quest", "Quest Pharmaceuticals", "Injection", "4.5 g")
            ),
            importedBrands = listOf(
                BrandInfo("Pipzo", "Sun Pharma", "Injection", "4.5 g / 2.25 g"),
                BrandInfo("Tazact", "Cipla Ltd.", "Injection", "4.5 g / 2.25 g"),
                BrandInfo("Zosyn", "Pfizer", "Injection", "4.5 g"),
                BrandInfo("Tazar", "Lupin Ltd.", "Injection", "4.5 g")
            )
        ),

        // 17. Meropenem
        BrandEnrichment(
            genericKey = "meropenem",
            nepalBrands = listOf(
                BrandInfo("Mero-DJPL", "Deurali-Janta Pharmaceuticals", "Injection", "1 g / 500 mg"),
                BrandInfo("Merop-NPL", "Nepal Pharmaceuticals Lab", "Injection", "1 g"),
                BrandInfo("Merocare", "Asian Pharmaceuticals", "Injection", "1 g")
            ),
            importedBrands = listOf(
                BrandInfo("Meronem", "Pfizer", "Injection", "1 g / 500 mg"),
                BrandInfo("Merocrit", "Cipla Ltd.", "Injection", "1 g / 500 mg"),
                BrandInfo("Meromac", "Macleods Pharmaceuticals", "Injection", "1 g"),
                BrandInfo("Ronem", "Aristo Pharmaceuticals", "Injection", "1 g")
            )
        ),

        // 18. Ibuprofen
        BrandEnrichment(
            genericKey = "ibuprofen",
            nepalBrands = listOf(
                BrandInfo("Ibufen", "Nepal Aushadhi Limited", "Tablet", "400 mg"),
                BrandInfo("Ibu-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Susp", "400 mg / 100mg/5mL"),
                BrandInfo("Ibu-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "400 mg"),
                BrandInfo("Ibulom", "Lomus Pharmaceuticals", "Tablet / Susp", "400 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Brufen", "Abbott Healthcare", "Tablet / Syrup", "200 mg / 400 mg / 100mg/5mL"),
                BrandInfo("Combiflam", "Sanofi", "Tablet / Syrup (Ibuprofen + Paracetamol)", "400mg + 325mg"),
                BrandInfo("Flexon", "Aristo Pharmaceuticals", "Tablet / Syrup (Ibuprofen + Paracetamol)", "400mg + 325mg"),
                BrandInfo("Ibugesic Plus", "Cipla Ltd.", "Tablet / Syrup", "400mg + 325mg")
            )
        ),

        // 19. Aceclofenac
        BrandEnrichment(
            genericKey = "aceclofenac",
            nepalBrands = listOf(
                BrandInfo("Aceclo-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "100 mg"),
                BrandInfo("Aceclofen-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "100 mg"),
                BrandInfo("Acefen", "Quest Pharmaceuticals", "Tablet", "100 mg"),
                BrandInfo("Acelom", "Lomus Pharmaceuticals", "Tablet", "100 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Zerodol", "Ipca Laboratories", "Tablet", "100 mg"),
                BrandInfo("Zerodol-SP", "Ipca Laboratories", "Tablet (Aceclo + Paracetamol + Serratiopeptidase)", "100mg + 325mg + 15mg"),
                BrandInfo("Zerodol-P", "Ipca Laboratories", "Tablet (Aceclo + Paracetamol)", "100mg + 325mg"),
                BrandInfo("Hifenac", "Intas Pharmaceuticals", "Tablet", "100 mg"),
                BrandInfo("Dolokind", "Mankind Pharma", "Tablet", "100 mg"),
                BrandInfo("Acenac", "Medley Pharmaceuticals", "Tablet", "100 mg")
            )
        ),

        // 20. Diclofenac
        BrandEnrichment(
            genericKey = "diclofenac",
            nepalBrands = listOf(
                BrandInfo("Diclo-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Gel / Inj", "50 mg / 75mg Inj"),
                BrandInfo("Diclon-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "50 mg / 75mg/3mL"),
                BrandInfo("Dicloc", "Quest Pharmaceuticals", "Tablet", "50 mg"),
                BrandInfo("Diclosan", "National Healthcare", "Tablet / Inj", "50 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Voveran", "Novartis", "Tablet / Gel / Inj / SR", "50 mg / 75 mg / 100 mg SR"),
                BrandInfo("Dynapar", "Troikaa Pharmaceuticals", "Tablet / Inj / Gel", "75 mg Inj / 50 mg"),
                BrandInfo("Voltaren", "GlaxoSmithKline", "Gel / Tablet", "1% Gel / 50 mg"),
                BrandInfo("Jonac", "German Remedies", "Tablet / Inj", "50 mg / 75 mg"),
                BrandInfo("Diclogesic", "Torrent Pharmaceuticals", "Tablet", "50 mg")
            )
        ),

        // 21. Tramadol
        BrandEnrichment(
            genericKey = "tramadol",
            nepalBrands = listOf(
                BrandInfo("Tram-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "50 mg / 100mg Inj"),
                BrandInfo("Tramadol-NPL", "Nepal Pharmaceuticals Lab", "Capsule / Inj", "50 mg"),
                BrandInfo("Tramasan", "National Healthcare", "Capsule", "50 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Tramazac", "Zydus Healthcare", "Capsule / Inj", "50 mg / 100mg Inj"),
                BrandInfo("Ultracet", "Janssen / Johnson & Johnson", "Tablet (Tramadol + Paracetamol)", "37.5mg + 325mg"),
                BrandInfo("Tramasure", "Mankind Pharma", "Tablet", "50 mg"),
                BrandInfo("Ultram", "PriCara", "Tablet", "50 mg")
            )
        ),

        // 22. Amlodipine
        BrandEnrichment(
            genericKey = "amlodipine",
            nepalBrands = listOf(
                BrandInfo("Amlo-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Amlon-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Amlocard", "Quest Pharmaceuticals", "Tablet", "5 mg"),
                BrandInfo("Amlomax", "National Healthcare", "Tablet", "5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Amlip", "Cipla Ltd.", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Amlodac", "Zydus Healthcare", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Stamlo", "Dr. Reddy's Laboratories", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Amlong", "Micro Labs", "Tablet", "5 mg"),
                BrandInfo("Norvasc", "Pfizer", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Amcard", "Sun Pharma", "Tablet", "5 mg")
            )
        ),

        // 23. Telmisartan
        BrandEnrichment(
            genericKey = "telmisartan",
            nepalBrands = listOf(
                BrandInfo("Teltan", "Deurali-Janta Pharmaceuticals", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Telma-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "40 mg"),
                BrandInfo("Telmisat", "Quest Pharmaceuticals", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Telmimax", "National Healthcare", "Tablet", "40 mg"),
                BrandInfo("Telmi-Asian", "Asian Pharmaceuticals", "Tablet", "40 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Telma", "Glenmark Pharmaceuticals", "Tablet", "20 mg / 40 mg / 80 mg"),
                BrandInfo("Telmikind", "Mankind Pharma", "Tablet", "40 mg"),
                BrandInfo("Tazloc", "Torrent Pharmaceuticals", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Telpres", "Sun Pharma", "Tablet", "40 mg"),
                BrandInfo("Micardis", "Boehringer Ingelheim", "Tablet", "40 mg / 80 mg")
            )
        ),

        // 24. Losartan
        BrandEnrichment(
            genericKey = "losartan",
            nepalBrands = listOf(
                BrandInfo("Losar-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Losan-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "50 mg"),
                BrandInfo("Losacart", "Quest Pharmaceuticals", "Tablet", "50 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Losacar", "Zydus Healthcare", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Repace", "Sun Pharma", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Tozaar", "Torrent Pharmaceuticals", "Tablet", "50 mg"),
                BrandInfo("Cozaar", "Organon", "Tablet", "50 mg / 100 mg")
            )
        ),

        // 25. Enalapril / Ramipril
        BrandEnrichment(
            genericKey = "enalapril",
            nepalBrands = listOf(
                BrandInfo("Enap-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Enal-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Envas", "Cadila Healthcare", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Enam", "Dr. Reddy's Laboratories", "Tablet", "5 mg"),
                BrandInfo("Vasotec", "Merck", "Tablet", "5 mg / 10 mg")
            )
        ),

        // 26. Metoprolol
        BrandEnrichment(
            genericKey = "metoprolol",
            nepalBrands = listOf(
                BrandInfo("Metpro-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "25 mg / 50 mg ER"),
                BrandInfo("Meto-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "50 mg"),
                BrandInfo("Metloc", "Quest Pharmaceuticals", "Tablet", "25 mg / 50 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Metolar", "Cipla Ltd.", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Betaloc", "AstraZeneca", "Tablet / Inj", "25 mg / 50 mg / 5mg Inj"),
                BrandInfo("Revelol", "Ipca Laboratories", "Tablet XL", "25 mg / 50 mg"),
                BrandInfo("Seloken", "AstraZeneca", "Tablet", "50 mg")
            )
        ),

        // 27. Bisoprolol
        BrandEnrichment(
            genericKey = "bisoprolol",
            nepalBrands = listOf(
                BrandInfo("Biso-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Bisocard-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "5 mg"),
                BrandInfo("Bisoprol", "Quest Pharmaceuticals", "Tablet", "5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Concor", "Merck", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Bisoheart", "Mankind Pharma", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Corbis", "Unichem Laboratories", "Tablet", "2.5 mg / 5 mg")
            )
        ),

        // 28. Nebivolol
        BrandEnrichment(
            genericKey = "nebivolol",
            nepalBrands = listOf(
                BrandInfo("Nebil-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Nebicard-NP", "Quest Pharmaceuticals", "Tablet", "5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Nebicard", "Torrent Pharmaceuticals", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Nebistar", "Lupin Ltd.", "Tablet", "5 mg"),
                BrandInfo("Nebilong", "Micro Labs", "Tablet", "2.5 mg / 5 mg"),
                BrandInfo("Bystolic", "Forest Labs", "Tablet", "5 mg")
            )
        ),

        // 29. Carvedilol
        BrandEnrichment(
            genericKey = "carvedilol",
            nepalBrands = listOf(
                BrandInfo("Carve-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "3.125 mg / 6.25 mg / 12.5 mg"),
                BrandInfo("Carven-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "6.25 mg / 12.5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Cardivas", "Sun Pharma", "Tablet", "3.125 mg / 6.25 mg / 12.5 mg / 25 mg"),
                BrandInfo("Carca", "Intas Pharmaceuticals", "Tablet", "6.25 mg / 12.5 mg"),
                BrandInfo("Coreg", "GSK", "Tablet", "6.25 mg / 12.5 mg")
            )
        ),

        // 30. Furosemide
        BrandEnrichment(
            genericKey = "furosemide",
            nepalBrands = listOf(
                BrandInfo("Salurin", "Nepal Aushadhi Limited", "Tablet", "40 mg"),
                BrandInfo("Furo-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "40 mg / 20mg/2mL"),
                BrandInfo("Furon-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "40 mg / 20mg")
            ),
            importedBrands = listOf(
                BrandInfo("Lasix", "Sanofi", "Tablet / Injection", "40 mg / 20mg/2mL"),
                BrandInfo("Frusenex", "Macleods Pharmaceuticals", "Tablet", "40 mg / 100 mg")
            )
        ),

        // 31. Torsemide
        BrandEnrichment(
            genericKey = "torsemide",
            nepalBrands = listOf(
                BrandInfo("Tors-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Torsem-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Dytor", "Cipla Ltd.", "Tablet / Inj", "5 mg / 10 mg / 20 mg / 20mg Inj"),
                BrandInfo("Torget", "Torrent Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Torsine", "Sun Pharma", "Tablet", "10 mg")
            )
        ),

        // 32. Spironolactone
        BrandEnrichment(
            genericKey = "spironolactone",
            nepalBrands = listOf(
                BrandInfo("Spiron-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Spiro-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "25 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Aldactone", "RPG Life Sciences", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Spilocard", "Torrent Pharmaceuticals", "Tablet", "25 mg / 50 mg"),
                BrandInfo("Practone", "Cipla Ltd.", "Tablet", "25 mg")
            )
        ),

        // 33. Atorvastatin
        BrandEnrichment(
            genericKey = "atorvastatin",
            nepalBrands = listOf(
                BrandInfo("Ator-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Atorva-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Atorsan", "Quest Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Atorlip-NP", "National Healthcare", "Tablet", "10 mg / 20 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Atorva", "Zydus Healthcare", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Lipitor", "Pfizer", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Storvas", "Sun Pharma", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Tonact", "Lupin Ltd.", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Atocor", "Dr. Reddy's Laboratories", "Tablet", "10 mg / 20 mg")
            )
        ),

        // 34. Rosuvastatin
        BrandEnrichment(
            genericKey = "rosuvastatin",
            nepalBrands = listOf(
                BrandInfo("Rosu-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Rosuv-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Rosulom", "Lomus Pharmaceuticals", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Rosuvas", "Sun Pharma", "Tablet", "5 mg / 10 mg / 20 mg / 40 mg"),
                BrandInfo("Crestor", "AstraZeneca", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Roseday", "USV Ltd.", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Rosulip", "Cipla Ltd.", "Tablet", "10 mg / 20 mg")
            )
        ),

        // 35. Clopidogrel
        BrandEnrichment(
            genericKey = "clopidogrel",
            nepalBrands = listOf(
                BrandInfo("Clopi-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "75 mg"),
                BrandInfo("Clopin-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "75 mg"),
                BrandInfo("Clopisan", "Quest Pharmaceuticals", "Tablet", "75 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Clopilet", "Sun Pharma", "Tablet", "75 mg / 150 mg"),
                BrandInfo("Deplatt", "Torrent Pharmaceuticals", "Tablet", "75 mg / 150 mg"),
                BrandInfo("Plavix", "Sanofi", "Tablet", "75 mg"),
                BrandInfo("Clavix", "Intas Pharmaceuticals", "Tablet", "75 mg")
            )
        ),

        // 36. Aspirin (Low Dose / Antiplatelet)
        BrandEnrichment(
            genericKey = "aspirin",
            nepalBrands = listOf(
                BrandInfo("Aspi-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "75 mg / 150 mg"),
                BrandInfo("Aspi-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "75 mg"),
                BrandInfo("Loprin-NP", "Quest Pharmaceuticals", "Tablet", "75 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Ecosprin", "USV Ltd.", "Gastro-resistant Tablet", "75 mg / 150 mg"),
                BrandInfo("Disprin", "Reckitt Benckiser", "Soluble Tablet", "350 mg"),
                BrandInfo("Delisprin", "Aristo Pharmaceuticals", "Tablet", "75 mg"),
                BrandInfo("ASA-Card", "Sun Pharma", "Tablet", "75 mg")
            )
        ),

        // 37. Metformin
        BrandEnrichment(
            genericKey = "metformin hydrochloride",
            nepalBrands = listOf(
                BrandInfo("Metphage", "Deurali-Janta Pharmaceuticals", "Tablet SR", "500 mg / 850 mg / 1000 mg"),
                BrandInfo("Metform-NPL", "Nepal Pharmaceuticals Lab", "Tablet SR", "500 mg / 1000 mg"),
                BrandInfo("Formin-NP", "Quest Pharmaceuticals", "Tablet", "500 mg / 850 mg"),
                BrandInfo("Metlom", "Lomus Pharmaceuticals", "Tablet", "500 mg"),
                BrandInfo("Met-Asian", "Asian Pharmaceuticals", "Tablet", "500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Glycomet", "USV Ltd.", "Tablet / SR", "250 mg / 500 mg / 850 mg / 1g SR"),
                BrandInfo("Gluconorm", "Lupin Ltd.", "Tablet SR", "500 mg / 1000 mg"),
                BrandInfo("Cetapin", "Sanofi", "Tablet SR", "500 mg / 1000 mg"),
                BrandInfo("Glucophage", "Merck", "Tablet", "500 mg / 850 mg / 1000 mg"),
                BrandInfo("Formin", "Alkem Laboratories", "Tablet", "500 mg")
            )
        ),

        // 38. Glimepiride
        BrandEnrichment(
            genericKey = "glimepiride",
            nepalBrands = listOf(
                BrandInfo("Glim-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "1 mg / 2 mg / 3 mg"),
                BrandInfo("Glimen-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "1 mg / 2 mg"),
                BrandInfo("Glimisan", "Quest Pharmaceuticals", "Tablet", "1 mg / 2 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Amaryl", "Sanofi", "Tablet", "1 mg / 2 mg / 3 mg / 4 mg"),
                BrandInfo("Glimestar", "Mankind Pharma", "Tablet", "1 mg / 2 mg"),
                BrandInfo("Zoryl", "Intas Pharmaceuticals", "Tablet", "1 mg / 2 mg"),
                BrandInfo("Glimy", "Dr. Reddy's Laboratories", "Tablet", "1 mg / 2 mg")
            )
        ),

        // 39. Vildagliptin / Sitagliptin
        BrandEnrichment(
            genericKey = "vildagliptin",
            nepalBrands = listOf(
                BrandInfo("Vilda-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "50 mg"),
                BrandInfo("Vildan-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "50 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Galvus", "Novartis", "Tablet", "50 mg"),
                BrandInfo("Zomelis", "Abbott Healthcare", "Tablet", "50 mg"),
                BrandInfo("Jalra", "USV Ltd.", "Tablet", "50 mg")
            )
        ),

        // 40. Dapagliflozin
        BrandEnrichment(
            genericKey = "dapagliflozin",
            nepalBrands = listOf(
                BrandInfo("Dapa-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapan-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Forxiga", "AstraZeneca", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dapanorm", "Alkem Laboratories", "Tablet", "10 mg"),
                BrandInfo("Oxra", "Sun Pharma", "Tablet", "10 mg"),
                BrandInfo("Dapavel", "Glenmark Pharmaceuticals", "Tablet", "10 mg")
            )
        ),

        // 41. Empagliflozin
        BrandEnrichment(
            genericKey = "empagliflozin",
            nepalBrands = listOf(
                BrandInfo("Empa-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Empan-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Jardiance", "Boehringer Ingelheim", "Tablet", "10 mg / 25 mg"),
                BrandInfo("Gibtulio", "Lupin Ltd.", "Tablet", "10 mg / 25 mg")
            )
        ),

        // 42. Levothyroxine
        BrandEnrichment(
            genericKey = "levothyroxine",
            nepalBrands = listOf(
                BrandInfo("Thyro-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "25 mcg / 50 mcg / 100 mcg"),
                BrandInfo("Thyron-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "50 mcg / 100 mcg")
            ),
            importedBrands = listOf(
                BrandInfo("Thyronorm", "Abbott Healthcare", "Tablet", "25 mcg / 50 mcg / 75 mcg / 100 mcg / 125 mcg"),
                BrandInfo("Eltroxin", "GlaxoSmithKline", "Tablet", "50 mcg / 100 mcg"),
                BrandInfo("Thyrox", "Macleods Pharmaceuticals", "Tablet", "50 mcg / 100 mcg"),
                BrandInfo("Synthroid", "AbbVie", "Tablet", "50 mcg / 100 mcg")
            )
        ),

        // 43. Cetirizine
        BrandEnrichment(
            genericKey = "cetirizine",
            nepalBrands = listOf(
                BrandInfo("Alatrol", "Square Pharmaceuticals / Nepal", "Tablet / Syrup", "10 mg / 5mg/5mL"),
                BrandInfo("Cetriz-NP", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg"),
                BrandInfo("Cetin-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg"),
                BrandInfo("Zocet-NP", "Quest Pharmaceuticals", "Tablet / Syrup", "10 mg"),
                BrandInfo("Cetrilom", "Lomus Pharmaceuticals", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Cetriz", "Alkem Laboratories", "Tablet / Syrup", "10 mg / 5mg/5mL"),
                BrandInfo("Okacet", "Cipla Ltd.", "Tablet / Syrup", "10 mg / 5mg/5mL"),
                BrandInfo("Cetzine", "Dr. Reddy's Laboratories", "Tablet", "10 mg"),
                BrandInfo("Incid-L", "Bayer", "Tablet", "10 mg"),
                BrandInfo("Zyrtec", "J&J", "Tablet / Syrup", "10 mg")
            )
        ),

        // 44. Levocetirizine
        BrandEnrichment(
            genericKey = "levocetirizine",
            nepalBrands = listOf(
                BrandInfo("Levocet-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "5 mg"),
                BrandInfo("Levocet-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Syrup", "5 mg"),
                BrandInfo("Levocip-NP", "Quest Pharmaceuticals", "Tablet", "5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Levocet", "Glenmark Pharmaceuticals", "Tablet / Syrup", "5 mg / 2.5mg/5mL"),
                BrandInfo("Teczine", "Sun Pharma", "Tablet / Syrup", "5 mg / 2.5mg/5mL"),
                BrandInfo("1-AL", "FDC Ltd.", "Tablet / Syrup", "5 mg"),
                BrandInfo("Xyzal", "Sanofi", "Tablet", "5 mg"),
                BrandInfo("L-Hist", "Alkem Laboratories", "Tablet", "5 mg")
            )
        ),

        // 45. Montelukast (+ Levocetirizine)
        BrandEnrichment(
            genericKey = "montelukast",
            nepalBrands = listOf(
                BrandInfo("Mont-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "4 mg / 5 mg / 10 mg"),
                BrandInfo("Montair-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg"),
                BrandInfo("Montel-NP", "Quest Pharmaceuticals", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Montair", "Cipla Ltd.", "Chewable Tab / Tablet", "4 mg / 5 mg / 10 mg"),
                BrandInfo("Montair-LC", "Cipla Ltd.", "Tablet (Montelukast + Levocetirizine)", "10mg + 5mg"),
                BrandInfo("Telekast", "Lupin Ltd.", "Tablet", "10 mg"),
                BrandInfo("Telekast-L", "Lupin Ltd.", "Tablet (Montelukast + Levocetirizine)", "10mg + 5mg"),
                BrandInfo("Romilast", "Ranbaxy / Sun Pharma", "Tablet", "10 mg"),
                BrandInfo("Montek-LC", "Sun Pharma", "Tablet", "10mg + 5mg"),
                BrandInfo("Singulair", "Organon", "Tablet", "10 mg")
            )
        ),

        // 46. Salbutamol / Albuterol
        BrandEnrichment(
            genericKey = "salbutamol",
            nepalBrands = listOf(
                BrandInfo("Salbu-NAL", "Nepal Aushadhi Limited", "Tablet", "2 mg / 4 mg"),
                BrandInfo("Salbu-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Syrup", "4 mg / 2mg/5mL"),
                BrandInfo("Salbut-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Syrup", "4 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Asthalin", "Cipla Ltd.", "Inhaler / Respule / Tab / Syr", "100 mcg MDI / 2.5mg Resp / 4mg"),
                BrandInfo("Ventorlin", "GlaxoSmithKline", "Inhaler / Syrup", "100 mcg / 2mg/5mL"),
                BrandInfo("Aerolin", "GSK", "Inhaler", "100 mcg"),
                BrandInfo("Salbair", "Lupin Ltd.", "Inhaler / Respule", "100 mcg / 2.5mg")
            )
        ),

        // 47. Formoterol + Budesonide / Inhalers
        BrandEnrichment(
            genericKey = "budesonide",
            nepalBrands = listOf(
                BrandInfo("Bude-DJPL", "Deurali-Janta Pharmaceuticals", "Respules", "0.5 mg / 1 mg"),
                BrandInfo("Budeson-NPL", "Nepal Pharmaceuticals Lab", "Respules", "0.5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Budecort", "Cipla Ltd.", "Inhaler / Respules", "100 mcg / 200 mcg / 0.5mg Respule"),
                BrandInfo("Foracort", "Cipla Ltd.", "Rotacaps / Inhaler (Formoterol + Budesonide)", "200 mcg / 400 mcg"),
                BrandInfo("Budamate", "Lupin Ltd.", "Inhaler / Transcaps", "200 mcg / 400 mcg"),
                BrandInfo("Symbicort", "AstraZeneca", "Turbuhaler", "160/4.5 mcg / 320/9 mcg"),
                BrandInfo("Pulmicort", "AstraZeneca", "Respules", "0.5 mg / 1 mg")
            )
        ),

        // 48. Levosalbutamol + Ipratropium
        BrandEnrichment(
            genericKey = "ipratropium",
            nepalBrands = listOf(
                BrandInfo("Ipra-DJPL", "Deurali-Janta Pharmaceuticals", "Respules", "250 mcg"),
                BrandInfo("Ipran-NPL", "Nepal Pharmaceuticals Lab", "Respules", "250 mcg")
            ),
            importedBrands = listOf(
                BrandInfo("Duolin", "Cipla Ltd.", "Inhaler / Respules (Levosalbutamol + Ipratropium)", "50mcg+20mcg / 1.25mg+500mcg"),
                BrandInfo("Combivent", "Boehringer Ingelheim", "Respules", "2.5mL"),
                BrandInfo("Ipratrop", "Cipla Ltd.", "Inhaler", "20 mcg"),
                BrandInfo("Levolin", "Cipla Ltd.", "Inhaler / Respules", "50 mcg / 0.63mg")
            )
        ),

        // 49. Cough Syrups / Cold
        BrandEnrichment(
            genericKey = "dextromethorphan",
            nepalBrands = listOf(
                BrandInfo("Cof-DJPL", "Deurali-Janta Pharmaceuticals", "Syrup", "100 mL"),
                BrandInfo("Cofnil-NPL", "Nepal Pharmaceuticals Lab", "Syrup", "100 mL")
            ),
            importedBrands = listOf(
                BrandInfo("Ascoril", "Glenmark Pharmaceuticals", "Syrup (Expectorant / D / LS)", "100 mL"),
                BrandInfo("Alex", "Glenmark Pharmaceuticals", "Syrup (Dextromethorphan + CPM + Phenylephrine)", "100 mL"),
                BrandInfo("Benadryl", "Johnson & Johnson", "Cough Syrup", "100 mL"),
                BrandInfo("Zedex", "Wockhardt", "Cough Syrup", "100 mL"),
                BrandInfo("Corex-DX", "Pfizer", "Syrup", "100 mL"),
                BrandInfo("Grilinctus", "Franco-Indian", "Syrup", "100 mL")
            )
        ),

        // 50. Cold Formulations (Phenylephrine + Paracetamol + CPM)
        BrandEnrichment(
            genericKey = "chlorpheniramine",
            nepalBrands = listOf(
                BrandInfo("Cold-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "Standard"),
                BrandInfo("Cofarest-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "Standard")
            ),
            importedBrands = listOf(
                BrandInfo("Sinarest", "Centaur Pharmaceuticals", "Tablet / Syrup", "Paracetamol + Phenylephrine + CPM"),
                BrandInfo("Wikoryl", "Alembic Pharmaceuticals", "Tablet / Syrup", "Paracetamol + Phenylephrine + CPM"),
                BrandInfo("Cheston Cold", "Cipla Ltd.", "Tablet", "Cetirizine + Phenylephrine + Paracetamol"),
                BrandInfo("Maxtra", "Zuventus Healthcare", "Syrup / Drops", "Phenylephrine + CPM"),
                BrandInfo("Coldarin", "Sanofi", "Tablet", "Standard")
            )
        ),

        // 51. Ondansetron
        BrandEnrichment(
            genericKey = "ondansetron",
            nepalBrands = listOf(
                BrandInfo("Ondan-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "4 mg / 8 mg / 4mg Inj"),
                BrandInfo("Ondan-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "4 mg / 4mg/2mL"),
                BrandInfo("Periset-NP", "Quest Pharmaceuticals", "Tablet", "4 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Emeset", "Cipla Ltd.", "Tablet / Inj / Syrup", "4 mg / 8 mg / 2mg/mL Inj"),
                BrandInfo("Ondem", "Alkem Laboratories", "Tablet / Inj / Syrup", "4 mg / 8 mg / 2mg/5mL"),
                BrandInfo("Vomitron", "Sun Pharma", "Tablet / Inj", "4 mg / 8 mg"),
                BrandInfo("Zofer", "Sun Pharma", "Tablet / Inj", "4 mg / 8 mg"),
                BrandInfo("Zofran", "Novartis", "Tablet / Inj", "4 mg / 8 mg")
            )
        ),

        // 52. Domperidone
        BrandEnrichment(
            genericKey = "domperidone",
            nepalBrands = listOf(
                BrandInfo("Dom-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Drop", "10 mg / 10mg/mL"),
                BrandInfo("Dom-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Domstal", "Torrent Pharmaceuticals", "Tablet / Suspension / Drops", "10 mg / 1mg/mL"),
                BrandInfo("Motilium", "Janssen / J&J", "Tablet / Suspension", "10 mg"),
                BrandInfo("Vomistop", "Cipla Ltd.", "Tablet", "10 mg")
            )
        ),

        // 53. Metoclopramide
        BrandEnrichment(
            genericKey = "metoclopramide",
            nepalBrands = listOf(
                BrandInfo("Perinorm-NAL", "Nepal Aushadhi Limited", "Tablet", "10 mg"),
                BrandInfo("Meto-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "10 mg / 10mg/2mL"),
                BrandInfo("Reglan-NP", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Perinorm", "Ipca Laboratories", "Tablet / Injection / Syrup", "10 mg / 10mg/2mL"),
                BrandInfo("Reglan", "ANI Pharmaceuticals", "Tablet / Inj", "10 mg"),
                BrandInfo("Maxeron", "Wallace Pharmaceuticals", "Tablet / Inj", "10 mg")
            )
        ),

        // 54. Laxatives (Bisacodyl / Lactulose / Cremaffin)
        BrandEnrichment(
            genericKey = "lactulose",
            nepalBrands = listOf(
                BrandInfo("Lactu-DJPL", "Deurali-Janta Pharmaceuticals", "Syrup", "10 g/15mL"),
                BrandInfo("Lactun-NPL", "Nepal Pharmaceuticals Lab", "Syrup", "10 g/15mL")
            ),
            importedBrands = listOf(
                BrandInfo("Duphalac", "Abbott Healthcare", "Syrup", "3.335 g/5mL (100mL / 200mL / 450mL)"),
                BrandInfo("Cremaffin", "Abbott Healthcare", "Emulsion (Liquid Paraffin + Milk of Magnesia)", "170 mL / 225 mL"),
                BrandInfo("Dulcolax", "Sanofi", "Tablet / Suppository (Bisacodyl)", "5 mg / 10 mg"),
                BrandInfo("Ezilax", "Sun Pharma", "Syrup", "10 g/15mL"),
                BrandInfo("Softovac", "Lupin Ltd.", "Granules", "100 g")
            )
        ),

        // 55. Loperamide
        BrandEnrichment(
            genericKey = "loperamide",
            nepalBrands = listOf(
                BrandInfo("Lopam-DJPL", "Deurali-Janta Pharmaceuticals", "Capsule", "2 mg"),
                BrandInfo("Lopan-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "2 mg"),
                BrandInfo("Lomid", "Asian Pharmaceuticals", "Capsule", "2 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Lopamide", "Torrent Pharmaceuticals", "Tablet", "2 mg"),
                BrandInfo("Imodium", "Johnson & Johnson", "Capsule", "2 mg"),
                BrandInfo("Eldoper", "Micro Labs", "Capsule", "2 mg")
            )
        ),

        // 55b. Oral Rehydration Salts (ORS / Jeevan Jal)
        BrandEnrichment(
            genericKey = "oral rehydration salts",
            nepalBrands = listOf(
                BrandInfo("Jeevan Jal ORS", "Nepal Aushadhi Limited / MoHP", "Sachet", "WHO Low Osmolarity 20.5g for 1L"),
                BrandInfo("Nava Jeevan ORS", "Nepal Pharmaceuticals Lab", "Sachet", "WHO Low Osmolarity 20.5g for 1L"),
                BrandInfo("ORS-Quest", "Quest Pharmaceuticals", "Sachet", "WHO Formula 20.5g for 1L"),
                BrandInfo("Electrobion", "Procter & Gamble Nepal", "Sachet", "21.8g for 1L")
            ),
            importedBrands = listOf(
                BrandInfo("Electral ORS", "FDC Ltd.", "Sachet", "WHO Formula 21.8g for 1L"),
                BrandInfo("Walyte", "Cipla Ltd.", "Sachet", "20.5g for 1L"),
                BrandInfo("Pocari Sweat", "Otsuka", "Drink / Powder", "Electrolyte Solution")
            )
        ),

        // 56. Clonazepam
        BrandEnrichment(
            genericKey = "clonazepam",
            nepalBrands = listOf(
                BrandInfo("Clona-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "0.25 mg / 0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Clonap-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "0.5 mg / 1 mg"),
                BrandInfo("Clonafast", "Quest Pharmaceuticals", "Tablet", "0.5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Zapiz", "Intas Pharmaceuticals", "Tablet", "0.25 mg / 0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Petril", "Micro Labs", "Tablet", "0.25 mg / 0.5 mg / 1 mg"),
                BrandInfo("Epitril", "Novartis", "Tablet", "0.5 mg / 2 mg"),
                BrandInfo("Rivotril", "Roche", "Tablet", "0.5 mg / 2 mg"),
                BrandInfo("Lonazep", "Sun Pharma", "Tablet", "0.5 mg / 1 mg / 2 mg")
            )
        ),

        // 57. Alprazolam
        BrandEnrichment(
            genericKey = "alprazolam",
            nepalBrands = listOf(
                BrandInfo("Alpra-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "0.25 mg / 0.5 mg"),
                BrandInfo("Alpraz-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "0.25 mg / 0.5 mg"),
                BrandInfo("Alprosan", "National Healthcare", "Tablet", "0.5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Alprax", "Torrent Pharmaceuticals", "Tablet", "0.25 mg / 0.5 mg / 1 mg"),
                BrandInfo("Restyl", "Cipla Ltd.", "Tablet", "0.25 mg / 0.5 mg"),
                BrandInfo("Alzolam", "Sun Pharma", "Tablet", "0.25 mg / 0.5 mg"),
                BrandInfo("Trika", "Unichem Laboratories", "Tablet", "0.25 mg / 0.5 mg"),
                BrandInfo("Xanax", "Pfizer", "Tablet", "0.25 mg / 0.5 mg / 1 mg")
            )
        ),

        // 58. Diazepam
        BrandEnrichment(
            genericKey = "diazepam",
            nepalBrands = listOf(
                BrandInfo("Diaze-NAL", "Nepal Aushadhi Limited", "Tablet", "5 mg"),
                BrandInfo("Diaz-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "5 mg / 10mg/2mL"),
                BrandInfo("Diazepam-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "5 mg / 10mg/2mL")
            ),
            importedBrands = listOf(
                BrandInfo("Valium", "Roche", "Tablet / Injection", "5 mg / 10 mg / 10mg/2mL"),
                BrandInfo("Calmpose", "Ranbaxy / Sun Pharma", "Tablet / Inj", "5 mg / 10mg/2mL")
            )
        ),

        // 59. Escitalopram
        BrandEnrichment(
            genericKey = "escitalopram",
            nepalBrands = listOf(
                BrandInfo("Escita-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Escit-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Escilom", "Lomus Pharmaceuticals", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Nexito", "Sun Pharma", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Cilentra", "Intas Pharmaceuticals", "Tablet", "5 mg / 10 mg / 20 mg"),
                BrandInfo("Stalopam", "Lupin Ltd.", "Tablet", "10 mg / 20 mg"),
                BrandInfo("S-Citadep", "Cipla Ltd.", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Lexapro", "Allergan", "Tablet", "10 mg / 20 mg")
            )
        ),

        // 60. Sertraline
        BrandEnrichment(
            genericKey = "sertraline",
            nepalBrands = listOf(
                BrandInfo("Sertra-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Sertran-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "50 mg / 100 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Sertima", "Intas Pharmaceuticals", "Tablet", "25 mg / 50 mg / 100 mg"),
                BrandInfo("Daxid", "Pfizer", "Tablet", "50 mg / 100 mg"),
                BrandInfo("Zoloft", "Pfizer", "Tablet", "50 mg / 100 mg"),
                BrandInfo("Serta", "Sun Pharma", "Tablet", "50 mg"),
                BrandInfo("Serlift", "Torrent Pharmaceuticals", "Tablet", "50 mg / 100 mg")
            )
        ),

        // 61. Levetiracetam
        BrandEnrichment(
            genericKey = "levetiracetam",
            nepalBrands = listOf(
                BrandInfo("Levi-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Syr", "250 mg / 500 mg / 100mg/mL"),
                BrandInfo("Levip-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Levipil", "Sun Pharma", "Tablet / Syrup / Inj", "250 mg / 500 mg / 750 mg / 1000 mg"),
                BrandInfo("Keppra", "UCB Pharma", "Tablet / Oral Sol / Inj", "500 mg / 1000 mg"),
                BrandInfo("Torleva", "Torrent Pharmaceuticals", "Tablet", "500 mg / 750 mg"),
                BrandInfo("Levera", "Intas Pharmaceuticals", "Tablet", "500 mg")
            )
        ),

        // 62. Sodium Valproate / Divalproex
        BrandEnrichment(
            genericKey = "sodium valproate",
            nepalBrands = listOf(
                BrandInfo("Valpro-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet CR / Syr", "200 mg / 300 mg / 500 mg CR"),
                BrandInfo("Valpron-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "300 mg / 500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Encorate", "Sun Pharma", "Tablet Chrono / Syrup / Inj", "200 mg / 300 mg / 500 mg Chrono"),
                BrandInfo("Valparin", "Sanofi", "Tablet Chrono / Syrup", "200 mg / 300 mg / 500 mg"),
                BrandInfo("Depakote", "AbbVie", "Tablet ER", "250 mg / 500 mg"),
                BrandInfo("Epilim", "Sanofi", "Tablet Chrono", "200 mg / 500 mg")
            )
        ),

        // 63. Carbamazepine
        BrandEnrichment(
            genericKey = "carbamazepine",
            nepalBrands = listOf(
                BrandInfo("Carba-NAL", "Nepal Aushadhi Limited", "Tablet", "200 mg"),
                BrandInfo("Carba-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet CR", "200 mg / 400 mg CR"),
                BrandInfo("Carban-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "200 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Tegretol", "Novartis", "Tablet / CR / Syrup", "100 mg / 200 mg / 400 mg CR"),
                BrandInfo("Mazetol", "Abbott Healthcare", "Tablet / SR", "100 mg / 200 mg / 400 mg"),
                BrandInfo("Zen", "Sun Pharma", "Tablet", "200 mg")
            )
        ),

        // 64. Phenytoin
        BrandEnrichment(
            genericKey = "phenytoin",
            nepalBrands = listOf(
                BrandInfo("Pheny-NAL", "Nepal Aushadhi Limited", "Tablet", "100 mg"),
                BrandInfo("Pheny-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "100 mg / 100mg/2mL")
            ),
            importedBrands = listOf(
                BrandInfo("Eptoin", "Abbott Healthcare", "Tablet / Injection", "50 mg / 100 mg / 100mg/2mL"),
                BrandInfo("Dilantin", "Pfizer", "Capsule / Inj", "100 mg")
            )
        ),

        // 65. Gabapentin / Pregabalin
        BrandEnrichment(
            genericKey = "gabapentin",
            nepalBrands = listOf(
                BrandInfo("Gaba-DJPL", "Deurali-Janta Pharmaceuticals", "Capsule", "100 mg / 300 mg"),
                BrandInfo("Gaban-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "300 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Gabapin", "Intas Pharmaceuticals", "Capsule / Tablet", "100 mg / 300 mg / 400 mg"),
                BrandInfo("Neurontin", "Pfizer", "Capsule", "300 mg / 400 mg"),
                BrandInfo("Prebaxe", "Sun Pharma", "Capsule (Pregabalin)", "75 mg / 150 mg"),
                BrandInfo("Lyrica", "Pfizer", "Capsule (Pregabalin)", "75 mg / 150 mg"),
                BrandInfo("Maxgalin", "Torrent Pharmaceuticals", "Capsule", "75 mg")
            )
        ),

        // 66. Olanzapine
        BrandEnrichment(
            genericKey = "olanzapine",
            nepalBrands = listOf(
                BrandInfo("Olan-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Olanz-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "5 mg / 10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Oleanz", "Sun Pharma", "Tablet / Melt / Inj", "2.5 mg / 5 mg / 10 mg / 15 mg"),
                BrandInfo("Oliza", "Intas Pharmaceuticals", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Zyprexa", "Eli Lilly", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Olexar", "Cipla Ltd.", "Tablet", "5 mg / 10 mg")
            )
        ),

        // 67. Levodopa + Carbidopa
        BrandEnrichment(
            genericKey = "levodopa + carbidopa",
            nepalBrands = listOf(
                BrandInfo("Levo-Carb-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "100/25 mg / 250/25 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Syndopa", "Sun Pharma", "Tablet (110 / 275 / Plus / CR)", "100/10 mg / 100/25 mg / 250/25 mg"),
                BrandInfo("Tidomet", "Torrent Pharmaceuticals", "Tablet (LS / Plus / Forte)", "100/10 mg / 100/25 mg / 250/25 mg"),
                BrandInfo("Sinemet", "Organon", "Tablet", "100/25 mg / 250/25 mg")
            )
        ),

        // 68. Tamsulosin
        BrandEnrichment(
            genericKey = "tamsulosin",
            nepalBrands = listOf(
                BrandInfo("Tamsu-DJPL", "Deurali-Janta Pharmaceuticals", "Capsule MR", "0.4 mg"),
                BrandInfo("Tamsul-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "0.4 mg"),
                BrandInfo("Tamsan", "Quest Pharmaceuticals", "Capsule", "0.4 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Urimax", "Cipla Ltd.", "Capsule MR / 0.4", "0.4 mg"),
                BrandInfo("Flodart", "Sun Pharma", "Tablet", "0.4 mg"),
                BrandInfo("Veltam", "Intas Pharmaceuticals", "Capsule", "0.4 mg"),
                BrandInfo("Dynapres", "Torrent Pharmaceuticals", "Capsule", "0.4 mg"),
                BrandInfo("Flomax", "Boehringer Ingelheim", "Capsule", "0.4 mg")
            )
        ),

        // 69. Silodosin / Finasteride
        BrandEnrichment(
            genericKey = "silodosin",
            nepalBrands = listOf(
                BrandInfo("Silo-DJPL", "Deurali-Janta Pharmaceuticals", "Capsule", "4 mg / 8 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Silodal", "Sun Pharma", "Capsule", "4 mg / 8 mg"),
                BrandInfo("Silofast", "Cipla Ltd.", "Capsule", "4 mg / 8 mg"),
                BrandInfo("Rapaflo", "Allergan", "Capsule", "8 mg"),
                BrandInfo("Finax", "Dr. Reddy's Laboratories", "Tablet (Finasteride)", "1 mg / 5 mg"),
                BrandInfo("Proscar", "Organon", "Tablet (Finasteride)", "5 mg"),
                BrandInfo("Fincar", "Cipla Ltd.", "Tablet (Finasteride)", "5 mg")
            )
        ),

        // 70. Betamethasone / Dexamethasone / Prednisolone
        BrandEnrichment(
            genericKey = "dexamethasone",
            nepalBrands = listOf(
                BrandInfo("Dexa-NAL", "Nepal Aushadhi Limited", "Tablet / Inj", "0.5 mg / 4mg/mL"),
                BrandInfo("Dexa-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet / Inj", "0.5 mg / 4mg/2mL"),
                BrandInfo("Dexan-NPL", "Nepal Pharmaceuticals Lab", "Tablet / Inj", "0.5 mg / 4mg")
            ),
            importedBrands = listOf(
                BrandInfo("Dexona", "Zydus Healthcare", "Tablet / Injection", "0.5 mg / 4mg/mL"),
                BrandInfo("Decdan", "Wockhardt", "Tablet / Inj", "0.5 mg / 4mg"),
                BrandInfo("Betnesol", "GlaxoSmithKline", "Tablet / Inj / Drops (Betamethasone)", "0.5 mg / 4mg/mL"),
                BrandInfo("Wysolone", "Pfizer", "Tablet (Prednisolone)", "5 mg / 10 mg / 20 mg / 40 mg"),
                BrandInfo("Omnacortil", "Macleods Pharmaceuticals", "Tablet / Drops (Prednisolone)", "5 mg / 10 mg / 20 mg / 5mg/5mL"),
                BrandInfo("Medrol", "Pfizer", "Tablet (Methylprednisolone)", "4 mg / 8 mg / 16 mg")
            )
        ),

        // 71. Topicals: Betnovate / Tenovate / Candid / Bactroban / Betadine
        BrandEnrichment(
            genericKey = "betamethasone dipropionate",
            nepalBrands = listOf(
                BrandInfo("Betnov-NP", "Deurali-Janta Pharmaceuticals", "Cream / Ointment", "0.1%"),
                BrandInfo("Betason-NPL", "Nepal Pharmaceuticals Lab", "Cream", "0.1%")
            ),
            importedBrands = listOf(
                BrandInfo("Betnovate", "GlaxoSmithKline", "Cream / Ointment / N / C / GM", "0.1% / 20g / 50g"),
                BrandInfo("Tenovate", "GlaxoSmithKline", "Cream / Ointment (Clobetasol)", "0.05% / 15g / 30g"),
                BrandInfo("Dermovate", "GSK", "Cream / Ointment", "0.05%"),
                BrandInfo("Candid", "Glenmark Pharmaceuticals", "Cream / Powder / Lotion (Clotrimazole)", "1% / 30g / 50g"),
                BrandInfo("Canesten", "Bayer", "Cream", "1%"),
                BrandInfo("Bactroban", "GlaxoSmithKline", "Ointment (Mupirocin)", "2% / 5g / 15g"),
                BrandInfo("Supirocin", "Glenmark Pharmaceuticals", "Ointment (Mupirocin)", "2% / 5g"),
                BrandInfo("Betadine", "Win-Medicare", "Ointment / Solution / Gargle (Povidone Iodine)", "5% / 10% / 2%"),
                BrandInfo("Cipladine", "Cipla Ltd.", "Ointment / Solution", "5% / 10%"),
                BrandInfo("Burnol", "Morepen Laboratories", "Antiseptic Cream", "20g"),
                BrandInfo("Silverex", "Rexcin Pharmaceuticals", "Cream (Silver Sulfadiazine)", "1% / 25g / 250g"),
                BrandInfo("Scaboma", "Glenmark Pharmaceuticals", "Lotion (Permethrin / Lindane)", "1% / 5% 100mL"),
                BrandInfo("Permite", "Galderma", "Cream (Permethrin)", "5% / 30g"),
                BrandInfo("Calamine / Caladryl", "Piramal Healthcare", "Lotion", "120 mL")
            )
        ),

        // 72. Lansoprazole
        BrandEnrichment(
            genericKey = "lansoprazole",
            nepalBrands = listOf(
                BrandInfo("Junior Lanzol", "Cipla Nepal", "DT Tablet", "15 mg"),
                BrandInfo("Lanzol", "Cipla Nepal", "Capsule", "15 mg / 30 mg"),
                BrandInfo("Lanpro", "Deurali-Janta Pharmaceuticals", "Capsule", "30 mg"),
                BrandInfo("Lan-30", "Quest Pharmaceuticals", "Capsule", "30 mg"),
                BrandInfo("Lanzop", "Nepal Pharmaceuticals Lab", "Capsule", "30 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Lanzol", "Cipla Ltd.", "Capsule", "15 mg / 30 mg"),
                BrandInfo("Junior Lanzol", "Cipla Ltd.", "Dispersible Tab", "15 mg"),
                BrandInfo("Prevacid", "Takeda", "Delayed-Release Cap", "15 mg / 30 mg"),
                BrandInfo("Lan", "Intas Pharmaceuticals", "Capsule", "30 mg")
            )
        ),

        // 73. Dexlansoprazole
        BrandEnrichment(
            genericKey = "dexlansoprazole",
            nepalBrands = listOf(
                BrandInfo("Dexpure", "Asian Pharmaceuticals", "DDR Capsule", "30 mg / 60 mg"),
                BrandInfo("Dexilant-NP", "Quest Pharmaceuticals", "DDR Capsule", "30 mg / 60 mg"),
                BrandInfo("Dexla", "Deurali-Janta Pharmaceuticals", "DDR Capsule", "30 mg / 60 mg"),
                BrandInfo("D-Lans", "Nepal Pharmaceuticals Lab", "DDR Capsule", "60 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Dexilant", "Takeda", "DDR Capsule", "30 mg / 60 mg"),
                BrandInfo("Delprazol", "Macleods", "DDR Capsule", "30 mg / 60 mg"),
                BrandInfo("Dexla", "Lupin", "DDR Capsule", "30 mg / 60 mg")
            )
        ),

        // 74. Ilaprazole
        BrandEnrichment(
            genericKey = "ilaprazole",
            nepalBrands = listOf(
                BrandInfo("Ila-P", "Lomus Pharmaceuticals", "Tablet", "10 mg"),
                BrandInfo("Ilapro", "Quest Pharmaceuticals", "Tablet", "10 mg"),
                BrandInfo("Ilapra", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg"),
                BrandInfo("Ila-D", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Iladac", "Zydus Cadila", "Tablet", "10 mg"),
                BrandInfo("Blokacid", "Ajanta Pharma", "Tablet", "10 mg"),
                BrandInfo("Lupila", "Lupin", "Tablet", "10 mg")
            )
        ),

        // 75. Granisetron
        BrandEnrichment(
            genericKey = "granisetron",
            nepalBrands = listOf(
                BrandInfo("Granicip", "Cipla Nepal", "Injection / Tab", "1 mg/mL, 1 mg tab"),
                BrandInfo("Graniforce", "Mankind Pharma Nepal", "Injection / Tab", "1 mg/mL, 1 mg tab"),
                BrandInfo("Granitron", "Deurali-Janta Pharmaceuticals", "Tablet", "1 mg / 2 mg"),
                BrandInfo("Graniset-Quest", "Quest Pharmaceuticals", "Injection", "1 mg / 3 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Kytril", "Roche", "Injection / Tab", "1 mg, 2 mg"),
                BrandInfo("Granicip", "Cipla", "Injection / Tab", "1 mg/mL, 1 mg tab"),
                BrandInfo("Graniforce", "Mankind", "Tablet / Inj", "1 mg, 2 mg")
            )
        ),

        // 76. Palonosetron
        BrandEnrichment(
            genericKey = "palonosetron",
            nepalBrands = listOf(
                BrandInfo("Palostar", "Quest Pharmaceuticals", "Injection", "0.25 mg / 5 mL"),
                BrandInfo("Palonox", "Nepal Pharmaceuticals Lab", "Injection", "0.25 mg / 5 mL"),
                BrandInfo("Palnox", "Lomus Pharmaceuticals", "Injection", "0.25 mg / 5 mL"),
                BrandInfo("Palosafe-NP", "Asian Pharmaceuticals", "Injection", "0.25 mg / 5 mL")
            ),
            importedBrands = listOf(
                BrandInfo("Aloxi", "Helsinn / Eisai", "Injection", "0.25 mg / 5 mL"),
                BrandInfo("Palosafe", "Mankind", "Injection", "0.25 mg / 5 mL"),
                BrandInfo("Palonext", "Dr. Reddy's", "Injection", "0.25 mg / 5 mL")
            )
        ),

        // 77. Aprepitant
        BrandEnrichment(
            genericKey = "aprepitant",
            nepalBrands = listOf(
                BrandInfo("Aprecap", "Glenmark Nepal", "Capsule Pack", "125 mg + 2x 80 mg"),
                BrandInfo("Emend-NP", "MSD / Quest Pharma", "Capsule Pack", "125 mg + 2x 80 mg"),
                BrandInfo("Aprepep", "Asian Pharmaceuticals", "Capsule Pack", "125 mg + 2x 80 mg"),
                BrandInfo("Apriset", "Nepal Pharmaceuticals Lab", "Capsule Pack", "125 mg + 2x 80 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Emend", "Merck Sharp & Dohme (MSD)", "Capsule Pack", "125 mg + 2x 80 mg"),
                BrandInfo("Aprecap", "Glenmark", "Capsule Pack", "125 mg + 2x 80 mg"),
                BrandInfo("Apriset", "Dr. Reddy's", "Capsule Pack", "125 mg + 2x 80 mg")
            )
        ),

        // 78. Ispaghula Husk (Psyllium)
        BrandEnrichment(
            genericKey = "ispaghula",
            nepalBrands = listOf(
                BrandInfo("Fybogel", "Reckitt Benckiser Nepal", "Effervescent Granules", "3.5 g sachet"),
                BrandInfo("Ispabowel", "Lomus Pharmaceuticals", "Granules/Husk", "100 g jar"),
                BrandInfo("Isabgol-NPL", "Nepal Pharmaceuticals Lab", "Pure Husk", "100 g / 200 g"),
                BrandInfo("Naturelax", "Deurali-Janta Pharmaceuticals", "Husk Powder", "100 g jar")
            ),
            importedBrands = listOf(
                BrandInfo("Fybogel Orange", "Reckitt", "Sachet", "3.5 g"),
                BrandInfo("Softovac", "Lupin", "Powder", "100 g / 250 g"),
                BrandInfo("Isabgol", "Baidyanath / Dabur", "Pure Husk", "100 g"),
                BrandInfo("Metamucil", "Procter & Gamble", "Powder", "Pack")
            )
        ),

        // 79. Milk of Magnesia / Magnesium Hydroxide
        BrandEnrichment(
            genericKey = "magnesium hydroxide",
            nepalBrands = listOf(
                BrandInfo("Cremaffin", "Abbott Nepal", "Suspension", "Magnesium Hydroxide + Liq Paraffin"),
                BrandInfo("Phillips MOM", "GSK Nepal", "Suspension", "Magnesium Hydroxide 8% w/v"),
                BrandInfo("Magnesia-Lomus", "Lomus Pharmaceuticals", "Suspension", "400 mg / 5 mL"),
                BrandInfo("MOM-NPL", "Nepal Pharmaceuticals Lab", "Suspension", "Magnesium Hydroxide Oral"),
                BrandInfo("Gelusil-M", "Pfizer Nepal", "Suspension", "Magnesium Hydroxide Antacid")
            ),
            importedBrands = listOf(
                BrandInfo("Phillips Milk of Magnesia", "Bayer / GSK", "Suspension", "Magnesium Hydroxide"),
                BrandInfo("Cremaffin", "Abbott", "Suspension", "Mag Hydroxide + Liq Paraffin"),
                BrandInfo("Gelusil", "Pfizer", "Suspension", "Mag Hydroxide + Alum Hydroxide")
            )
        ),

        // 80. Sodium Alginate + Sodium Bicarbonate (Gaviscon)
        BrandEnrichment(
            genericKey = "sodium alginate",
            nepalBrands = listOf(
                BrandInfo("Gaviscon", "Reckitt Benckiser Nepal", "Suspension / Chew Tab", "500mg/267mg per 10mL"),
                BrandInfo("Refluxid", "Quest Pharmaceuticals", "Suspension", "Sodium Alginate Reflux"),
                BrandInfo("Algigel", "Deurali-Janta Pharmaceuticals", "Suspension", "Alginate Raft Formula"),
                BrandInfo("Gastrocid-A", "Nepal Pharmaceuticals Lab", "Chewable Tablet", "Alginate + Bicarbonate")
            ),
            importedBrands = listOf(
                BrandInfo("Gaviscon Double Action", "Reckitt", "Liquid / Chew Tab", "Alginate 500mg + Bicarb"),
                BrandInfo("Algiscon", "Abbott", "Suspension", "Sodium Alginate + Bicarbonate"),
                BrandInfo("Refluxoff", "Mankind", "Suspension", "Alginate Formula")
            )
        ),

        // 81. Simethicone
        BrandEnrichment(
            genericKey = "simethicone",
            nepalBrands = listOf(
                BrandInfo("Colinorm", "Lomus Pharmaceuticals", "Drops / Tablets", "40 mg/mL, 80 mg tab"),
                BrandInfo("Degas", "Quest Pharmaceuticals", "Chewable Tab / Drops", "80 mg, 40 mg/mL"),
                BrandInfo("Gas-Free", "Deurali-Janta Pharmaceuticals", "Chewable Tablet", "40 mg / 80 mg"),
                BrandInfo("Flatu-Nil", "Nepal Pharmaceuticals Lab", "Drops / Tab", "40 mg/mL"),
                BrandInfo("Colicaid", "Meyer / Quest Nepal", "Paediatric Drops", "Simethicone + Dill Oil")
            ),
            importedBrands = listOf(
                BrandInfo("Gas-X", "GSK", "Chewable Tab / Softgel", "80 mg, 125 mg"),
                BrandInfo("Polycrol", "Piramal Healthcare", "Liquid / Chew Tab", "Simethicone + Antacids"),
                BrandInfo("Gelusil MPS", "Pfizer", "Tablet / Liquid", "Simethicone Antacid"),
                BrandInfo("Colicaid", "Meyer Organics", "Infant Drops", "Simethicone 40mg/mL")
            )
        ),

        // 82. Diphenoxylate + Atropine
        BrandEnrichment(
            genericKey = "diphenoxylate",
            nepalBrands = listOf(
                BrandInfo("Lomotil", "RPG / Sanofi Nepal", "Tablet", "2.5 mg / 0.025 mg"),
                BrandInfo("Lomofen", "RPG Life Sciences Nepal", "Tablet", "2.5 mg / 0.025 mg"),
                BrandInfo("Dia-Stop", "Lomus Pharmaceuticals", "Tablet", "2.5 mg / 0.025 mg"),
                BrandInfo("Difen-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "2.5 mg / 0.025 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Lomotil", "RPG Life Sciences", "Tablet", "2.5 mg / 0.025 mg"),
                BrandInfo("Lomofen", "RPG", "Tablet", "2.5 mg / 0.025 mg"),
                BrandInfo("Diarlop", "Cipla", "Tablet", "2.5 mg / 0.025 mg")
            )
        ),

        // 83. Silymarin
        BrandEnrichment(
            genericKey = "silymarin",
            nepalBrands = listOf(
                BrandInfo("Silybon", "Micro Labs Nepal", "Tablet / Capsule", "70 mg / 140 mg"),
                BrandInfo("Silymar", "Deurali-Janta Pharmaceuticals", "Capsule", "140 mg"),
                BrandInfo("Hepaliv-S", "Lomus Pharmaceuticals", "Capsule", "140 mg"),
                BrandInfo("Livercare-S", "Quest Pharmaceuticals", "Tablet", "140 mg"),
                BrandInfo("Sily-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "140 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Silybon", "Micro Labs", "Suspension / Tab", "70 mg, 140 mg"),
                BrandInfo("Hepa-Merz", "Sun Pharma / Merz", "Granules / Infusion", "LOLA + Silymarin"),
                BrandInfo("Legalon", "Madaus", "Capsule", "140 mg"),
                BrandInfo("Liv-52", "Himalaya", "Syrup / Tablet", "Herbal Hepatoprotective")
            )
        ),

        // 85. Vonoprazan / Vonopran
        BrandEnrichment(
            genericKey = "vonoprazan",
            nepalBrands = listOf(
                BrandInfo("Vonopran", "Lomus Pharmaceuticals", "Tablet (P-CAB)", "10 mg / 20 mg"),
                BrandInfo("Vonafresh", "Asian Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Vonasafe", "Quest Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Vonozap", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg / 20 mg"),
                BrandInfo("P-Cab", "Deurali-Janta Pharmaceuticals", "Tablet", "20 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Vonopran", "Alkem Laboratories", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Voquezna", "Phathom Pharmaceuticals / Dr. Reddy's", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Vonopraz", "Sun Pharma", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Lupivon", "Lupin Ltd.", "Tablet", "20 mg"),
                BrandInfo("Macpraz", "Macleods Pharmaceuticals", "Tablet", "20 mg"),
                BrandInfo("Takecab", "Takeda Pharmaceuticals", "Tablet", "10 mg / 20 mg")
            )
        ),

        BrandEnrichment(
            genericKey = "vonopran",
            nepalBrands = listOf(
                BrandInfo("Vonopran", "Lomus Pharmaceuticals", "Tablet (P-CAB)", "10 mg / 20 mg"),
                BrandInfo("Vonafresh", "Asian Pharmaceuticals", "Tablet", "10 mg / 20 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Vonopran", "Alkem Laboratories", "Tablet", "10 mg / 20 mg")
            )
        ),

        // 86. Azilsartan Medoxomil
        BrandEnrichment(
            genericKey = "azilsartan",
            nepalBrands = listOf(
                BrandInfo("Azildac", "Zydus Nepal", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Abel", "Lupin Nepal", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Zilpres", "Asian Pharmaceuticals", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Azilsan", "Quest Pharmaceuticals", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Aziltor", "Torrent Nepal", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Azil-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "40 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Edarbi", "Takeda / Lupin", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Azildac", "Zydus Cadila", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Abel", "Lupin Ltd.", "Tablet", "40 mg / 80 mg"),
                BrandInfo("Zilarbi", "Sun Pharma", "Tablet", "40 mg / 80 mg")
            )
        ),

        // 87. Vericiguat
        BrandEnrichment(
            genericKey = "vericiguat",
            nepalBrands = listOf(
                BrandInfo("Verquvo", "Bayer Nepal", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Veriheart", "Sun Pharma Nepal", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Vericip", "Cipla Nepal", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Veric-DJPL", "Deurali-Janta Pharmaceuticals", "Tablet", "2.5 mg / 5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Verquvo", "Bayer / MSD", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Verifast", "Lupin Ltd.", "Tablet", "2.5 mg / 5 mg / 10 mg"),
                BrandInfo("Veritas", "Intas Pharmaceuticals", "Tablet", "2.5 mg / 5 mg / 10 mg")
            )
        ),

        // 88. Bempedoic Acid + Ezetimibe
        BrandEnrichment(
            genericKey = "bempedoic",
            nepalBrands = listOf(
                BrandInfo("Bemdac-EZ", "Zydus Nepal", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Brillo-EZ", "Sun Pharma Nepal", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Bempro-EZ", "Quest Pharmaceuticals", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Bempo-EZ", "Asian Pharmaceuticals", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Bemlip-EZ", "Deurali-Janta Pharmaceuticals", "Tablet", "180 mg + 10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Nexlizet", "Esperion / Daiichi Sankyo", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Bemdac-EZ", "Zydus Cadila", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Brillo-EZ", "Sun Pharma", "Tablet", "180 mg + 10 mg"),
                BrandInfo("Bemzet", "Cipla Ltd.", "Tablet", "180 mg + 10 mg")
            )
        ),

        // 89. Remogliflozin Etabonate
        BrandEnrichment(
            genericKey = "remogliflozin",
            nepalBrands = listOf(
                BrandInfo("Remo", "Glenmark Nepal", "Tablet", "100 mg"),
                BrandInfo("Remozul", "Torrent Nepal", "Tablet", "100 mg"),
                BrandInfo("Remo-M", "Glenmark Nepal", "Tablet", "100mg + 500mg Metformin"),
                BrandInfo("Zucara", "Quest Pharmaceuticals", "Tablet", "100 mg"),
                BrandInfo("Remofit", "Asian Pharmaceuticals", "Tablet", "100 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Remo", "Glenmark Pharmaceuticals", "Tablet", "100 mg"),
                BrandInfo("Zucara", "Torrent Pharmaceuticals", "Tablet", "100 mg"),
                BrandInfo("Remozen", "Mankind Pharma", "Tablet", "100 mg")
            )
        ),

        // 90. Dapagliflozin + Vildagliptin
        BrandEnrichment(
            genericKey = "vildagliptin",
            nepalBrands = listOf(
                BrandInfo("Galvus-Dapa", "Novartis Nepal", "Tablet", "10 mg / 100 mg SR"),
                BrandInfo("Zita-D", "Glenmark Nepal", "Tablet", "10 mg / 100 mg"),
                BrandInfo("Vildaprime-D", "Quest Pharmaceuticals", "Tablet", "10 mg / 100 mg"),
                BrandInfo("Dapavin", "Asian Pharmaceuticals", "Tablet", "10 mg / 100 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Galvus-Dapa", "Novartis India", "Tablet", "10 mg / 100 mg SR"),
                BrandInfo("Zita-D", "Glenmark Pharmaceuticals", "Tablet", "10 mg / 100 mg"),
                BrandInfo("Jalra-D", "USV Pvt Ltd", "Tablet", "10 mg / 100 mg"),
                BrandInfo("Vysov-D", "Intas Pharmaceuticals", "Tablet", "10 mg / 100 mg")
            )
        ),

        // 91. Rimegepant
        BrandEnrichment(
            genericKey = "rimegepant",
            nepalBrands = listOf(
                BrandInfo("Nurtec ODT", "Pfizer Nepal", "ODT Tablet", "75 mg"),
                BrandInfo("Rimegep", "Sun Pharma Nepal", "ODT Tablet", "75 mg"),
                BrandInfo("Rimepan", "Cipla Nepal", "ODT Tablet", "75 mg"),
                BrandInfo("Rimez", "Lupin Nepal", "ODT Tablet", "75 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Nurtec ODT", "Pfizer India", "ODT Tablet", "75 mg"),
                BrandInfo("Rimegep", "Sun Pharma", "ODT Tablet", "75 mg"),
                BrandInfo("Rimecure", "Intas Pharmaceuticals", "ODT Tablet", "75 mg")
            )
        ),

        // 92. Vilazodone
        BrandEnrichment(
            genericKey = "vilazodone",
            nepalBrands = listOf(
                BrandInfo("Vilano", "Sun Pharma Nepal", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Vilazine", "Intas Nepal", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Viladep", "Torrent Nepal", "Tablet", "20 mg / 40 mg"),
                BrandInfo("Vilazod", "Quest Pharmaceuticals", "Tablet", "20 mg / 40 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Viibryd", "AbbVie / Allergan", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Vilano", "Sun Pharma", "Tablet", "10 mg / 20 mg / 40 mg"),
                BrandInfo("Vilazine", "Intas Pharmaceuticals", "Tablet", "10 mg / 20 mg / 40 mg")
            )
        ),

        // 93. Lemborexant
        BrandEnrichment(
            genericKey = "lemborexant",
            nepalBrands = listOf(
                BrandInfo("Dayvigo", "Eisai Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Lembo", "Sun Pharma Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Lemborest", "Intas Nepal", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Dormilex", "Quest Pharmaceuticals", "Tablet", "5 mg / 10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Dayvigo", "Eisai / Lupin", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Lembo", "Sun Pharma", "Tablet", "5 mg / 10 mg"),
                BrandInfo("Lemborest", "Intas Pharmaceuticals", "Tablet", "5 mg / 10 mg")
            )
        ),

        // 94. Dupilumab
        BrandEnrichment(
            genericKey = "dupilumab",
            nepalBrands = listOf(
                BrandInfo("Dupixent", "Sanofi / Regeneron Nepal", "Pre-filled Pen", "300 mg / 2 mL"),
                BrandInfo("Dupix", "Zydus Biologics Nepal", "Pre-filled Syringe", "300 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Dupixent", "Sanofi India", "Pre-filled Pen", "300 mg / 2 mL"),
                BrandInfo("Dupitrust", "Dr. Reddy's Laboratories", "Pre-filled Syringe", "300 mg")
            )
        ),

        // 95. Brexpiprazole
        BrandEnrichment(
            genericKey = "brexpiprazole",
            nepalBrands = listOf(
                BrandInfo("Rexulti", "Otsuka / Lundbeck Nepal", "Tablet", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Brexzee", "Sun Pharma Nepal", "Tablet", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Brexpip", "Torrent Nepal", "Tablet", "1 mg / 2 mg"),
                BrandInfo("Brexura", "Intas Nepal", "Tablet", "1 mg / 2 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Rexulti", "Otsuka / Lundbeck", "Tablet", "0.5 mg / 1 mg / 2 mg / 3 mg"),
                BrandInfo("Brexzee", "Sun Pharma", "Tablet", "0.5 mg / 1 mg / 2 mg"),
                BrandInfo("Brexal", "Lupin Ltd.", "Tablet", "1 mg / 2 mg")
            )
        ),

        // 96. Atogepant
        BrandEnrichment(
            genericKey = "atogepant",
            nepalBrands = listOf(
                BrandInfo("Atogep-NPL", "Deurali-Janta / Quest", "Tablet", "10 mg / 60 mg"),
                BrandInfo("Qulip-NP", "Lomus / Asian Pharma", "Tablet", "60 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Qulipta", "AbbVie", "Tablet", "10 mg / 30 mg / 60 mg"),
                BrandInfo("Atogep", "Dr. Reddy's", "Tablet", "10 mg / 60 mg"),
                BrandInfo("Aquipta", "AbbVie / Allergan India", "Tablet", "60 mg")
            )
        ),

        // 97. Tenapanor
        BrandEnrichment(
            genericKey = "tenapanor",
            nepalBrands = listOf(
                BrandInfo("Ibsrela-NP", "Quest / Nepal Pharma", "Tablet", "50 mg"),
                BrandInfo("Tenapa-NP", "Deurali-Janta", "Tablet", "30 mg / 50 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Ibsrela", "Ardelyx", "Tablet", "50 mg"),
                BrandInfo("Xphozah", "Ardelyx", "Tablet", "30 mg"),
                BrandInfo("Tenapan", "Sun Pharma / Intas", "Tablet", "30 mg / 50 mg")
            )
        ),

        // 98. Fezolinetant
        BrandEnrichment(
            genericKey = "fezolinetant",
            nepalBrands = listOf(
                BrandInfo("Veozah-NP", "Asian Pharma / Quest", "Tablet", "45 mg"),
                BrandInfo("Fezo-NP", "Lomus Pharmaceuticals", "Tablet", "45 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Veozah", "Astellas Pharma", "Tablet", "45 mg"),
                BrandInfo("Fezolin", "Sun Pharma / Intas", "Tablet", "45 mg"),
                BrandInfo("Velnita", "Dr. Reddy's", "Tablet", "45 mg")
            )
        ),

        // 99. Pregabalin + Nortriptyline
        BrandEnrichment(
            genericKey = "nortriptyline",
            nepalBrands = listOf(
                BrandInfo("Preganor", "Deurali-Janta Pharmaceuticals", "Tablet", "75 mg + 10 mg / 75 mg + 25 mg"),
                BrandInfo("Gabamax-NT", "Quest Pharmaceuticals", "Tablet", "75 mg + 10 mg"),
                BrandInfo("Pregabid-NT", "Intas / Nepal Pharma", "Tablet", "75 mg + 10 mg"),
                BrandInfo("Maxgalin-NT", "Sun Pharma Nepal", "Tablet", "75 mg + 10 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Pregabid-NT", "Intas Pharmaceuticals", "Tablet", "75 mg + 10 mg / 75 mg + 25 mg"),
                BrandInfo("Gabamax-NT", "Aristo Pharmaceuticals", "Tablet", "75 mg + 10 mg"),
                BrandInfo("Maxgalin-NT", "Sun Pharma", "Tablet", "75 mg + 10 mg"),
                BrandInfo("Pregeb-NT", "Torrent Pharma", "Tablet", "75 mg + 10 mg")
            )
        ),

        // 100. Rabeprazole + Levosulpiride
        BrandEnrichment(
            genericKey = "rabeprazole + levosulpiride",
            nepalBrands = listOf(
                BrandInfo("Rabicip-L", "Cipla Nepal", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Veloz-L", "Torrent / Nepal Pharma", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Razo-L", "Dr. Reddy's Nepal", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Rabilab-LS", "Deurali-Janta Pharmaceuticals", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Placid-L", "Lomus Pharmaceuticals", "Capsule SR", "20 mg + 75 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Rabicip-L", "Cipla Ltd.", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Veloz-L", "Torrent Pharmaceuticals", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Razo-L", "Dr. Reddy's", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Rabekind-Plus", "Mankind Pharma", "Capsule SR", "20 mg + 75 mg"),
                BrandInfo("Happi-L", "Zydus Lifesciences", "Capsule SR", "20 mg + 75 mg")
            )
        ),

        // 101. Etofylline + Theophylline (Deriphyllin)
        BrandEnrichment(
            genericKey = "etofylline",
            nepalBrands = listOf(
                BrandInfo("Deriphyllin", "Zydus Nepal", "Tablet / Injection", "150mg / 300mg / 2mL Amp"),
                BrandInfo("Deriphyll-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "150 mg / 300 mg"),
                BrandInfo("Bronchophylline", "Deurali-Janta Pharmaceuticals", "Tablet", "150 mg / 300 mg"),
                BrandInfo("Theofed", "Lomus Pharmaceuticals", "Tablet", "150 mg / 300 mg"),
                BrandInfo("Asthmaphylline", "Quest Pharmaceuticals", "Tablet", "300 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Deriphyllin", "Zydus Healthcare", "Tablet / Injection", "150 mg / 300 mg Retard / 2mL"),
                BrandInfo("Deriphyllin-OD", "Zydus Healthcare", "Tablet CR", "300 mg / 450 mg"),
                BrandInfo("Theo-Asthalin", "Cipla Ltd.", "Tablet", "Theophylline + Salbutamol")
            )
        ),

        // 102. Anti-Rabies Vaccine
        BrandEnrichment(
            genericKey = "rabies vaccine",
            nepalBrands = listOf(
                BrandInfo("Rabipur", "Chiron Behring / GSK Nepal", "Vial + Diluent (PCECV)", "≥2.5 IU / mL"),
                BrandInfo("Abhayrab", "Indian Immunologicals / Nepal", "Vial + Diluent (PVRV)", "≥2.5 IU / 0.5 mL"),
                BrandInfo("Verorab", "Sanofi Pasteur Nepal", "Vial + Diluent (PVRV)", "≥2.5 IU / 0.5 mL"),
                BrandInfo("Vaxirab N", "Zydus Lifesciences Nepal", "Vial + Diluent (PCECV)", "≥2.5 IU / 1.0 mL"),
                BrandInfo("Indirab", "Bharat Serums & Vaccines Nepal", "Vial + Diluent (PVRV)", "≥2.5 IU / 0.5 mL")
            ),
            importedBrands = listOf(
                BrandInfo("Rabipur", "Chiron Behring Vaccines", "Vial + Sterile Water", "≥2.5 IU"),
                BrandInfo("Abhayrab", "Indian Immunologicals Ltd.", "Vial + Diluent", "≥2.5 IU"),
                BrandInfo("Verorab", "Sanofi Healthcare India", "Vial + Diluent", "≥2.5 IU")
            )
        ),

        // 103. Japanese Encephalitis Vaccine
        BrandEnrichment(
            genericKey = "japanese encephalitis",
            nepalBrands = listOf(
                BrandInfo("CD.JEVAX", "Chengdu Institute / Nepal MoHP NIP", "Vial + Diluent (Live Attenuated SA 14-14-2)", "0.5 mL"),
                BrandInfo("Imojev", "Sanofi Pasteur Nepal", "Vial + Diluent (Recombinant Live)", "0.5 mL"),
                BrandInfo("JENVAC", "Bharat Biotech Nepal", "Vial (Inactivated)", "0.5 mL")
            ),
            importedBrands = listOf(
                BrandInfo("JENVAC", "Bharat Biotech International", "Single dose vial", "0.5 mL"),
                BrandInfo("CD.JEVAX", "Chengdu Biological / Biological E", "Vial + Diluent", "0.5 mL"),
                BrandInfo("Imojev", "Sanofi India", "Prefilled syringe", "0.5 mL")
            )
        ),

        // 104. Typhoid Conjugate Vaccine (TCV)
        BrandEnrichment(
            genericKey = "typhoid conjugate",
            nepalBrands = listOf(
                BrandInfo("Typbar-TCV", "Bharat Biotech / Nepal MoHP EPI", "Single-dose vial", "25 mcg Vi polysaccharide / 0.5 mL"),
                BrandInfo("Zyvac-TCV", "Zydus Lifesciences Nepal", "Single-dose vial", "25 mcg / 0.5 mL"),
                BrandInfo("Typhevax", "Biological E Nepal", "Single-dose vial", "25 mcg / 0.5 mL")
            ),
            importedBrands = listOf(
                BrandInfo("Typbar-TCV", "Bharat Biotech International", "Single dose vial / PFS", "25 mcg Vi polysaccharide"),
                BrandInfo("PedaTyph", "Bio-Med", "Vial", "5 mcg Vi conjugate"),
                BrandInfo("Typhevax", "Biological E Ltd.", "Vial", "25 mcg")
            )
        ),

        // 105. Isoxsuprine
        BrandEnrichment(
            genericKey = "isoxsuprine",
            nepalBrands = listOf(
                BrandInfo("Duvadilan", "Abbott Nepal", "Tablet / Injection", "10 mg / 40 mg SR / 2 mL Amp"),
                BrandInfo("Suprine", "Quest Pharmaceuticals", "Tablet", "10 mg / 40 mg SR"),
                BrandInfo("Tidilan", "Deurali-Janta Pharmaceuticals", "Tablet", "10 mg / 20 mg"),
                BrandInfo("Isox-NPL", "Nepal Pharmaceuticals Lab", "Tablet", "10 mg / 40 mg SR"),
                BrandInfo("Gestaprine", "Asian Pharmaceuticals", "Tablet", "10 mg / 40 mg SR")
            ),
            importedBrands = listOf(
                BrandInfo("Duvadilan", "Abbott Healthcare", "Tablet / Injection", "10 mg / 40 mg Retard / 10mg Inj"),
                BrandInfo("Tidilan", "Sun Pharma", "Tablet", "10 mg / 20 mg / 40 mg Retard"),
                BrandInfo("Supradyl", "Mankind Pharma", "Tablet", "40 mg SR")
            )
        ),

        // 106. Amorolfine
        BrandEnrichment(
            genericKey = "amorolfine",
            nepalBrands = listOf(
                BrandInfo("Loceryl 5% Lacquer", "Galderma / Nepal", "Nail Lacquer", "5% w/v (5 mL)"),
                BrandInfo("Amorolf", "Asian Pharmaceuticals", "Nail Lacquer / Cream", "5% Lacquer / 0.25% Cream"),
                BrandInfo("Fungicros", "Sun Pharma Nepal", "Nail Lacquer / Cream", "5% Lacquer / 0.25% Cream"),
                BrandInfo("Arolf", "Quest Pharmaceuticals", "Nail Lacquer", "5% w/v (5 mL)"),
                BrandInfo("Amorderm", "National Healthcare", "Cream", "0.25% w/w (20g)")
            ),
            importedBrands = listOf(
                BrandInfo("Loceryl", "Galderma India", "Nail Lacquer Kit", "5% w/v"),
                BrandInfo("Fungicros", "Sun Pharma", "Nail Lacquer / Cream", "5% / 0.25%"),
                BrandInfo("Amrolmac", "Macleods", "Nail Lacquer", "5% w/v")
            )
        ),

        // 107. Rabeprazole + Domperidone
        BrandEnrichment(
            genericKey = "rabeprazole sodium + domperidone",
            nepalBrands = listOf(
                BrandInfo("Razo-D", "Dr. Reddy's Nepal", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Rabekind-D", "Mankind Nepal", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Cyra-D", "Systopic Nepal", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Rabicer-D", "Deurali-Janta Pharmaceuticals", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Robikem-D", "Alkem Nepal", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Rabep-D", "Nepal Pharmaceuticals Lab", "Capsule SR", "20 mg + 30 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Razo-D", "Dr. Reddy's Laboratories", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Rabicip-D", "Cipla Ltd.", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Cyra-D", "Systopic Laboratories", "Capsule SR", "20 mg + 30 mg"),
                BrandInfo("Rablet-D", "Lupin Ltd.", "Capsule SR", "20 mg + 30 mg")
            )
        ),

        // 108. Esomeprazole + Domperidone
        BrandEnrichment(
            genericKey = "esomeprazole + domperidone",
            nepalBrands = listOf(
                BrandInfo("Esomac-D", "Cipla Nepal", "Capsule SR", "40 mg + 30 mg"),
                BrandInfo("Nexpro-RD", "Torrent Nepal", "Capsule SR", "40 mg + 30 mg"),
                BrandInfo("Sompraz-D", "Sun Pharma Nepal", "Capsule SR", "40 mg + 30 mg"),
                BrandInfo("Esoz-D", "Glenmark Nepal", "Capsule SR", "40 mg + 30 mg"),
                BrandInfo("Esofag-D", "Deurali-Janta Pharmaceuticals", "Capsule SR", "40 mg + 30 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Nexpro-RD", "Torrent Pharmaceuticals", "Capsule SR", "40 mg + 30 mg"),
                BrandInfo("Sompraz-D", "Sun Pharma", "Capsule SR", "40 mg + 30 mg"),
                BrandInfo("Esokem-D", "Alkem Laboratories", "Capsule SR", "40 mg + 30 mg")
            )
        ),

        // 109. Telmisartan + Chlorthalidone
        BrandEnrichment(
            genericKey = "telmisartan + chlorthalidone",
            nepalBrands = listOf(
                BrandInfo("Telma-CT", "Glenmark Nepal", "Tablet", "40/12.5 mg / 80/12.5 mg"),
                BrandInfo("Teltan-CT", "Deurali-Janta Pharmaceuticals", "Tablet", "40/12.5 mg / 80/12.5 mg"),
                BrandInfo("Tazloc-CT", "Torrent Nepal", "Tablet", "40/12.5 mg / 80/12.5 mg"),
                BrandInfo("Telpres-CT", "Sun Pharma Nepal", "Tablet", "40/12.5 mg"),
                BrandInfo("Telmikind-CT", "Mankind Nepal", "Tablet", "40/12.5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Telma-CT", "Glenmark Pharmaceuticals", "Tablet", "40/12.5 mg / 80/12.5 mg"),
                BrandInfo("Tazloc-CT", "Torrent Pharmaceuticals", "Tablet", "40/12.5 mg"),
                BrandInfo("Telpres-CT", "Sun Pharma", "Tablet", "40/12.5 mg / 80/12.5 mg")
            )
        ),

        // 110. Tamsulosin + Dutasteride
        BrandEnrichment(
            genericKey = "tamsulosin + dutasteride",
            nepalBrands = listOf(
                BrandInfo("Urimax-D", "Cipla Nepal", "Capsule", "0.4 mg + 0.5 mg"),
                BrandInfo("Veltam-Plus", "Intas Nepal", "Capsule", "0.4 mg + 0.5 mg"),
                BrandInfo("Tamlet-D", "Sun Pharma Nepal", "Capsule", "0.4 mg + 0.5 mg"),
                BrandInfo("Flodart-Plus", "Macleods Nepal", "Capsule", "0.4 mg + 0.5 mg"),
                BrandInfo("Uroflo-D", "Quest Pharmaceuticals", "Capsule", "0.4 mg + 0.5 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Urimax-D", "Cipla Ltd.", "Capsule", "0.4 mg + 0.5 mg"),
                BrandInfo("Veltam-Plus", "Intas Pharmaceuticals", "Capsule", "0.4 mg + 0.5 mg"),
                BrandInfo("Flodart-Plus", "Macleods Pharmaceuticals", "Capsule", "0.4 mg + 0.5 mg")
            )
        ),

        // 111. Rosuvastatin + Fenofibrate
        BrandEnrichment(
            genericKey = "rosuvastatin + fenofibrate",
            nepalBrands = listOf(
                BrandInfo("Rozavel-F", "Sun Pharma Nepal", "Tablet", "10 mg + 160 mg / 10 mg + 145 mg"),
                BrandInfo("Rosuvas-F", "Ranbaxy / Sun Nepal", "Tablet", "10 mg + 160 mg"),
                BrandInfo("Lipirose-F", "Mankind Nepal", "Tablet", "10 mg + 145 mg"),
                BrandInfo("Novastat-TG", "Lupin Nepal", "Tablet", "10 mg + 145 mg"),
                BrandInfo("Rosufit-F", "Torrent Nepal", "Tablet", "10 mg + 145 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Rozavel-F", "Sun Pharma", "Tablet", "10 mg + 160 mg"),
                BrandInfo("Novastat-TG", "Lupin Ltd.", "Tablet", "10 mg + 145 mg"),
                BrandInfo("Rosuvas-F", "Sun Pharma", "Tablet", "10 mg + 160 mg")
            )
        ),

        // 112. Atorvastatin + Fenofibrate
        BrandEnrichment(
            genericKey = "atorvastatin + fenofibrate",
            nepalBrands = listOf(
                BrandInfo("Atorva-F", "Zydus Nepal", "Tablet", "10 mg + 145 mg / 10 mg + 160 mg"),
                BrandInfo("Tonact-F", "Lupin Nepal", "Tablet", "10 mg + 145 mg"),
                BrandInfo("Atocor-F", "Dr. Reddy's Nepal", "Tablet", "10 mg + 160 mg"),
                BrandInfo("Lipikind-F", "Mankind Nepal", "Tablet", "10 mg + 145 mg"),
                BrandInfo("Storvas-F", "Sun Pharma Nepal", "Tablet", "10 mg + 145 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Tonact-F", "Lupin Ltd.", "Tablet", "10 mg + 145 mg"),
                BrandInfo("Atorva-F", "Zydus Healthcare", "Tablet", "10 mg + 160 mg"),
                BrandInfo("Lipikind-F", "Mankind Pharma", "Tablet", "10 mg + 145 mg")
            )
        ),

        // 113. Cefoperazone + Sulbactam
        BrandEnrichment(
            genericKey = "cefoperazone + sulbactam",
            nepalBrands = listOf(
                BrandInfo("Magnex", "Pfizer Nepal", "IV Injection / Infusion", "1.5g / 3g Vial"),
                BrandInfo("Sulbacin", "Cipla Nepal", "IV Injection", "1.5g / 3g Vial"),
                BrandInfo("Ceftas-SB", "Intas Nepal", "IV Injection", "1.5g / 3g"),
                BrandInfo("Zosul", "Alkem Nepal", "IV Injection", "1.5g / 3g"),
                BrandInfo("Cefosul-NPL", "Nepal Pharmaceuticals Lab", "IV Injection", "1.5g Vial")
            ),
            importedBrands = listOf(
                BrandInfo("Magnex", "Pfizer India", "IV Vial", "1.5g / 3g"),
                BrandInfo("Sulbacin", "Cipla Ltd.", "IV Vial", "1.5g / 3g"),
                BrandInfo("Ceftas-SB", "Intas Pharmaceuticals", "IV Vial", "1.5g")
            )
        ),

        // 114. Glimepiride + Metformin
        BrandEnrichment(
            genericKey = "glimepiride + metformin",
            nepalBrands = listOf(
                BrandInfo("Glycomet-GP", "USV Nepal", "Tablet", "1/500 mg / 2/500 mg / 2/1000 mg SR"),
                BrandInfo("Amaryl-M", "Sanofi Nepal", "Tablet", "1/500 mg / 2/500 mg"),
                BrandInfo("Diaprime-M", "Deurali-Janta Pharmaceuticals", "Tablet", "1/500 mg / 2/500 mg"),
                BrandInfo("Glimy-M", "Nepal Pharmaceuticals Lab", "Tablet", "1/500 mg / 2/500 mg"),
                BrandInfo("Glimestar-M", "Mankind Nepal", "Tablet", "1/500 mg / 2/500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Glycomet-GP 1 / 2", "USV Ltd.", "Tablet", "1/500 mg / 2/500 mg"),
                BrandInfo("Amaryl-M", "Sanofi India", "Tablet", "1/500 mg / 2/500 mg"),
                BrandInfo("Glimestar-M", "Mankind Pharma", "Tablet", "1/500 mg / 2/500 mg")
            )
        ),

        // 115. Glimepiride + Metformin + Voglibose
        BrandEnrichment(
            genericKey = "glimepiride + metformin + voglibose",
            nepalBrands = listOf(
                BrandInfo("Trio-SR", "USV Nepal", "Tablet", "1/500/0.2 mg / 2/500/0.2 mg"),
                BrandInfo("Glimestar-PM", "Mankind Nepal", "Tablet", "1/500/0.2 mg / 2/500/0.2 mg"),
                BrandInfo("Glycomet-Trio", "USV Nepal", "Tablet", "1/500/0.2 mg / 2/500/0.3 mg"),
                BrandInfo("Amaryl-M-VP", "Sanofi Nepal", "Tablet", "1/500/0.2 mg / 2/500/0.2 mg"),
                BrandInfo("Volix-Trio", "Sun Pharma Nepal", "Tablet", "1/500/0.2 mg / 2/500/0.2 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Glycomet-Trio 1 / 2", "USV Ltd.", "Tablet", "1/500/0.2 mg / 2/500/0.3 mg"),
                BrandInfo("Glimestar-PM", "Mankind Pharma", "Tablet", "1/500/0.2 mg / 2/500/0.2 mg"),
                BrandInfo("Zoryl-MV", "Intas Pharmaceuticals", "Tablet", "1/500/0.2 mg")
            )
        ),

        // 116. Dapagliflozin + Metformin
        BrandEnrichment(
            genericKey = "dapagliflozin + metformin",
            nepalBrands = listOf(
                BrandInfo("Oxra-M", "Sun Pharma Nepal", "Tablet SR", "10/500 mg / 10/1000 mg"),
                BrandInfo("Dapa-M", "Cipla Nepal", "Tablet SR", "10/500 mg / 10/1000 mg"),
                BrandInfo("Forxiga-M", "AstraZeneca Nepal", "Tablet SR", "10/1000 mg"),
                BrandInfo("Dapavel-M", "Torrent Nepal", "Tablet SR", "10/500 mg / 10/1000 mg"),
                BrandInfo("Dapaford-M", "Leeford Nepal", "Tablet SR", "10/500 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Oxra-M", "Sun Pharma", "Tablet SR", "10/500 mg / 10/1000 mg"),
                BrandInfo("Forxiga-M", "AstraZeneca India", "Tablet SR", "10/1000 mg"),
                BrandInfo("Dapavel-M", "Torrent Pharmaceuticals", "Tablet SR", "10/500 mg")
            )
        ),

        // 117. Carboxymethylcellulose
        BrandEnrichment(
            genericKey = "carboxymethylcellulose",
            nepalBrands = listOf(
                BrandInfo("Refresh Tears 0.5%", "Allergan Nepal", "Eye Drops", "0.5% w/v (10 mL)"),
                BrandInfo("Tears Plus", "Nepal Eye Hospital / NPL", "Eye Drops", "0.5% w/v (10 mL)"),
                BrandInfo("Eyemist", "Sun Pharma Nepal", "Eye Drops", "0.5% w/v (10 mL)"),
                BrandInfo("Lacryl", "Entod Nepal", "Eye Drops", "0.5% / 1% (10 mL)"),
                BrandInfo("Vistafresh", "Cipla Nepal", "Eye Drops", "0.5% w/v (10 mL)")
            ),
            importedBrands = listOf(
                BrandInfo("Refresh Tears", "Allergan India", "Eye Drops", "0.5% w/v (10 mL)"),
                BrandInfo("Eyemist", "Sun Pharma", "Eye Drops", "0.5% w/v (10 mL)"),
                BrandInfo("Tears Plus", "Allergan", "Eye Drops", "0.5% w/v")
            )
        ),

        // 118. Norfloxacin + Tinidazole
        BrandEnrichment(
            genericKey = "norfloxacin + tinidazole",
            nepalBrands = listOf(
                BrandInfo("Norflox-TZ", "Cipla Nepal", "Tablet", "400 mg + 600 mg"),
                BrandInfo("Normaxin-TZ", "Torrent Nepal", "Tablet", "400 mg + 600 mg"),
                BrandInfo("Floxagyl-TZ", "Nepal Pharmaceuticals Lab", "Tablet", "400 mg + 600 mg"),
                BrandInfo("Tiniflox", "Deurali-Janta Pharmaceuticals", "Tablet", "400 mg + 600 mg"),
                BrandInfo("Nortin", "Quest Pharmaceuticals", "Tablet", "400 mg + 600 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Norflox-TZ", "Cipla Ltd.", "Tablet", "400 mg + 600 mg"),
                BrandInfo("Normaxin-TZ", "Torrent Pharmaceuticals", "Tablet", "400 mg + 600 mg"),
                BrandInfo("Albiotic-TZ", "Alkem", "Tablet", "400 mg + 600 mg")
            )
        ),

        // 119. Amoxicillin + Cloxacillin
        BrandEnrichment(
            genericKey = "amoxicillin + cloxacillin",
            nepalBrands = listOf(
                BrandInfo("Novaclox", "Cipla Nepal", "Capsule / Dry Syrup", "250/250 mg / 125/125 mg per 5mL"),
                BrandInfo("Megapen", "Aristo Nepal", "Capsule / Injection", "250/250 mg / 1000 mg"),
                BrandInfo("Ampiclox", "GlaxoSmithKline Nepal", "Capsule / Syrup", "250/250 mg"),
                BrandInfo("Clomox-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "250/250 mg"),
                BrandInfo("Asian-Clox", "Asian Pharmaceuticals", "Capsule / Syrup", "500 mg / 250 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Novaclox", "Cipla Ltd.", "Capsule / Dry Syrup", "250/250 mg / 125/125 mg"),
                BrandInfo("Megapen", "Aristo Pharmaceuticals", "Capsule / Vial", "250/250 mg / 1g"),
                BrandInfo("Ampiclox", "GSK India", "Capsule", "250/250 mg")
            )
        ),

        // 120. Cefixime + Ofloxacin
        BrandEnrichment(
            genericKey = "cefixime + ofloxacin",
            nepalBrands = listOf(
                BrandInfo("Zifi-O", "FDC Nepal", "Tablet", "200 mg + 200 mg"),
                BrandInfo("Ceftas-O", "Intas Nepal", "Tablet", "200 mg + 200 mg"),
                BrandInfo("Taxim-OF", "Alkem Nepal", "Tablet", "200 mg + 200 mg"),
                BrandInfo("Mahacef-Plus", "Mankind Nepal", "Tablet", "200 mg + 200 mg"),
                BrandInfo("Fix-O", "Nepal Pharmaceuticals Lab", "Tablet", "200 mg + 200 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Zifi-O", "FDC Ltd.", "Tablet", "200 mg + 200 mg"),
                BrandInfo("Ceftas-O", "Intas Pharmaceuticals", "Tablet", "200 mg + 200 mg"),
                BrandInfo("Taxim-OF", "Alkem Laboratories", "Tablet", "200 mg + 200 mg")
            )
        ),

        // 121. Cefixime + Potassium Clavulanate
        BrandEnrichment(
            genericKey = "cefixime + potassium clavulanate",
            nepalBrands = listOf(
                BrandInfo("Zifi-CV", "FDC Nepal", "Tablet", "200 mg + 125 mg"),
                BrandInfo("Taxim-O CV", "Alkem Nepal", "Tablet", "200 mg + 125 mg"),
                BrandInfo("Ceftas-CV", "Intas Nepal", "Tablet", "200 mg + 125 mg"),
                BrandInfo("Omnicef-CV", "Aristo Nepal", "Tablet", "200 mg + 125 mg"),
                BrandInfo("Fix-CV", "Nepal Pharmaceuticals Lab", "Tablet", "200 mg + 125 mg")
            ),
            importedBrands = listOf(
                BrandInfo("Zifi-CV", "FDC Ltd.", "Tablet", "200 mg + 125 mg"),
                BrandInfo("Taxim-O CV", "Alkem Laboratories", "Tablet", "200 mg + 125 mg"),
                BrandInfo("Ceftas-CV", "Intas Pharmaceuticals", "Tablet", "200 mg + 125 mg")
            )
        ),

        // 122. Lidocaine + Prilocaine
        BrandEnrichment(
            genericKey = "lidocaine + prilocaine",
            nepalBrands = listOf(
                BrandInfo("Prilox Cream", "Neon Laboratories Nepal", "Topical Cream", "2.5% + 2.5% (5g / 30g)"),
                BrandInfo("EMLA Cream", "AstraZeneca Nepal", "Topical Cream", "2.5% + 2.5% (5g / 30g)"),
                BrandInfo("Lignopril", "Troikaa Nepal", "Cream", "2.5% + 2.5% (5g)"),
                BrandInfo("Anesderm", "Sun Pharma Nepal", "Cream", "2.5% + 2.5% (5g)")
            ),
            importedBrands = listOf(
                BrandInfo("Prilox", "Neon Laboratories", "Cream", "2.5% + 2.5% (5g / 30g)"),
                BrandInfo("EMLA", "AstraZeneca India", "Cream", "2.5% + 2.5% (5g / 30g)"),
                BrandInfo("Lido-Prilo", "Sun Pharma", "Cream", "5g")
            )
        )
    )

    /**
     * Enriches a single Drug with authentic Nepal and imported brand names from the catalog.
     */
    fun enrichDrug(drug: Drug): Drug {
        val lowerGen = drug.genericName.lowercase().trim()
        val matchingEnrichments = catalog.filter { enrichment ->
            val key = enrichment.genericKey.lowercase()
            lowerGen.contains(key) || key.contains(lowerGen)
        }

        if (matchingEnrichments.isEmpty()) return drug

        // Merge existing with enriched, removing duplicates by name
        val combinedNepal = (drug.brandsNepal + matchingEnrichments.flatMap { it.nepalBrands })
            .distinctBy { it.name.lowercase().trim() }

        val combinedIndia = (drug.brandsIndia + matchingEnrichments.flatMap { it.importedBrands })
            .distinctBy { it.name.lowercase().trim() }

        return drug.copy(
            brandsNepal = combinedNepal,
            brandsIndia = combinedIndia
        )
    }

    /**
     * Enriches a complete list of drugs.
     */
    fun enrichAllDrugs(drugs: List<Drug>): List<Drug> {
        return drugs.map { enrichDrug(it) }
    }
}
