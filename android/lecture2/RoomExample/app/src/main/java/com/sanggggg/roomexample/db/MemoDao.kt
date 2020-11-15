package com.sanggggg.roomexample.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MemoDao {
    @Query("SELECT * FROM memo_table")
    fun getAllMemo(): LiveData<List<Memo>>

    @Query("SELECT * FROM memo_table WHERE id = :id")
    fun getMemoById(id: Long): LiveData<Memo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(memo: Memo)

    @Update
    fun updateMemo(memo: Memo)

    @Delete
    fun deleteMemo(memo: Memo)
}