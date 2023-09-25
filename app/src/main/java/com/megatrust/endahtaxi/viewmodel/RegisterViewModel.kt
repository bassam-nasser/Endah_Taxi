package com.megatrust.endahtaxi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.megatrust.endahtaxi.models.Driver
import com.megatrust.endahtaxi.repo.RegisterFirbaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterFirbaseRepository) :
    ViewModel() {

    private val _driver = MutableStateFlow(Driver("", "", "", ""))
    val driverState = _driver.asStateFlow()

    fun updateName(name: String) {
        _driver.value = _driver.value.copy(name = name)
    }

    fun updateType(type: String) {
        _driver.value = _driver.value.copy(carType = type)

    }

    fun updatePhone(phone: String) {
        _driver.value = _driver.value.copy(phoneNumber = phone)

    }

    fun updateModel(model: String) {
        _driver.value = _driver.value.copy(carModel = model)
        Log.d("TAGG", model)
    }

}