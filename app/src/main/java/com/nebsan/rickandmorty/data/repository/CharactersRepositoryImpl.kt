package com.nebsan.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nebsan.rickandmorty.common.DispatcherProvider
import com.nebsan.rickandmorty.data.paging.CharacterPagingSource
import com.nebsan.rickandmorty.data.remote.CharactersApi
import com.nebsan.rickandmorty.data.remote.dto.CharacterDetailDto
import com.nebsan.rickandmorty.data.remote.dto.CharacterDto
import com.nebsan.rickandmorty.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val charactersApi: CharactersApi,
    private val dispatcherProvider: DispatcherProvider,
) :
    CharactersRepository {

    companion object {
        const val PAGE_SIZE = 20
        const val PREFETCH_ITEMS = 3
    }


    override fun getCharacters(characterName: String?): Flow<PagingData<CharacterDto>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                CharacterPagingSource(charactersApi, characterName)
            }).flow
    }

    override suspend fun getCharacterDetailInfo(characterId: Int): Result<CharacterDetailDto> {
        return runCatching {
            withContext(dispatcherProvider.io) {
                charactersApi.getCharacterDetailInfo(characterId)
            }
        }
    }
}