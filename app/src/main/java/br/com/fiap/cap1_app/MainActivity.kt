package br.com.fiap.cap1_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import br.com.fiap.cap1_app.ui.theme.Cap1APPTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.fiap.cap1_app.screens.LoginScreen
import br.com.fiap.cap1_app.screens.MenuScreen
import br.com.fiap.cap1_app.screens.PerfilScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cap1APPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu") { MenuScreen(navController) }
                        composable(route = "perfil") { PerfilScreen(navController) }
                    }
                }
            }
        }
    }
}