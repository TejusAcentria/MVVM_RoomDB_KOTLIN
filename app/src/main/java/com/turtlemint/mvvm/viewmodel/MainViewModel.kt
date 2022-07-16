package com.turtlemint.mvvm.viewmodel

import android.app.Activity
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.turtlemint.mvvm.model.IssuesResponseModel
import com.turtlemint.mvvm.view.IssueDetailActivity
import com.turtlemint.repos.MainRepository
import com.turtlemint.router.AppRouter

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var mainRepository = MainRepository.getInstance()

    fun requestIssuesList() {
        mainRepository.requestIssuesList()
    }
    fun sendDataToDetailActivity(
        act: Activity,
        issuesResponseModel: IssuesResponseModel
    ) {
        AppRouter.sendDataToActivity(act,IssueDetailActivity::class.java.name,issuesResponseModel)
    }

    fun responseIssuesList(): MutableLiveData<ArrayList<IssuesResponseModel>> {
        return mainRepository.responseIssuesList()
    }

}