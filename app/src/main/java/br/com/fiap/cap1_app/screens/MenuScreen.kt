package br.com.fiap.cap1_app.screens

import android.R.attr.text
import android.R.id.text2
import android.icu.text.CaseMap
import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import br.com.fiap.cap1_app.repositories.UserRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import br.com.fiap.cap1_app.viewmodels.UserViewModel
import br.com.fiap.cap1_app.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val repository = UserRepository()


    // Carrega o nome do usuário ao iniciar a tela
    LaunchedEffect(Unit) {
        val userId = auth.currentUser?.uid
        if (userId != null) {
            val name = repository.getUserName(userId)
            if (name != null) {
                username = name
            } else {
                username = "Usuário não encontrado"
            }
        } else {
            username = "Usuário não autenticado"
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            TitleText(text1 = "DashBoard ", text2 = "- CMeter", color = Color.Green)
            Image(
                painterResource(id = R.drawable.ic_earth),
                contentDescription = "Logo",
                modifier = Modifier.size(48.dp)
            )
        }
        Spacer(modifier = Modifier.height(200.dp))

        // Título do Dashboard
        Text(
            text = "Bem-Vindo - $username",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )


        Spacer(modifier = Modifier.height(32.dp))

        // Botão para Simulação
        Button(
            onClick = { navController.navigate("simulation") }, // Navega para a tela de simulação
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Simulação",
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
       }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para Histórico
        Button(
            onClick = { navController.navigate("history") }, // Navega para a tela de histórico
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Histórico",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para Perfil
        Button(
            onClick = { navController.navigate("perfil") }, // Navega para a tela de perfil
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Perfil",
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botão para Voltar ao Login
        Button(
            onClick = { navController.navigate("login") }, // Navega de volta para a tela de login
            modifier = Modifier
                .width(120.dp)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Sair",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Composable
fun TitleText(text1: String, text2: String, color: Color) {
    Text(
        text = buildAnnotatedString {
            append(text1)
            withStyle(
                style = SpanStyle(
                    color = color
                )
            ){
                append(text2)
            }
        },
        color = Color.White,
        fontSize = 24.sp
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewMenuScreen () {
    MenuScreen(navController = NavHostController(LocalContext.current))
}