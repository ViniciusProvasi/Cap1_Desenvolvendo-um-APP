package br.com.fiap.cap1_app.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fiap.cap1_app.models.User
import br.com.fiap.cap1_app.repositories.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()

    fun saveUser(user: User) {
        viewModelScope.launch {
            repository.saveUser(user)
        }
    }

    fun getUser(userId: String, onSuccess: (User?) -> Unit) {
        viewModelScope.launch {
            val user = repository.getUser(userId)
            onSuccess(user)
        }
    }
}