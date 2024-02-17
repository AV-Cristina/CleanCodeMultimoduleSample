package com.bignerdranch.cleancodetest.domain1.domain.usecase

import com.bignerdranch.cleancodetest.domain1.domain.models.SaveUserNameParam
import com.bignerdranch.cleancodetest.domain1.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) {
            return true
        }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}