package com.nebsan.rickandmorty.data.remote

import com.nebsan.rickandmorty.data.remote.dto.CharacterDetailDto
import com.nebsan.rickandmorty.data.remote.dto.CharactersResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CharactersApi {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int = 1,
        @Query("name") name: String? = null,
    ): CharactersResponseDto

    @GET("character/{id}")
    suspend fun getCharacterDetailInfo(@Path("id") characterId: Int): CharacterDetailDto
}