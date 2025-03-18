package br.com.fiap.cap1_app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.cap1_app.models.User
import br.com.fiap.cap1_app.viewmodels.UserViewModel

@Composable
fun PerfilScreen(navController: NavHostController, userId: String) {
    val viewModel: UserViewModel = viewModel()
    var user by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(Unit) {
        viewModel.getUser(userId) { fetchedUser ->
            user = fetchedUser
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (user != null) {
            Text(text = "Nome: ${user!!.name}")
            Text(text = "Email: ${user!!.email}")
            Text(text = "Pegada de Carbono: ${user!!.carbonFootprint}")
        } else {
            Text(text = "Carregando...")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val newUser = User(id = userId, name = "João Silva", email = "joao@example.com", carbonFootprint = 120.5)
            viewModel.saveUser(newUser)
        }) {
            Text(text = "Salvar Usuário")
        }
    }
}