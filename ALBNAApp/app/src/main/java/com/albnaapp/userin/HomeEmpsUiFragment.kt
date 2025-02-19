package com.albnaapp.userin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.albnaapp.R
import com.albnaapp.databinding.FragmentHomeEmpsUiBinding



class HomeEmpsUiFragment : Fragment() {
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.half_rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.half_rotate_close_anim) }
    //private val fromAnimation: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.from_anim) }
    //private val toAnimation: Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.to_anim) }
    private var clicked = false
    lateinit var binding: FragmentHomeEmpsUiBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home_emps_ui,
            container,
            false
        )

        binding.fabBtnAdd.setOnClickListener {
            onAddButtonClicked()
        }
        binding.fabBtnAddDeposit.setOnClickListener {
            findNavController().navigate(R.id.AddDeposit)
        }
        binding.fabBtnAddOrder.setOnClickListener {
            findNavController().navigate(R.id.CreateOrder)
        }
        binding.fabBtnAddCustomer.setOnClickListener {
            findNavController().navigate(R.id.AddClient)
        }
        binding.fabBtnAddCapital.setOnClickListener {
            findNavController().navigate(R.id.AddCapital)
        }
        return binding.root
    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        //clickController(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding.fabBtnAddDeposit.show()
            binding.fabBtnAddOrder.show()
            binding.fabBtnAddCustomer.show()
            binding.fabBtnAddCapital.show()
        } else {
            binding.fabBtnAddDeposit.hide()
            binding.fabBtnAddOrder.hide()
            binding.fabBtnAddCustomer.hide()
            binding.fabBtnAddCapital.hide()
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            binding.fabBtnAddDeposit.extend()
            binding.fabBtnAddOrder.extend()
            binding.fabBtnAddCustomer.extend()
            binding.fabBtnAddCapital.extend()
            /*binding.fabBtnAddDeposit.startAnimation(fromAnimation)
            binding.fabBtnAddOrder.startAnimation(fromAnimation)
            binding.fabBtnAddCustomer.startAnimation(fromAnimation)
            binding.fabBtnAddCapital.startAnimation(fromAnimation)*/

            binding.fabBtnAdd.startAnimation(rotateOpen)
        }else{
            binding.fabBtnAddDeposit.shrink()
            binding.fabBtnAddOrder.shrink()
            binding.fabBtnAddCustomer.shrink()
            binding.fabBtnAddCapital.shrink()
            /*binding.fabBtnAddDeposit.startAnimation(toAnimation)
            binding.fabBtnAddOrder.startAnimation(toAnimation)
            binding.fabBtnAddCustomer.startAnimation(toAnimation)
            binding.fabBtnAddCapital.startAnimation(toAnimation)*/

            binding.fabBtnAdd.startAnimation(rotateClose)

        }
    }

    /*private fun clickController(clicked: Boolean) {
        if (!clicked){
            binding.fabBtnAddDeposit.isClickable = true
            binding.fabBtnAddOrder.isClickable = true
            binding.fabBtnAddCustomer.isClickable = true
            binding.fabBtnAddCapital.isClickable = true
        } else {
            binding.fabBtnAddDeposit.isClickable = false
            binding.fabBtnAddOrder.isClickable = false
            binding.fabBtnAddCustomer.isClickable = false
            binding.fabBtnAddCapital.isClickable = false
        }
    }*/
}

