package com.wankotlin.mvp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.wankotlin.mvp.BuildConfig
import com.wankotlin.mvp.data.database.AppDatabase
import com.wankotlin.mvp.data.database.repository.options.OptionsRepo
import com.wankotlin.mvp.data.database.repository.options.OptionsRepository
import com.wankotlin.mvp.data.network.ApiHeader
import com.wankotlin.mvp.data.network.ApiHelper
import com.wankotlin.mvp.data.network.AppApiHelper
import com.wankotlin.mvp.data.preferences.AppPreferenceHelper
import com.wankotlin.mvp.data.preferences.PreferenceHelper
import com.wankotlin.mvp.di.ApiKeyInfo
import com.wankotlin.mvp.di.PreferenceInfo
import com.wankotlin.mvp.util.AppConstants
import com.wankotlin.mvp.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by jyotidubey on 05/01/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
            userId = preferenceHelper.getCurrentUserId(),
            accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

//    @Provides
//    @Singleton
//    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo = QuestionRepository(appDatabase.questionsDao())
//
    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): OptionsRepo = OptionsRepository(appDatabase.optionsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}