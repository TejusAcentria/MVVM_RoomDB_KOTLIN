package com.turtlemint.service

import com.turtlemint.mvvm.model.IssuesResponseModel
import com.turtlemint.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(Constants.ISSUE_URL)
    fun responseIssuesList(): Call<ArrayList<IssuesResponseModel>>
}