package com.bignerdranch.cleancodetest.app

import android.app.Application
import com.bignerdranch.cleancodetest.di.AppComponent
import com.bignerdranch.cleancodetest.di.AppModule
import com.bignerdranch.cleancodetest.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}