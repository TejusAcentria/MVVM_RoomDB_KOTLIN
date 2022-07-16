package com.turtlemint.router

import android.app.Activity
import android.content.Intent
import com.turtlemint.mvvm.model.IssuesResponseModel
import com.turtlemint.utils.Constants

object AppRouter {
    fun sendDataToActivity(
        activity: Activity,
        className: String,
        issuesResponseModel: IssuesResponseModel
    ) {
        val intent = Intent(activity, Class.forName(className))
        intent.putExtra(Constants.data, issuesResponseModel)
        activity.startActivity(intent)
    }
}