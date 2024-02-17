package com.bignerdranch.cleancodetest.data.storage

import com.bignerdranch.cleancodetest.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}