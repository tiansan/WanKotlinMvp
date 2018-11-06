package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
        @Expose
        @SerializedName("email")
        var email: String = "",
        @Expose
        @SerializedName("icon")
        var icon: String = "",
        @Expose
        @SerializedName("id")
        var id: Int = 0,
        @Expose
        @SerializedName("password")
        var password: String = "",
        @Expose
        @SerializedName("token")
        var token: String = "",
        @Expose
        @SerializedName("type")
        var type: Int = 0,
        @Expose
        @SerializedName("username")
        var username: String = ""
)