package com.nebsan.rickandmorty.presentation.ui.characterDetail

import com.nebsan.rickandmorty.domain.model.CharacterDetailInfo

sealed class CharacterDetailUiState {
    data object Loading : CharacterDetailUiState()
    data class Success(val character: CharacterDetailInfo) : CharacterDetailUiState()
    data class Error(val message: String) : CharacterDetailUiState()
}