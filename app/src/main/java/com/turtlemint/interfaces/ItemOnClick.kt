package com.turtlemint.interfaces

import com.turtlemint.mvvm.model.IssuesResponseModel

interface ItemOnClick {
    fun onClick(issuesResponseModel: IssuesResponseModel)
}