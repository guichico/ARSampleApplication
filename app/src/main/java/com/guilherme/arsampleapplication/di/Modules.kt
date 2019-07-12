package com.guilherme.arsampleapplication.di

import com.guilherme.arsampleapplication.repository.ObjectARDB
import com.guilherme.arsampleapplication.repository.ObjARRepository
import com.guilherme.arsampleapplication.viewmodels.ObjARViewModel
import com.guilherme.arsampleapplication.viewmodels.ObjectsARViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ObjectsARModule = module {
    single { ObjectARDB() }
    single { ObjARRepository(get()) }

    viewModel { ObjectsARViewModel(get()) }
}
val ObjARModule = module {
    viewModel { ObjARViewModel(get()) }
}

val objectsARModule = listOf(ObjectsARModule)
val objARModule = listOf(ObjARModule)