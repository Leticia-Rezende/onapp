package com.example.urbanize.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class AnimalActionItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun AnimalsScreen(navController: NavController) {
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
        AnimalScreenTopBar(backgroundColor = Color(0xffffffff))
        Spacer(modifier = Modifier.height(32.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(actionItems.size) { index ->
                val item = actionItems[index]
                ActionCardAnimals(
                    item = item,
                    backgroundColor = Color(0xffffffff),
                    onClick = {
                        when (item.label) {
                            "Cadastrar" -> navController.navigate("cadastroAnimal")
                            "Consultar" -> navController.navigate("consultarAnimal")
                            "Relatório" -> navController.navigate("relatorioAnimal")
                            "Tratamento" -> navController.navigate("tratamentoAnimal")
                            // você pode adicionar outras rotas aqui se quiser
                            else -> println("Clicou em ${item.label}")
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun ActionCardAnimals(item: AnimalActionItem, backgroundColor: Color, onClick: () -> Unit) {
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
fun AnimalScreenTopBar(backgroundColor: Color) {
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
                text = "Animais",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Icon(Icons.Default.Pets, contentDescription = "Ícone de animal", tint = Color.Black)
        }
    }
}



