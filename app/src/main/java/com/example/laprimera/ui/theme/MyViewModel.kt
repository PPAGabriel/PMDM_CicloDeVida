package com.example.laprimera.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel(): ViewModel() {

    private val TAG_LOG: String="Mensaje de ViewModel"

    var _numbers= mutableStateOf(0)
    var _numbers2= mutableStateOf(0)
    var _nameC= mutableStateOf("")
    var _nameC2= mutableStateOf("START")
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

    //////////////////////////////////////////

    fun aumentoN(){
        _numbers2.value++
    }

    fun getNumero2():Int{
        return _numbers2.value
    }

    fun cambiarEstado(){
        if (_nameC2.value.equals("START")){
            _nameC2.value = "RESET"
        } else {
            _nameC2.value = "START"
        }
    }

    fun getNombre2():String{
        return _nameC2.value
    }



}