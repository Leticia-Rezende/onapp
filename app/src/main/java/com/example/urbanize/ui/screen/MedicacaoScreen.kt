package com.example.urbanize.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.MoveToInbox
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            .background(Color(0xffd5d69d)) // Cor de Fundo
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MedicacaoScreenTopBar(backgroundColor = Color(0xffffffff))
        Spacer(modifier = Modifier.height(32.dp))

        // 2. Grid com os Cards
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // Define que teremos 2 colunas
            verticalArrangement = Arrangement.spacedBy(16.dp), // Espaço vertical entre os cards
            horizontalArrangement = Arrangement.spacedBy(16.dp) // Espaço horizontal
        ) {
            items(actionItems.size) { index ->
                val item = actionItems[index]
                ActionCardMedicacao(
                    item = item,
                    (Color(0xff9b7a37)), //Cor de fundo dos Cards
                    onClick = {
                        // TODO: Lógica de navegação para a tela de "Cadastrar", "Consultar", etc.
                        println("Clicou em ${item.label}")
                    }
                )
            }

        }
    }
}

@Composable
fun ActionCardMedicacao(item: MedicacaoActionItem, backgroundColor: Color, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        modifier = Modifier
            .aspectRatio(1f) // Garante que o card seja um quadrado
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = item.label,
                modifier = Modifier.size(50.dp),
                tint = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.label,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun MedicacaoScreenTopBar(backgroundColor: Color) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(50),
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.Black)
            }
            Text(
                text = "Medicação",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Icon(Icons.Default.Medication, contentDescription = "Ícone de medicação", tint = Color.Black)
        }
    }
}
