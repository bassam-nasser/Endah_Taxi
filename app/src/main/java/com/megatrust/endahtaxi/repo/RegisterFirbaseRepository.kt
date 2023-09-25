package com.megatrust.endahtaxi.repo

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class RegisterFirbaseRepository @Inject constructor(
    private val firebaseFireStore: FirebaseFirestore
) {

    fun checkIfVoteBefore(id: String, callback: (Boolean) -> Unit) {
        firebaseFireStore.collection("VOTERS_COLLECTION").whereEqualTo("VOTERS_ID", id)
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



}