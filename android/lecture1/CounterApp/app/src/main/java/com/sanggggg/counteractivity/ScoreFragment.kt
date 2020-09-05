package com.sanggggg.counteractivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.counteractivity.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    lateinit var binding: FragmentScoreBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_score, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }
}