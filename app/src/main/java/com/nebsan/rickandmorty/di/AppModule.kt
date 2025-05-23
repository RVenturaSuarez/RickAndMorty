package com.nebsan.rickandmorty.di

import com.nebsan.rickandmorty.data.remote.CharactersApi
import com.nebsan.rickandmorty.data.repository.CharactersRepositoryImpl
import com.nebsan.rickandmorty.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCharactersApi(): CharactersApi {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharactersRepository(charactersApi: CharactersApi): CharactersRepository {
        return CharactersRepositoryImpl(charactersApi)
    }

}