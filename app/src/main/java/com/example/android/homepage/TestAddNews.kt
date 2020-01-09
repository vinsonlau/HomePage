package com.example.android.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_add_news.*

class TestAddNews : AppCompatActivity() {

    private val TAG = "TestAddNews"
    private val REQUIRED = "Required"
    //access database table
    private var newsDatabase: DatabaseReference? = null//change
    //to get the current database pointer
    private var newsReference: DatabaseReference? = null//change
    private var newsListener: ChildEventListener? = null//change

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_news)

        //to get the root folder
        newsDatabase = FirebaseDatabase.getInstance().reference//change
        //to access to the table
        newsReference = FirebaseDatabase.getInstance().getReference("news")//change

        buttonSubmit.setOnClickListener {
            Toast.makeText(applicationContext,"Saving to database..",Toast.LENGTH_SHORT).show()
            addNews()
        }
    }

    private fun addNews(){
        val title = editTextTitle.text.toString() //change
        val link = editTextLink.text.toString() //change

        val news = News(title,link)

        val newsValues = news.toMap() //change
        val childUpdates = HashMap<String, Any>()

        val key = newsDatabase!!.child("news").push().key //change

        childUpdates.put("/news/" + key, newsValues) //MUST change

        newsDatabase!!.updateChildren(childUpdates) //change

    }
}