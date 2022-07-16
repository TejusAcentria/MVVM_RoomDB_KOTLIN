package com.turtlemint.typos

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.turtlemint.mvvm.model.IssuesResponseModel
import java.lang.reflect.Type

class UserTypeConverter {
    private val gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): IssuesResponseModel.User? {
        if (data == null) return null
        val listType: Type = object : TypeToken<IssuesResponseModel.User?>() {}.type
        return gson.fromJson<IssuesResponseModel.User?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObject: IssuesResponseModel.User?): String? {
        return gson.toJson(someObject)
    }
}