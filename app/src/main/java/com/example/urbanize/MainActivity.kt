package com.example.urbanize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urbanize.ui.screen.*
import com.example.urbanize.ui.theme.UrbanizeTheme

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
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) }
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

            // -------------------------------
            // 🐮 Rotas da aba Animais
            // -------------------------------
            composable("animais") { AnimalsScreen(navController) }
            composable("cadastroAnimal") {
                CadastroAnimalScreen(
                    navController = navController,
                    onSaveClicked = {
                        navController.navigate("cadastroSucessoAnimal")
                    }
                )
            }
            composable("consultarAnimal") { ConsultarAnimalScreen(navController) }
            composable("relatorioAnimal") { RelatorioAnimalScreen(navController) }
            composable("tratamentoAnimal") { TratamentoAnimalScreen(navController) }

            composable("cadastroSucessoAnimal") {
                CadastroSalvoAnimalScreen(
                    onBackToHome = {
                        navController.popBackStack(route = "animais", inclusive = false)
                    }
                )
            }

            // 🆕 NOVA ROTA – detalhes do animal selecionado
            composable("detalheAnimal/{nomeAnimal}") { backStackEntry ->
                val nomeAnimal = backStackEntry.arguments?.getString("nomeAnimal")
                DetalheAnimalScreen(nomeAnimal, navController)
            }

            // -------------------------------
            // 💉 Rotas da aba Doenças
            // -------------------------------
            composable("doencas") { DoencasScreen(navController) }
            composable("inserirDoenca") {
                InserirDoencaScreen(
                    navController = navController,
                    onSaveClicked = {
                        navController.navigate("cadastroSucessoDoenca")
                    }
                )
            }
            composable("alertasDoenca") { AlertasDoencasScreen(navController) }
            composable("cadastroSucessoDoenca") {
                CadastroSalvoAnimalScreen(
                    onBackToHome = {
                        navController.popBackStack(route = "doencas", inclusive = false)
                    }
                )
            }

            // -------------------------------
            // 💊 Rotas da aba Medicação
            // -------------------------------
            composable("medicacao") { MedicacaoScreen(navController) }

            // -------------------------------
            // 💬 Rotas da aba Bate-Papo
            // -------------------------------
            composable("batepapo") { BatePapoScreen() }
        }
    }
}
