package com.albnaapp.userin.warehouse

import com.albnaapp.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.albnaapp.adapter.SectionsAdapter
import com.albnaapp.data.DeptsDatasource
import com.albnaapp.databinding.FragmentDeptWarehouseBinding


class DeptWarehouseFragment : Fragment() {
    lateinit var binding: FragmentDeptWarehouseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dept_warehouse,container,false)

        //(activity as AppCompatActivity?)!!.supportActionBar!!.show()
        val warehouseSections = DeptsDatasource().loadWarehouseSections()
        val sectionsAdapter = SectionsAdapter(requireContext(),warehouseSections)
        binding.rcyclrWarehouseDep.adapter = sectionsAdapter
        binding.rcyclrWarehouseDep.setHasFixedSize(true)
        return binding.root
    }
}


