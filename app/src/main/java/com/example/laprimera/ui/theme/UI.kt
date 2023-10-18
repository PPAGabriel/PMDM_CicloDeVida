@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.laprimera.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laprimera.R

@OptIn(ExperimentalMaterial3Api::class)
open class UI {
}

@Composable
 fun InterfazUsuario(miViewModel: MyViewModel,name: String, modifier: Modifier = Modifier) {
    // var nameC= remember{ mutableStateOf("") }
    // var numbers = remember { mutableStateOf(0) }  esto hace que siempre que cambie el valor de numbers se va a actualizar, remember es un observer
    //al ponerle el cero el compilador ya sabe que es un entero

    var miColor= Color(255,222,0)
    var saludo= stringResource(R.string.greeting)
    Column {
        Image(
            painter = painterResource(R.drawable.pikachu),
            contentDescription= "imagen"
        )

        Text(
            text = "$saludo, $name",
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 40.sp,
            color = miColor
        )

        Text(
            text = "Soy Pikachu!",
            modifier = modifier.padding(15.dp),
            fontSize = 60.sp,
            color = Color.Red
        )

        Button(
            onClick = {
                miViewModel.crearRandomList()
                //miViewModel.crearRandom()
                Log.d("Funciones","Click!!!!!")
            },
            modifier= Modifier
                .height(90.dp)
                .width(160.dp),
            colors= ButtonDefaults.buttonColors(miColor)
        ) {
            Text(text = "Pincha aquí",
                fontSize = 15.sp,
                color = Color.Red
            )
            Image(
                painter = painterResource(R.drawable.rocket),
                contentDescription= "imagen",
                modifier= modifier
            )
        }

        if (miViewModel.getNumberList().isEmpty()){
            Text(text = "Lista random vacía",
                fontSize = 30.sp,
                color = Color.Red
            )
        }else{
            Text(
                text= "Lista random: ${miViewModel.getNumberList()}",
                //text = "Numero random: ${miViewModel.getNumero()}",
                modifier = modifier,
                fontSize = 30.sp,
                color = miColor
            )
        }

        // campo de texto para rellenar
        OutlinedTextField(
            value = miViewModel.getNombre(),
            onValueChange = {
                miViewModel._nameC.value = it
            },
            label = { Text(
                text = "Introduzca un nombre",
                color= miColor ) },
            modifier=modifier.padding(0.dp,20.dp)
        )

        if (miViewModel.getNombre().length>3){
            Text(text = "Nombre escrito: ${miViewModel.getNombre()}",
                fontSize = 25.sp,
                modifier = Modifier.padding(vertical = 20.dp),
                color= Color.Red
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        InterfazUsuario(miViewModel=MyViewModel(), "prueba" )
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