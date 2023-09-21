package com.example.laprimera

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.laprimera.ui.theme.LaPrimeraTheme

var name:String = "Android" //var es para variables

class MainActivity : ComponentActivity() {

    val TAG:String = "Estado" //val es para constantes



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaPrimeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Magenta) {
                    Saludo(name)
                }
            }
        }


        ///Empieza la logica de la aplicación
        Log.d(TAG,"Estoy en Create")
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

@Composable
fun Saludo(name: String, modifier: Modifier = Modifier) {
    var miColor=Color.Cyan
    Column {

        Text(
            text = "Hola, $name!",
            modifier = modifier,
            fontSize = 40.sp,
            color = miColor
        )

        Text(
            text = "Hola, $name!",
            modifier = modifier,
            fontSize = 60.sp,
            color = Color.Yellow
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        Saludo(name)
    }
}
