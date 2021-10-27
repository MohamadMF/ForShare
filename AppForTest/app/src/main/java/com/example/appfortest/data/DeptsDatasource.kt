package com.example.appfortest.data

import com.example.appfortest.R
import com.example.appfortest.model.SectionsOfDepts

class DeptsDatasource {
    fun loadWarehouseSections(): MutableList<SectionsOfDepts>{
        val section1 = listOf(R.string.str_whPr_rcvdPrm,R.string.str_whPr_dfrdPrm,R.string.str_whPr_cnfdPrm,R.string.str_whPr_cnsldPrm)
        val section2 = listOf(R.string.str_whOr_OrdList,R.string.str_whOr_RtnList,R.string.str_whOr_IncList,R.string.str_whOr_ctrIncomes,R.string.str_whOr_ctrReturns)
        val section3 = listOf(R.string.str_whEs_EsList,R.string.str_whEs_cnsldEs,R.string.str_whEs_addEs)
        val section4 = listOf(R.string.str_whIn_recent,R.string.str_whIn_Empty,R.string.str_whIn_Deleted,R.string.str_whIn_AddItem,R.string.str_whIn_delItem)
        return mutableListOf<SectionsOfDepts>(
            SectionsOfDepts(R.string.str_title_preOrder,section1),
            SectionsOfDepts(R.string.str_title_orders, section2),
            SectionsOfDepts(R.string.str_title_shipEs, section3),
            SectionsOfDepts(R.string.str_title_inventory, section4)
        )
    }

    fun loadOfficeSections(): MutableList<SectionsOfDepts>{
        val section1 = listOf(R.string.str_ofFin_safeAdd,R.string.str_ofFin_daily,R.string.str_ofFin_general,R.string.str_ofFin_chqs)
        val section2 = listOf(R.string.str_ofCp_capList,R.string.str_ofCp_sumList,R.string.str_ofCp_detList,R.string.str_ofCp_comR)
        val section3 = listOf(R.string.str_ofCS_csList,R.string.str_ofCS_stoppedList,R.string.str_ofCS_inactiveList,R.string.str_ofCS_dBalances,R.string.str_ofCS_bBalances,R.string.str_ofCS_others)
        return mutableListOf<SectionsOfDepts>(
            SectionsOfDepts(R.string.str_fin_section, section1),
            SectionsOfDepts(R.string.str_cap_section, section2),
            SectionsOfDepts(R.string.str_cusSup_section, section3),
            SectionsOfDepts(R.string.str_pers_section,null)
        )
    }
    /*
    SectionsOfDepts(R.string.str_title_preOrder, listOf(R.string.str_whPr_rcvdPrm,R.string.str_whPr_dfrdPrm,R.string.str_whPr_cnfdPrm,R.string.str_whPr_cnsldPrm)),
            SectionsOfDepts(R.string.str_title_orders, listOf(R.string.str_whOr_OrdList,R.string.str_whOr_RtnList,R.string.str_whOr_IncList,R.string.str_whOr_ctrIncomes,R.string.str_whOr_ctrReturns)),
            SectionsOfDepts(R.string.str_title_shipEs, listOf(R.string.str_whEs_EsList,R.string.str_whEs_cnsldEs,R.string.str_whEs_addEs)),
            SectionsOfDepts(R.string.str_title_inventory, listOf(R.string.str_whIn_recent,R.string.str_whIn_Empty,R.string.str_whIn_Deleted,R.string.str_whIn_AddItem,R.string.str_whIn_delItem))

            SectionsOfDepts(R.string.str_fin_section, listOf(R.string.str_ofFin_safeAdd,R.string.str_ofFin_daily,R.string.str_ofFin_general,R.string.str_ofFin_chqs)),
            SectionsOfDepts(R.string.str_cap_section, listOf(R.string.str_ofCp_capList,R.string.str_ofCp_sumList,R.string.str_ofCp_detList,R.string.str_ofCp_comR)),
            SectionsOfDepts(R.string.str_cusSup_section, listOf(R.string.str_ofCS_csList,R.string.str_ofCS_stoppedList,R.string.str_ofCS_inactiveList,R.string.str_ofCS_dBalances,R.string.str_ofCS_bBalances,R.string.str_ofCS_others)),
            SectionsOfDepts(R.string.str_pers_section, listOf())
     */
}