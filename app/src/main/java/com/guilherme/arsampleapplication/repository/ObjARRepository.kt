package com.guilherme.arsampleapplication.repository

import com.guilherme.arsampleapplication.models.ObjAR
import io.reactivex.Maybe

interface ObjARRepository {
    fun listAll(): Maybe<List<ObjAR>>
}

class ObjARRepositoryImpl(private val objectARDB: ObjectARDB) : ObjARRepository {

    override fun listAll(): Maybe<List<ObjAR>> = objectARDB.listAll()
}