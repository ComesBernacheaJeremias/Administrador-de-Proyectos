package com.example.administradordeproyectos.domain.JWT

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import java.util.Date

fun generateJWT(userId: String): String {
    val algorithm = Algorithm.HMAC256("your_secret_key")
    val token = JWT.create()
        .withIssuer("your_app")
        .withClaim("userId", userId)
        .withExpiresAt(Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hora
        .sign(algorithm)

    return token
}
