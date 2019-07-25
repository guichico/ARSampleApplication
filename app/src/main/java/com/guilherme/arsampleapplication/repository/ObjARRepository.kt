package com.guilherme.arsampleapplication.repository

import com.guilherme.arsampleapplication.models.ObjAR

interface ObjARRepository {
    suspend fun listAll(): List<ObjAR>
}

class ObjARRepositoryImpl(private val objectARDB: ObjectARDB) : ObjARRepository {

    override suspend fun listAll(): List<ObjAR> = objectARDB.listAll()

}