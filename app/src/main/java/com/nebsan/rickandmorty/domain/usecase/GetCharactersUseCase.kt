package com.nebsan.rickandmorty.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.nebsan.rickandmorty.domain.mapper.CharactersMapper.toDomain
import com.nebsan.rickandmorty.domain.model.CharacterInfo
import com.nebsan.rickandmorty.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val charactersRepository: CharactersRepository) {

    operator fun invoke(characterName: String?): Flow<PagingData<CharacterInfo>> {
        return charactersRepository.getCharacters(characterName)
            .map { pagingData ->
                pagingData.map { characterDto -> characterDto.toDomain() }
            }
    }
}