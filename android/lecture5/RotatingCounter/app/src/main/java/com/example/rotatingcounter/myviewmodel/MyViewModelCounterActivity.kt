package com.example.rotatingcounter.myviewmodel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.rotatingcounter.BaseActivity
import com.example.rotatingcounter.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_counter.*

class MyViewModelCounterActivity : BaseActivity() {

    companion object {
        private const val TAG = "MyViewModelCounter"
        fun intent(context: Context) = Intent(context, MyViewModelCounterActivity::class.java)
    }

    private val viewModel = MyCounterViewModel()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        initializeViews()
    }

    private fun initializeViews() {
        viewModel.observeCount()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                counter_text.text = it.toString()
            }, {
                Log.e(TAG, "Observe Count", it)
            })
            .also { compositeDisposable.add(it) }

        counter_text.setOnClickListener {
            viewModel.increment()
        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}
