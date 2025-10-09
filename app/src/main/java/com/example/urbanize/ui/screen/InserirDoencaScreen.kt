package com.example.urbanize.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InserirDoencaScreen(navController: NavController , onSaveClicked: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var sintomas by remember { mutableStateOf("") }
    var tratamento by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var observacoes by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastrar Doença") },
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
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome da doença") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = sintomas,
                onValueChange = { sintomas = it },
                label = { Text("Sintomas") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = tratamento,
                onValueChange = { tratamento = it },
                label = { Text("Tratamento") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = data,
                onValueChange = { data = it },
                label = { Text("Data do diagnóstico") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = observacoes,
                onValueChange = { observacoes = it },
                label = { Text("Observações") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    // TODO: salvar os dados (ex: Room, ViewModel, etc.)
                    // navController.popBackStack()
                    onSaveClicked()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B4513))
            ) {
                Icon(Icons.Default.Check, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Salvar")
            }
        }
    }
}
