package br.com.fiap.cap1_app.screens

import android.view.Menu
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = (Color(0xCE4CAF50)))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bem Vindo", fontSize = 34.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* Navegar para outra tela */ },
            modifier = Modifier.size(height = 60.dp, width = 200.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Perfil",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.size(height = 60.dp, width = 200.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Consumo",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.size(height = 60.dp, width = 200.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "ONGs",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("login") },
            modifier = Modifier.size(height = 60.dp, width = 200.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Sobre Nos",
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview() {
    MenuScreen(navController = NavHostController(LocalContext.current))
}
