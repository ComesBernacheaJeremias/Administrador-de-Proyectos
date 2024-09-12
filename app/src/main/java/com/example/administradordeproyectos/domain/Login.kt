package com.example.administradordeproyectos.domain

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.administradordeproyectos.ui.MiUI
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


@Composable
fun login(email:String, password:String) {
    var goUI by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val auth = Firebase.auth
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                val user = auth.currentUser
                goUI = true
            } else {
                // If sign in fails, display a message to the user.
                Toast.makeText(
                    context,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT,
                ).show()

            }
        }
    if (goUI){
        MiUI()
        Toast.makeText(
            context,
            "Sesion Iniciada",
            Toast.LENGTH_SHORT,
        ).show()
    }
}