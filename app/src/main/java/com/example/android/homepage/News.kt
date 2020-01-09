package com.example.android.homepage

import com.google.firebase.database.Exclude
import kotlinx.android.synthetic.main.fragment_add_news.*
import java.util.*

class News{
    var title:String? = null
    var link:String? = null
    constructor(){

    }

    constructor(title:String?, link:String?){
        this.title=title
        this.link=link
    }

    @Exclude
    fun toMap(): Map<String,Any>{
        val result = HashMap<String, Any>()
        result.put("title",title!!)
        result.put("link",link!!)

        return result
    }
}