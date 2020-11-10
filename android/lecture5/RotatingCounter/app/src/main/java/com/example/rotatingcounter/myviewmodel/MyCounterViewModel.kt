package com.example.rotatingcounter.myviewmodel

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class MyCounterViewModel {

    private val countSubject = BehaviorSubject.createDefault(0)

    fun observeCount(): Observable<Int> = countSubject.hide()
    fun increment() {
        countSubject.onNext(countSubject.value + 1)
    }
}