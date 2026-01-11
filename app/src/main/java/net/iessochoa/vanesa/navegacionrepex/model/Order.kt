package net.iessochoa.vanesa.navegacionrepex.model

/**
 * Modelo del pedido actual.
 * Inmutable → usar copy() para actualizar.
 * NO TOCAR.
 */
data class Order(
    val item: MenuItem? = null,
    val quantity: Int = 1,
    val extraSauce: Boolean = false,
    val extraMeat: Boolean = false,
    val totalPrice: Double = 0.0
)
