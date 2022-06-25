package com.project.sharedviewmodel

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.project.sharedviewmodel.databinding.Fragment2Binding

class Fragment2 : Fragment() {

    private lateinit var binding: Fragment2Binding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = Fragment2Binding.inflate(inflater, container, false)

        binding.buttonFragment2.setOnClickListener {
            sharedViewModel.updateText(binding.editTextFromFragment2.text as Editable)
        }

        sharedViewModel.getData().observe(viewLifecycleOwner, Observer {
            binding.editTextFromFragment2.text = it as Editable
        })
        return binding.root
    }
}