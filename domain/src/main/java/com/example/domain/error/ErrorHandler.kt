package com.example.domain.error

interface ErrorHandler {

    fun getError(error: Throwable): ErrorEntity
}