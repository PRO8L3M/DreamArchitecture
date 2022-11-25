package com.example.domain.repositories

import com.example.domain.models.Motorcycle
import com.example.domain.models.Plane
import com.example.domain.models.wrappers.Result
import kotlinx.coroutines.flow.Flow

interface MotorcycleRepository {

    fun getMotorcycleList(): Flow<Result<List<Motorcycle>>>
    suspend fun sync()

    suspend fun addMotorcycle(model: Motorcycle)
}
