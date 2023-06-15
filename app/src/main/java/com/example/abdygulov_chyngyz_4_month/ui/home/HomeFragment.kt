package com.example.abdygulov_chyngyz_4_month.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.abdygulov_chyngyz_4_month.R
import com.example.abdygulov_chyngyz_4_month.databinding.FragmentHomeBinding
import com.example.abdygulov_chyngyz_4_month.model.Task
import com.example.abdygulov_chyngyz_4_month.ui.home.adapter.TaskAdapter
import com.example.abdygulov_chyngyz_4_month.ui.task.TaskFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(TaskFragment.TASK_REQUEST) { _, bundle ->
            val data = bundle.getSerializable(TaskFragment.TASK_KEY)as Task
            adapter.addTask(data)
        }
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        binding.recyclerView.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}