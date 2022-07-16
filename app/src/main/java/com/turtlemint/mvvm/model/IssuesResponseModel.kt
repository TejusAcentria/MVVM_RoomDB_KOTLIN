package com.turtlemint.mvvm.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.turtlemint.typos.LabelTypeConverter
import com.turtlemint.typos.UserTypeConverter

@Entity
class IssuesResponseModel() : Parcelable {
    @PrimaryKey
    var id: Int? = null
    var url: String? = null
    var repository_url: String? = null
    var labels_url: String? = null
    var comments_url: String? = null
    var events_url: String? = null
    var html_url: String? = null
    var node_id: String? = null
    var number = 0
    var title: String? = null

    @SerializedName("user")
    @TypeConverters(UserTypeConverter::class)
    var user: User? = null

    @TypeConverters(LabelTypeConverter::class)
    var labels: List<Label>? = null


    var state: String? = null
    var locked = false

    var comments = 0
    var created_at: String? = null
    var updated_at: String? = null

    var author_association: String? = null

    var draft = false

    var body: String? = null

    var timeline_url: String? = null

    var state_reason: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        url = parcel.readString()
        repository_url = parcel.readString()
        labels_url = parcel.readString()
        comments_url = parcel.readString()
        events_url = parcel.readString()
        html_url = parcel.readString()
        node_id = parcel.readString()
        number = parcel.readInt()
        title = parcel.readString()
        state = parcel.readString()
        locked = parcel.readByte() != 0.toByte()
        comments = parcel.readInt()
        created_at = parcel.readString()
        updated_at = parcel.readString()
        author_association = parcel.readString()
        draft = parcel.readByte() != 0.toByte()
        body = parcel.readString()
        timeline_url = parcel.readString()
        state_reason = parcel.readString()
    }

     class User():Parcelable {
        var login: String? = null
        var id = 0
        var node_id: String? = null
        var avatar_url: String? = null
        var gravatar_id: String? = null
        var url: String? = null
        var html_url: String? = null
        var followers_url: String? = null
        var following_url: String? = null
        var gists_url: String? = null
        var starred_url: String? = null
        var subscriptions_url: String? = null
        var organizations_url: String? = null
        var repos_url: String? = null
        var events_url: String? = null
        var received_events_url: String? = null
        var type: String? = null
        var site_admin = false

        constructor(parcel: Parcel) : this() {
            login = parcel.readString()
            id = parcel.readInt()
            node_id = parcel.readString()
            avatar_url = parcel.readString()
            gravatar_id = parcel.readString()
            url = parcel.readString()
            html_url = parcel.readString()
            followers_url = parcel.readString()
            following_url = parcel.readString()
            gists_url = parcel.readString()
            starred_url = parcel.readString()
            subscriptions_url = parcel.readString()
            organizations_url = parcel.readString()
            repos_url = parcel.readString()
            events_url = parcel.readString()
            received_events_url = parcel.readString()
            type = parcel.readString()
            site_admin = parcel.readByte() != 0.toByte()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(login)
            parcel.writeInt(id)
            parcel.writeString(node_id)
            parcel.writeString(avatar_url)
            parcel.writeString(gravatar_id)
            parcel.writeString(url)
            parcel.writeString(html_url)
            parcel.writeString(followers_url)
            parcel.writeString(following_url)
            parcel.writeString(gists_url)
            parcel.writeString(starred_url)
            parcel.writeString(subscriptions_url)
            parcel.writeString(organizations_url)
            parcel.writeString(repos_url)
            parcel.writeString(events_url)
            parcel.writeString(received_events_url)
            parcel.writeString(type)
            parcel.writeByte(if (site_admin) 1 else 0)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<User> {
            override fun createFromParcel(parcel: Parcel): User {
                return User(parcel)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }

     class Root() :Parcelable {
        var url: String? = null
        var repository_url: String? = null
        var labels_url: String? = null
        var comments_url: String? = null
        var events_url: String? = null
        var html_url: String? = null
        var id = 0
        var node_id: String? = null
        var number = 0
        var title: String? = null
        var user: User? = null
        var labels: List<Label>? = null
        var state: String? = null
        var locked = false
        var assignee: Assignee? = null
        var assignees: List<Assignee>? = null
        var milestone: Milestone? = null
        var comments = 0
        var created_at: String? = null
        var updated_at: String? = null
        var author_association: String? = null
        var draft = false
        var body: String? = null
        var reactions: Reactions? = null
        var timeline_url: String? = null
        var state_reason: String? = null

         constructor(parcel: Parcel) : this() {
             url = parcel.readString()
             repository_url = parcel.readString()
             labels_url = parcel.readString()
             comments_url = parcel.readString()
             events_url = parcel.readString()
             html_url = parcel.readString()
             id = parcel.readInt()
             node_id = parcel.readString()
             number = parcel.readInt()
             title = parcel.readString()
             user = parcel.readParcelable(User::class.java.classLoader)
             state = parcel.readString()
             locked = parcel.readByte() != 0.toByte()
             comments = parcel.readInt()
             created_at = parcel.readString()
             updated_at = parcel.readString()
             author_association = parcel.readString()
             draft = parcel.readByte() != 0.toByte()
             body = parcel.readString()
             timeline_url = parcel.readString()
             state_reason = parcel.readString()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(url)
             parcel.writeString(repository_url)
             parcel.writeString(labels_url)
             parcel.writeString(comments_url)
             parcel.writeString(events_url)
             parcel.writeString(html_url)
             parcel.writeInt(id)
             parcel.writeString(node_id)
             parcel.writeInt(number)
             parcel.writeString(title)
             parcel.writeParcelable(user, flags)
             parcel.writeString(state)
             parcel.writeByte(if (locked) 1 else 0)
             parcel.writeInt(comments)
             parcel.writeString(created_at)
             parcel.writeString(updated_at)
             parcel.writeString(author_association)
             parcel.writeByte(if (draft) 1 else 0)
             parcel.writeString(body)
             parcel.writeString(timeline_url)
             parcel.writeString(state_reason)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Root> {
             override fun createFromParcel(parcel: Parcel): Root {
                 return Root(parcel)
             }

             override fun newArray(size: Int): Array<Root?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class Assignee() :Parcelable {
        var login: String? = null
        var id = 0
        var node_id: String? = null
        var avatar_url: String? = null
        var gravatar_id: String? = null
        var url: String? = null
        var html_url: String? = null
        var followers_url: String? = null
        var following_url: String? = null
        var gists_url: String? = null
        var starred_url: String? = null
        var subscriptions_url: String? = null
        var organizations_url: String? = null
        var repos_url: String? = null
        var events_url: String? = null
        var received_events_url: String? = null
        var type: String? = null
        var site_admin = false

         constructor(parcel: Parcel) : this() {
             login = parcel.readString()
             id = parcel.readInt()
             node_id = parcel.readString()
             avatar_url = parcel.readString()
             gravatar_id = parcel.readString()
             url = parcel.readString()
             html_url = parcel.readString()
             followers_url = parcel.readString()
             following_url = parcel.readString()
             gists_url = parcel.readString()
             starred_url = parcel.readString()
             subscriptions_url = parcel.readString()
             organizations_url = parcel.readString()
             repos_url = parcel.readString()
             events_url = parcel.readString()
             received_events_url = parcel.readString()
             type = parcel.readString()
             site_admin = parcel.readByte() != 0.toByte()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(login)
             parcel.writeInt(id)
             parcel.writeString(node_id)
             parcel.writeString(avatar_url)
             parcel.writeString(gravatar_id)
             parcel.writeString(url)
             parcel.writeString(html_url)
             parcel.writeString(followers_url)
             parcel.writeString(following_url)
             parcel.writeString(gists_url)
             parcel.writeString(starred_url)
             parcel.writeString(subscriptions_url)
             parcel.writeString(organizations_url)
             parcel.writeString(repos_url)
             parcel.writeString(events_url)
             parcel.writeString(received_events_url)
             parcel.writeString(type)
             parcel.writeByte(if (site_admin) 1 else 0)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Assignee> {
             override fun createFromParcel(parcel: Parcel): Assignee {
                 return Assignee(parcel)
             }

             override fun newArray(size: Int): Array<Assignee?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class Assignee2() :Parcelable {
        var login: String? = null
        var id = 0
        var node_id: String? = null
        var avatar_url: String? = null
        var gravatar_id: String? = null
        var url: String? = null
        var html_url: String? = null
        var followers_url: String? = null
        var following_url: String? = null
        var gists_url: String? = null
        var starred_url: String? = null
        var subscriptions_url: String? = null
        var organizations_url: String? = null
        var repos_url: String? = null
        var events_url: String? = null
        var received_events_url: String? = null
        var type: String? = null
        var site_admin = false

         constructor(parcel: Parcel) : this() {
             login = parcel.readString()
             id = parcel.readInt()
             node_id = parcel.readString()
             avatar_url = parcel.readString()
             gravatar_id = parcel.readString()
             url = parcel.readString()
             html_url = parcel.readString()
             followers_url = parcel.readString()
             following_url = parcel.readString()
             gists_url = parcel.readString()
             starred_url = parcel.readString()
             subscriptions_url = parcel.readString()
             organizations_url = parcel.readString()
             repos_url = parcel.readString()
             events_url = parcel.readString()
             received_events_url = parcel.readString()
             type = parcel.readString()
             site_admin = parcel.readByte() != 0.toByte()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(login)
             parcel.writeInt(id)
             parcel.writeString(node_id)
             parcel.writeString(avatar_url)
             parcel.writeString(gravatar_id)
             parcel.writeString(url)
             parcel.writeString(html_url)
             parcel.writeString(followers_url)
             parcel.writeString(following_url)
             parcel.writeString(gists_url)
             parcel.writeString(starred_url)
             parcel.writeString(subscriptions_url)
             parcel.writeString(organizations_url)
             parcel.writeString(repos_url)
             parcel.writeString(events_url)
             parcel.writeString(received_events_url)
             parcel.writeString(type)
             parcel.writeByte(if (site_admin) 1 else 0)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Assignee2> {
             override fun createFromParcel(parcel: Parcel): Assignee2 {
                 return Assignee2(parcel)
             }

             override fun newArray(size: Int): Array<Assignee2?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class Creator() :Parcelable {
        var login: String? = null
        var id = 0
        var node_id: String? = null
        var avatar_url: String? = null
        var gravatar_id: String? = null
        var url: String? = null
        var html_url: String? = null
        var followers_url: String? = null
        var following_url: String? = null
        var gists_url: String? = null
        var starred_url: String? = null
        var subscriptions_url: String? = null
        var organizations_url: String? = null
        var repos_url: String? = null
        var events_url: String? = null
        var received_events_url: String? = null
        var type: String? = null
        var site_admin = false

         constructor(parcel: Parcel) : this() {
             login = parcel.readString()
             id = parcel.readInt()
             node_id = parcel.readString()
             avatar_url = parcel.readString()
             gravatar_id = parcel.readString()
             url = parcel.readString()
             html_url = parcel.readString()
             followers_url = parcel.readString()
             following_url = parcel.readString()
             gists_url = parcel.readString()
             starred_url = parcel.readString()
             subscriptions_url = parcel.readString()
             organizations_url = parcel.readString()
             repos_url = parcel.readString()
             events_url = parcel.readString()
             received_events_url = parcel.readString()
             type = parcel.readString()
             site_admin = parcel.readByte() != 0.toByte()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(login)
             parcel.writeInt(id)
             parcel.writeString(node_id)
             parcel.writeString(avatar_url)
             parcel.writeString(gravatar_id)
             parcel.writeString(url)
             parcel.writeString(html_url)
             parcel.writeString(followers_url)
             parcel.writeString(following_url)
             parcel.writeString(gists_url)
             parcel.writeString(starred_url)
             parcel.writeString(subscriptions_url)
             parcel.writeString(organizations_url)
             parcel.writeString(repos_url)
             parcel.writeString(events_url)
             parcel.writeString(received_events_url)
             parcel.writeString(type)
             parcel.writeByte(if (site_admin) 1 else 0)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Creator> {
             override fun createFromParcel(parcel: Parcel): Creator {
                 return Creator(parcel)
             }

             override fun newArray(size: Int): Array<Creator?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class Label() :Parcelable {
        var id: Long = 0
        var node_id: String? = null
        var url: String? = null
        var name: String? = null
        var color: String? = null
        var description: String? = null

         constructor(parcel: Parcel) : this() {
             id = parcel.readLong()
             node_id = parcel.readString()
             url = parcel.readString()
             name = parcel.readString()
             color = parcel.readString()
             description = parcel.readString()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeLong(id)
             parcel.writeString(node_id)
             parcel.writeString(url)
             parcel.writeString(name)
             parcel.writeString(color)
             parcel.writeString(description)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Label> {
             override fun createFromParcel(parcel: Parcel): Label {
                 return Label(parcel)
             }

             override fun newArray(size: Int): Array<Label?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class Milestone() :Parcelable {
        var url: String? = null
        var html_url: String? = null
        var labels_url: String? = null
        var id = 0
        var node_id: String? = null
        var number = 0
        var title: String? = null
        var description: String? = null
        var creator: Creator? = null
        var open_issues = 0
        var closed_issues = 0
        var state: String? = null
        var created_at: String? = null
        var updated_at: String? = null
        var due_on: String? = null

         constructor(parcel: Parcel) : this() {
             url = parcel.readString()
             html_url = parcel.readString()
             labels_url = parcel.readString()
             id = parcel.readInt()
             node_id = parcel.readString()
             number = parcel.readInt()
             title = parcel.readString()
             description = parcel.readString()
             creator = parcel.readParcelable(Creator::class.java.classLoader)
             open_issues = parcel.readInt()
             closed_issues = parcel.readInt()
             state = parcel.readString()
             created_at = parcel.readString()
             updated_at = parcel.readString()
             due_on = parcel.readString()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(url)
             parcel.writeString(html_url)
             parcel.writeString(labels_url)
             parcel.writeInt(id)
             parcel.writeString(node_id)
             parcel.writeInt(number)
             parcel.writeString(title)
             parcel.writeString(description)
             parcel.writeParcelable(creator, flags)
             parcel.writeInt(open_issues)
             parcel.writeInt(closed_issues)
             parcel.writeString(state)
             parcel.writeString(created_at)
             parcel.writeString(updated_at)
             parcel.writeString(due_on)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Milestone> {
             override fun createFromParcel(parcel: Parcel): Milestone {
                 return Milestone(parcel)
             }

             override fun newArray(size: Int): Array<Milestone?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class PullRequest() :Parcelable {
        var url: String? = null
        var html_url: String? = null
        var diff_url: String? = null
        var patch_url: String? = null

         constructor(parcel: Parcel) : this() {
             url = parcel.readString()
             html_url = parcel.readString()
             diff_url = parcel.readString()
             patch_url = parcel.readString()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(url)
             parcel.writeString(html_url)
             parcel.writeString(diff_url)
             parcel.writeString(patch_url)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<PullRequest> {
             override fun createFromParcel(parcel: Parcel): PullRequest {
                 return PullRequest(parcel)
             }

             override fun newArray(size: Int): Array<PullRequest?> {
                 return arrayOfNulls(size)
             }
         }
     }

     class Reactions() :Parcelable {
        var url: String? = null
        var total_count = 0
        var laugh = 0
        var hooray = 0
        var confused = 0
        var heart = 0
        var rocket = 0
        var eyes = 0

         constructor(parcel: Parcel) : this() {
             url = parcel.readString()
             total_count = parcel.readInt()
             laugh = parcel.readInt()
             hooray = parcel.readInt()
             confused = parcel.readInt()
             heart = parcel.readInt()
             rocket = parcel.readInt()
             eyes = parcel.readInt()
         }

         override fun writeToParcel(parcel: Parcel, flags: Int) {
             parcel.writeString(url)
             parcel.writeInt(total_count)
             parcel.writeInt(laugh)
             parcel.writeInt(hooray)
             parcel.writeInt(confused)
             parcel.writeInt(heart)
             parcel.writeInt(rocket)
             parcel.writeInt(eyes)
         }

         override fun describeContents(): Int {
             return 0
         }

         companion object CREATOR : Parcelable.Creator<Reactions> {
             override fun createFromParcel(parcel: Parcel): Reactions {
                 return Reactions(parcel)
             }

             override fun newArray(size: Int): Array<Reactions?> {
                 return arrayOfNulls(size)
             }
         }
     }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(url)
        parcel.writeString(repository_url)
        parcel.writeString(labels_url)
        parcel.writeString(comments_url)
        parcel.writeString(events_url)
        parcel.writeString(html_url)
        parcel.writeString(node_id)
        parcel.writeInt(number)
        parcel.writeString(title)
        parcel.writeString(state)
        parcel.writeByte(if (locked) 1 else 0)
        parcel.writeInt(comments)
        parcel.writeString(created_at)
        parcel.writeString(updated_at)
        parcel.writeString(author_association)
        parcel.writeByte(if (draft) 1 else 0)
        parcel.writeString(body)
        parcel.writeString(timeline_url)
        parcel.writeString(state_reason)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IssuesResponseModel> {
        override fun createFromParcel(parcel: Parcel): IssuesResponseModel {
            return IssuesResponseModel(parcel)
        }

        override fun newArray(size: Int): Array<IssuesResponseModel?> {
            return arrayOfNulls(size)
        }
    }
}