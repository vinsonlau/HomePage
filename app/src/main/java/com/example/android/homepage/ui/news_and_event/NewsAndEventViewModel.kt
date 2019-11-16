package com.example.android.homepage.ui.news_and_event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsAndEventViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {


    }
    val text: LiveData<String> = _text
}