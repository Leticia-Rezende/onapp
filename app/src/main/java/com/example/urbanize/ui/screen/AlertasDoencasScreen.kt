package com.example.urbanize.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Alerta(
    val titulo: String,
    val descricao: String,
    val dataHora: String,
    val severidade: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertasDoencasScreen(navController: NavController) {

    // Lista simulada de alertas
    val listaAlertas = listOf(
        Alerta(
            "Surto de febre aftosa",
            "Casos identificados em fazendas próximas. Mantenha os animais isolados e comunique o veterinário.",
            formatarDataHora(),
            "Grave"
        ),
        Alerta(
            "Aumento de carrapatos",
            "Relatos de infestação em áreas rurais. Reforce o controle com produtos recomendados.",
            formatarDataHora(),
            "Moderado"
        ),
        Alerta(
            "Nova vacina disponível",
            "Chegou a vacina atualizada contra raiva bovina. Procure o posto veterinário municipal.",
            formatarDataHora(),
            "Informativo"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Alertas de Doenças") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listaAlertas) { alerta ->
                AlertaCard(alerta)
            }
        }
    }
}

@Composable
fun AlertaCard(alerta: Alerta) {
    val cor = when (alerta.severidade) {
        "Grave" -> MaterialTheme.colorScheme.errorContainer
        "Moderado" -> MaterialTheme.colorScheme.tertiaryContainer
        else -> MaterialTheme.colorScheme.primaryContainer
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = cor)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(alerta.titulo, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(alerta.descricao, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "🕒 ${alerta.dataHora}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatarDataHora(): String {
    val agora = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    return agora.format(formatter)
}
