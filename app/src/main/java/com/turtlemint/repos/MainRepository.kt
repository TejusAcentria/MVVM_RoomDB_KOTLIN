package com.turtlemint.repos

import androidx.lifecycle.MutableLiveData
import com.turtlemint.mvvm.model.IssuesResponseModel
import com.turtlemint.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository {

    lateinit var issueListMutableLiveData: MutableLiveData<ArrayList<IssuesResponseModel>>

    companion object {

        fun getInstance(): MainRepository {
            return MainRepository()
        }
    }

    fun requestIssuesList() {
        val call = ApiService.apiInterface.responseIssuesList()
        call.enqueue(object : Callback<ArrayList<IssuesResponseModel>> {
            override fun onFailure(call: Call<ArrayList<IssuesResponseModel>>, t: Throwable) {
                issueListMutableLiveData.value=null
            }
            override fun onResponse(
                call: Call<ArrayList<IssuesResponseModel>>, response: Response<ArrayList<IssuesResponseModel>>
            ) {
                issueListMutableLiveData.value=response.body()
            }
        })
    }

    fun responseIssuesList(): MutableLiveData<ArrayList<IssuesResponseModel>> {
        issueListMutableLiveData = MutableLiveData()
        return issueListMutableLiveData
    }
}