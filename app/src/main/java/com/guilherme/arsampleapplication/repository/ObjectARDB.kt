package com.guilherme.arsampleapplication.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.guilherme.arsampleapplication.models.ObjAR

class ObjectARDB : ObjARDataSource {

    override fun listAll(success: (List<ObjAR>) -> Unit, failure: () -> Unit) {
        val db = FirebaseFirestore.getInstance()

        db.collection("/ObjectsAR").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    task.result?.let {
                        success(it.toObjects(ObjAR::class.java))
                    }
                } else {
                    failure()
                }
            }
    }
}