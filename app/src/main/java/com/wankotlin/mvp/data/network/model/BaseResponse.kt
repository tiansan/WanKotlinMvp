package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseResponse {
    @Expose
    @SerializedName("errorCode")
    var errorCode: Int = -1
    @Expose
    @SerializedName("errorMsg")
    var errorMsg: String = ""

    val isSuccess: Boolean
        get() = errorCode == 0
}