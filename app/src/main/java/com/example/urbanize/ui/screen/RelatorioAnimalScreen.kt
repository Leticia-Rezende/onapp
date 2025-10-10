package com.example.urbanize.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Animal(
    val nome: String,
    val idade: Int,
    val peso: Double,
    val brinco: String,
    val doencas: String,
    val saude: String
)

@Composable
fun RelatorioAnimalScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    val animals = listOf(
        Animal("Vaca 1", 4, 450.0, "A123", "Nenhuma", "Saudável"),
        Animal("Vaca 2", 3, 420.0, "B456", "Febre", "Estável"),
        Animal("Vaca 3", 5, 460.0, "B789", "Gripe", "Recuperando"),
        Animal("Vaca 4", 2, 410.0, "B790", "Nenhuma", "Saudável"),
        Animal("Boi 1", 5, 620.0, "C789", "Nenhuma", "Saudável"),
        Animal("Boi 2", 4, 590.0, "C790", "Virose", "Estável"),
        Animal("Boi 3", 6, 640.0, "C791", "Nenhuma", "Saudável"),
        Animal("Bezerro 1", 1, 180.0, "D123", "Nenhuma", "Saudável"),
        Animal("Bezerro 2", 1, 175.0, "D124", "Gripe leve", "Estável"),
        Animal("Touro 1", 7, 720.0, "E321", "Nenhuma", "Saudável"),
        Animal("Touro 2", 8, 740.0, "E322", "Infecção leve", "Tratando")
    )

    val filteredAnimals = animals.filter {
        it.nome.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Relatório de Animais", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar animal...") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(filteredAnimals) { animal ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // 🔗 navega para a tela de detalhes
                            navController.navigate("detalheAnimal/${animal.nome}")
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = animal.nome, style = MaterialTheme.typography.titleMedium)

                        Text(text = "Brinco: ${animal.brinco}")


                    }
                }
            }
        }
    }
}
