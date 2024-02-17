package com.bignerdranch.cleancodetest.di

import android.content.Context
import com.bignerdranch.cleancodetest.data.repository.UserRepositoryImpl
import com.bignerdranch.cleancodetest.data.storage.UserStorage
import com.bignerdranch.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.bignerdranch.cleancodetest.domain1.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}