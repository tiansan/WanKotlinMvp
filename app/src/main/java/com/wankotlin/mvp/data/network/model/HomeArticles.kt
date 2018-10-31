package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HomeArticles(@Expose
                        @SerializedName("curPage")
                        var curPage: Int = 0,
                        @Expose
                        @SerializedName("pageCount")
                        var pageCount: Int = 0,
                        @Expose
                        @SerializedName("size")
                        var size: Int = 0,
                        @Expose
                        @SerializedName("total")
                        var total: Int = 0,
                        @Expose
                        @SerializedName("offset")
                        var offset: Int = 0,
                        @Expose
                        @SerializedName("over")
                        var over: Boolean = false,
                        @Expose
                        @SerializedName("datas")
                        var datas: List<Articles> = listOf())