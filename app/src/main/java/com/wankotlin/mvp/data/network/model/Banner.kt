package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * 类名：Banner
 * 作者：Yun.Lei
 * 功能：
 * 创建日期：2018-10-19 11:30
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

data class Banner(
        @Expose
        @SerializedName("desc")
        var desc: String = "",
        @Expose
        @SerializedName("id")
        var id: Int = 0,
        @Expose
        @SerializedName("imagePath")
        var imagePath: String = "",
        @Expose
        @SerializedName("isVisible")
        var isVisible: Int = 0,
        @Expose
        @SerializedName("order")
        var order: Int = 0,
        @Expose
        @SerializedName("title")
        var title: String = "",
        @Expose
        @SerializedName("type")
        var type: Int = 0,
        @Expose
        @SerializedName("url")
        var url: String = ""
)