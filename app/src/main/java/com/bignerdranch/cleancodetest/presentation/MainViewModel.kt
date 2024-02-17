package com.bignerdranch.cleancodetest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.cleancodetest.domain1.domain.models.SaveUserNameParam
import com.bignerdranch.cleancodetest.domain1.domain.models.UserName
import com.bignerdranch.cleancodetest.domain1.domain.usecase.GetUserNameUseCase
import com.bignerdranch.cleancodetest.domain1.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = this.resultLiveMutable

    init {
        Log.e("MainVM", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("MainVM", "ViewModel cleared")
        super.onCleared()
    }

    fun save(text: String) {
        val param = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = param)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load () {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}