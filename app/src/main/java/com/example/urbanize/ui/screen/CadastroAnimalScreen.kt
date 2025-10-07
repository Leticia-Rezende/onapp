package com.example.urbanize.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroAnimalScreen(navController: NavController) {
    var animal by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var genero by remember { mutableStateOf("") }
    var numeroBrinco by remember { mutableStateOf("") }
    var raca by remember { mutableStateOf("") }
    var estadoSaude by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastrar Animal") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = animal,
                onValueChange = { animal = it },
                label = { Text("Animal") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Peso") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text("Idade") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = genero,
                onValueChange = { genero = it },
                label = { Text("Gênero") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = numeroBrinco,
                onValueChange = { numeroBrinco = it },
                label = { Text("Nº Brinco") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = raca,
                onValueChange = { raca = it },
                label = { Text("Raça") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = estadoSaude,
                onValueChange = { estadoSaude = it },
                label = { Text("Estado de Saúde") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* TODO: ação de salvar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}
