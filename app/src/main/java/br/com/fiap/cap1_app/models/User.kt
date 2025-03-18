package br.com.fiap.cap1_app.models

data class User(
    val id: String = "", // ID do usuário (gerado pelo proprio Firebase)
    val name: String = "",
    val email: String = "",
    val carbonFootprint: Double = 0.0 // Pegada de carbono do usuário aqui
)