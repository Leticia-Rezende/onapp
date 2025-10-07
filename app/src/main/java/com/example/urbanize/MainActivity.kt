package com.example.urbanize


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.MedicalInformation
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.urbanize.ui.screen.AnimalsScreen
import com.example.urbanize.ui.screen.DoencasScreen
import com.example.urbanize.ui.screen.MedicacaoScreen
import com.example.urbanize.ui.screen.BatePapoScreen
import com.example.urbanize.ui.theme.UrbanizeTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.urbanize.ui.screen.CadastroAnimalScreen
import com.example.urbanize.ui.screen.ConsultarAnimalScreen
import com.example.urbanize.ui.screen.RelatorioAnimalScreen
import com.example.urbanize.ui.screen.TratamentoAnimalScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UrbanizeTheme {
                HomeScreen()
                }
            }
        }
    }
data class BottomNavItem(
    val label: String,
    val icon: ImageVector
)
@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val items = listOf(
                    BottomNavItem("Animais", Icons.Filled.Pets),
                    BottomNavItem("Doenças", Icons.Filled.MedicalInformation),
                    BottomNavItem("Medicação", Icons.Filled.Medication),
                    BottomNavItem("Bate-Papo", Icons.Filled.Chat)
                )

                var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            when (index) {
                                0 -> navController.navigate("animais")
                                1 -> navController.navigate("doencas")
                                2 -> navController.navigate("medicacao")
                                3 -> navController.navigate("batepapo")
                            }
                        },
                        label = { Text(text = item.label) },
                        icon = {
                            Icon(imageVector = item.icon, contentDescription = item.label)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "animais",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("animais") { AnimalsScreen(navController) }
            composable("doencas") { DoencasScreen() }
            composable("medicacao") { MedicacaoScreen() }
            composable("batepapo") { BatePapoScreen() }

            // Nova rota para os cards
            composable("cadastroAnimal") { CadastroAnimalScreen(navController) }
            composable("consultarAnimal") { ConsultarAnimalScreen(navController) }
            composable("relatorioAnimal") { RelatorioAnimalScreen(navController) }
            composable("tratamentoAnimal") { TratamentoAnimalScreen(navController) }
        }
    }
}





