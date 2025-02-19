package com.albnaapp.userin.warehouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.albnaapp.R
import com.albnaapp.adapter.AddOrderAdapter
import com.albnaapp.databinding.FragmentPoCreateOrderBinding
import com.albnaapp.model.OrderDetails

class PoCreateOrderFragment : Fragment() {
    lateinit var binding: FragmentPoCreateOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_po_create_order,container,false)

        val addOrderAdapter = AddOrderAdapter(requireContext(), arrayListOf(OrderDetails()))

        //Add in Recycler View
        binding.recOrderDetails.adapter = addOrderAdapter
        addOrderAdapter.xClickListener = object : AddOrderAdapter.ItemClickListener{
            override fun onRemovedItemClick(position: Int) {
                addOrderAdapter.removeAt(position)
            }
        }

        // The button in bottom
        binding.strBtnAddItem.setOnClickListener {
            addOrderAdapter.add(OrderDetails())
        }
        return binding.root
    }
}


