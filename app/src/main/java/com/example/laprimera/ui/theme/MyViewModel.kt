package com.example.laprimera.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel() {

    private val TAG_LOG: String="Mensaje de ViewModel"

    var _numbers= mutableStateOf(0)

    init{
        Log.d(TAG_LOG,"Inicializamos ViewModel")
    }

    fun crearRandom(){
        _numbers.value=(0..10).random()
        Log.d(TAG_LOG,"creamos random ${_numbers.value}")
    }

    fun getNumero():Int{
        return _numbers.value
    }

}