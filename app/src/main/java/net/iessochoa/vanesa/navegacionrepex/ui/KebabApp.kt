package net.iessochoa.vanesa.navegacionrepex.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController


@Composable
fun KebabApp() {
    val navController = rememberNavController()

    Scaffold { padding ->
        KebabNavHost(
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}
