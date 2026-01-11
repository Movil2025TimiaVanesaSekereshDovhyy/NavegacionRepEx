package net.iessochoa.vanesa.navegacionrepex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.vanesa.navegacionrepex.data.MenuRepository
import net.iessochoa.vanesa.navegacionrepex.model.Order
import net.iessochoa.vanesa.navegacionrepex.ui.theme.NavegacionRepExTheme

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
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Imagen del producto
            Image(
                painter = painterResource(order.item?.imageResId ?: 0),
                contentDescription = order.item?.name,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.size(12.dp))


            //Datos del pedido
            Column(modifier = Modifier.weight(1f)) {
                Text(order.item?.name ?: "")
                Text("Cantidad: ${order.quantity}")
                Text("Total: ${order.totalPrice} €")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderSummaryCardPreview() {

    //Obtenemos un item cualquiera del menú
    val item = MenuRepository.getMenu().first()

    //Creamos un pedido falso para el preview
    val fakeOrder = Order(
        item = item,
        quantity = 2
    )

    NavegacionRepExTheme {
        OrderSummaryCard(
            order = fakeOrder,
            modifier = Modifier.padding(16.dp)
        )
    }
}
