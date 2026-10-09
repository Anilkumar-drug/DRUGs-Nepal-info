package com.example.data.repository

import com.example.data.model.BodySiteRecommendation
import com.example.data.model.FtuCalculationArea
import com.example.data.model.SteroidPotencyClass
import com.example.data.model.TopicalSteroidAgent

object TopicalSteroidLadderData {

    // ==========================================
    // 1. COMPREHENSIVE 7-TIER STEROID AGENTS
    // ==========================================
    val steroidAgents: List<TopicalSteroidAgent> = listOf(
        // CLASS I: SUPERPOTENT (ULTRA-HIGH)
        TopicalSteroidAgent(
            id = "steroid_c1_clobetasol_oint",
            genericName = "Clobetasol Propionate",
            strength = "0.05%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_1,
            commonNepalBrands = listOf("Tenovate (GSK)", "Lobate (Abbott)", "Cosvate", "Clop-G (w/ Gentamicin)", "Exovate"),
            approvedIndications = listOf(
                "Severe plaque psoriasis (recalcitrant)",
                "Lichen planus (hypertrophic)",
                "Lichen sclerosus et atrophicus",
                "Severe palmoplantar eczema / pompholyx",
                "Discoid lupus erythematosus (DLE)",
                "Alopecia areata (short-course pulsed)"
            ),
            maxDurationWeeks = "Max 2 consecutive weeks (Strict limit <50g/week)",
            permissibleBodySites = listOf("Palms", "Soles", "Extensor surfaces (elbows/knees)", "Scalp (severe thick plaques)"),
            contraindicatedSites = listOf("Face", "Eyelids", "Axillae", "Groin / Inguinal folds", "Perianal", "Infantile diaper area"),
            clinicalNotes = "Highest risk of HPA axis suppression and skin atrophy. Ointment base provides superior occlusive penetration for thick keratotic plaques. Never use under occlusion unless under strict specialist direction. Must taper to lower class (Class IV/V) or topical calcineurin inhibitor.",
            systemicAbsorptionRisk = "Very High (Suppresses adrenal axis within days if applied >50g/wk or with occlusion)"
        ),
        TopicalSteroidAgent(
            id = "steroid_c1_clobetasol_crm",
            genericName = "Clobetasol Propionate",
            strength = "0.05%",
            formulation = "Cream",
            potencyClass = SteroidPotencyClass.CLASS_1,
            commonNepalBrands = listOf("Tenovate Cream", "Lobate Cream", "Clobetamil", "Dermovate"),
            approvedIndications = listOf(
                "Severe resistant eczema",
                "Acute severe contact dermatitis (exudative)",
                "Lichenified eczema",
                "Bullous pemphigoid (generalized high-dose protocol)"
            ),
            maxDurationWeeks = "Max 2 weeks",
            permissibleBodySites = listOf("Thick trunk plaques", "Extremities", "Palms", "Soles"),
            contraindicatedSites = listOf("Face", "Neck", "Flexural folds", "Scrotum", "Eyelids"),
            clinicalNotes = "Cream vehicle preferred over ointment in weeping or acute wet dermatoses. Still carries maximal potency risk. Taper promptly to prevent rebound flare.",
            systemicAbsorptionRisk = "Very High"
        ),
        TopicalSteroidAgent(
            id = "steroid_c1_halobetasol_oint",
            genericName = "Halobetasol Propionate",
            strength = "0.05%",
            formulation = "Ointment / Cream",
            potencyClass = SteroidPotencyClass.CLASS_1,
            commonNepalBrands = listOf("Haloderm", "Halovate (Glenmark)", "Ultravate", "Halox"),
            approvedIndications = listOf(
                "Moderate to severe plaque psoriasis",
                "Severe chronic hand eczema",
                "Hypertrophic lichen planus"
            ),
            maxDurationWeeks = "Max 2 consecutive weeks (Do not exceed 50g per week)",
            permissibleBodySites = listOf("Palms", "Soles", "Thick extensor plaques"),
            contraindicatedSites = listOf("Face", "Intertriginous areas", "Eyelids", "Genitalia"),
            clinicalNotes = "Fluorinated superpotent corticosteroid. Rapid anti-inflammatory onset within 48-72 hours. Monitor for local cutaneous striae and telangiectasia.",
            systemicAbsorptionRisk = "Very High"
        ),

        // CLASS II: POTENT (HIGH POTENCY)
        TopicalSteroidAgent(
            id = "steroid_c2_mometasone_oint",
            genericName = "Mometasone Furoate",
            strength = "0.1%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_2,
            commonNepalBrands = listOf("Momate Ointment (Glenmark)", "Elocon Ointment (Organon)", "Momesone", "Metaspray"),
            approvedIndications = listOf(
                "Moderate to severe atopic dermatitis (flare)",
                "Chronic plaque psoriasis",
                "Discoid eczema (nummular)",
                "Severe allergic contact dermatitis"
            ),
            maxDurationWeeks = "2 to 3 weeks (Once daily application suffices)",
            permissibleBodySites = listOf("Trunk", "Upper & lower extremities", "Hands and feet"),
            contraindicatedSites = listOf("Face", "Flexures (groin, axilla)", "Eyelids"),
            clinicalNotes = "Mometasone ointment has high lipid solubility, placing it into Class II (unlike its cream formulation which is Class IV). Once daily dosing offers high adherence due to receptor binding affinity.",
            systemicAbsorptionRisk = "Moderate to High"
        ),
        TopicalSteroidAgent(
            id = "steroid_c2_betamethasone_dipro_oint",
            genericName = "Betamethasone Dipropionate",
            strength = "0.05%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_2,
            commonNepalBrands = listOf("Diprovate Ointment", "Diprosone", "Betnovate-DP"),
            approvedIndications = listOf(
                "Subacute to chronic plaque psoriasis",
                "Lichen simplex chronicus (neurodermatitis)",
                "Refractory dry eczema"
            ),
            maxDurationWeeks = "2 to 3 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Scalp"),
            contraindicatedSites = listOf("Face", "Flexural folds", "Genital skin"),
            clinicalNotes = "Augmented dipropionate formulations can reach Class I; standard dipropionate ointment sits at Class II. Fast-acting vasoconstriction and antipruritic effect.",
            systemicAbsorptionRisk = "Moderate to High"
        ),
        TopicalSteroidAgent(
            id = "steroid_c2_fluocinonide_oint",
            genericName = "Fluocinonide",
            strength = "0.05%",
            formulation = "Ointment / Gel",
            potencyClass = SteroidPotencyClass.CLASS_2,
            commonNepalBrands = listOf("Lidex", "Flunide", "Topifort"),
            approvedIndications = listOf(
                "Hypertrophic lichen planus",
                "Severe contact dermatitis",
                "Nummular eczema"
            ),
            maxDurationWeeks = "2 to 4 weeks",
            permissibleBodySites = listOf("Limbs", "Trunk", "Scalp"),
            contraindicatedSites = listOf("Face", "Groin", "Axillae"),
            clinicalNotes = "High lipid solubility. Avoid occlusive dressings.",
            systemicAbsorptionRisk = "Moderate to High"
        ),

        // CLASS III: UPPER MID-STRENGTH (HIGH-MEDIUM)
        TopicalSteroidAgent(
            id = "steroid_c3_betamethasone_val_oint",
            genericName = "Betamethasone Valerate",
            strength = "0.1%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_3,
            commonNepalBrands = listOf("Betnovate Ointment (GSK Nepal)", "Betasone", "Zovate"),
            approvedIndications = listOf(
                "Moderate atopic dermatitis in adults",
                "Nummular dermatitis",
                "Seborrheic dermatitis (severe trunk lesions)",
                "Stasis dermatitis (avoid open ulcers)"
            ),
            maxDurationWeeks = "2 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Neck (short-term)"),
            contraindicatedSites = listOf("Face (Never use long-term)", "Eyelids", "Inguinal crease"),
            clinicalNotes = "Widely available and inexpensive across Nepal. Note: Betnovate cream is Class V, but the ointment is Class III due to enhanced stratum corneum hydration.",
            systemicAbsorptionRisk = "Moderate"
        ),
        TopicalSteroidAgent(
            id = "steroid_c3_fluticasone_prop_oint",
            genericName = "Fluticasone Propionate",
            strength = "0.005%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_3,
            commonNepalBrands = listOf("Flutivate Ointment (GSK)", "Cutivate", "Flixonase"),
            approvedIndications = listOf(
                "Moderate to severe dry eczema",
                "Lichen simplex chronicus",
                "Pityriasis rosea (intense pruritus)"
            ),
            maxDurationWeeks = "3 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Extremities"),
            contraindicatedSites = listOf("Face", "Flexural areas"),
            clinicalNotes = "Undergoes rapid hepatic first-pass metabolism if absorbed, giving a favorable benefit-to-risk ratio. High glucocorticoid receptor selectivity.",
            systemicAbsorptionRisk = "Low to Moderate"
        ),
        TopicalSteroidAgent(
            id = "steroid_c3_triamcinolone_oint",
            genericName = "Triamcinolone Acetonide",
            strength = "0.1%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_3,
            commonNepalBrands = listOf("Kenacort Ointment (Abbott)", "Ledercort", "Aristocort"),
            approvedIndications = listOf(
                "Lichenified atopic dermatitis",
                "Plaque eczema",
                "Chronic contact dermatitis"
            ),
            maxDurationWeeks = "3 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Dorsal hands"),
            contraindicatedSites = listOf("Face", "Axillae", "Groin"),
            clinicalNotes = "Ointment formulation elevates triamcinolone from Class IV (cream) to Class III (ointment). Avoid abrupt cessation; step down to emollients.",
            systemicAbsorptionRisk = "Moderate"
        ),

        // CLASS IV: MID-STRENGTH (MEDIUM POTENCY)
        TopicalSteroidAgent(
            id = "steroid_c4_mometasone_crm",
            genericName = "Mometasone Furoate",
            strength = "0.1%",
            formulation = "Cream / Lotion",
            potencyClass = SteroidPotencyClass.CLASS_4,
            commonNepalBrands = listOf("Momate Cream (Glenmark)", "Elocon Cream", "Topcort", "Momecon"),
            approvedIndications = listOf(
                "Atopic dermatitis (first-line in children >2 yrs and adults)",
                "Seborrheic dermatitis of scalp/body",
                "Allergic contact dermatitis",
                "Insect bite reactions"
            ),
            maxDurationWeeks = "Up to 4 weeks (Once daily application)",
            permissibleBodySites = listOf("Trunk", "Extremities", "Scalp (lotion)", "Face (strictly max 5-7 days under close MD review)"),
            contraindicatedSites = listOf("Eyelids", "Prolonged facial use (>7 days)", "Thin intertriginous folds"),
            clinicalNotes = "Workhorse topical steroid in modern outpatient practice. High therapeutic index with low systemic bioavailability (0.4%). Once daily application is fully therapeutic due to high skin reservoir.",
            systemicAbsorptionRisk = "Low (when used without occlusion)"
        ),
        TopicalSteroidAgent(
            id = "steroid_c4_triamcinolone_crm",
            genericName = "Triamcinolone Acetonide",
            strength = "0.1%",
            formulation = "Cream",
            potencyClass = SteroidPotencyClass.CLASS_4,
            commonNepalBrands = listOf("Kenacort 0.1% Cream", "T-Cort", "Aristocort A"),
            approvedIndications = listOf(
                "Subacute eczema and dermatitis",
                "Pruritus of inflammatory dermatoses",
                "Sunburn (severe inflammatory phase)"
            ),
            maxDurationWeeks = "2 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Neck"),
            contraindicatedSites = listOf("Face", "Groin", "Axilla"),
            clinicalNotes = "Standard mid-strength agent. Well tolerated, non-greasy cream base suitable for exudative or intertriginous-adjacent non-fold skin.",
            systemicAbsorptionRisk = "Low to Moderate"
        ),
        TopicalSteroidAgent(
            id = "steroid_c4_hydrocortisone_val_oint",
            genericName = "Hydrocortisone Valerate",
            strength = "0.2%",
            formulation = "Ointment",
            potencyClass = SteroidPotencyClass.CLASS_4,
            commonNepalBrands = listOf("Westcort Ointment", "Hydro-Val"),
            approvedIndications = listOf(
                "Atopic eczema in children",
                "Dry irritant contact dermatitis"
            ),
            maxDurationWeeks = "3 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs"),
            contraindicatedSites = listOf("Face", "Flexural areas"),
            clinicalNotes = "Valerate ester significantly enhances lipophilicity over plain hydrocortisone.",
            systemicAbsorptionRisk = "Low"
        ),

        // CLASS V: LOWER MID-STRENGTH (LOWER-MEDIUM)
        TopicalSteroidAgent(
            id = "steroid_c5_betamethasone_val_crm",
            genericName = "Betamethasone Valerate",
            strength = "0.1%",
            formulation = "Cream / Lotion",
            potencyClass = SteroidPotencyClass.CLASS_5,
            commonNepalBrands = listOf("Betnovate Cream (GSK Nepal)", "Betasone Cream", "Zovate Cream"),
            approvedIndications = listOf(
                "Mild to moderate atopic eczema",
                "Seborrheic dermatitis of chest and scalp",
                "Irritant contact dermatitis",
                "Discoid lupus (adjunct)"
            ),
            maxDurationWeeks = "2 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Scalp (lotion)"),
            contraindicatedSites = listOf("Face (Rampantly abused in Nepal as beauty cream; leading cause of steroid rosacea!)", "Groin", "Axillae"),
            clinicalNotes = "CRITICAL NEPAL WARNING: Betnovate cream is often purchased OTC by patients for acne, melasma, and fairness. Causes severe cutaneous atrophy, telangiectasia, perioral dermatitis, and Tinea incognito. NEVER prescribe for facial melasma or acne!",
            systemicAbsorptionRisk = "Low to Moderate"
        ),
        TopicalSteroidAgent(
            id = "steroid_c5_fluticasone_prop_crm",
            genericName = "Fluticasone Propionate",
            strength = "0.05%",
            formulation = "Cream",
            potencyClass = SteroidPotencyClass.CLASS_5,
            commonNepalBrands = listOf("Flutivate Cream (GSK)", "Cutivate Cream"),
            approvedIndications = listOf(
                "Atopic dermatitis in pediatric patients (≥3 months of age)",
                "Subacute eczema in adults"
            ),
            maxDurationWeeks = "Up to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Pediatric extremities"),
            contraindicatedSites = listOf("Eyelids", "Face (>7 days)"),
            clinicalNotes = "One of the safest mid-lower potency options for children down to 3 months. High receptor affinity and low systemic bioavailability.",
            systemicAbsorptionRisk = "Low"
        ),
        TopicalSteroidAgent(
            id = "steroid_c5_hydrocortisone_but_crm",
            genericName = "Hydrocortisone Butyrate",
            strength = "0.1%",
            formulation = "Cream / Lipocream",
            potencyClass = SteroidPotencyClass.CLASS_5,
            commonNepalBrands = listOf("Locoid Lipocream", "Locoid Cream"),
            approvedIndications = listOf(
                "Pediatric eczema",
                "Facial dermatitis (short term 5-7 days under supervision)",
                "Intertrigo (short term)"
            ),
            maxDurationWeeks = "2 to 4 weeks",
            permissibleBodySites = listOf("Trunk", "Limbs", "Face (max 5 days)"),
            contraindicatedSites = listOf("Eyelids"),
            clinicalNotes = "Butyrate ester provides mid-potency anti-inflammatory efficacy with low atrophogenicity.",
            systemicAbsorptionRisk = "Low"
        ),

        // CLASS VI: MILD (LOW POTENCY)
        TopicalSteroidAgent(
            id = "steroid_c6_desonide_crm",
            genericName = "Desonide",
            strength = "0.05%",
            formulation = "Cream / Lotion / Ointment",
            potencyClass = SteroidPotencyClass.CLASS_6,
            commonNepalBrands = listOf("Desowen Cream (Galderma)", "Desosoft", "Tridesilon"),
            approvedIndications = listOf(
                "Facial dermatitis and eczema",
                "Eyelid dermatitis (short course, monitor IOP)",
                "Intertriginous eczema (axilla, groin, submammary)",
                "Pediatric and infant eczema"
            ),
            maxDurationWeeks = "Up to 2 to 4 weeks on body; max 1 to 2 weeks on face/flexures",
            permissibleBodySites = listOf("Face", "Eyelids (careful)", "Axillae", "Groin", "Inframammary fold", "Pediatric skin"),
            contraindicatedSites = listOf("Open infected lesions", "Undiagnosed cutaneous ulcers"),
            clinicalNotes = "Preferred non-fluorinated low-potency steroid for delicate skin. Safe for face, neck, and flexures when short courses are indicated. Minimal risk of cutaneous atrophy or telangiectasia.",
            systemicAbsorptionRisk = "Minimal"
        ),
        TopicalSteroidAgent(
            id = "steroid_c6_alclometasone_crm",
            genericName = "Alclometasone Dipropionate",
            strength = "0.05%",
            formulation = "Cream / Ointment",
            potencyClass = SteroidPotencyClass.CLASS_6,
            commonNepalBrands = listOf("Aclovate", "Alclom"),
            approvedIndications = listOf(
                "Mild facial eczema",
                "Flexural and genital eczema",
                "Pediatric eczema flare"
            ),
            maxDurationWeeks = "Up to 3 weeks",
            permissibleBodySites = listOf("Face", "Flexures", "Trunk in infants"),
            contraindicatedSites = listOf("Tinea infections", "Herpetic eruptions"),
            clinicalNotes = "Low atrophogenic potential, making it an excellent alternative to desonide for sensitive thin-skinned regions.",
            systemicAbsorptionRisk = "Minimal"
        ),

        // CLASS VII: LEAST POTENT (ULTRA-LOW POTENCY)
        TopicalSteroidAgent(
            id = "steroid_c7_hydrocortisone_1pct",
            genericName = "Hydrocortisone (Base / Acetate)",
            strength = "1.0%",
            formulation = "Cream / Ointment",
            potencyClass = SteroidPotencyClass.CLASS_7,
            commonNepalBrands = listOf("Wycort (Wyeth / Pfizer)", "Hycort", "Cort-S", "Dermacort"),
            approvedIndications = listOf(
                "Mild facial eczema and perioral dermatitis",
                "Infantile seborrheic dermatitis (cradle cap)",
                "Diaper dermatitis (mild irritant, after ruling out Candida)",
                "Intertrigo and flexural chafing",
                "Perianal and scrotal pruritus",
                "Mild sunburn"
            ),
            maxDurationWeeks = "Safe for 2 to 4 weeks; minimal atrophy even with prolonged use",
            permissibleBodySites = listOf("Face", "Eyelids", "Groin", "Scrotum / Vulva", "Axillae", "Diaper area in infants", "All body areas"),
            contraindicatedSites = listOf("Active untreated fungal (Tinea, Candida), bacterial (Impetigo), or viral (Herpes) infections"),
            clinicalNotes = "Safest topical corticosteroid available. Lowest intrinsic glucocorticoid receptor affinity. Does not cause skin thinning, striae, or adrenal suppression at conventional dosages. Safe for infants, elderly thin skin, and long-term maintenance tapering.",
            systemicAbsorptionRisk = "Negligible"
        ),
        TopicalSteroidAgent(
            id = "steroid_c7_hydrocortisone_0_5pct",
            genericName = "Hydrocortisone Acetate",
            strength = "0.5%",
            formulation = "Cream",
            potencyClass = SteroidPotencyClass.CLASS_7,
            commonNepalBrands = listOf("Hycort 0.5%", "Cortaid 0.5%"),
            approvedIndications = listOf(
                "Superficial insect bites",
                "Mild cosmetic irritations",
                "Infant eyelid eczema"
            ),
            maxDurationWeeks = "Safe for up to 4 weeks",
            permissibleBodySites = listOf("All delicate body sites including face, lids, scrotum"),
            contraindicatedSites = listOf("Infected lesions"),
            clinicalNotes = "Ultra-low strength. Often sufficient for delicate facial skin and pediatric cradle cap in conjunction with thick emollients.",
            systemicAbsorptionRisk = "Negligible"
        )
    )

    // ==========================================
    // 2. BODY SITE ANATOMICAL SAFETY MATRIX
    // ==========================================
    val bodySiteGuidelines: List<BodySiteRecommendation> = listOf(
        BodySiteRecommendation(
            anatomicalArea = "Face & Eyelids",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_6, SteroidPotencyClass.CLASS_7),
            prohibitedClasses = listOf(SteroidPotencyClass.CLASS_1, SteroidPotencyClass.CLASS_2, SteroidPotencyClass.CLASS_3, SteroidPotencyClass.CLASS_4, SteroidPotencyClass.CLASS_5),
            maxTreatmentDuration = "5 to 7 days maximum (strictly taper to non-steroidal emollients or tacrolimus)",
            defaultFtuAdult = 2.5, // 2.5 FTU = ~1.25g for Face + Neck
            clinicalPearls = "The stratum corneum on eyelids is 4-5x thinner than trunk. High potency steroids cause rapid steroid-induced rosacea, perioral dermatitis, permanent telangiectasia, cutaneous atrophy, and ocular glaucoma/cataracts if applied near eyelids. Use Desonide 0.05% or Hydrocortisone 1% only.",
            severeAdverseRisk = "EXTREME: Permanent skin thinning, rebound erythema, telangiectasia, steroid addiction/dependency."
        ),
        BodySiteRecommendation(
            anatomicalArea = "Flexures (Axillae, Groin, Submammary, Perianal)",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_6, SteroidPotencyClass.CLASS_7),
            prohibitedClasses = listOf(SteroidPotencyClass.CLASS_1, SteroidPotencyClass.CLASS_2, SteroidPotencyClass.CLASS_3),
            maxTreatmentDuration = "7 to 10 days maximum",
            defaultFtuAdult = 1.0, // per groin or axilla
            clinicalPearls = "Intertriginous areas provide natural occlusion (heat, moisture, skin-on-skin friction), dramatically increasing drug absorption by 10- to 100-fold. Potent steroids here cause irreversible purple striae distensae, maceration, secondary fungal colonization (Candida), and systemic absorption.",
            severeAdverseRisk = "HIGH: Irreversible wide violaceous striae, cutaneous maceration, candidal superinfection."
        ),
        BodySiteRecommendation(
            anatomicalArea = "Trunk, Abdomen & Back",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_3, SteroidPotencyClass.CLASS_4, SteroidPotencyClass.CLASS_5),
            prohibitedClasses = listOf(SteroidPotencyClass.CLASS_1), // Class 1 reserved only for thick discrete recalcitrant plaques
            maxTreatmentDuration = "2 to 3 weeks, then step down",
            defaultFtuAdult = 7.0, // 7 FTU for front chest/abd, 7 FTU for back
            clinicalPearls = "Thicker stratum corneum tolerates mid-potency agents well (Mometasone cream, Betamethasone valerate cream, Fluticasone). Once clinical inflammation improves, transition to twice-weekly weekend pulse therapy or emollients to prevent tachyphylaxis.",
            severeAdverseRisk = "Moderate: Folliculitis, mild skin thinning if used continuously for >1 month."
        ),
        BodySiteRecommendation(
            anatomicalArea = "Extremities (Arms & Legs)",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_2, SteroidPotencyClass.CLASS_3, SteroidPotencyClass.CLASS_4),
            prohibitedClasses = emptyList(),
            maxTreatmentDuration = "2 to 4 weeks",
            defaultFtuAdult = 3.0, // 3 FTU per arm, 6 FTU per leg
            clinicalPearls = "Extensor surfaces of elbows and knees tolerate high-potency formulations. Ointments provide occlusive lipid hydration for dry scaly lichenified eczema.",
            severeAdverseRisk = "Low to Moderate."
        ),
        BodySiteRecommendation(
            anatomicalArea = "Palms, Soles & Hyperkeratotic Plaques",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_1, SteroidPotencyClass.CLASS_2),
            prohibitedClasses = listOf(SteroidPotencyClass.CLASS_7), // Class 7 is ineffective through thick stratum corneum
            maxTreatmentDuration = "2 to 3 weeks (strict pulse therapy: e.g. 5 days on, 2 days off)",
            defaultFtuAdult = 1.0, // 1 FTU for both sides of one hand, 2 FTU for foot
            clinicalPearls = "Palms and soles have the thickest stratum corneum in the body (400-600 μm). Low and mild potency steroids CANNOT penetrate. Superpotent Class I (Clobetasol 0.05% ointment or Halobetasol) is indicated for chronic palmoplantar eczema, pompholyx, and palmoplantar psoriasis. Often combined with salicylic acid 3-6% (Propysalic) for keratolysis.",
            severeAdverseRisk = "Low risk of local atrophy due to thick keratin, but high risk of systemic absorption if applied over >20% body surface area."
        ),
        BodySiteRecommendation(
            anatomicalArea = "Scalp",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_1, SteroidPotencyClass.CLASS_2, SteroidPotencyClass.CLASS_4),
            prohibitedClasses = emptyList(),
            maxTreatmentDuration = "2 to 3 weeks",
            defaultFtuAdult = 3.0,
            clinicalPearls = "Vehicle selection is critical: use solutions, lotions, foams, or gels instead of heavy ointments for patient compliance. Clobetasol lotion/shampoo for severe psoriasis, Mometasone lotion for seborrheic dermatitis.",
            severeAdverseRisk = "Moderate: Scalp folliculitis, telangiectasia."
        ),
        BodySiteRecommendation(
            anatomicalArea = "Infants & Pediatric Skin (General)",
            recommendedClasses = listOf(SteroidPotencyClass.CLASS_6, SteroidPotencyClass.CLASS_7),
            prohibitedClasses = listOf(SteroidPotencyClass.CLASS_1, SteroidPotencyClass.CLASS_2, SteroidPotencyClass.CLASS_3),
            maxTreatmentDuration = "1 to 2 weeks maximum",
            defaultFtuAdult = 1.0,
            clinicalPearls = "Children have a significantly higher Body Surface Area (BSA) to body weight ratio than adults. Transcutaneous absorption can easily cause iatrogenic Cushing syndrome, growth retardation, and adrenal crisis. Avoid plastic pants or airtight diapers over treated skin (acts as occlusion!).",
            severeAdverseRisk = "CRITICAL: Systemic HPA-axis suppression, growth impairment, iatrogenic Cushingoid state."
        )
    )

    // ==========================================
    // 3. FINGERTIP UNIT (FTU) CALCULATION DATA
    // ==========================================
    // 1 FTU = Amount expressed from 5mm nozzle from distal crease to tip of adult index finger (~0.5g)
    // 1 FTU covers two adult palms with fingers closed (~2% adult BSA).
    val ftuAnatomicalAreas: List<FtuCalculationArea> = listOf(
        FtuCalculationArea("face_neck", "Face & Neck (चेहरा र घाँटी)", 2.5, 1.25),
        FtuCalculationArea("one_hand", "One Hand - Both sides (एक हात)", 1.0, 0.50),
        FtuCalculationArea("one_arm", "One Entire Arm + Hand (एउटा पाखुरा र हात)", 4.0, 2.00),
        FtuCalculationArea("one_foot", "One Foot (एउटा खुट्टाको पैताला)", 2.0, 1.00),
        FtuCalculationArea("one_leg", "One Entire Leg + Foot (एउटा पूरै गोडा)", 8.0, 4.00),
        FtuCalculationArea("chest_abdomen", "Chest & Abdomen - Front (छाती र पेट)", 7.0, 3.50),
        FtuCalculationArea("back_buttocks", "Back & Buttocks (ढाड र नितम्ब)", 7.0, 3.50),
        FtuCalculationArea("scalp", "Scalp (टाउकोको कपाल भएको भाग)", 3.0, 1.50),
        FtuCalculationArea("groin_genitalia", "Groin & Genitalia (काछ र गुप्ताङ्ग)", 1.0, 0.50)
    )

    // ==========================================
    // 4. NEPAL OTC ABUSE & TINEA INCOGNITO WARNINGS
    // ==========================================
    val nepalAbusePearls: List<String> = listOf(
        "🚨 THE QUADRIDERM / BETNOVATE-GM EPIDEMIC: Across retail pharmacies in Nepal, triple/quadruple combination creams (Betamethasone + Neomycin + Clotrimazole / Gentamicin) are routinely dispensed over the counter for acne, fungal ringworm, and fairness. This is medical malpractice that causes permanent cosmetic disfigurement.",
        "🍄 TINEA INCOGNITO DISASTER: When a topical corticosteroid is applied to ringworm (Tinea corporis / Tinea cruris), it blunts local cell-mediated immunity and erythema, giving temporary false relief. Meanwhile, dermatophyte fungal hyphae proliferate wildly into deeper dermis and follicles, converting a simple ring into extensive, bizarre, ulcerating lesions.",
        "👩‍🦰 TOPICAL STEROID-DAMAGED FACE (TSDF): Applying Class I-V steroids to the face leads to steroid-induced rosacea, perioral dermatitis, skin atrophy ('cigarette-paper wrinkling'), permanent telangiectasia, and rebound burning erythema upon stopping. Management requires abrupt cessation, cold compresses, oral doxycycline 100mg BD for 4-6 weeks, and topical tacrolimus 0.03-0.1%.",
        "👶 DIAPER DERMATITIS OCCLUSION HAZARD: Never use potent fluorinated steroids under disposable diapers. Plastic diaper backing acts as a powerful occlusive dressing, multiplying steroid absorption up to 100-fold and inducing infantile Cushing's syndrome.",
        "🛑 FINGER-TIP UNIT (FTU) RULES: Prescribe exactly the required tube size (15g, 20g, or 30g). Calculate: Grams needed = Total FTUs × 0.5g × Frequency (OD/BD) × Days. Do not give open-ended refills."
    )
}
