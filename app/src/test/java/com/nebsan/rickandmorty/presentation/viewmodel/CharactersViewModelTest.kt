package com.nebsan.rickandmorty.presentation.viewmodel

import com.nebsan.rickandmorty.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class CharactersViewModelTest {

    private lateinit var viewModel: CharactersViewModel
    private val getCharactersUseCase = mock<GetCharactersUseCase>()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = CharactersViewModel(getCharactersUseCase)
    }


    @Test
    fun `onCharacterNameChanged set name correctly`() {
        // WHEN
        viewModel.onCharacterNameChanged("Rick")

        // THEN
        assertTrue(viewModel.characterName.value == "Rick")
    }

}