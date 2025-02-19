package com.albnaapp.userin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.albnaapp.R
import com.albnaapp.databinding.FragmentAppAboutBinding

class AppAboutFragment : Fragment() {
    private lateinit var binding: FragmentAppAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_app_about, container,false)
        return binding.root
    }
}