package com.facundojaton.android_portfolio.presentation.main_activity.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facundojaton.android_portfolio.databinding.FragmentExperienceBinding

class ExperienceFragment : Fragment() {

    private lateinit var binding: FragmentExperienceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExperienceBinding.inflate(layoutInflater)
        return binding.root
    }
}