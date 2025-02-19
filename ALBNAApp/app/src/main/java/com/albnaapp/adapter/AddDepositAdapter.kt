package com.albnaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.albnaapp.R
import com.albnaapp.databinding.CardAddDepositBinding
import com.albnaapp.model.ClientDepositData

class AddDepositAdapter(
    private val context: Context,
    private val dataset: MutableList<ClientDepositData>
) : RecyclerView.Adapter<AddDepositAdapter.ElementsViewHolder>() {

    interface ItemClickListener {
        fun onRemovedItemClick(position: Int)
    }

    var xClickListener: ItemClickListener? = null

    class ElementsViewHolder(val binding: CardAddDepositBinding) : RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementsViewHolder {
        val adapterLayout = CardAddDepositBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ElementsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ElementsViewHolder, position: Int) {
        //val item = dataset[position]

        holder.binding.btnCancelDeposit.setOnClickListener { xClickListener?.onRemovedItemClick(position) }

        //Client Code Block
        val codes = context.resources.getStringArray(R.array.Codes)
        val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1, codes)
        holder.binding.clientCode.setAdapter(adapter)

        holder.binding.clientCode.setOnItemClickListener { _, _, position, _ ->
            when(position) {
                0 -> holder.binding.clientName.text = "أيمن البطوطي"
                1 -> holder.binding.clientName.text = "سيد الطيب"
                2 -> holder.binding.clientName.text = "طارق وعلاء"
                3 -> holder.binding.clientName.text = "عبدالكريم"
                4 -> holder.binding.clientName.text = "هشام البطوطي"
                5 -> holder.binding.clientName.text = "وليد علام"
                6 -> holder.binding.clientName.text = "عبدالباسط"

            }
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun add(customer: ClientDepositData) {
        dataset.add(customer)
        notifyItemInserted(dataset.size - 1)
    }

    fun update(customer: ClientDepositData, position: Int) {
        dataset[position] = customer
        notifyItemChanged(position)
    }

    fun removeAt(position: Int) {
        dataset.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, dataset.size)
    }
}