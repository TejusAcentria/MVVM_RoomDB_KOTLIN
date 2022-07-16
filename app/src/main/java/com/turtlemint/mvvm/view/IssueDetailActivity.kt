package com.turtlemint.mvvm.view

import android.os.Bundle
import android.view.MenuItem
import androidx.core.app.NavUtils
import com.bumptech.glide.Glide
import com.turtlemint.BuildConfig
import com.turtlemint.R
import com.turtlemint.base.BaseActivity
import com.turtlemint.utils.Utility
import kotlinx.android.synthetic.main.activity_issue_detail.*


class IssueDetailActivity : BaseActivity() {
    var userName: String? = null
    var avtar_url: String? = null
    var desc: String? = null
    var issueTitle: String? = null
    var date: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_detail)
        if (BuildConfig.DEBUG && supportActionBar == null) {
            error("Assertion failed")
        }
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        userName = intent.getStringExtra("userName")
        issueTitle = intent.getStringExtra("issueTitle")
        desc = intent.getStringExtra("desc")
        avtar_url = intent.getStringExtra("avtar_url")
        date = intent.getStringExtra("date")
        initUI()

    }

    private fun initUI() {
        Glide
            .with(this)
            .load(avtar_url)
            .centerCrop()
            .into(imageView)
        date_txt.text = Utility.convertToDate(date.toString())
        userName_txt.text=userName.toString()
        issue_title.text=issueTitle.toString()
        textdesc.text=desc.toString()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}