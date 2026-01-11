package net.iessochoa.vanesa.navegacionrepex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.iessochoa.vanesa.navegacionrepex.model.Order

/**
 * TAREA 4: Maquetar en Row.
 */
@Composable
fun OrderSummaryCard(
    order: Order,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {

        // TODO: Cambiar Column por Row
        Column(Modifier.padding(8.dp)) {

            Image(
                painter = painterResource(order.item?.imageResId ?: 0),
                contentDescription = order.item?.name,
                modifier = Modifier.size(80.dp)
            )

            Column {
                Text(order.item?.name ?: "")
                Text("Cantidad: ${order.quantity}")
                Text("Total: ${order.totalPrice} €")
            }
        }
    }
}
