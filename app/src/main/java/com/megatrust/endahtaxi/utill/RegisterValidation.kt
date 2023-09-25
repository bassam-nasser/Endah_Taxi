package com.megatrust.endahtaxi.utill

sealed class RegisterValidation {
    object Success : RegisterValidation()
    data class Failed(val message: String) : RegisterValidation()
}

data class RegistrationFieldState(
    val phone: RegisterValidation,
    val password: RegisterValidation,
    val carType: RegisterValidation,
    val carModel: RegisterValidation,
)