package com.example.android.homepage.ui.news_and_event


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import com.example.android.homepage.R
import kotlinx.android.synthetic.main.fragment_event_details.*

/**
 * A simple [Fragment] subclass.
 */
class EventDetails : Fragment() {

    private var listener: FragmentEvent.OnFragmentInteractionListener?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val args = EventDetailsArgs.fromBundle(arguments!!)
        //(activity as AppCompatActivity).supportActionBar?.title = args.title

        val inflater = inflater.inflate(R.layout.fragment_event_details, container, false)

        /*textViewTitleContent.setText(args.title)
        textViewDOEContent.setText(args.date)
        textViewDescriptionContent.setText(args.description)*/

        return inflater
    }


}
