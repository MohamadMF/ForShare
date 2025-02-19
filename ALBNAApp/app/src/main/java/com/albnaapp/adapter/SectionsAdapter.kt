package com.albnaapp.adapter

import com.albnaapp.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.albnaapp.model.SectionsOfDepts
import com.albnaapp.model.SubSectionsOfDepts

class SectionsAdapter(private val context: Context, private val dataset1: List<SectionsOfDepts>) :
    RecyclerView.Adapter<SectionsAdapter.CardViewHolder>() {
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(context,R.anim.full_rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(context,R.anim.full_rotate_close_anim) }

        class CardViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val sectionTitle: TextView = view.findViewById(R.id.section_title)
            val subSectionViews: RecyclerView = view.findViewById(R.id.subSection_views)
            val iconSectionTitle: ImageButton = view.findViewById(R.id.icon_section_title)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.card_sections,parent,false)
        return CardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item1 = dataset1[position]

        holder.sectionTitle.text = context.resources.getString(item1.sectionSrcID)
        val subSectionAdapter = SubSectionViews(context, item1.subSectionSrcID)
        holder.subSectionViews.adapter = subSectionAdapter
        holder.sectionTitle.setOnClickListener {
            if (holder.subSectionViews.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(holder.subSectionViews, AutoTransition())
                holder.subSectionViews.visibility = View.VISIBLE
                holder.iconSectionTitle.startAnimation(rotateOpen)
            } else {
                TransitionManager.beginDelayedTransition(holder.subSectionViews,AutoTransition())
                holder.subSectionViews.visibility = View.GONE
                holder.iconSectionTitle.startAnimation(rotateClose)
            }
        }
        holder.iconSectionTitle.setOnClickListener {
            if (holder.subSectionViews.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(holder.subSectionViews, AutoTransition())
                holder.subSectionViews.visibility = View.VISIBLE
                holder.iconSectionTitle.startAnimation(rotateOpen)
            } else {
                TransitionManager.beginDelayedTransition(holder.subSectionViews,AutoTransition())
                holder.subSectionViews.visibility = View.GONE
                holder.iconSectionTitle.startAnimation(rotateClose)
            }
        }
    }

    override fun getItemCount() = dataset1.size
}

class SubSectionViews(private val context: Context, private val dataset: List<SubSectionsOfDepts>) :
    RecyclerView.Adapter<SubSectionViews.SubSectionListHolder>() {

    class SubSectionListHolder(view: View) : RecyclerView.ViewHolder(view) {
        val subSectionView: TextView = view.findViewById(R.id.subSection_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubSectionListHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.card_subsection,parent,false)
        return SubSectionListHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: SubSectionListHolder, position: Int) {
        val item = dataset[position]
        holder.subSectionView.text = context.resources.getString(item.subSectionSrcID)
        holder.subSectionView.setOnClickListener {

        /*val stringConvertToId = it.resources.getIdentifier(
                context.resources.getString(item.subSectionSrcID).replace("\\s".toRegex(), ""),
                "id",
                context.packageName)*/
            val mapItem = mapOf(
                R.string.btnStr_crtOrder to R.id.CreateOrder,
                R.string.str_whPo_rcvdPrm to R.id.ReceivedPreOrders,
                R.string.str_whPo_dfrdPrm to R.id.DeferredPreOrders,
                R.string.str_whPo_cnfdPrm to R.id.ConfirmedPreOrders,
                R.string.str_whPo_cnsldPrm to R.id.CancelledPreOrders,
                R.string.str_whOr_OrdList to R.id.OrdersList,
                R.string.str_whOr_RtnList to R.id.ReturnsList,
                R.string.str_whOr_IncList to R.id.IncomesList,
                R.string.str_whOr_ctrIncomes to R.id.CreateIncome,
                R.string.str_whOr_ctrReturns to R.id.ReturnOrder,
                R.string.str_whEs_EsList to R.id.ExpressesList,
                R.string.str_whEs_cnsldEs to R.id.StoppedExpress,
                R.string.str_whEs_addEs to R.id.AddExpress,
                R.string.str_whIn_recent to R.id.RecentItems,
                R.string.str_whIn_Deleted to R.id.DeletedItems,
                R.string.str_whIn_AddItem to R.id.AddItem,
                R.string.str_whIn_delItem to R.id.DeleteItem,
                R.string.btnStr_addDep to R.id.AddDeposit,
                R.string.str_ofFn_safeAdd to R.id.SafeTransactions,
                R.string.str_ofFn_daily to R.id.Absences,
                R.string.str_ofFn_general to R.id.GeneralReports,
                R.string.str_ofFn_chqs to R.id.ChequesList,
                R.string.btnStr_addCapital to R.id.AddCapital,
                R.string.str_ofCp_capList to R.id.CapitalList,
                R.string.str_ofCp_sumList to R.id.TransactionsSummery,
                R.string.str_ofCp_detList to R.id.TransactionsDetails,
                R.string.str_ofCp_comR to R.id.CompanyReportStatus,
                R.string.strBtn_addClient to R.id.AddClient,
                R.string.str_ofCS_csList to R.id.ClientsAndSuppliersList,
                R.string.str_ofCS_stoppedList to R.id.StoppedCSList,
                R.string.str_ofCS_inactiveList to R.id.InactiveCSList,
                R.string.str_ofCS_dBalances to R.id.DetailedBalances,
                R.string.str_ofCS_bBalances to R.id.BriefBalances,
                R.string.str_ofCS_others to R.id.OtherActions,
                R.string.str_ofPr_perList to R.id.PersonnelList,
                R.string.str_ofPr_mReport to R.id.MonthlySalary,
                R.string.str_ofPr_yReport to R.id.AnnualReport,
                R.string.str_ofPr_attendance to R.id.Attendance,
                R.string.str_ofPr_delay to R.id.Absences
            )
            val destinationsItem = mapItem[item.subSectionSrcID]
            destinationsItem?.let { it1 -> it.findNavController().navigate(it1) }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
/*
enum class SubsectionDestinations(@StringRes subSectionId: Int,@IdRes navigationId: Int) {
    CREATE_ORDER(R.string.btnStr_crtOrder,R.id.CreateOrder),
    RECEIVED_PREORDERS(R.string.str_whPo_rcvdPrm,R.id.ReceivedPreOrders),
    DEFERRED_PREORDERS(R.string.str_whPo_dfrdPrm,R.id.DeferredPreOrders),
    CONFIRMED_PREORDERS(R.string.str_whPo_cnfdPrm,R.id.ConfirmedPreOrders),
    CANCELLED_PREORDERS(R.string.str_whPo_cnsldPrm,R.id.CancelledPreOrders),
    ORDERS_LIST(R.string.str_whOr_OrdList,R.id.OrdersList),
    RETURNS_LIST(R.string.str_whOr_RtnList,R.id.ReturnsList),
    INCOMES_LIST(R.string.str_whOr_IncList,R.id.IncomesList),
    CREATE_INCOME(R.string.str_whOr_ctrIncomes,R.id.CreateIncome),
    RETURN_ORDER(R.string.str_whOr_ctrReturns,R.id.ReturnOrder),
    EXPRESSES_LIST(R.string.str_whEs_EsList,R.id.ExpressesList),
    STOPPED_EXPRESS(R.string.str_whEs_cnsldEs,R.id.StoppedExpress),
    ADD_EXPRESS(R.string.str_whEs_addEs,R.id.AddExpress),
    RECENT_ITEMS(R.string.str_whIn_recent,R.id.RecentItems),
    DELETED_ITEMS(R.string.str_whIn_Deleted,R.id.DeletedItems),
    ADD_ITEM(R.string.str_whIn_AddItem,R.id.AddItem),
    DELETE_ITEM(R.string.str_whIn_delItem,R.id.DeleteItem),
    ADD_DEPOSIT(R.string.btnStr_addDep,R.id.AddDeposit),
    SAFE_TRANS(R.string.str_ofFn_safeAdd,R.id.SafeTransactions),
    DAILY_REPORT(R.string.str_ofFn_daily,R.id.DelayAndEarly),
    GENERAL_REPORT(R.string.str_ofFn_general,R.id.GeneralReports),
    CHEQUES_LIST(R.string.str_ofFn_chqs,R.id.ChequesList),
    ADD_CAPITAL(R.string.btnStr_addCapital,R.id.AddCapital),
    CAPITAL_LIST(R.string.str_ofCp_capList,R.id.CapitalList),
    TRANS_SUM(R.string.str_ofCp_sumList,R.id.TransactionsSummery),
    TRANS_DETAILS(R.string.str_ofCp_detList,R.id.TransactionsDetails),
    COM_RP_STAT(R.string.str_ofCp_comR,R.id.CompanyReportStatus),
    ADD_CLIENT(R.string.strBtn_addClient,R.id.AddClient),
    CLIENTS_SUPPLIERS(R.string.str_ofCS_csList,R.id.ClientsAndSuppliersList),
    STOPPED_CS(R.string.str_ofCS_stoppedList,R.id.StoppedCSList),
    INACTIVE_CS(R.string.str_ofCS_inactiveList,R.id.InactiveCSList),
    DETAILED_BALANCES(R.string.str_ofCS_dBalances,R.id.DetailedBalances),
    BRIEF_BALANCES(R.string.str_ofCS_bBalances,R.id.BriefBalances),
    OTHER_ACTIONS(R.string.str_ofCS_others,R.id.OtherActions),
    PERSONNEL_LIST(R.string.str_ofPr_perList,R.id.PersonnelList),
    MONTHLY_SALARY(R.string.str_ofPr_mReport,R.id.MonthlySalary),
    ANNUAL_REPORT(R.string.str_ofPr_yReport,R.id.AnnualReport),
    ATTENDANCE(R.string.str_ofPr_attendance,R.id.Attendance),
    DELAY_EARLY(R.string.str_ofPr_delay,R.id.DelayAndEarly)
    /*PRODUCT_CAT(R.string.str_impDB_catgs),
    SUPPLIERS(R.string.str_impDB_sups),
    INV_INFO(R.string.str_impEn_invInfo),
    TRANSACTIONS(R.string.str_impEn_trans),
    INVOICES(R.string.str_impEn_invoices),
    STAT_BALANCES(R.string.str_impRp_stats),
    COSTS(R.string.str_impRp_costs),
    EX_INFO(R.string.str_impRp_ex),
    SFSI(R.string.str_impRp_sfsi),
    ORDER_TRACKER(R.string.str_impTr_orTracker),
    TASK_TRACKER(R.string.str_impTr_tsTracker)*/
}
*/