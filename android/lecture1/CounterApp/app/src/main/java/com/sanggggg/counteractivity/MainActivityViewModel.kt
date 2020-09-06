package com.sanggggg.counteractivity

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val scoreText = MutableLiveData<String>()

    val userName = MutableLiveData<String>()

    init {
        scoreText.value = "0"
        userName.value = ""
    }

    fun addScore() {
        Log.d("_____", scoreText.value)
        scoreText.value = (scoreText.value?.toInt()?.plus(1)).toString()
    }
}