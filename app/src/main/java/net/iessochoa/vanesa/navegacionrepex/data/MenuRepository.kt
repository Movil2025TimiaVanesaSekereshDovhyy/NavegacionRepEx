package net.iessochoa.vanesa.navegacionrepex.data

import android.view.MenuItem
import net.iessochoa.vanesa.navegacionrepex.R

/**
 * Repositorio simulado para el menú del kiosco.
 * Actúa como fuente de verdad única (Single Source of Truth).
 * NO TOCAR.
 */
object MenuRepository {
    private val menu = listOf(
        MenuItem(
            id = 1,
            name = "Kebab Clásico",
            basePrice = 5.0,
            imageResId = R.drawable.kebab
        ),
        MenuItem(
            id = 2,
            name = "Durum Completo",
            basePrice = 6.5,
            imageResId = R.drawable.durum
        ),
        MenuItem(
            id = 3,
            name = "Falafel Vegano",
            basePrice = 4.5,
            imageResId = R.drawable.falafel
        ),
        MenuItem(
            id = 4,
            name = "Patatas Especiales",
            basePrice = 3.0,
            imageResId = R.drawable.fries
        ),
        MenuItem(
            id = 5,
            name = "Refresco",
            basePrice = 1.5,
            imageResId = R.drawable.soda
        )
    )

    fun getMenu(): List<MenuItem> = menu
}
