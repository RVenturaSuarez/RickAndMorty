package com.nebsan.rickandmorty.domain.repository

import com.nebsan.rickandmorty.data.remote.dto.CharactersResponseDto

interface CharactersRepository {
    suspend fun getCharacters(): CharactersResponseDto
}