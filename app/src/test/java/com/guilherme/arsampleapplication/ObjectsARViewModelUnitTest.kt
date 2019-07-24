package com.guilherme.arsampleapplication

import com.guilherme.arsampleapplication.viewmodels.ObjectsARViewModel
import org.junit.Before
import org.junit.Test
import org.koin.test.AutoCloseKoinTest
import org.mockito.MockitoAnnotations
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.repository.ObjARRepository
import io.reactivex.Maybe
import org.junit.Assert
import org.junit.rules.TestRule
import org.junit.Rule
import org.mockito.Mock
import org.mockito.Mockito

class ObjectsARViewModelUnitTest : AutoCloseKoinTest() {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var objectsARViewModel: ObjectsARViewModel

    @Mock
    lateinit var objARRepository: ObjARRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);
        objectsARViewModel = ObjectsARViewModel(objARRepository)
    }

    @Test
    fun listObjectsTest() {
        Mockito.`when`(objARRepository.listAll()).thenReturn(Maybe.just(emptyList()))

        objectsARViewModel.listObjects()

        Assert.assertEquals(emptyList<ObjAR>(), objectsARViewModel.objAR.value)
        Assert.assertEquals("Lista vazia", objectsARViewModel.message.value)
    }
}