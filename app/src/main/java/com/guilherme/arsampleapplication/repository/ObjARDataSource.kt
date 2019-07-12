package com.guilherme.arsampleapplication.repository

import com.guilherme.arsampleapplication.models.ObjAR

interface ObjARDataSource {

    fun listAll(success : (List<ObjAR>) -> Unit, failure: () -> Unit)
}