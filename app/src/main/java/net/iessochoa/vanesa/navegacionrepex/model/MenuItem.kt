package net.iessochoa.vanesa.navegacionrepex.model

import androidx.annotation.DrawableRes

/**
 * Modelo de un producto del menú.
 * NO TOCAR.
 */
data class MenuItem(
    val id: Int,
    val name: String,
    val basePrice: Double,
    @DrawableRes val imageResId: Int
)
