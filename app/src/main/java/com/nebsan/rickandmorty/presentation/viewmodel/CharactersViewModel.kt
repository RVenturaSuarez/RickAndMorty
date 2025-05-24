package com.nebsan.rickandmorty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nebsan.rickandmorty.domain.model.CharacterInfo
import com.nebsan.rickandmorty.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(getCharactersUseCase: GetCharactersUseCase) :
    ViewModel() {

    val characters: Flow<PagingData<CharacterInfo>> =
        getCharactersUseCase()
            .cachedIn(viewModelScope)
}