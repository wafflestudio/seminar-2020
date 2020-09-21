package com.sanggggg.roomexample.db

import android.content.Context
import androidx.lifecycle.LiveData

class MemoRepository(context: Context) {
    val memoDao: MemoDao = MemoDatabase.getInstance(context).memoDao()

    fun getMemos(): LiveData<List<Memo>> = memoDao.getAllMemo()
}