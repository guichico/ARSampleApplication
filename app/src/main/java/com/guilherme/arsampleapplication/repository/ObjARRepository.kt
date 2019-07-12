package com.guilherme.arsampleapplication.repository

import com.guilherme.arsampleapplication.models.ObjAR

class ObjARRepository(private val objectARDB: ObjectARDB) : ObjARDataSource {

    override fun listAll(success: (List<ObjAR>) -> Unit, failure: () -> Unit) {
        objectARDB.listAll(success, failure)
    }
}