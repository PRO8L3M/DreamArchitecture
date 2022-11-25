package com.example.domain.utils

import com.example.domain.error.ErrorHandler
import com.example.domain.models.wrappers.Result
import kotlinx.coroutines.CancellationException

inline fun <T, R> T.runCatchingSafe(errorHandler: ErrorHandler, block: T.() -> R): Result<R> {
    return try {
        Result.Success(block(this))
    } catch (e: Exception) {
        if (e is CancellationException) {
            throw e
        }
        Result.Error(errorHandler.getError(e))
    }
}