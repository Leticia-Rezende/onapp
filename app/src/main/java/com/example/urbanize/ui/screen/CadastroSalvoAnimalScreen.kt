package com.example.urbanize.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroSalvoAnimalScreen(
    onBackToHome: () -> Unit // Função para voltar à tela principal
) {
    Button(onClick = onBackToHome) {
        Text("Voltar ao Início")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastro Concluído") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF)) // Cor de Fundo
                .padding(paddingValues)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Ícone de sucesso
            Icon(
                imageVector = Icons.Filled.CheckCircle,
                contentDescription = "Sucesso",
                tint = Color(0xFF8B4513),
                modifier = Modifier.size(96.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Mensagem de sucesso
            Text(
                text = "Animal Cadastrado com Sucesso!",
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Os dados foram salvos temporariamente.",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(48.dp))

            // Botão para voltar
            Button(
                onClick = onBackToHome,
                modifier = Modifier.fillMaxWidth(0.6f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B4513))
            ) {
                Text("Voltar ao Início")
            }
        }
    }
}