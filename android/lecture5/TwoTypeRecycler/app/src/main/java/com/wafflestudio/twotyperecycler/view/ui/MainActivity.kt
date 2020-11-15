package com.wafflestudio.twotyperecycler.view.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wafflestudio.twotyperecycler.R
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val compositeDisposable = CompositeDisposable()

    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        viewModel.getTodos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapter.todos = it
                adapter.notifyDataSetChanged()
            }, {
                Log.d(MainActivity::class.java.name, "getTodos error", it)
            })
    }

    private fun initializeViews() {
        adapter = TodoAdapter()
        todo_list.layoutManager = LinearLayoutManager(this)
        todo_list.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
