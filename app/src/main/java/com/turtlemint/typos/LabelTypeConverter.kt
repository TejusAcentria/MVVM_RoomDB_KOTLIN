package com.turtlemint.typos

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.turtlemint.mvvm.model.IssuesResponseModel

class LabelTypeConverter {
    @TypeConverter
    fun storedStringToMyObjects(data: String): List<IssuesResponseModel.Label> {
        val gson = Gson()
        val listType = object : TypeToken<List<IssuesResponseModel.Label>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun myObjectsToStoredString(myObjects: List<IssuesResponseModel.Label>): String {
        val gson = Gson()
        return gson.toJson(myObjects)
    }
}