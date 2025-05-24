package com.nebsan.rickandmorty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.nebsan.rickandmorty.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
@HiltViewModel
class CharactersViewModel @Inject constructor(getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {

    private val _characterName = MutableStateFlow("")
    val characterName: StateFlow<String> = _characterName

    val characters = characterName
        .debounce(300)
        .flatMapLatest { name ->
            getCharactersUseCase(name)
        }

    fun onCharacterNameChanged(newName: String) {
        _characterName.value = newName
    }
}