package com.project.sharedviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {

    private var inputText: MutableLiveData<CharSequence> = MutableLiveData()

    fun getData(): MutableLiveData<CharSequence> = inputText

    fun updateText(input: CharSequence) {
        inputText.value = input
    }
}
