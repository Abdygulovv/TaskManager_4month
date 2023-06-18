package com.example.abdygulov_chyngyz_4_month.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.abdygulov_chyngyz_4_month.R
import com.example.abdygulov_chyngyz_4_month.data.local.Pref
import com.example.abdygulov_chyngyz_4_month.databinding.FragmentOnBoardingBinding
import com.example.abdygulov_chyngyz_4_month.ui.onboarding.adapter.OnBoardingAdapter

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    private val adapter = OnBoardingAdapter(this:: onClick)

    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter = adapter
        binding.indicator.setViewPager(binding.viewpager)
    }

    private fun onClick(){
        pref.saveSeen()
        findNavController().navigateUp()

    }
}