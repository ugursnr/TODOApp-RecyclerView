package com.ugurrsnr.todoapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ugurrsnr.todoapp.TODOAdapter.TODOHolder
import com.ugurrsnr.todoapp.databinding.TodoRecyclerRowBinding

class TODOAdapter(val todoList : ArrayList<TODOs>) : RecyclerView.Adapter<TODOHolder>() {

    class TODOHolder(val binding : TodoRecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TODOHolder {
        val binding = TodoRecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TODOHolder(binding)
    }

    override fun onBindViewHolder(holder: TODOHolder, position: Int) {
        holder.binding.rowTextView.text = todoList[position].todoDescription

        holder.binding.deleteTODO.setOnClickListener {
            deleteTODO(todoList[position])
        }


    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteTODO(todo : TODOs){
        todoList.remove(todo)
        notifyDataSetChanged()

    }
}