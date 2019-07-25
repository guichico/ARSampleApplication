package com.guilherme.arsampleapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.guilherme.arsampleapplication.models.ObjAR
import com.guilherme.arsampleapplication.repository.ObjARRepository
import com.guilherme.arsampleapplication.viewmodels.ObjectsARViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.test.AutoCloseKoinTest
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations.*

class ObjectsARViewModelUnitTest : AutoCloseKoinTest() {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var objectsARViewModel: ObjectsARViewModel

    @Mock
    lateinit var objARRepository: ObjARRepository

    @Before
    fun setup() {
        initMocks(this);
        objectsARViewModel = ObjectsARViewModel(objARRepository)
    }

    @Test
    fun listObjectsTestOk() = runBlocking {
        var list = listOf(
            ObjAR("1", "Teste", "teste", listOf("img"), "model.obj", "Teste")
        )

        `when`(objARRepository.listAll()).thenReturn(list)

        objectsARViewModel.listObjects()

        assertEquals(list, objectsARViewModel.objAR.value)
    }

    @Test
    fun listObjectsTestEmptyList() = runBlocking {
        `when`(objARRepository.listAll()).thenReturn(emptyList())

        objectsARViewModel.listObjects()

        assertEquals(emptyList<ObjAR>(), objectsARViewModel.objAR.value)
        assertEquals("Lista vazia", objectsARViewModel.message.value)
    }

    @Test(expected = java.lang.Exception::class)
    fun listObjectsTestServiceUnavailable() = runBlocking {
        `when`(objARRepository.listAll()).thenThrow(Exception::class.java)

        objectsARViewModel.listObjects()

        assertEquals("Erro ao carregar dados", objectsARViewModel.message.value)
    }
}