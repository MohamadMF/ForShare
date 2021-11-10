package com.myply.myapplication

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter internal constructor(
    val context: Context?,
    val data: MutableList<CustomerModel>
) : RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>() {
    var mClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_customer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customer = data[position]

        holder.editName.setText(customer.name)

        holder.rbDeposit.setOnCheckedChangeListener(null)
        holder.rbCheque.setOnCheckedChangeListener(null)

        holder.rbDeposit.isChecked = customer.depositType == "Deposit"
        holder.rbCheque.isChecked = customer.depositType == "Cheque"

        holder.btnRemove.setOnClickListener { mClickListener?.onItemRemoveClicked(position) }
        holder.editName.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE || event?.action == KeyEvent.ACTION_DOWN && event?.keyCode == KeyEvent.KEYCODE_ENTER) {
                    customer.name = holder.editName.text.toString()

                    holder.editName.clearFocus()

                    update(customer, position)
                    return true
                }
                return false
            }
        })
        holder.rbDeposit.setOnCheckedChangeListener { compoundButton, b ->
            customer.depositType = "Deposit"

            update(customer, position)
        }
        holder.rbCheque.setOnCheckedChangeListener { compoundButton, b ->
            customer.depositType = "Cheque"

            update(customer, position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun add(customer: CustomerModel) {
        data.add(customer)
        notifyItemInserted(data.size - 1)
    }

    fun update(customer: CustomerModel, position: Int) {
        data[position] = customer
        notifyItemChanged(position)
    }

    fun removeAt(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, data.size)
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var editName: EditText = itemView.findViewById(R.id.edit_name)
        var btnRemove: ImageView = itemView.findViewById(R.id.btn_remove)
        var rbDeposit: RadioButton = itemView.findViewById(R.id.rb_deposit)
        var rbCheque: RadioButton = itemView.findViewById(R.id.rb_cheque)
    }

    interface ItemClickListener {
        fun onItemRemoveClicked(position: Int)
    }
}