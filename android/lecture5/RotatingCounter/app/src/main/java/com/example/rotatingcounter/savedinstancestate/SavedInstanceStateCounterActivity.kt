package com.example.rotatingcounter.savedinstancestate

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rotatingcounter.BaseActivity
import com.example.rotatingcounter.R
import kotlinx.android.synthetic.main.activity_counter.*

class SavedInstanceStateCounterActivity : BaseActivity() {

    companion object {
        fun intent(context: Context) =
            Intent(context, SavedInstanceStateCounterActivity::class.java)

        const val COUNT_KEY = "count"
    }

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        count = savedInstanceState?.getInt(COUNT_KEY) ?: 0

        initializeViews()
    }

    private fun initializeViews() {
        counter_text.text = count.toString()
        counter_text.setOnClickListener {
            count++
            counter_text.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_KEY, count)
        super.onSaveInstanceState(outState)
    }
}
