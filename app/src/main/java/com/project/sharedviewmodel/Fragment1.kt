package com.project.sharedviewmodel

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.project.sharedviewmodel.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment1Binding.inflate(inflater, container, false)

        binding.buttonFragment1.setOnClickListener {
            sharedViewModel.updateText(binding.editTextFromFragment1.text as Editable)
        }

        sharedViewModel.getData().observe(viewLifecycleOwner, Observer {
            binding.editTextFromFragment1.text = it as Editable
        })

        return binding.root
    }
}