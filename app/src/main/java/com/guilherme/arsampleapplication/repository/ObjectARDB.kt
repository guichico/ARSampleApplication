package com.guilherme.arsampleapplication.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.guilherme.arsampleapplication.models.ObjAR
import io.reactivex.Maybe

class ObjectARDB(val db: FirebaseFirestore) {

    fun listAll(): Maybe<List<ObjAR>> {
        return Maybe.create { emitter ->
            db.collection("/ObjectsAR").get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        task.result?.let {
                            emitter.onSuccess(it.toObjects(ObjAR::class.java))
                        }
                    } else {
                        emitter.onError(task.exception!!)
                    }
                }
        }
    }
}