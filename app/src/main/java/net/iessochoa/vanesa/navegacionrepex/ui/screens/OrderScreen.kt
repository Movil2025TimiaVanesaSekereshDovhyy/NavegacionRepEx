package net.iessochoa.vanesa.navegacionrepex.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import net.iessochoa.vanesa.navegacionrepex.ui.KebabViewModel
import net.iessochoa.vanesa.navegacionrepex.ui.components.MenuItemCard


/**
 * TAREA 2: Refactorizar para usar ViewModel.
 */
@Composable
fun OrderScreen(
    viewModel: KebabViewModel,
    onNavigateToConfirmation: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn {
        items(uiState.menu) { item ->
            MenuItemCard(
                item = item,
                onClick = {
                    viewModel.onItemSelected(item)
                    onNavigateToConfirmation()
                }
            )
        }
    }
}
