package com.example.rotatingcounter.simple

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rotatingcounter.BaseActivity
import com.example.rotatingcounter.R
import kotlinx.android.synthetic.main.activity_counter.*

class SimpleCounterActivity : BaseActivity() {

    companion object {
        fun intent(context: Context) = Intent(context, SimpleCounterActivity::class.java)
    }

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        initializeViews()
    }

    private fun initializeViews() {
        counter_text.text = count.toString()
        counter_text.setOnClickListener {
            count++
            counter_text.text = count.toString()
        }
    }
}
