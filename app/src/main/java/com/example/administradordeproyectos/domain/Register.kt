package com.example.administradordeproyectos.domain


import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.administradordeproyectos.ui.MiUI
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

/*
@Composable
fun Register(email:String, password:String) {
    var goMiUi by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val auth = Firebase.auth
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information

                val user = auth.currentUser
                goMiUi = true
            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(
                    context,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }
    if (goMiUi) {
        MiUI()
        Toast.makeText(
            context,
            "Sesion Iniciada",
            Toast.LENGTH_SHORT,
        ).show()
    }
}

 */

class AuthViewModel : ViewModel() {
    private val auth = Firebase.auth
    var user by mutableStateOf<FirebaseUser?>(null)
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")


    fun login(email: String, password: String) {
        isLoading = true
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    user = auth.currentUser

                } else {
                    errorMessage = "Authentication failed."
                }
            }
    }

    fun register(email: String, password: String) {
        isLoading = true
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                isLoading = false
                if (task.isSuccessful) {
                    user = auth.currentUser

                } else {
                    errorMessage = "Authentication failed."
                }
            }
    }

}

