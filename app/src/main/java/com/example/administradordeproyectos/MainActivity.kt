package com.example.administradordeproyectos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.administradordeproyectos.domain.AuthViewModel

import com.example.administradordeproyectos.ui.Login
import com.example.administradordeproyectos.ui.MiUI
import com.example.administradordeproyectos.ui.RegisterUi
import com.example.administradordeproyectos.ui.theme.AdministradorDeProyectosTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = Firebase.auth


        setContent {
            AdministradorDeProyectosTheme {
                val auth = Firebase.auth
                val currentUser = auth.currentUser
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    navigation(startDestination = "login", route = "auth") {
                        composable("login") { Login(navController)
                        val viewModel = it.sharedViewModel<AuthViewModel>(navController)}
                        composable("register") { RegisterUi(navController) }
                        composable("miui") { MiUI(navController) }
                    }
                }


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (currentUser != null) {
                        if (navController.currentDestination?.route != "miui") {
                            navController.navigate("miui")
                        }
                    } else {
                        if (navController.currentDestination?.route != "login") {
                            navController.navigate("login")
                        }

                    }
                }
            }
        }

    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route?: return viewModel()
    val parentEntry =  remember(this){
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

/*
@Composable
fun ViewContainer() {
    val auth = Firebase.auth
    val currentUser = auth.currentUser

    /*val navController = rememberNavController()

    NavHost(navController, startDestination = "login") {
        composable("login") { Login() }
        composable("register") { RegisterUi() }
        composable("miui") { MiUI() }
    }

     */


    LaunchedEffect(currentUser) {
        if (currentUser != null) {
            navController.navigate("miui") {
                popUpTo("login") {
                    inclusive = true
                } // Evita que el usuario vuelva a la pantalla de login
            }
        } else {
            navController.navigate("login") {
                popUpTo("miui") {
                    inclusive = true
                } // Evita que el usuario vuelva a la pantalla de miui
            }
        }
    }



}
/*


    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                if (currentUser != null) {
                    MiUI()
                } else {
                    Login()
                }


            }
        }
    )

}

 */

class AuthViewModelFactory(private val navController: NavController) : ViewModelProvider.Factory {
    fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthViewModel(navController) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(navController))
    // Usa viewModel en tu UI
}

@Composable
fun RegisterScreen(navController: NavController) {
    val viewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(navController))
    // Usa viewModel en tu UI
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdministradorDeProyectosTheme {
        //ViewContainer()
    }
}

 */