package com.wankotlin.mvp.data.database.repository.options

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jyotidubey on 03/01/18.
 */
@Entity(tableName = "options")
data class Options(

        @PrimaryKey(autoGenerate = true) var id: Long,

        @Expose
        @SerializedName("option_text")
        @ColumnInfo(name = "option_text")
        var optionText: String,

        @Expose
        @SerializedName("question_id")
        @ColumnInfo(name = "question_id")
        var questionId: Long,

        @Expose
        @SerializedName("is_correct")
        @ColumnInfo(name = "is_correct")
        var isCorrect: Boolean,

        @Expose
        @SerializedName("created_at")
        @ColumnInfo(name = "created_at")
        var createdAt: String?,

        @Expose
        @SerializedName("updated_at")
        @ColumnInfo(name = "updated_at")
        var updatedAt: String?
)


