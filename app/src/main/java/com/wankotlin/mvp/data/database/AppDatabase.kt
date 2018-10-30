package com.wankotlin.mvp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.wankotlin.mvp.data.database.repository.options.Options
import com.wankotlin.mvp.data.database.repository.options.OptionsDao

/**
 * Created by jyotidubey on 03/01/18.
 */
@Database(entities = [Options::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun optionsDao(): OptionsDao
//
//    abstract fun questionsDao(): QuestionsDao

}