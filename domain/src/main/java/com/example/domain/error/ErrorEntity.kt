package com.example.domain.error

sealed class ErrorEntity {

    object Network : ErrorEntity()
    object NotFound : ErrorEntity()
    object AccessDenied : ErrorEntity()
    object ServiceUnavailable : ErrorEntity()
    object Unknown : ErrorEntity()
}
