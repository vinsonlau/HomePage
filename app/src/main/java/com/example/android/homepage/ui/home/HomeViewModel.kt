package com.example.android.homepage.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Are you trying to help the mother earth by doing something else but not sure what to do? " +
                "Do you have a lot of things to be recycled but don't know how they can be categorised? " +
                "Are you looking for news regarding the environmental problems?" +
                "Are you looking for events that are helpful to the environment? " +
                "Are you looking for a recycling centre but don't know where is it? " +
                "If any of the questions are yes to you, then you have selected the right app :)"
    }
    val text: LiveData<String> = _text
}