package com.sanggggg.roomexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanggggg.roomexample.R
import com.sanggggg.roomexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.run {
            lifecycleOwner = this@MainActivity
            viewModel = mainActivityViewModel
            adapter = MemoListAdapter()
            btnAdd.setOnClickListener {
                mainActivityViewModel.addItem()
            }
        }
    }
}