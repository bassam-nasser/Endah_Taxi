package com.megatrust.endahtaxi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.megatrust.endahtaxi.models.Driver
import com.megatrust.endahtaxi.repo.RegisterFirbaseRepository
import com.megatrust.endahtaxi.utill.Existent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: RegisterFirbaseRepository) :
    ViewModel() {

    private val _driver = MutableStateFlow(Driver("", "", "", ""))
    val driverState = _driver.asStateFlow()

    private val _existStatus = MutableLiveData<Existent>()
    val existStatus: LiveData<Existent> = _existStatus


    private val _creationStatus = MutableLiveData<Existent>()
    val creationStatus: LiveData<Existent> = _creationStatus

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

    fun createDriver(driver: Driver) {
        repository.createDriver(driver) {
            if (it) {
                _creationStatus.value = Existent.CREATED
            } else _creationStatus.value = Existent.Failed
        }
    }

    fun checkIfExistentBefore(phone: String) {
        repository.checkIfRegister(phone) {
            if (it) {
                // Document exists
                // Do something
                _existStatus.value = Existent.EXIST

            } else {
                // Document does not exist
                // Do something else
                _existStatus.value = Existent.NOT_EXIST
            }
            Log.d("TAGG", existStatus.value.toString())
        }
    }

  }
