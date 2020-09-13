package com.sanggggg.simpletodo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.sanggggg.simpletodo.R
import com.sanggggg.simpletodo.databinding.ActivityMainBinding
import com.sanggggg.simpletodo.databinding.DialogAddTodoBinding
import com.sanggggg.simpletodo.utils.InjectionUtils
import com.sanggggg.simpletodo.viewmodel.TodoViewModel


// Already completed
// Do not modify
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingDialog: DialogAddTodoBinding
    private lateinit var dialog: AlertDialog

    private val todoViewModel: TodoViewModel by viewModels {
        InjectionUtils.provideTodoViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.run {
            lifecycleOwner = this@MainActivity
            viewModel = todoViewModel
            adapter = TodoListAdapter(todoViewModel)
        }

        setUpDialog()

        binding.floatingActionButton.setOnClickListener {
            bindingDialog.textTitle.setText("")
            bindingDialog.textContent.setText("")
            dialog.show()
        }
    }

    private fun setUpDialog() {
        bindingDialog = DialogAddTodoBinding.inflate(LayoutInflater.from(this))
        val dialogBuilder = AlertDialog.Builder(this@MainActivity)
            .setTitle("Add Todos")
            .setView(bindingDialog.root)
            .setPositiveButton(
                "Create"
            ) { _, _ ->
                todoViewModel.addTodo(
                    bindingDialog.textTitle.text.toString(),
                    bindingDialog.textContent.text.toString()
                )
                Toast.makeText(applicationContext, "Create", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(
                "Cancel"
            ) { _, _ ->
                Toast.makeText(applicationContext, "Cancel", Toast.LENGTH_SHORT).show()
            }
        dialog = dialogBuilder.create()
    }
}