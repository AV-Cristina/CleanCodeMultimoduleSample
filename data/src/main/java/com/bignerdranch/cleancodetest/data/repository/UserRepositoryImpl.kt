package com.bignerdranch.cleancodetest.data.repository

import com.bignerdranch.cleancodetest.data.storage.UserStorage
import com.bignerdranch.cleancodetest.data.storage.models.User
import com.bignerdranch.cleancodetest.domain1.domain.models.SaveUserNameParam
import com.bignerdranch.cleancodetest.domain1.domain.models.UserName
import com.bignerdranch.cleancodetest.domain1.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}