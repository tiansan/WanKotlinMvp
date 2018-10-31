package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticlesTag(@Expose
                       @SerializedName("name")
                       var name: String = "",
                       @Expose
                       @SerializedName("url")
                       var url: String = "")