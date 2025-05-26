package com.nebsan.rickandmorty.domain.mapper

import com.nebsan.rickandmorty.data.remote.dto.CharacterDetailDto
import com.nebsan.rickandmorty.domain.model.CharacterDetailInfo
import com.nebsan.rickandmorty.data.remote.dto.CharacterDto
import com.nebsan.rickandmorty.domain.model.CharacterInfo


object CharactersMapper {

    fun CharacterDto.toDomain(): CharacterInfo {
        return CharacterInfo(id = id, name = name, image = image)
    }

    fun CharacterDetailDto.toDomain(): CharacterDetailInfo {
        return CharacterDetailInfo(
            name = name,
            status = status,
            specie = specie,
            gender = gender,
            image = image,
            episodes = episodes.mapNotNull { episodeUrl ->
                episodeUrl.substringAfterLast("/").toIntOrNull()
            }
        )
    }
}