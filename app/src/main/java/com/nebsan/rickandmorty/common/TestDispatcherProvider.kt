package com.nebsan.rickandmorty.common

import kotlinx.coroutines.CoroutineDispatcher

class TestDispatcherProvider(override val io: CoroutineDispatcher) : DispatcherProvider