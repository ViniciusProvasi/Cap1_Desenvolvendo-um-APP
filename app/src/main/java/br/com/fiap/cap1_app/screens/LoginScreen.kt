package br.com.fiap.cap1_app.screens

import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.height(120.dp)) {
            Text(text = "Bem-Vindo!", fontSize = 24.sp)
        }
        OutlinedTextField(
            value = username,
            singleLine = true,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            isError = error,
            colors = TextFieldDefaults.colors(
                errorIndicatorColor = Color.Red,  // Cor da borda quando erro
                errorSupportingTextColor = Color.Red, // Cor do texto de erro
                errorLabelColor = Color.Red,      // Cor do label quando erro
                errorCursorColor = Color.Red      // Cor do cursor quando erro
            )
        )
        if (error) {
            Text(text = "Preencha o campo de usuário", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

//        OutlinedTextField(
//            value = password,
//            singleLine = true,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth(),
//            trailingIcon = {
//                val icon = if (passwordVisible) "+" else "-"
//                Text(icon, modifier = Modifier.clickable { passwordVisible = !passwordVisible })
//            }
//        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username.isNotEmpty() /*&& password.isNotEmpty()*/) {
                    navController.navigate("menu")
                } else {
                    error = true
                }
            },
            modifier = Modifier.size(height = 60.dp, width = 120.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = MaterialTheme.shapes.medium,

            ) {
            Text(
                text = "Login",
                modifier = Modifier
                    .padding(vertical = 8.dp),
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navController = NavHostController(LocalContext.current))
}
