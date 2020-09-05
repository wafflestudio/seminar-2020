package com.sanggggg.counteractivity

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.counteractivity.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        binding.buttonAdd.setOnClickListener {
            onClickAdd()
        }

        return binding.root
    }

    fun onClickAdd() {
        viewModel.addScore()
    }
}