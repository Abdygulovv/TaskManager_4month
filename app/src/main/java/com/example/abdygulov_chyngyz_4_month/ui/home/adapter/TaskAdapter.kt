package com.example.abdygulov_chyngyz_4_month.ui.home.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.abdygulov_chyngyz_4_month.databinding.ItemTaskBinding
import com.example.abdygulov_chyngyz_4_month.model.Task

class TaskAdapter(
    private val onLongClickTask: (Task) -> Unit,
    private val onClickTask: (Bundle) -> Unit
) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val list = arrayListOf<Task>()

    fun setTasks(tasks: List<Task>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binds(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun binds(task: Task) = with(binding) {
            tvTitle.text = task.title
            tvDescription.text = task.description
            itemView.setOnLongClickListener {
                onLongClickTask(task)
                false
            }
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putSerializable(TASK_KEY, task)
                onClickTask(bundle)
            }
        }
    }

    companion object {
        const val TASK_KEY = "task.result"
    }
}
