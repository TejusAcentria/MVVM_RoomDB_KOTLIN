package com.turtlemint.mvvm.view.adapter

import android.content.Context
import android.content.Intent
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turtlemint.R
import com.turtlemint.interfaces.ItemOnClick
import com.turtlemint.mvvm.model.IssuesResponseModel
import com.turtlemint.mvvm.view.IssueDetailActivity
import kotlinx.android.synthetic.main.raw_list_user.view.*

class IssuesListAdapter(var userList: List<IssuesResponseModel>, var context: Context,var itemOnClick: ItemOnClick) :
    RecyclerView.Adapter<IssuesListAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtUserName = view.user_name!!
        var txtTitle = view.issue_title!!
        var txtDesc = view.issue_desc!!
        var imgAvatar = view.user_avatar!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.raw_list_user,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return userList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = userList[position]
        holder.txtUserName.text = data.user!!.login
        holder.txtTitle.text = data.title

        if (data.body.toString().length >200) {
            data.body=data.body!!.substring(0,200)+"...";
            holder.txtDesc.text= Html.fromHtml( data.body.toString()+"<font color='blue'> <u>View More</u></font>")
        }else{
            holder.txtDesc.text =data.body
        }

        Glide
            .with(context)
            .load(data.user!!.avatar_url)
            .centerCrop()
            .into(holder.imgAvatar)

        holder.itemView.setOnClickListener {
            val intent =Intent(context,IssueDetailActivity::class.java)
            intent.putExtra("userName",data.user!!.login)
            intent.putExtra("issueTitle",data.title)
            intent.putExtra("desc",data.body)
            intent.putExtra("avtar_url", data.user!!.avatar_url)
            intent.putExtra("date",data.updated_at)
            context.startActivity(intent)
        }

    }

}