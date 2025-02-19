package com.albnaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.albnaapp.R
import com.albnaapp.databinding.CardAddOrderBinding
import com.albnaapp.model.OrderDetails

class AddOrderAdapter(
    private val context: Context,
    private val dataset: MutableList<OrderDetails>
) : RecyclerView.Adapter<AddOrderAdapter.DetailsViewHolder>() {
    interface ItemClickListener {
        fun onRemovedItemClick(position: Int)
    }

    var xClickListener: ItemClickListener? = null

    class DetailsViewHolder(val binding: CardAddOrderBinding ) : RecyclerView.ViewHolder(binding.root) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val adapterLayout = CardAddOrderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DetailsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.binding.btnCancelOrder.setOnClickListener { xClickListener?.onRemovedItemClick(position) }
        
        val items = context.resources.getStringArray(R.array.items)
        val adapterItems = ArrayAdapter(context,android.R.layout.simple_selectable_list_item,items)
        holder.binding.itemText.setAdapter(adapterItems)

        holder.binding.itemText.setOnItemClickListener { _, _, position, _ ->
            val types1 = context.resources.getStringArray(R.array.types1)
            val adapterTypes1 = ArrayAdapter(context, android.R.layout.simple_list_item_1,types1)
            val types2 = context.resources.getStringArray(R.array.types2)
            val adapterTypes2 = ArrayAdapter(context, android.R.layout.simple_list_item_1,types2)
            val types3 = context.resources.getStringArray(R.array.types3)
            val adapterTypes3= ArrayAdapter(context, android.R.layout.simple_list_item_1,types3)
            val colors1 = context.resources.getStringArray(R.array.colors1)
            val adapterColors1 = ArrayAdapter(context, android.R.layout.simple_list_item_1,colors1)
            val colors2 = context.resources.getStringArray(R.array.colors2)
            val adapterColors2 = ArrayAdapter(context, android.R.layout.simple_list_item_1,colors2)
            val colors3 = context.resources.getStringArray(R.array.colors3)
            val adapterColors3 = ArrayAdapter(context, android.R.layout.simple_list_item_1,colors3)
            when(position) {
                0 -> {
                    holder.binding.typeText.setAdapter(adapterTypes1)
                    holder.binding.colorText.setAdapter(adapterColors1)
                }
                1 -> {
                    holder.binding.typeText.setAdapter(adapterTypes2)
                    holder.binding.colorText.setAdapter(adapterColors2)
                }
                2 -> {
                    holder.binding.typeText.setAdapter(adapterTypes3)
                    holder.binding.colorText.setAdapter(adapterColors3)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun add(data: OrderDetails) {
        dataset.add(data)
        notifyItemInserted(dataset.size - 1)
    }

    fun update(data: OrderDetails, position: Int) {
        dataset[position] = data
        notifyItemChanged(position)
    }

    fun removeAt(position: Int) {
        dataset.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, dataset.size)
    }
}