package com.example.laprimera.ui.theme

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//Clase Data
data class MyData(
    val number:Int,
    val name:String,
    val numList:List<Int>
)

class MyViewModel(): ViewModel() {

    //almaceno los datos en una variable privada mutable
    private var data= mutableStateOf(MyData(0,"",emptyList()))

    private val TAG_LOG: String="Mensaje de ViewModel"

    /*var _numbers= mutableStateOf(0)
    var _nameC= mutableStateOf("")
    var _numberList= mutableStateListOf<Int>()
    */
    init{
        Log.d(TAG_LOG,"Inicializamos ViewModel")
    }

    fun getNombre():String{
        return data.value.name
    }

    //Función que permita actualizas uno de los valores de la clase
    fun updNombre(newNombre:String){
        data.value=data.value.copy(name=newNombre)
    }
    fun crearRandom(){
        data.value = data.value.copy(number = (0..10).random())
        Log.d(TAG_LOG, "Numero random: ${data.value.number}")
    }

    fun crearRandomList(){
        // copio la lista y acytualizo el objeto al añadir un valor
        data.value = data.value.copy(numList = data.value.numList + ((0..3).random()))
        Log.d(TAG_LOG, "creamos random ${data.value.numList.get(data.value.numList.size-1)}")
    }

    fun getNumero():Int{
        return data.value.number
    }

    fun getNumberList():List<Int>{
        return data.value.numList
    }

}