package com.albnaapp.userin.office

import com.albnaapp.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.albnaapp.adapter.AddDepositAdapter
import com.albnaapp.databinding.FragmentFnAddDepositBinding
import com.albnaapp.model.ClientDepositData

class FnAddDepositFragment : Fragment() {
    lateinit var binding: FragmentFnAddDepositBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_fn_add_deposit, container, false)

        val addDepositAdapter = AddDepositAdapter(requireContext(), arrayListOf(
            ClientDepositData()
        ))

        //Add in Recycler View
        binding.recViewAdding.adapter = addDepositAdapter
        addDepositAdapter.xClickListener = object : AddDepositAdapter.ItemClickListener{
            override fun onRemovedItemClick(position: Int) {
                addDepositAdapter.removeAt(position)
            }
        }

        // The button in bottom
        binding.strBtnAddOther.setOnClickListener {
            addDepositAdapter.add(ClientDepositData())
        }
        return binding.root
    }
}