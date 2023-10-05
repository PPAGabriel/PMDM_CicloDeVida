package com.example.laprimera

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laprimera.ui.theme.InterfazUsuario
import com.example.laprimera.ui.theme.View
import com.example.laprimera.ui.theme.LaPrimeraTheme
import com.example.laprimera.ui.theme.InterfazUsuario
import java.util.function.Function
import kotlin.jvm.internal.FunctionReference

var name:String = "Android" //var es para variables
var numbers = mutableStateOf(0)
var nameC= mutableStateOf("")
class MainActivity : ComponentActivity() {

    val TAG:String = "Estado" //val es para constantes
    val TAG2:String="Funciones"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaPrimeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color(100,0,255)) {
                    InterfazUsuario(name)
                }
            }
        }


        ///Empieza la logica de la aplicación
        Log.d(TAG,"Estoy en Create")

        calcular(a=3,b=5,
            fun(a:Int,b:Int){
                val suma=a+b
                Log.d(TAG2,suma.toString())
              })

        calcular(4,1,
            fun(x,y){
                val resta=x-y
                Log.d(TAG2,resta.toString())
             })

        calcular2{
               Log.d(TAG2,"Yo no hago nada")
            }
        

    }

    fun calcular(a:Int=0,b:Int=0, operacion: (x:Int,y:Int)->Unit){
        //val operacion=a+b
        operacion(a,b)
    }

    fun calcular2(a:Int=0,b:Int=0, operacion: ()->Unit){
        operacion()
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG,"He llegado al Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"llegado al Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"He llegado al Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"He llegado al Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"He llegado al Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"He llegado al Destroy")
    }
}

fun randomNumber(){
    numbers.value=(0..10).random()
}


