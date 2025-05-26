package com.nebsan.rickandmorty.domain.model

sealed class ResponseError : Throwable() {
    data object NotFound : ResponseError()
    data object Network : ResponseError()
    data class HttpError(val code: Int) : ResponseError()
}