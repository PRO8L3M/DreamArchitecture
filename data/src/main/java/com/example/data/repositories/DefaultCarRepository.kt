package com.example.data.repositories

import com.example.data.cacheservices.CarCacheService
import com.example.data.networkingservices.CarNetworkingService
import com.example.domain.error.ErrorHandler
import com.example.domain.models.Car
import com.example.domain.models.wrappers.Result
import com.example.domain.models.wrappers.asResult
import com.example.domain.repositories.CarRepository
import com.example.domain.utils.runCatchingSafe
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultCarRepository @Inject constructor(
    private val networkingService: CarNetworkingService,
    private val cacheService: CarCacheService,
    private val errorHandler: ErrorHandler,
) : CarRepository {

    override suspend fun sync() {
        val result = networkingService.getListOfCar()
        cacheService.insertListOfCar(result)
    }

    override fun getCarList(): Flow<Result<List<Car>>> {
        return cacheService.getListOfCar().asResult(errorHandler)
    }

    override suspend fun addCar(model: Car) = runCatchingSafe(errorHandler) {
        val result = networkingService.insertCar(model)
        cacheService.insertListOfCar(result)
    }
}
