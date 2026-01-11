package net.iessochoa.vanesa.navegacionrepex

import android.R.style.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import net.iessochoa.vanesa.navegacionrepex.ui.theme.NavegacionRepExTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavegacionRepExTheme {
                KebabApp()
            }
        }
    }
}