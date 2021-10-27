package com.example.appfortest.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appfortest.R
import com.example.appfortest.data.DeptsDatasource
import com.example.appfortest.model.SectionsOfDepts

class CardAdapter(private val context: Context, private val dataset1: List<SectionsOfDepts>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {


        class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
            val sectionTitle: TextView = view.findViewById(R.id.section_title)
            val subSectionViews: TextView = view.findViewById(R.id.subSection_views)
            val iconSubSection: ImageView = view.findViewById(R.id.icon_subSection)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        //val binding = DataBindingUtil.inflate<DeptsCardViewBinding>(LayoutInflater.from(parent.context),R.layout.depts_card_view,parent,false)
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.depts_card_view,parent,false)
        return CardViewHolder(adapterLayout)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item1 = dataset1[position]

        holder.sectionTitle.text = item1.sectionSrcID?.let { context.resources.getString(it) }
        for (sub in holder.subSectionViews.text){
            context.resources.getString(sub.toInt(),item1.subSectionSrcID)
        }

    }

    override fun getItemCount() = dataset1.size
}






