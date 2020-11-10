package com.example.rotatingcounter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rotatingcounter.androidviewmodel.ViewModelCounterActivity
import com.example.rotatingcounter.myviewmodel.MyViewModelCounterActivity
import com.example.rotatingcounter.savedinstancestate.SavedInstanceStateCounterActivity
import com.example.rotatingcounter.simple.SimpleCounterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    private fun initializeViews() {
        button1.setOnClickListener {
            startActivity(SimpleCounterActivity.intent(this))
        }
        button2.setOnClickListener {
            startActivity(SavedInstanceStateCounterActivity.intent(this))
        }
        button3.setOnClickListener {
            startActivity(MyViewModelCounterActivity.intent(this))
        }
        button4.setOnClickListener {
            startActivity(ViewModelCounterActivity.intent(this))
        }
    }
}