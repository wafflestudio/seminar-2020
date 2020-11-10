package com.sanggggg.tictactoe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@Suppress("PrivatePropertyName")
class TicTacToeViewModel : ViewModel() {

    // TODO: Make your ViewModel!
    // CONSTANTS FOR views text (DO NOT FIX)
    private val PLAYER_O = "O"
    private val PLAYER_X = "X"

    private val STATUS_PLAYING = "PLAYING..."
    private val STATUS_O_WIN = "PLAYER O WIN!"
    private val STATUS_X_WIN = "PLAYER X WIN!"
    private val STATUS_DRAW = "DRAW!"

    // recommended LiveData fields (fill free to fix it)
    val cells = ArrayList<MutableLiveData<String>>()
    val gameStatus = MutableLiveData<String>()
    private var whoseTurn = true

    init {
        for (i in 0..8) {
            cells.add(MutableLiveData())
        }
        restart()
    }

    // recommended function structures (fill free to fix it)
    fun clickCell(pos: Int) {}

    fun restart() {}

    fun checkWinOrNot() {

    }
}