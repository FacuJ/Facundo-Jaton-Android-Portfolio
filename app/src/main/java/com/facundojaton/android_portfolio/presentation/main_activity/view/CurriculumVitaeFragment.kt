package com.facundojaton.android_portfolio.presentation.main_activity.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.facundojaton.android_portfolio.R
import com.facundojaton.android_portfolio.databinding.FragmentCurriculumVitaeBinding

class CurriculumVitaeFragment : Fragment() {

    private lateinit var binding: FragmentCurriculumVitaeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurriculumVitaeBinding.inflate(layoutInflater)
        return binding.root
    }

}