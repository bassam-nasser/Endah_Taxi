package com.megatrust.endahtaxi.utill

import com.megatrust.endahtaxi.models.Driver

fun checkDriverData(driver: Driver): RegisterValidation {

    if (driver.name.length<3) {
        return RegisterValidation.Failed("driver name field cant be empty or less than 3 char!!")
    }
    if (driver.phoneNumber.isEmpty()) {
        return RegisterValidation.Failed("phone number field cant be empty or less than 3 char!!")
    }

    if (driver.carType.isEmpty()) {
        return RegisterValidation.Failed("car type field cant be empty or less than 3 char!!")
    }
    if (driver.carModel.isEmpty()) {
        return RegisterValidation.Failed("car model field cant be empty or less than 3 char!!")
    }
    return RegisterValidation.Success
}