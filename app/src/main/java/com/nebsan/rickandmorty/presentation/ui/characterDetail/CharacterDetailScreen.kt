package com.nebsan.rickandmorty.presentation.ui.characterDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nebsan.rickandmorty.R
import com.nebsan.rickandmorty.presentation.ui.characterDetail.components.CharacterAttributeSection
import com.nebsan.rickandmorty.presentation.ui.characterDetail.components.EpisodesSection
import com.nebsan.rickandmorty.presentation.ui.characterDetail.components.TopBarDetailCharacter
import com.nebsan.rickandmorty.presentation.ui.core.components.CharacterImageSection
import com.nebsan.rickandmorty.presentation.viewmodel.CharacterDetailViewModel

@Composable
fun CharacterDetailScreen(
    characterDetailViewModel: CharacterDetailViewModel = hiltViewModel(),
    characterId: Int,
    onBack: () -> Unit,
) {
    val uiState by characterDetailViewModel.characterDetailState.collectAsState()

    LaunchedEffect(Unit) {
        characterDetailViewModel.getInfoCharacter(characterId)
    }


    Scaffold(topBar = {
        TopBarDetailCharacter(
            characterName = if (uiState is CharacterDetailUiState.Success) (uiState as CharacterDetailUiState.Success).character.name else "",
            onBack = {
                onBack()
                characterDetailViewModel.clearInfoCharacter()
            }
        )
    }) { paddingValues ->
        when (uiState) {
            is CharacterDetailUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is CharacterDetailUiState.Success -> {
                val character = (uiState as CharacterDetailUiState.Success).character
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    CharacterImageSection(image = character.image)
                    CharacterAttributeSection(character.status)
                    CharacterAttributeSection(character.specie)
                    CharacterAttributeSection(character.gender)

                    if (character.episodes.isNotEmpty()) {
                        EpisodesSection(episodes = character.episodes)
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                }
            }

            is CharacterDetailUiState.Error -> {
                val error = (uiState as CharacterDetailUiState.Error).message
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = error, color = Color.Red, textAlign = TextAlign.Center)
                    Button(onClick = { characterDetailViewModel.getInfoCharacter(characterId) }) {
                        Text(text = stringResource(id = R.string.btn_retry))
                    }
                }
            }
        }

    }
}



