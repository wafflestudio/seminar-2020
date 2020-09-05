package com.sanggggg.counter1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("DebugLog", "DetailActivity onCreate!")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DebugLog", "DetailActivity onDestroy!")
    }
}