package net.iessochoa.vanesa.navegacionrepex.ui.navegation

import net.iessochoa.vanesa.navegacionrepex.R

object MenuPrincipal : NavigationDestination {
     // TODO: Implementa las propiedades de la interfaz para la pantalla de lista
     // Pista: La ruta puede ser "menu_list"

     override val route = "menu_list"
     override val titleRes = R.string.app_name
}

object Resumen : NavigationDestination {

     override val route = "summary"
     override val titleRes = R.string.summary
}