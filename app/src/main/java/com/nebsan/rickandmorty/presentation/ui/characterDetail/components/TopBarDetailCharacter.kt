package com.nebsan.rickandmorty.presentation.ui.characterDetail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDetailCharacter(characterName: String, onBack: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = characterName) },
        navigationIcon = {
            IconButton(onClick = { onBack() }) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
            }
        },
        modifier = Modifier.padding(horizontal = 20.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun TopBarDetailCharacterPreview() {

    val characterName = "Rick Sanchez"

    CenterAlignedTopAppBar(
        title = { Text(text = characterName) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
            }
        },
        modifier = Modifier.padding(horizontal = 20.dp)
    )
}

