package com.sanggggg.counter1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var score = MutableLiveData<String>()

    init {
        score.value = "0"
    }

    fun addScore() {
        score.value = (score.value?.toInt()?.plus(1)).toString()
    }
}