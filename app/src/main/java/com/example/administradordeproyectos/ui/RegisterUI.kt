package com.example.administradordeproyectos.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.administradordeproyectos.domain.AuthViewModel
import com.example.administradordeproyectos.domain.login


@Composable
fun RegisterUi(navController: NavController) {
    Log.i("Corcho", "entro register")
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var registrar by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Text(text = "Register")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                isError = false
            },
            label = { Text("Correo electrónico") },
            isError = isError && email.isBlank(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = user,
            onValueChange = {
                user = it
                isError = false
            },
            label = { Text("Usuario") },
            isError = isError && user.isBlank(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                isError = false
            },
            label = { Text("Contraseña") },
            isError = isError && password.isBlank(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank() && user.isNotBlank()) {
                    //registrar = true
                    //viewModel.register(email, password)
                    navController.navigate("miui")

                } else {
                    isError = true
                    Log.i("Corcho", "$email, $password, $user")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }
        Spacer(modifier = Modifier.height(8.dp))
        if (isError) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Por favor, completa ambos campos")
            Log.i("Corcho", "$email, $password, $user")
        }/*
        if (registrar){
            register(email, password)
            Log.i("Corcho", "$email, $password, $user")
        }*/
    }
}