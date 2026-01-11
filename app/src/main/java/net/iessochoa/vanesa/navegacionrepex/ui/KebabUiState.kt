package net.iessochoa.vanesa.navegacionrepex.ui

import net.iessochoa.vanesa.navegacionrepex.model.MenuItem
import net.iessochoa.vanesa.navegacionrepex.model.Order


/**
 * Estado de la UI.
 * Ya definido. NO TOCAR.
 */
data class KebabUiState(
    val menu: List<MenuItem> = emptyList(),
    val currentOrder: Order = Order(),
)
