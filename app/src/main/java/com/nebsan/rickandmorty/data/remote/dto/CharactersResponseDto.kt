package com.nebsan.rickandmorty.data.remote.dto

data class CharactersResponseDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)
