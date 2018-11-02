package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("email") var email: String = "",
        @SerializedName("icon") var icon: String = "",
        @SerializedName("id") var id: Int = 0,
        @SerializedName("password") var password: String = "",
        @SerializedName("token") var token: String = "",
        @SerializedName("type") var type: Int = 0,
        @SerializedName("username") var username: String = ""
)