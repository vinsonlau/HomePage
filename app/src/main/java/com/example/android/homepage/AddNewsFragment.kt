package com.example.android.homepage


import android.content.ContentValues.TAG
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_add_news.*
import kotlinx.android.synthetic.main.fragment_fragment_news.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

/**
 * A simple [Fragment] subclass.
 */
class AddNewsFragment : Fragment() {

    private val TAG = "AddNewsFragment"
    private val REQUIRED = "Required"
    //access database table
    private var newsDatabase: DatabaseReference? = null//change
    //to get the current database pointer
    private var newsReference: DatabaseReference? = null//change
    private var newsListener: ChildEventListener? = null//change


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_news, container, false)

        newsDatabase = FirebaseDatabase.getInstance().reference
        newsReference = FirebaseDatabase.getInstance().getReference("news")
        buttonSubmit.setOnClickListener {
            addNews()
        }
        return view
      //  return inflater.inflate(R.layout.fragment_add_news, container, false)
    }


    private fun addNews(){
        val title:String = editTextTitle.text.toString()
        val link:String = editTextLink.text.toString()

        val news = News(title,link)

        val newsValues = news.toMap()
        val childUpdates = HashMap<String,Any>()
        val key = newsDatabase!!.child("news").push().key
        childUpdates.put("/news/" + key, newsValues)
        newsDatabase!!.updateChildren(childUpdates)
    }
}
