package net.iessochoa.vanesa.navegacionrepex.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.vanesa.navegacionrepex.data.MenuRepository
import net.iessochoa.vanesa.navegacionrepex.model.MenuItem
import net.iessochoa.vanesa.navegacionrepex.model.Order

class KebabViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(KebabUiState())
    val uiState: StateFlow<KebabUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                menu = MenuRepository.getMenu()
            )
        }
    }

    // TAREA 1.1 — Seleccionar item
    fun onItemSelected(item: MenuItem) {
        _uiState.update { currentState ->
            currentState.copy(
                currentOrder = currentState.currentOrder.copy(
                    item = item,
                    quantity = 1,
                    extraSauce = false,
                    extraMeat = false,
                    totalPrice = item.basePrice
                )
            )
        }
    }

    // TAREA 1.2 — Cambiar cantidad
    fun onQuantityChanged(newQuantity: Int) {
        _uiState.update { currentState ->
            val order = currentState.currentOrder
            val item = order.item

            currentState.copy(
                currentOrder = order.copy(
                    quantity = newQuantity,
                    totalPrice = calculatePrice(
                        item = item,
                        quantity = newQuantity,
                        extraSauce = order.extraSauce,
                        extraMeat = order.extraMeat
                    )
                )
            )
        }
    }

    // Extras
    fun onExtraChanged(extraSauce: Boolean? = null, extraMeat: Boolean? = null) {
        _uiState.update { currentState ->
            val order = currentState.currentOrder

            val newSauce = extraSauce ?: order.extraSauce
            val newMeat = extraMeat ?: order.extraMeat

            currentState.copy(
                currentOrder = order.copy(
                    extraSauce = newSauce,
                    extraMeat = newMeat,
                    totalPrice = calculatePrice(
                        item = order.item,
                        quantity = order.quantity,
                        extraSauce = newSauce,
                        extraMeat = newMeat
                    )
                )
            )
        }
    }

    // Recalcular precio total
    fun onPriceRecalculated() {
        _uiState.update { currentState ->
            val order = currentState.currentOrder
            currentState.copy(
                currentOrder = order.copy(
                    totalPrice = calculatePrice(
                        item = order.item,
                        quantity = order.quantity,
                        extraSauce = order.extraSauce,
                        extraMeat = order.extraMeat
                    )
                )
            )
        }
    }

    // TAREA 1.3 — Confirmar pedido
    fun onOrderConfirmed() {
        _uiState.update { currentState ->
            currentState.copy(
                currentOrder = Order() // reset
            )
        }
    }

    // Función interna para calcular precio
    private fun calculatePrice(
        item: MenuItem?,
        quantity: Int,
        extraSauce: Boolean,
        extraMeat: Boolean
    ): Double {
        if (item == null){
            return 0.0
        }

        var price = item.basePrice * quantity

        if (extraSauce){
            price += 0.50 * quantity
        }
        if (extraMeat){
            price += 1.00 * quantity
        }

        return price
    }
}
