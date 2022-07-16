package com.turtlemint.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.turtlemint.mvvm.model.IssuesResponseModel

@Dao
interface IssuesListDAO {
    @Query("Select * from IssuesResponseModel")
    fun getIssuesList():List<IssuesResponseModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( user: List<IssuesResponseModel>)

}