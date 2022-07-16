package com.turtlemint.utils

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

object Utility {

    fun showToast(context: Context, msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

     fun getDate(date: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-mm-dd",Locale.getDefault())
        return SimpleDateFormat("mm-dd-yyyy", Locale.getDefault()).format(simpleDateFormat.parse(date)!!)
    }

    fun convertToDate(date:String): String {
        val s=date.split("T")
       return getDate(s[0])
    }

}