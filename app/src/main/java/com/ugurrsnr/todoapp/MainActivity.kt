package com.ugurrsnr.todoapp

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurrsnr.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var todoAdapter : TODOAdapter
    private lateinit var todoList : ArrayList<TODOs>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        todoList = ArrayList<TODOs>()

        todoAdapter = TODOAdapter(todoList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = todoAdapter

    }

    @SuppressLint("NotifyDataSetChanged")
    fun todoAdder(view : View){

        val textFromET = binding.todoEditText.text.toString()
        val newTodo = TODOs(textFromET)
        todoList.add(newTodo)
        todoAdapter.notifyDataSetChanged()
        binding.todoEditText.text.clear()


    }

}