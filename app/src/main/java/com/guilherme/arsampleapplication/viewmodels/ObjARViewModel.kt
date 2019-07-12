package com.guilherme.arsampleapplication.viewmodels

import android.content.Context
import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.ar.core.ArCoreApk

class ObjARViewModel(private val context: Context) : ViewModel() {
    val tryObjEnable = MutableLiveData<Boolean>()
    val tryObjAlpha = MutableLiveData<Float>()

    fun mayEnableArButton() {
        val availability = ArCoreApk.getInstance().checkAvailability(context)
        if (availability.isTransient) {
            // Re-query at 5Hz while compatibility is checked in the background.
            Handler().postDelayed({
                mayEnableArButton();
            }, 200)
        }

        tryObjEnable.postValue(availability.isSupported)
        tryObjAlpha.postValue(if (availability.isSupported) 1.0.toFloat() else 0.5.toFloat())
    }
}