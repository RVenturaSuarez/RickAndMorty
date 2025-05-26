package com.nebsan.rickandmorty.presentation.viewmodel

import com.nebsan.rickandmorty.domain.model.CharacterDetailInfo
import com.nebsan.rickandmorty.domain.usecase.GetCharacterDetailInfoUseCase
import com.nebsan.rickandmorty.presentation.ui.characterDetail.CharacterDetailUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class CharactersDetailViewModelTest {

    private lateinit var viewModel: CharacterDetailViewModel
    private val getCharacterDetailInfoUseCase = mock<GetCharacterDetailInfoUseCase>()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = CharacterDetailViewModel(getCharacterDetailInfoUseCase)
    }


    @Test
    fun `getInfoCharacter update state to Success when UseCase returns data`() = runTest {
        // GIVEN
        val characterId = 1
        val characterDetailInfo = CharacterDetailInfo(
            name = "Rick Sanchez",
            status = "Alive",
            specie = "Human",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episodes = listOf(1, 2)
        )
        val result = Result.success(characterDetailInfo)

        whenever(getCharacterDetailInfoUseCase(characterId)).thenReturn(
            result
        )

        // WHEN
        viewModel.getInfoCharacter(characterId)
        advanceUntilIdle()

        // THEN
        assertTrue(viewModel.characterDetailState.value is CharacterDetailUiState.Success)
        assertEquals(
            (viewModel.characterDetailState.value as CharacterDetailUiState.Success).character,
            characterDetailInfo
        )
    }

    @Test
    fun `getInfoCharacter update state to Error when UseCase returns failure`() = runTest {
        // GIVEN
        val characterId = 1
        val result = Result.failure<CharacterDetailInfo>(Exception("Error loading character"))

        whenever(getCharacterDetailInfoUseCase(characterId)).thenReturn(
            result
        )

        // WHEN
        viewModel.getInfoCharacter(characterId)
        advanceUntilIdle()

        // THEN
        assertTrue(viewModel.characterDetailState.value is CharacterDetailUiState.Error)
        assertEquals(
            (viewModel.characterDetailState.value as CharacterDetailUiState.Error).message,
            "Error: Error loading character"
        )
    }

    @Test
    fun `clearInfoCharacter set state to Loading`() = runTest {
        // WHEN
        viewModel.clearInfoCharacter()

        // THEN
        assertTrue(viewModel.characterDetailState.value is CharacterDetailUiState.Loading)
    }

}