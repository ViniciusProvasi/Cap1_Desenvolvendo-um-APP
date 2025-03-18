package br.com.fiap.cap1_app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PerfilScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xCE4CAF50))
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Perfil",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(text = "João Silva", fontSize = 18.sp)

                Spacer(modifier = Modifier.height(18.dp))

                Text(text = "joao.silva@email.com", fontSize = 18.sp)

                Spacer(modifier = Modifier.height(18.dp))

                Text(text = "(11) 98765-4321", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(62.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Visão Geral",
                    fontSize = 28.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "Seu consumo total: 0,6426", fontSize = 18.sp)

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "Mudas plantadas: 18 arvores plantadas", fontSize = 18.sp)

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "kg.CO2 Neutralizados: 2.941,2", fontSize = 18.sp)

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "m2 de Área Recuperada: 10m² ", fontSize = 18.sp)

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPerfilScreen() {
    PerfilScreen(navController = NavHostController(LocalContext.current))
}

