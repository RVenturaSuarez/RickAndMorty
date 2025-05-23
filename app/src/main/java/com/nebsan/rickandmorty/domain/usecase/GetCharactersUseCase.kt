package com.nebsan.rickandmorty.domain.usecase

import com.nebsan.rickandmorty.domain.mapper.CharactersMapper.toDomain
import com.nebsan.rickandmorty.domain.model.CharacterInfo
import com.nebsan.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend operator fun invoke(): List<CharacterInfo> {
        val characters = charactersRepository.getCharacters().results
        return characters.map { characterDto ->
            characterDto.toDomain()
        }
    }
}