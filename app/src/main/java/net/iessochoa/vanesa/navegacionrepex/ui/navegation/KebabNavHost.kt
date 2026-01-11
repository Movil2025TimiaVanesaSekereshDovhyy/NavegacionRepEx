package net.iessochoa.vanesa.navegacionrepex.ui.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.vanesa.navegacionrepex.ui.KebabViewModel
import net.iessochoa.vanesa.navegacionrepex.ui.screens.ConfirmationScreen
import net.iessochoa.vanesa.navegacionrepex.ui.screens.OrderScreen

@Composable
fun KebabNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: KebabViewModel
) {
    NavHost(
        navController = navController,
        startDestination = MenuPrincipal.route,
        modifier = modifier
    ) {
        composable(MenuPrincipal.route) {
            OrderScreen(
                viewModel = viewModel,
                onNavigateToConfirmation = {
                    navController.navigate(Resumen.route)
                }
            )
        }

        composable(Resumen.route) {
            ConfirmationScreen(
                viewModel = viewModel,
                onNewOrder = { navController.popBackStack() }
            )
        }
    }
}
