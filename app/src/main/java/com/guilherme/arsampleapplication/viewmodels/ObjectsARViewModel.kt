package com.guilherme.arsampleapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.repository.ObjARRepository

class ObjectsARViewModel(private val objARRepository: ObjARRepository) : ViewModel() {
    val objAR = MutableLiveData<List<ObjAR>>()
    val loadingVisibility = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun listObjects() {
        loadingVisibility.postValue(true)
        message.postValue("")

        objARRepository.listAll({
            objAR.postValue(it)
            if (it.isEmpty())
                message.postValue("Lista vazia")
            loadingVisibility.postValue(false)
        }, {
            message.postValue("Erro ao carregar dados")
            loadingVisibility.postValue(false)
        })
    }
}