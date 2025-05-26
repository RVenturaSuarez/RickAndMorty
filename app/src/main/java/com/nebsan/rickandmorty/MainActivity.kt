package com.nebsan.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nebsan.rickandmorty.presentation.navigation.AppNavigation
import com.nebsan.rickandmorty.ui.theme.RickAndMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme(darkTheme = true) {
                AppNavigation()
            }
        }
    }
}
