package com.nebsan.rickandmorty.domain.mapper

import com.nebsan.rickandmorty.data.remote.dto.CharacterDto
import com.nebsan.rickandmorty.domain.model.CharacterInfo


object CharactersMapper {

    fun CharacterDto.toDomain(): CharacterInfo {
        return CharacterInfo(id = id, name = name, image = image)
    }
}