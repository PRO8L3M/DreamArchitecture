package com.example.domain.repositories

import com.example.domain.models.Plane
import com.example.domain.models.wrappers.Result
import kotlinx.coroutines.flow.Flow

interface PlaneRepository {

    fun getPlaneList(): Flow<Result<List<Plane>>>
    suspend fun sync()

    suspend fun addPlane(model: Plane)
}
