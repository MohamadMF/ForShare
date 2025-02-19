package com.albnaapp.userin.import

import com.albnaapp.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.albnaapp.adapter.SectionsAdapter
import com.albnaapp.data.DeptsDatasource
import com.albnaapp.databinding.FragmentDeptImportBinding

class DeptImportFragment : Fragment() {
    lateinit var binding: FragmentDeptImportBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dept_import, container, false)

        val loadImportDept = DeptsDatasource().loadImportDepartment()
        binding.rcyclrImport.adapter = SectionsAdapter(requireContext(), loadImportDept)

        return binding.root
    }

}