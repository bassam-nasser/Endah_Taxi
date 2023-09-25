package com.megatrust.endahtaxi.repo

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.megatrust.endahtaxi.models.Driver
import com.megatrust.endahtaxi.utill.Constant.CAR_MODEL
import com.megatrust.endahtaxi.utill.Constant.CAR_TYPE
import com.megatrust.endahtaxi.utill.Constant.DRIVER_COLLECTION
import com.megatrust.endahtaxi.utill.Constant.DRIVER_NAME
import com.megatrust.endahtaxi.utill.Constant.Driver_PHONE
import javax.inject.Inject

class RegisterFirbaseRepository @Inject constructor(
    private val firebaseFireStore: FirebaseFirestore
) {

    fun checkIfRegister(phone: String, callback: (Boolean) -> Unit) {
        firebaseFireStore.collection(DRIVER_COLLECTION).whereEqualTo(Driver_PHONE, phone)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val querySnapshot = task.result
                    if (querySnapshot != null && !querySnapshot.isEmpty) {
                        // Document with the specific string value exists
                        callback(true)
                    } else {
                        // Document with the specific string value does not exist
                        callback(false)
                    }
                } else {
                    // Handle errors
                    val exception = task.exception
                    // ...
                    callback(false) // Return false in case of an error
                }
            }
    }

      fun createDriver(driver: Driver, callback: (Boolean) -> Unit) {
        val driver = hashMapOf(
            DRIVER_NAME to driver.name,
            Driver_PHONE to driver.phoneNumber,
            CAR_TYPE to driver.carType,
            CAR_MODEL to driver.carModel
        )
        firebaseFireStore.collection(DRIVER_COLLECTION).add(driver)
            .addOnSuccessListener { documentReference ->
                Log.d("TAGG", "DocumentSnapshot added with ID: ${documentReference.id}")
                callback(true)
            }.addOnFailureListener { e ->
                Log.d("TAGG", "Error adding document: $e")
                callback(false)
            }
    }


}