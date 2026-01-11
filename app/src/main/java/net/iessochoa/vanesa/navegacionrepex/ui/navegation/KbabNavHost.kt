package net.iessochoa.vanesa.navegacionrepex.ui.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.iessochoa.vanesa.navegacionrepex.ui.KebabViewModel

@Composable
fun KebabNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: KebabViewModel = KebabViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.ORDER,
        modifier = modifier
    ) {
        composable(Destinations.ORDER) {
            OrderScreen(
                viewModel = viewModel,
                onNavigateToConfirmation = {
                    navController.navigate(Destinations.CONFIRMATION)
                }
            )
        }

        composable(Destinations.CONFIRMATION) {
            ConfirmationScreen(
                viewModel = viewModel,
                onNewOrder = { navController.popBackStack() }
            )
        }
    }
}
