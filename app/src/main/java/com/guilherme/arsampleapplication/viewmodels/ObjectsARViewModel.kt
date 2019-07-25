package com.guilherme.arsampleapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.repository.ObjARRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ObjectsARViewModel(private val objARRepository: ObjARRepository) : ViewModel() {
    val objAR = MutableLiveData<List<ObjAR>>()
    val loadingVisibility = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    fun listObjects() {
        loadingVisibility.postValue(true)
        message.postValue("")

        GlobalScope.launch {
            try {
                objARRepository.listAll().let {
                    objAR.postValue(it)

                    if (it.isEmpty())
                        message.postValue("Lista vazia")
                }

                loadingVisibility.postValue(false)
            } catch (e: Exception) {
                message.postValue("Erro ao carregar dados")
                loadingVisibility.postValue(false)
            }
        }
    }
}