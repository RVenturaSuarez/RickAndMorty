package com.nebsan.rickandmorty.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.nebsan.rickandmorty.presentation.ui.characterDetail.CharacterDetailScreen
import com.nebsan.rickandmorty.presentation.ui.charactersInfo.CharactersInfoScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CharactersInfoScreen
    ) {
        composable<CharactersInfoScreen> {
            CharactersInfoScreen(
                onNavigateToDetail = { characterId ->
                    navController.navigate(CharacterDetailScreen(characterId))
                },
            )
        }

        composable<CharacterDetailScreen> {
            val args = it.toRoute<CharacterDetailScreen>()
            CharacterDetailScreen(
                characterId = args.characterId,
                onBack = { navController.popBackStack() })
        }
    }
}

