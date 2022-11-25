package com.example.data.repositories

import com.example.data.cacheservices.PlaneCacheService
import com.example.data.networkingservices.PlaneNetworkingService
import com.example.domain.error.ErrorHandler
import com.example.domain.models.Plane
import com.example.domain.models.wrappers.Result
import com.example.domain.models.wrappers.asResult
import com.example.domain.repositories.PlaneRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultPlaneRepository @Inject constructor(
    private val networkingService: PlaneNetworkingService,
    private val cacheService: PlaneCacheService,
    private val errorHandler: ErrorHandler,
) : PlaneRepository {

    override suspend fun sync() {
        val result = networkingService.getListOfPlane()
        cacheService.insertListOfPlane(result)
    }

    override fun getPlaneList(): Flow<Result<List<Plane>>> {
        return cacheService.getListOfPlane().asResult(errorHandler)
    }

    override suspend fun addPlane(model: Plane) {
        val result = networkingService.insertPlane(model)
        cacheService.insertListOfPlane(result)
    }
}