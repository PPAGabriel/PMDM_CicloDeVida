package com.example.laprimera.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel() {

    private val TAG_LOG: String="Mensaje de ViewModel"

    var _numbers= mutableStateOf(0)
    var _nameC= mutableStateOf("")
    var _numberList= mutableStateListOf<Int>()

    init{
        Log.d(TAG_LOG,"Inicializamos ViewModel")
    }

    fun getNombre():String{
        return _nameC.value
    }
    fun crearRandom(){
        _numbers.value=(0..10).random()
        Log.d(TAG_LOG,"creamos random ${_numbers.value}")
    }

    fun crearRandomList(){
        _numberList.add((0..3).random())
        Log.d(TAG_LOG,"creamos random list ${_numberList.toList()}")
    }

    fun getNumero():Int{
        return _numbers.value
    }

    fun getNumberList():List<Int>{
        return _numberList.toList()
    }

}