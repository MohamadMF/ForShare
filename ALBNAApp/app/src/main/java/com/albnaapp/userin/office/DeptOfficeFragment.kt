package com.albnaapp.userin.office

import com.albnaapp.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.albnaapp.adapter.SectionsAdapter
import com.albnaapp.data.DeptsDatasource
import com.albnaapp.databinding.FragmentDeptOfficeBinding

class DeptOfficeFragment : Fragment() {
    lateinit var binding: FragmentDeptOfficeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dept_office, container, false)

        val officeSections = DeptsDatasource().loadOfficeSections()
        binding.rcyclrOfficeDep.adapter = SectionsAdapter(requireContext(),officeSections)
        binding.rcyclrOfficeDep.setHasFixedSize(true)

        return binding.root
    }
}