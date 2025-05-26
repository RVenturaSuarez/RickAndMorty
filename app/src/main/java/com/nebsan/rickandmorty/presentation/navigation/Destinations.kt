package com.nebsan.rickandmorty.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object CharactersInfoScreen

@Serializable
data class CharacterDetailScreen(val characterId: Int)