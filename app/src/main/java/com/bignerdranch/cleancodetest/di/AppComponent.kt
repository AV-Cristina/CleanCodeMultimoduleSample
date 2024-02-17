package com.bignerdranch.cleancodetest.di

import com.bignerdranch.cleancodetest.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}