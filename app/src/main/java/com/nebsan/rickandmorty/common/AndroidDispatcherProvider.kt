package com.nebsan.rickandmorty.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AndroidDispatcherProvider(override val io: CoroutineDispatcher = Dispatchers.IO) :
    DispatcherProvider