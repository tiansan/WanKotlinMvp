package com.wankotlin.mvp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Articles(@Expose
                    @SerializedName("author")
                    var author: String = "",
                    @Expose
                    @SerializedName("apkLink")
                    var apkLink: String = "",
                    @Expose
                    @SerializedName("chapterName")
                    var chapterName: String = "",
                    @Expose
                    @SerializedName("desc")
                    var desc: String = "",
                    @Expose
                    @SerializedName("envelopePic")
                    var envelopePic: String = "",
                    @Expose
                    @SerializedName("collect")
                    var collect: Boolean = false,
                    @Expose
                    @SerializedName("fresh")
                    var fresh: Boolean = false,
                    @Expose
                    @SerializedName("id")
                    var id: Int = 0,
                    @Expose
                    @SerializedName("link")
                    var link: String = "",
                    @Expose
                    @SerializedName("niceDte")
                    var niceDate: String = "",
                    @Expose
                    @SerializedName("origin")
                    var origin: String = "",
                    @Expose
                    @SerializedName("projectLink")
                    var projectLink: String = "",
                    @Expose
                    @SerializedName("publishTime")
                    var publishTime: Long = 0L,
                    @Expose
                    @SerializedName("superChapterId")
                    var superChapterId: Int = 0,
                    @Expose
                    @SerializedName("superChapterName")
                    var superChapterName: String = "",
                    @Expose
                    @SerializedName("title")
                    var title: String = "",
                    @Expose
                    @SerializedName("type")
                    var type: Int = 0,
                    @Expose
                    @SerializedName("userId")
                    var userId: Int = 0,
                    @Expose
                    @SerializedName("visible")
                    var visible: Int = 0,
                    @Expose
                    @SerializedName("zan")
                    var zan: Int = 0,
                    @Expose
                    @SerializedName("tags")
                    var tags: List<ArticlesTag> = listOf())
