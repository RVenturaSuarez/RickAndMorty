package com.nebsan.rickandmorty.presentation.ui.characterDetail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CharacterAttributeSection(attribute: String) {
    Card(
        colors = CardDefaults.cardColors(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = attribute, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}


@Composable
@Preview
fun CharacterAttributeSectionPreview() {
    val attribute = "Alive"
    Card(
        colors = CardDefaults.cardColors(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = attribute, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
    }
}