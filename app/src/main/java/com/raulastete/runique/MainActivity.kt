package com.raulastete.runique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.raulastete.auth.presentation.register.RegisterScreen
import com.raulastete.core.presentation.designsystem.RuniqueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RuniqueTheme {
                RegisterScreen(
                    onSignInClick = {},
                    onSuccessfulRegistration = {}
                )
            }
        }
    }
}
