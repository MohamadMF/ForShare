package com.albnaapp.userin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.albnaapp.databinding.FragmentAppReportBinding

class AppReportFragment : Fragment() {
    private lateinit var binding: FragmentAppReportBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAppReportBinding.inflate(layoutInflater)
        return binding.root
    }
}