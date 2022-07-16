package com.turtlemint.mvvm.view

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.turtlemint.R
import com.turtlemint.interfaces.ItemOnClick
import com.turtlemint.base.BaseActivity
import com.turtlemint.db.AppDatabase
import com.turtlemint.mvvm.model.IssuesResponseModel
import com.turtlemint.mvvm.view.adapter.IssuesListAdapter
import com.turtlemint.mvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(),ItemOnClick {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: IssuesListAdapter
    private lateinit var appDatabase: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initilizeViewModel()
        initilizeDatabase()
        initUI()
        apiCall()
        getApiData()

    }

    private fun getApiData() {
        viewModel.responseIssuesList().observe(this, Observer { response ->
            if (response != null) {
                response.let {
                    appDatabase.userDao()
                        .insertAll(response as List<IssuesResponseModel>)
                }
                setData(response)
            }
            setData(
                appDatabase.userDao().getIssuesList().let { appDatabase.userDao().getIssuesList() })
        })
    }

    private fun setData(list: List<IssuesResponseModel>) {
        adapter = IssuesListAdapter(
            list,
            this,
            this
        )
        recyclerViewUserList.adapter = adapter

    }

    private fun apiCall() {
        viewModel.requestIssuesList()
    }

    private fun initUI() {
        val viewManager = LinearLayoutManager(this)
        recyclerViewUserList.apply {
            this.layoutManager = viewManager
            isNestedScrollingEnabled = false
            hasFixedSize()

        }
    }

    private fun initilizeDatabase() {
        appDatabase = AppDatabase.getDatabase(this)
    }

    private fun initilizeViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onClick(issuesResponseModel: IssuesResponseModel) {
        viewModel.sendDataToDetailActivity(this,issuesResponseModel)
    }
}