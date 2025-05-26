package com.nebsan.rickandmorty.domain.usecase

import com.nebsan.rickandmorty.domain.mapper.CharactersMapper.toDomain
import com.nebsan.rickandmorty.domain.model.CharacterDetailInfo
import com.nebsan.rickandmorty.domain.repository.CharactersRepository
import javax.inject.Inject

class GetCharacterDetailInfoUseCase @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend operator fun invoke(characterId: Int): Result<CharacterDetailInfo> {
        return charactersRepository.getCharacterDetailInfo(characterId).map { characterDetailDto ->
            characterDetailDto.toDomain()
        }
    }
}