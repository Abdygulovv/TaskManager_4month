package com.example.abdygulov_chyngyz_4_month.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.abdygulov_chyngyz_4_month.App
import com.example.abdygulov_chyngyz_4_month.R
import com.example.abdygulov_chyngyz_4_month.databinding.FragmentTaskBinding
import com.example.abdygulov_chyngyz_4_month.model.Task

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    private var task: Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        task = arguments?.getSerializable(TASK_KEY) as Task?
        if (task == null) {
            binding.btnSave.setOnClickListener {
                onSave()
            }
        } else {
            binding.etTitle.setText(task?.title)
            binding.etDescription.setText(task?.description)
            binding.btnSave.text = (getString(R.string.update))

            binding.btnSave.setOnClickListener {
                onUpdate()
            }
        }
    }

    private fun onSave() {
        val data = Task(
            title = binding.etTitle.text.toString(),
            description = binding.etDescription.text.toString()
        )
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }

    companion object {
        const val TASK_KEY = "task.result"
    }

    private fun onUpdate() {
        val data = Task(
            id = task?.id,
            title = binding.etTitle.text.toString(),
            description = binding.etDescription.text.toString()
        )
        App.db.taskDao().update(data)
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}