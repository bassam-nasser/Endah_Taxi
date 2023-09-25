package com.megatrust.endahtaxi.utill

import android.content.Context
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.models.Driver

fun checkDriverData(driver: Driver, context: Context): RegisterValidation {

    if (driver.name.length < 3) {
        return RegisterValidation.Failed(context.getString(R.string.nameWarning))
    }
    if (driver.phoneNumber.length<11||driver.phoneNumber.length>11) {
        return RegisterValidation.Failed(context.getString(R.string.phoneWarning))
    }

    if (driver.carType.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.typeWarning))
    }
    if (driver.carModel.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.modelWarning))
    }
    return RegisterValidation.Success
}