package com.example.domain.models.wrappers

import com.example.domain.error.ErrorEntity
import com.example.domain.error.ErrorHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: ErrorEntity) : Result<Nothing>()

    inline fun onSuccess(block: (T) -> Unit): Result<T> {
        if (this is Success) block(data)
        return this
    }

    inline fun onError(block: (ErrorEntity) -> Unit): Result<T> {
        if (this is Error) block(error)
        return this
    }
}

fun <T> Flow<T>.asResult(errorHandler: ErrorHandler): Flow<Result<T>> = map<T, Result<T>> { Result.Success(it) }
    .onStart { emit(Result.Loading) }
    .catch { emit(Result.Error(errorHandler.getError(it))) }
