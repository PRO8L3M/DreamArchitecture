package com.example.domain.usecases

import com.example.domain.error.ErrorHandler
import com.example.domain.repositories.CarRepository
import com.example.domain.repositories.MotorcycleRepository
import com.example.domain.repositories.PlaneRepository
import com.example.domain.utils.runCatchingSafe
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class SyncHomeDataUseCase @Inject constructor(
    private val planeRepository: PlaneRepository,
    private val carRepository: CarRepository,
    private val motorcycleRepository: MotorcycleRepository,
    private val errorHandler: ErrorHandler,
) {

    suspend operator fun invoke() = runCatchingSafe(errorHandler) {
        planeRepository.sync()
        carRepository.sync()
        motorcycleRepository.sync()
    }
}