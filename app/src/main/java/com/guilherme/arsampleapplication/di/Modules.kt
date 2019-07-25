package com.guilherme.arsampleapplication.di

import com.google.firebase.firestore.FirebaseFirestore
import com.guilherme.arsampleapplication.repository.ObjARRepository
import com.guilherme.arsampleapplication.repository.ObjARRepositoryImpl
import com.guilherme.arsampleapplication.repository.ObjectARDB
import com.guilherme.arsampleapplication.viewmodels.ObjARViewModel
import com.guilherme.arsampleapplication.viewmodels.ObjectsARViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ObjectsARModule = module {
    single { ObjectARDB(FirebaseFirestore.getInstance()) }
    single { ObjARRepositoryImpl(get()) as ObjARRepository }

    viewModel { ObjectsARViewModel(get()) }
}
val ObjARModule = module {
    viewModel { ObjARViewModel(get()) }
}

val objectsARModule = listOf(ObjectsARModule)
val objARModule = listOf(ObjARModule)