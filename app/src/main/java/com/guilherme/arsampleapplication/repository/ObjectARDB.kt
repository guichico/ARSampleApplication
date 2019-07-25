package com.guilherme.arsampleapplication.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.guilherme.arsampleapplication.models.ObjAR
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class ObjectARDB(private val db: FirebaseFirestore) {

    suspend fun listAll(): List<ObjAR> = suspendCoroutine { continuation ->
        db.collection("/ObjectsAR").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result?.let {
                        continuation.resume(it.toObjects(ObjAR::class.java))
                    }
                } else {
                    continuation.resumeWithException(task.exception!!)
                }
            }
    }
}