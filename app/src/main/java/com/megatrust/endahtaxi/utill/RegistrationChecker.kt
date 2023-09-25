package com.megatrust.endahtaxi.utill

import android.content.Context
import android.util.Patterns

fun validatePhone(phone: String, context: Context): RegisterValidation {
    if (phone.isEmpty()) {
        return RegisterValidation.Failed("Phone number can't be empty!!")
    }

    if (!Patterns.PHONE.matcher(phone).matches()) {
        return RegisterValidation.Failed("Wrong Phone number format!!")
    }
    return RegisterValidation.Success
}

fun validateName(name: String, context: Context): RegisterValidation {
    if (name.isEmpty()) {
        return RegisterValidation.Failed("Password can't be empty!!")
    }

    if (name.length < 6) {
        return RegisterValidation.Failed("Password can't be less than 6!!")
    }
    return RegisterValidation.Success
}

fun validateCarType(password: String, context: Context): RegisterValidation {
    if (password.isEmpty()) {
        return RegisterValidation.Failed("Password can't be empty!!")
    }

    if (password.length < 3) {
        return RegisterValidation.Failed("Password can't be less than 3!!")
    }
    return RegisterValidation.Success
}

fun validateCarModel(password: String, context: Context): RegisterValidation {
    if (password.isEmpty()) {
        return RegisterValidation.Failed("Car model can't be empty!!")
    }

    if (password.length < 3) {
        return RegisterValidation.Failed("Car model can't be less than 3!!")
    }
    return RegisterValidation.Success
}