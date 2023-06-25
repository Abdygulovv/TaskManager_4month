package com.example.abdygulov_chyngyz_4_month.ui.profile

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.abdygulov_chyngyz_4_month.R
import com.example.abdygulov_chyngyz_4_month.data.local.Pref
import com.example.abdygulov_chyngyz_4_month.databinding.FragmentProfileBinding
import com.example.abdygulov_chyngyz_4_month.utils.loadImage

class ProfileFragment : Fragment() {

    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    private lateinit var binding: FragmentProfileBinding
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                val photoUri = it.data?.data
                pref.saveImage(photoUri.toString())
                binding.profileImage.loadImage(photoUri.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText(pref.getName())
        binding.btnSave1.setOnClickListener {
            pref.saveName(binding.etName.text.toString())
        }
        pref.getImage()?.let { binding.profileImage.loadImage(it) }
        binding.profileImage.setOnClickListener {
            chooseImage()
        }
    }

    private fun chooseImage() {
        val intent: Intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT
        launcher.launch(intent)

    }

}