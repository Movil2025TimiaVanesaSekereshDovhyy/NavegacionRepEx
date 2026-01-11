package net.iessochoa.vanesa.navegacionrepex.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.vanesa.navegacionrepex.ui.KebabViewModel
import net.iessochoa.vanesa.navegacionrepex.ui.component.PriceSelector
import net.iessochoa.vanesa.navegacionrepex.ui.components.OrderSummaryCard


/**
 * TAREA 4: Completar UI.
 */
@Composable
fun ConfirmationScreen(
    viewModel: KebabViewModel,
    onNewOrder: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(Modifier.padding(16.dp)) {

        //Para que no se cierre la app de golpe hago una comprobación
        if (uiState.currentOrder.item != null) {
            OrderSummaryCard(order = uiState.currentOrder)
        }
        Spacer(Modifier.height(16.dp))

        PriceSelector(
            valor = uiState.currentOrder.quantity.toFloat(),
            onQuantityChange = { viewModel.onQuantityChanged(it.toInt()) }
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                onNewOrder()
                viewModel.onOrderConfirmed()
            }
        ) {
            Text("Confirmar pedido")
        }
    }
}
