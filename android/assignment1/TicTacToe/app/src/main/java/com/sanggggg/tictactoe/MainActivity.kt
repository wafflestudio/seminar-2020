package com.sanggggg.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.tictactoe.databinding.ActivityMainBinding
// TODO: Complete MainActivity.kt
// You may have to add some onClick listeners for buttons

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var ticTacToeViewModel: TicTacToeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ticTacToeViewModel = ViewModelProvider(this).get(TicTacToeViewModel::class.java)

        binding.apply {
            viewModel = ticTacToeViewModel
            lifecycleOwner = this@MainActivity
        }
    }
}