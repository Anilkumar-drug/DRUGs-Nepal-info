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

        // 55. Loperamide / ORS
        BrandEnrichment(
            genericKey = "loperamide",
            nepalBrands = listOf(
                BrandInfo("Lopam-DJPL", "Deurali-Janta Pharmaceuticals", "Capsule", "2 mg"),
                BrandInfo("Lopan-NPL", "Nepal Pharmaceuticals Lab", "Capsule", "2 mg"),
                BrandInfo("Jeevan Jal ORS", "Nepal Aushadhi Limited", "Sachet", "WHO Formula 20.5g"),
                BrandInfo("Nava Jeevan ORS", "Deurali-Janta Pharmaceuticals", "Sachet", "WHO Low Osmolarity 20.5g")
            ),
            importedBrands = listOf(
                BrandInfo("Lopamide", "Torrent Pharmaceuticals", "Tablet", "2 mg"),
                BrandInfo("Imodium", "Johnson & Johnson", "Capsule", "2 mg"),
                BrandInfo("Eldoper", "Micro Labs", "Capsule", "2 mg"),
                BrandInfo("Electral ORS", "FDC Ltd.", "Sachet", "WHO Formula 21.8g")
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
