package com.example.android.homepage


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
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
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.ChangeEventListener
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
    private var newsAdapter: FirebaseRecyclerAdapter<News, NewsViewHolder>? = null

    lateinit var notificationManager : NotificationManager //manage notification
    lateinit var notificationChannel : NotificationChannel //to allow user to enable/disable notification type
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.android.homepage"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //must have to add data into database
        //to get the root folder
        newsDatabase = FirebaseDatabase.getInstance().reference//change
        //to access to the table
        newsReference = FirebaseDatabase.getInstance().getReference("news")

        val view = inflater.inflate(R.layout.fragment_add_news, container, false)
        val btnSubmit: Button = view.findViewById(R.id.buttonSubmit)
        btnSubmit.setOnClickListener {
            //validation on input
            if(TextUtils.isEmpty(editTextTitle.text.toString())){
                editTextTitle.error = getString(R.string.required)
                Toast.makeText(context, "Title is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(TextUtils.isEmpty(editTextLink.text.toString())){
                editTextLink.error = getString(R.string.required)
                Toast.makeText(context, "Link is required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            addNews()


        }

        return view
      //  return inflater.inflate(R.layout.fragment_add_news, container, false)
    }

    private fun addNews(){
        val title = editTextTitle.text.toString()
        val link= editTextLink.text.toString()
        val date = System.currentTimeMillis()



        val news = News(title,link,date)

        val newsValues = news.toMap()
        val childUpdates = HashMap<String,Any>()
        val key = newsDatabase!!.child("news").push().key
        childUpdates.put("/news/" + key, newsValues)
        newsDatabase!!.updateChildren(childUpdates)
        Toast.makeText(context, "News updated", Toast.LENGTH_SHORT).show()
        editTextTitle.setText("")
        editTextLink.setText("")

    }
}
