package com.example.android.homepage.ui.news_and_event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.homepage.R

class NewsAndEventFragment : Fragment() {

    private lateinit var newsAndEventViewModel: NewsAndEventViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsAndEventViewModel =
            ViewModelProviders.of(this).get(NewsAndEventViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news_and_event, container, false)
        val textView: TextView = root.findViewById(R.id.text_news_and_event)
        newsAndEventViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}