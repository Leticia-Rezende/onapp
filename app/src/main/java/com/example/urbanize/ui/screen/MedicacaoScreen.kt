package com.example.urbanize.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.MoveToInbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class MedicacaoActionItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun MedicacaoScreen() {
    // Lista de ações para os cards
    val actionItems = listOf(
        MedicacaoActionItem("Reposição", Icons.Default.AddBox),
        MedicacaoActionItem("Estoque", Icons.Default.MoveToInbox),
        MedicacaoActionItem("Alertas", Icons.Default.AddAlert),
        MedicacaoActionItem("Relatório", Icons.Default.Assessment)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()

            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(32.dp))

        // 2. Grid com os Cards
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Define que teremos 2 colunas
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espaço vertical entre os cards
            horizontalArrangement = Arrangement.spacedBy(16.dp) // Espaço horizontal
        ) {

        }
    }
}
@Composable
fun MedicacaoScreen(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Tela de $name")
    }
}