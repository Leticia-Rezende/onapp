package com.example.urbanize.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheAnimalScreen(nomeAnimal: String?, navController: NavController) {
    val animais = listOf(
        Animal("Vaca 1", 4, 450.0, "A123", "Nenhuma", "Saudável"),
        Animal("Vaca 2", 3, 420.0, "B456", "Febre", "Estável"),
        Animal("Vaca 3", 2, 410.0, "B457", "Gripe", "Estável"),
        Animal("Vaca 4", 5, 460.0, "B458", "Nenhuma", "Saudável"),
        Animal("Boi 1", 5, 620.0, "C789", "Nenhuma", "Saudável"),
        Animal("Boi 2", 4, 600.0, "C790", "Virose", "Estável"),
        Animal("Boi 3", 3, 590.0, "C791", "Nenhuma", "Saudável")
    )
    val animal = animais.find { it.nome == nomeAnimal }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do Animal") },
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
            verticalArrangement = Arrangement.Top
        ) {
            animal?.let {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Nome: ${it.nome}", style = MaterialTheme.typography.titleLarge)
                        Spacer(Modifier.height(8.dp))
                        Text("Idade: ${it.idade} anos")
                        Text("Peso: ${it.peso} kg")
                        Text("Nº do brinco: ${it.brinco}")
                        Text("Doenças: ${it.doencas}")
                        Text("Saúde: ${it.saude}")
                    }
                }
                Spacer(Modifier.height(24.dp))
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Voltar")
                }
            } ?: Text(
                "Nenhum animal encontrado com esse nome.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
