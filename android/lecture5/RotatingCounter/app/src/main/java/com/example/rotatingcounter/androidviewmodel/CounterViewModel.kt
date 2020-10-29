package com.example.rotatingcounter.androidviewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class CounterViewModel : ViewModel() {

    private val countSubject = BehaviorSubject.createDefault(0)

    fun observeCount(): Observable<Int> = countSubject.hide()
    fun increment() {
        countSubject.onNext(countSubject.value + 1)
    }
}