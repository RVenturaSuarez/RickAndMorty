package com.nebsan.rickandmorty.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io: CoroutineDispatcher
}