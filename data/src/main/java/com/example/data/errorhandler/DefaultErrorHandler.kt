package com.example.data.errorhandler

import com.example.domain.error.ErrorEntity
import com.example.domain.error.ErrorHandler
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class DefaultErrorHandler @Inject constructor() : ErrorHandler {

    override fun getError(error: Throwable): ErrorEntity = when(error) {
        is IOException -> ErrorEntity.Network
        is HttpException -> when(error.code()) {
            HttpURLConnection.HTTP_NOT_FOUND -> ErrorEntity.NotFound
            HttpURLConnection.HTTP_FORBIDDEN -> ErrorEntity.AccessDenied
            HttpURLConnection.HTTP_UNAVAILABLE -> ErrorEntity.ServiceUnavailable
            else -> ErrorEntity.Unknown
        }
        else -> ErrorEntity.Unknown
    }
}