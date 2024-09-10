package com.example.administradordeproyectos.domain

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException

fun validateJWT(token: String): Boolean {
    return try {
        val algorithm = Algorithm.HMAC256("your_secret_key")
        val verifier = JWT.require(algorithm)
            .withIssuer("your_app")
            .build() // Reutiliza el verificador para validar tokens

        val decodedJWT = verifier.verify(token) // Decodifica y verifica
        val userId = decodedJWT.getClaim("userId").asString()

        // El token es válido si llega aquí
        println("Token válido para el usuario: $userId")
        true
    } catch (exception: JWTVerificationException) {
        // Si hay algún error (token expirado, mal formado, etc.)
        println("Token inválido: ${exception.message}")
        false
    }
}
