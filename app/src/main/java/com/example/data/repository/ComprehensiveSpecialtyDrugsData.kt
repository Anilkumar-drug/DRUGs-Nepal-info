package com.example.data.repository

import com.example.data.model.Drug

data class SpecialtyCategoryInfo(
    val id: String,
    val name: String,
    val tag: String,
    val iconEmoji: String,
    val description: String,
    val clinicalImportance: String
)

object ComprehensiveSpecialtyDrugsData {

    val categories: List<SpecialtyCategoryInfo> = listOf(
        SpecialtyCategoryInfo(
            id = "anti_htn",
            name = "Anti-HTN (Antihypertensives)",
            tag = "Anti-HTN",
            iconEmoji = "🩺",
            description = "Reserpine, Methyldopa, Telmisartan, Cilnidipine, Sacubitril/Valsartan, Zilebesiran (siRNA), Aprocitentan, Baxdrostat",
            clinicalImportance = "From classical monoamine depletors to modern ARBs/ARNIs and 6-monthly RNA interference (siRNA) and aldosterone synthase inhibitors."
        ),
        SpecialtyCategoryInfo(
            id = "oha",
            name = "OHA (Oral Antidiabetics)",
            tag = "OHA",
            iconEmoji = "🍬",
            description = "Chlorpropamide, Metformin, Dapagliflozin, Oral Semaglutide, Imeglimin, Orforglipron (oral non-peptide), Retatrutide (Triple G)",
            clinicalImportance = "Evolution from 1st-gen sulfonylureas to SGLT2i, oral GLP-1, and investigational triple hormone agonists."
        ),
        SpecialtyCategoryInfo(
            id = "thyroid",
            name = "Thyroid Disorders",
            tag = "Thyroid disorders",
            iconEmoji = "🦋",
            description = "Desiccated Thyroid, PTU, Levothyroxine, Methimazole, Teprotumumab (IGF-1R mAb), Resmetirom (THR-beta agonist)",
            clinicalImportance = "From animal extracts to pure synthetic T4, targeted IGF-1R biologics for thyroid eye disease, and selective THR-beta agonists."
        ),
        SpecialtyCategoryInfo(
            id = "antiepileptic",
            name = "Antiepileptic (ASMs)",
            tag = "Antiepileptic",
            iconEmoji = "⚡",
            description = "Phenytoin, Sodium Valproate, Levetiracetam, Lacosamide, Cenobamate (dual Na+/GABA-A)",
            clinicalImportance = "From classical 1st-generation enzyme inducers to SV2A ligands and novel persistent sodium current blockers with high seizure freedom."
        ),
        SpecialtyCategoryInfo(
            id = "anticoagulant",
            name = "Anti Coagulants",
            tag = "Anti coagulant",
            iconEmoji = "🩸",
            description = "Warfarin, Acenocoumarol, Apixaban (DOAC), Rivaroxaban, Milvexian (Factor XIa inhibitor)",
            clinicalImportance = "From Vitamin K antagonists requiring frequent INR to targeted DOACs and investigational Factor XIa inhibitors without bleeding risk."
        ),
        SpecialtyCategoryInfo(
            id = "antiplatelets",
            name = "Antiplatelets",
            tag = "Antiplatelets",
            iconEmoji = "🛑",
            description = "Aspirin, Clopidogrel, Ticagrelor, Cangrelor, Selatogrel (patient emergency autoinjector)",
            clinicalImportance = "From irreversible COX-1 inhibition to potent reversible P2Y12 blockers and emergency pre-hospital autoinjectors."
        ),
        SpecialtyCategoryInfo(
            id = "antihelminthes",
            name = "Anti Helminthes",
            tag = "Anti helminthes",
            iconEmoji = "🪱",
            description = "Piperazine, Pyrantel, Albendazole, Mebendazole, Ivermectin, Emodepside (latrophilin receptor agonist)",
            clinicalImportance = "From simple neuromuscular relaxers to broad-spectrum tubulin inhibitors and novel cyclodepsipeptides for resistant nematodes."
        ),
        SpecialtyCategoryInfo(
            id = "antiparasitic",
            name = "Anti Parasitic & Antimalarials",
            tag = "Anti parasitic",
            iconEmoji = "🦟",
            description = "Chloroquine, Quinine, Metronidazole, Coartem (ACT), Miltefosine, Ganaplacide (KAF156)",
            clinicalImportance = "From aminoquinolines with heavy resistance to artemisinin-based combinations and novel multi-stage imidazolopiperazines."
        ),
        SpecialtyCategoryInfo(
            id = "statins",
            name = "Statins & Lipid-Lowering",
            tag = "Statins",
            iconEmoji = "🫀",
            description = "Simvastatin, Atorvastatin, Rosuvastatin, Bempedoic Acid (ACL inhibitor), Inclisiran (siRNA), Pelacarsen (anti-Lp(a))",
            clinicalImportance = "From fungal prodrug statins to high-intensity synthetic statins, muscle-sparing ACL inhibitors, and 6-monthly siRNA therapeutics."
        ),
        SpecialtyCategoryInfo(
            id = "anticancer",
            name = "Anti Cancer (Oncology)",
            tag = "Anti cancer",
            iconEmoji = "🎗️",
            description = "Cisplatin, 5-FU, Doxorubicin, Pembrolizumab (PD-1), Trastuzumab Deruxtecan, MRTX1133 (KRAS G12D inhibitor)",
            clinicalImportance = "From toxic non-specific DNA crosslinkers to immune checkpoint inhibitors and targeted inhibitors of historically undruggable KRAS mutations."
        ),
        SpecialtyCategoryInfo(
            id = "immunosuppressor",
            name = "Immuno Supressors",
            tag = "Immuno supressor",
            iconEmoji = "🛡️",
            description = "Azathioprine, Cyclosporine, Tacrolimus (FK506), Mycophenolate, Belatacept, Voclosporin (next-gen CNI)",
            clinicalImportance = "From purine antimetabolites requiring TPMT testing to calcineurin inhibitors and targeted calcineurin analogs without therapeutic drug monitoring."
        ),
        SpecialtyCategoryInfo(
            id = "ra",
            name = "Rheumatoid Arthritis (RA)",
            tag = "RA",
            iconEmoji = "🦴",
            description = "Methotrexate, Hydroxychloroquine, Sulfasalazine, Upadacitinib (JAK1), Tocilizumab, Remibrutinib (BTK inhibitor)",
            clinicalImportance = "From conventional synthetic DMARDs (csDMARDs) to targeted synthetic JAK inhibitors and novel covalent BTK inhibitors."
        )
    )

    val specialtyDrugs: List<Drug> =
        SpecialtyDrugsCardioMetabolic.drugs +
        SpecialtyDrugsThyroidLipid.drugs +
        SpecialtyDrugsNeuroHeme.drugs +
        SpecialtyDrugsInfectiousImmunoOnco.drugs

    fun getDrugsByCategory(categoryTag: String): List<Drug> {
        return specialtyDrugs.filter { it.therapeuticClassTag.equals(categoryTag, ignoreCase = true) }
    }

    fun getDrugsByEra(era: String): List<Drug> {
        return specialtyDrugs.filter { it.era.contains(era, ignoreCase = true) }
    }

    fun getCategoryTimeline(categoryTag: String): Map<String, List<Drug>> {
        val list = getDrugsByCategory(categoryTag)
        return mapOf(
            "Older / Classical" to list.filter { it.isOlderMedication },
            "Newer / Modern" to list.filter { it.isNewerMedication },
            "Under Research / Pipeline" to list.filter { it.isUnderResearch }
        )
    }
}
