package com.example.android.homepage.ui.information_centre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.android.homepage.R

class InformationCentreFragment : Fragment() {

    private lateinit var informationCentreViewModel: InformationCentreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        informationCentreViewModel =
            ViewModelProviders.of(this).get(InformationCentreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_information_centre, container, false)
        val textView: TextView = root.findViewById(R.id.text_information_centre)
        informationCentreViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}