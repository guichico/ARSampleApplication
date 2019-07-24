package com.guilherme.arsampleapplication

import androidx.multidex.MultiDexApplication
import com.google.firebase.FirebaseApp
import com.guilherme.arsampleapplication.di.objARModule
import com.guilherme.arsampleapplication.di.objectsARModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class ARSampleApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)

            modules(objectsARModule)
            modules(objARModule)
        }

        FirebaseApp.initializeApp(this);
    }
}