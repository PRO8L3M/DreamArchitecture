package com.example.data.cacheservices

import com.example.domain.models.Motorcycle
import kotlinx.coroutines.flow.Flow

interface MotorcycleCacheService {

    fun getListOfMotorcycle(): Flow<List<Motorcycle>>

    suspend fun insertListOfMotorcycle(list: List<Motorcycle>)
}
