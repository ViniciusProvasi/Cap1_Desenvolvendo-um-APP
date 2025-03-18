package br.com.fiap.cap1_app.repositories

import br.com.fiap.cap1_app.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.jvm.java

class UserRepository {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    // Função para salvar um usuário no Firestore
    suspend fun saveUser(user: User) {
        db.collection("users").document(user.id).set(user).await()
    }

    // Função para buscar um usuário pelo ID
    suspend fun getUser(userId: String): User? {
        val snapshot = db.collection("users").document(userId).get().await()
        return snapshot.toObject(User::class.java)
    }

    suspend fun getUserName(userId: String): String? {
        return try {
            val document = db.collection("users").document(userId).get().await()
            if (document.exists()) {
                document.getString("username") // Retorna o nome do usuário
            } else {
                null // Documento não encontrado
            }
        } catch (e: Exception) {
            println("Erro ao buscar nome do usuário: ${e.message}")
            null
        }
    }
}