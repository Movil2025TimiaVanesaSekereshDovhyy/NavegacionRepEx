package net.iessochoa.vanesa.navegacionrepex.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.iessochoa.vanesa.navegacionrepex.data.MenuRepository


class KebabViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        KebabUiState(
            menu = MenuRepository.getMenu()
        )
    )
    val uiState: StateFlow<KebabUiState> = _uiState

    // TODO TAREA 1.1
    fun onItemSelected(itemId: Int) {
        // cargar item en currentOrder
    }

    // TODO TAREA 1.2
    fun onQuantityChanged(newQuantity: Int) {
        // actualizar cantidad
    }

    fun onExtraChanged(extraSauce: Boolean? = null, extraMeat: Boolean? = null) {
        // actualizar extras
    }

    fun onPriceRecalculated() {
        // recalcular precio total
    }

    // TODO TAREA 1.3
    fun onOrderConfirmed() {
        // guardar pedido y resetear estado
    }
}
