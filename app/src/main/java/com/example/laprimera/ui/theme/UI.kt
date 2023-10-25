@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.laprimera.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laprimera.R

@OptIn(ExperimentalMaterial3Api::class)
open class UI {
}

@Composable
 fun InterfazUsuario(miViewModel: MyViewModel,name: String, modifier: Modifier = Modifier) {

    var miColor= Color(220,122,255)
    var saludo= stringResource(R.string.greeting)
    Column {
    Column {
        ronda(miViewModel,modifier = modifier,miColor=miColor)
    }

        botonesSimon()

        Row {
            botonStart(miViewModel, miColor = miColor, modifier = modifier)
            botonRound(miViewModel, miColor = miColor, modifier = modifier)
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
@Composable()
fun ronda(miViewModel: MyViewModel,modifier: Modifier,miColor: Color) {
    Text(
        text = "Ronda:",
        modifier = modifier
            .padding(250.dp,0.dp,0.dp,0.dp),
        textAlign = TextAlign.Right,
        fontSize = 40.sp,
        color = Color.White
    )

    if (miViewModel.getNumero2() > 10) {
        Text(
            text = "${miViewModel.getNumero2()}",
            fontSize = 60.sp,
            modifier = Modifier.padding(300.dp,0.dp,0.dp,0.dp),
            color = Color.White
        )
    } else {
        Text(
            text = "${miViewModel.getNumero2()}",
            fontSize = 40.sp,
            modifier = Modifier.padding(300.dp,0.dp,0.dp,0.dp),
            color = Color.White
        )
    }
}
@Composable
fun botonStart(miViewModel: MyViewModel,miColor: Color,modifier: Modifier){
    Button(
        onClick = {
            miViewModel.cambiarEstado()
        },
        modifier= Modifier
            .height(90.dp)
            .width(160.dp),
        colors= ButtonDefaults.buttonColors(miColor)
    ) {
        Text(
            text = miViewModel.getNombre2(),
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}
@Composable
fun botonRound(miViewModel: MyViewModel,miColor: Color,modifier: Modifier){
    Button(
        onClick = {
            miViewModel.aumentoN()
            Log.d("Funciones","Click!!!!!")
        },
        modifier= Modifier
            .height(90.dp)
            .width(160.dp)
            .padding(70.dp, 0.dp, 0.dp, 0.dp),
        colors= ButtonDefaults.buttonColors(miColor)
    ) {
        Image(
            painter = painterResource(R.drawable.arrow),
            contentDescription = "imagen",
            modifier = modifier
        )
    }
}

@Composable
fun botonesSimon(){
    Row (modifier = Modifier.padding(0.dp,100.dp,0.dp,0.dp)){
        columnButtonSimon(color = Color.Cyan)
        columnButtonSimon(color = Color.Green)
    }
    Row (){
        columnButtonSimon(color = Color.Red)
        columnButtonSimon(color = Color.Yellow)
    }
}

@Composable
fun columnButtonSimon(color: Color){
    Column {
        Button(onClick = {
            /*TODO*/
        },
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .padding(50.dp, 50.dp)
            ,
            colors = ButtonDefaults.buttonColors(color)
        ){

        }
    }
}

/////////////////////////////////////////////
@Composable
fun  textos(miColor:Color,saludo:String,name:String,modifier: Modifier){
    Text(
        text = "$saludo, $name",
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontSize = 40.sp,
        color = miColor
    )

    Text(
        text = "Soy Pikachu!",
        modifier = modifier.padding(15.dp),
        fontSize = 60.sp,
        color = Color.Red
    )
}

@Composable
fun imagen(){
    Image(
        painter = painterResource(R.drawable.pikachu),
        contentDescription= "imagen"
    )
}
@Composable
fun boton(miViewModel: MyViewModel,miColor: Color,modifier: Modifier) {
    Button(
        onClick = {
            miViewModel.crearRandomList()
            //miViewModel.crearRandom()
            Log.d("Funciones", "Click!!!!!")
        },
        modifier = Modifier
            .height(90.dp)
            .width(160.dp),
        colors = ButtonDefaults.buttonColors(miColor)
    ) {
        Image(
            painter = painterResource(R.drawable.rocket),
            contentDescription = "imagen",
            modifier = modifier
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textoARellenar(miViewModel: MyViewModel,miColor: Color,modifier: Modifier){
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