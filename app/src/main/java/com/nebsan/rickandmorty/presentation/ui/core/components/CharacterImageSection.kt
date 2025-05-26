package com.nebsan.rickandmorty.presentation.ui.core.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.nebsan.rickandmorty.R

@Composable
fun CharacterImageSection(image: String) {
    AsyncImage(
        model = image,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.place_holder_character),
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(300.dp)
    )
}

