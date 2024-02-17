package com.bignerdranch.cleancodetest.domain1.domain.repository

import com.bignerdranch.cleancodetest.domain1.domain.models.SaveUserNameParam
import com.bignerdranch.cleancodetest.domain1.domain.models.UserName

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}