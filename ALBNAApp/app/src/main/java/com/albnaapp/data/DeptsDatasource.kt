package com.albnaapp.data

import com.albnaapp.R
import com.albnaapp.model.SectionsOfDepts
import com.albnaapp.model.SubSectionsOfDepts

class DeptsDatasource {
    fun loadWarehouseSections(): MutableList<SectionsOfDepts> {
        return mutableListOf(
            SectionsOfDepts(R.string.str_title_preOrder, whSection1()),
            SectionsOfDepts(R.string.str_title_orders, whSection2()),
            SectionsOfDepts(R.string.str_title_shipEs, whSection3()),
            SectionsOfDepts(R.string.str_title_inventory, whSection4())
        )
    }

    private fun whSection1(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.btnStr_crtOrder),
            SubSectionsOfDepts(R.string.str_whPo_rcvdPrm),
            SubSectionsOfDepts(R.string.str_whPo_dfrdPrm),
            SubSectionsOfDepts(R.string.str_whPo_cnfdPrm),
            SubSectionsOfDepts(R.string.str_whPo_cnsldPrm)
        )
    }

    private fun whSection2(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_whOr_OrdList),
            SubSectionsOfDepts(R.string.str_whOr_RtnList),
            SubSectionsOfDepts(R.string.str_whOr_IncList),
            SubSectionsOfDepts(R.string.str_whOr_ctrIncomes),
            SubSectionsOfDepts(R.string.str_whOr_ctrReturns)
        )
    }

    private fun whSection3(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_whEs_EsList),
            SubSectionsOfDepts(R.string.str_whEs_cnsldEs),
            SubSectionsOfDepts(R.string.str_whEs_addEs)
        )
    }

    private fun whSection4(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_whIn_recent),
            SubSectionsOfDepts(R.string.str_whIn_Deleted),
            SubSectionsOfDepts(R.string.str_whIn_AddItem),
            SubSectionsOfDepts(R.string.str_whIn_delItem)
        )
    }

    fun loadOfficeSections(): MutableList<SectionsOfDepts> {
        return mutableListOf(
            SectionsOfDepts(R.string.str_fin_section, ofSection1()),
            SectionsOfDepts(R.string.str_cap_section, ofSection2()),
            SectionsOfDepts(R.string.str_cusSup_section, ofSection3()),
            SectionsOfDepts(R.string.str_pers_section, ofSection4())
        )
    }

    private fun ofSection1(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.btnStr_addDep),
            SubSectionsOfDepts(R.string.str_ofFn_safeAdd),
            SubSectionsOfDepts(R.string.str_ofFn_daily),
            SubSectionsOfDepts(R.string.str_ofFn_general),
            SubSectionsOfDepts(R.string.str_ofFn_chqs)
        )
    }
    private fun ofSection2(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.btnStr_addCapital),
            SubSectionsOfDepts(R.string.str_ofCp_capList),
            SubSectionsOfDepts(R.string.str_ofCp_sumList),
            SubSectionsOfDepts(R.string.str_ofCp_detList),
            SubSectionsOfDepts(R.string.str_ofCp_comR)
        )
    }
    private fun ofSection3(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.strBtn_addClient),
            SubSectionsOfDepts(R.string.str_ofCS_csList),
            SubSectionsOfDepts(R.string.str_ofCS_stoppedList),
            SubSectionsOfDepts(R.string.str_ofCS_inactiveList),
            SubSectionsOfDepts(R.string.str_ofCS_dBalances),
            SubSectionsOfDepts(R.string.str_ofCS_bBalances),
            SubSectionsOfDepts(R.string.str_ofCS_others)
        )
    }
    private fun ofSection4(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_ofPr_perList),
            SubSectionsOfDepts(R.string.str_ofPr_mReport),
            SubSectionsOfDepts(R.string.str_ofPr_yReport),
            SubSectionsOfDepts(R.string.str_ofPr_attendance),
            SubSectionsOfDepts(R.string.str_ofPr_delay)
        )
    }

    fun loadImportDepartment(): MutableList<SectionsOfDepts> {
        return mutableListOf(
            SectionsOfDepts(R.string.str_impDB_section, dBSections()),
            SectionsOfDepts(R.string.str_impEn_section, eNSections()),
            SectionsOfDepts(R.string.str_impRp_section, rPSections()),
            SectionsOfDepts(R.string.str_impTr_section, tRSections())
        )
    }

    private fun dBSections(): List<SubSectionsOfDepts> {
        return listOf(
        SubSectionsOfDepts(R.string.str_impDB_catgs),
        SubSectionsOfDepts(R.string.str_impDB_sups),
        )
    }
    private fun eNSections(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_impEn_invInfo),
            SubSectionsOfDepts(R.string.str_impEn_trans),
            SubSectionsOfDepts(R.string.str_impEn_invoices),
        )
    }
    private fun rPSections(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_impRp_stats),
            SubSectionsOfDepts(R.string.str_impRp_costs),
            SubSectionsOfDepts(R.string.str_impRp_ex),
            SubSectionsOfDepts(R.string.str_impRp_sfsi),
        )
    }
    private fun tRSections(): List<SubSectionsOfDepts> {
        return listOf(
            SubSectionsOfDepts(R.string.str_impTr_orTracker),
            SubSectionsOfDepts(R.string.str_impTr_tsTracker)
        )
    }
}