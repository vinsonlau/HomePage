package com.example.android.homepage.ui.information_centre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformationCentreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "this is information centre fragment"
    }
    val text: LiveData<String> = _text
}

