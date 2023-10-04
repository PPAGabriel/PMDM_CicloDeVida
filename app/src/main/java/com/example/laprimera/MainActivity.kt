package com.example.laprimera

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import com.example.laprimera.ui.theme.LaPrimeraTheme
import java.util.function.Function
import kotlin.jvm.internal.FunctionReference

var name:String = "Android" //var es para variables

class MainActivity : ComponentActivity() {

    val TAG:String = "Estado" //val es para constantes



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaPrimeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color(100,0,255)) {
                    Saludo(name)
                }
            }
        }


        ///Empieza la logica de la aplicación
        Log.d(TAG,"Estoy en Create")

        calcular(a=3,b=5,
            fun(a:Int,b:Int){
                val suma=a+b
                Log.d("Calcular",suma.toString())
              })

        calcular(4,1,
            fun(x,y){
                val resta=x-y
                Log.d("Calcular",resta.toString())
             })

        calcular2{
               Log.d("Calcular","Yo no hago nada")
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

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Saludo(name: String, modifier: Modifier = Modifier) {
    var nameC=remember{ mutableStateOf("") }
    var numbers = remember {mutableStateOf(0)}  // esto hace que siempre que cambie el valor de numbers se va a actualizar, remember es un observer
    //al ponerle el cero el compilador ya sabe que es un entero

    var miColor= Color(255,222,0)
    var saludo=stringResource(R.string.greeting)
    Column {
        Image(
            painter = painterResource(R.drawable.pikachu),
            contentDescription= "imagen"
        )

        Text(
            text = "$saludo, $name",
            modifier = modifier,
            fontSize = 40.sp,
            color = miColor
        )

        Text(
            text = "Soy Pikachu!",
            modifier = modifier,
            fontSize = 60.sp,
            color = Color.Red
        )
        
        Button(
            onClick = {
                numbers.value=(0..10).random()
                Log.d("calcular","Click!!!!!")
            },
            modifier= Modifier
                .height(90.dp)
                .width(150.dp),
            colors=ButtonDefaults.buttonColors(miColor)
        ) {
            Text(text = "Pincha aquí",
                fontSize = 15.sp,
                color = Color.Red
                )
            Image(
                painter = painterResource(R.drawable.baseline_cruelty_free_24),
                contentDescription= "imagen",
                modifier= modifier
                    .height(48.dp)
                    .width(48.dp)
                )
            }

        Text(
            text = "Numero random: ${numbers.value}",
            modifier = modifier,
            fontSize = 30.sp,
            color = Color.Yellow
        )

        // campo de texto para rellenar
        OutlinedTextField(
            value = nameC.value,
            onValueChange = {
                nameC.value = it
            },
            label = { Text(
                text = "Introduzca un nombre",
                color= Color.Yellow ) }
        )

        Text(text = "Nombre escrito: ${nameC.value}",
            fontSize = 25.sp,
            modifier = Modifier.padding(vertical = 20.dp),
            color=Color.Red
            )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        Saludo("prueba")
    }
}

@Composable
fun chat(){
    TODO("Not yet implemented")
}
@Composable
fun login(){
    //texto y boton para loguear
    texto_descriptivo(texto = "Fallo de login")
}
@Composable
fun texto_descriptivo(texto:String){
    //texto descriptivo
    Text(text = texto)
}
@Composable
fun interfazUsuario(){
    login()
    texto_descriptivo(texto = "Hola texto")
    chat()
}
