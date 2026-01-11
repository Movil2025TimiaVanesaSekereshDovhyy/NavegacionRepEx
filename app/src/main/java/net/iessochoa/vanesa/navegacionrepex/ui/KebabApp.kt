package net.iessochoa.vanesa.navegacionrepex.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.iessochoa.vanesa.navegacionrepex.ui.navegation.KebabNavHost
import net.iessochoa.vanesa.navegacionrepex.ui.navegation.MenuPrincipal
import net.iessochoa.vanesa.navegacionrepex.ui.navegation.Resumen


@Composable
fun KebabApp(
    viewModel: KebabViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    // Lógica para decidir qué título mostrar según la ruta donde estemos
    val currentScreenTitle = when (currentRoute) {
        MenuPrincipal.route -> stringResource(MenuPrincipal.titleRes)
        Resumen.route -> stringResource(Resumen.titleRes)
        else -> stringResource(MenuPrincipal.titleRes)
    }




    Scaffold { padding ->
        KebabNavHost(
            navController = navController,
            modifier = Modifier.padding(padding),
            viewModel = viewModel
        )
    }
}
