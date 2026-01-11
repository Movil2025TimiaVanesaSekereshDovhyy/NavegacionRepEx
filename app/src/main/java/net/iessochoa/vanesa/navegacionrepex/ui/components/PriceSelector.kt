package net.iessochoa.vanesa.navegacionrepex.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Componente ROTO.
 * TAREA 4: Implementar Slider y conectar con ViewModel.
 */
@Composable
fun PriceSelector(
    quantity: Int,
    onQuantityChange: (Int) -> Unit
) {
    Column(Modifier.padding(8.dp)) {
        Text("Cantidad")
        Spacer(Modifier.height(8.dp))

        // TODO: Slider funcional
        Slider(
            value = 0f, // MAL
            onValueChange = { /* TODO */ },
            valueRange = 0f..5f,
            steps = 4
        )
    }
}
