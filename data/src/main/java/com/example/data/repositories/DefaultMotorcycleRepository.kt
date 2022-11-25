package com.example.data.repositories

import com.example.data.cacheservices.MotorcycleCacheService
import com.example.data.networkingservices.MotorcycleNetworkingService
import com.example.domain.error.ErrorHandler
import com.example.domain.models.Motorcycle
import com.example.domain.models.wrappers.Result
import com.example.domain.models.wrappers.asResult
import com.example.domain.repositories.MotorcycleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultMotorcycleRepository @Inject constructor(
    private val networkingService: MotorcycleNetworkingService,
    private val cacheService: MotorcycleCacheService,
    private val errorHandler: ErrorHandler,
) : MotorcycleRepository {

    override suspend fun sync() {
        val result = networkingService.getListOfMotorcycle()
        cacheService.insertListOfMotorcycle(result)
    }

    override fun getMotorcycleList(): Flow<Result<List<Motorcycle>>> {
        return cacheService.getListOfMotorcycle().asResult(errorHandler)
    }

    override suspend fun addMotorcycle(model: Motorcycle) {
        val result = networkingService.insertMotorcycle(model)
        cacheService.insertListOfMotorcycle(result)
    }
}
