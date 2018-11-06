package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @Expose
    @SerializedName("errorCode")
    var errorCode: Int = -1
    @Expose
    @SerializedName("errorMsg")
    var errorMsg: String = ""
    @Expose
    @SerializedName("data")
    var data: User = User()

    val isSuccess: Boolean
        get() = errorCode == 0
}