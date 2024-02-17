package com.bignerdranch.cleancodetest.domain1.domain.usecase

import com.bignerdranch.cleancodetest.domain1.domain.models.UserName
import com.bignerdranch.cleancodetest.domain1.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}