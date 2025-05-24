package com.nebsan.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.nebsan.rickandmorty.data.remote.dto.CharacterDto
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getCharacters(): Flow<PagingData<CharacterDto>>
}