package com.nebsan.rickandmorty.data.repository

import com.nebsan.rickandmorty.data.remote.CharactersApi
import com.nebsan.rickandmorty.data.remote.dto.CharactersResponseDto
import com.nebsan.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(private val charactersApi: CharactersApi) :
    CharactersRepository {

    override suspend fun getCharacters(): CharactersResponseDto {
        return charactersApi.getCharacters()
    }
}