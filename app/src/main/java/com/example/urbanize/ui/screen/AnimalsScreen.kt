package com.example.urbanize.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AnimalActionItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun AnimalsScreen() {
    // Lista de ações para os cards
    val actionItems = listOf(
        AnimalActionItem("Cadastrar", Icons.Default.PostAdd),
        AnimalActionItem("Consultar", Icons.Default.Search),
        AnimalActionItem("Relatório", Icons.Default.Assessment),
        AnimalActionItem("Tratamento", Icons.Default.Vaccines)
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
fun AnimalScreenTopBar(backgroundColor: Color) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(50), // Cantos bem arredondados
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* TODO: Ação de voltar */ }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Voltar", tint = Color.Black)
            }
            Text(
                text = "Animais",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f) // Ocupa o espaço restante
            )
            // Nota: O ícone de boi/vaca não está no pacote padrão.
            // Usei 'Pets' como substituto. Você pode usar um ícone personalizado.
            Icon(Icons.Default.Pets, contentDescription = "Ícone de animal", tint = Color.Black)
        }
    }
}

@Composable
fun ActionCard(item: AnimalActionItem, backgroundColor: Color, onClick: () -> Unit) {
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
fun AnimalsScreen(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Tela de $name")
    }
}

