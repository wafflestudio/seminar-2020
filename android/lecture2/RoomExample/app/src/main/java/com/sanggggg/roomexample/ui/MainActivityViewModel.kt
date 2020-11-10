package com.sanggggg.roomexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanggggg.roomexample.db.Memo
import com.sanggggg.roomexample.db.MemoRepository
import kotlin.random.Random

class MainActivityViewModel() : ViewModel() {
    val allMemos =  MutableLiveData<MutableList<Memo>>()

    init {
        allMemos.value = mutableListOf(getRandomItem(), getRandomItem(), getRandomItem(), getRandomItem())
    }

    fun addItem() {
        allMemos.value?.add(getRandomItem())
        allMemos.value = allMemos.value
    }

    private fun getRandomItem(): Memo {
        val randId = Random.nextLong(0, 100)
        val randMemo = Memo(randId, "TITLE $randId", "MESSAGE $randId")
        return randMemo
    }
}