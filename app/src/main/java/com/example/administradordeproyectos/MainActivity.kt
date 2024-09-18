package com.example.administradordeproyectos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.administradordeproyectos.ui.Login
import com.example.administradordeproyectos.ui.MiUI
import com.example.administradordeproyectos.ui.RegisterUi
import com.example.administradordeproyectos.ui.theme.AdministradorDeProyectosTheme
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth
        Log.i("Corcho", "entro en oncreate")



        setContent {
            AdministradorDeProyectosTheme {

                val auth = Firebase.auth
                val currentUser = auth.currentUser
                idea()

                Log.i("Corcho", "${currentUser}")
                Log.i("Corcho", "entro en oncreate${auth}")


            }
        }
    }
}


@Composable
fun idea() {
    val auth = Firebase.auth
    val currentUser = auth.currentUser
    Log.i("Corcho", "entro en idea")
    Log.i("Corcho", "${currentUser}")
   // Log.i("Corcho", "${navController}")

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = if (currentUser != null){miui} else {
        Home
    }
    ) {
        Log.i("Corcho", "llega hasta acá222")
        composable<Home> {
            Log.i("Corcho", "entro en HOme")
            Login(navController)}
        composable<register> { RegisterUi(navController)
            Log.i("Corcho", "entro en register")}
        composable<miui> { MiUI(navController)
            Log.i("Corcho", "entro en miui")}


    }

    if (currentUser != null) {
        if (navController.currentDestination?.route != "miui") {
            navController.navigate("miui")
        }
    } else {
        if (navController.currentDestination?.route != "Home") {
            Log.i("Corcho", "entro en iff")
            navController.navigate(Home)
        }

    }


}


@Serializable
object Home

@Serializable
object register

@Serializable
object miui



fun goBack(){

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdministradorDeProyectosTheme {
        //ViewContainer()
    }
}

