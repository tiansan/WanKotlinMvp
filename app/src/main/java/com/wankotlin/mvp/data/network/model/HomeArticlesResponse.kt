package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeArticlesResponse(@Expose
                                @SerializedName("errorCode")
                                var errorCode: Int = -1,
                                @Expose
                                @SerializedName("errorMsg")
                                var errorMsg: String = "",
                                @Expose
                                @SerializedName("data")
                                var data: HomeArticles = HomeArticles())