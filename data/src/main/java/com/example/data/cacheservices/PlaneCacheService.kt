package com.example.data.cacheservices

import com.example.domain.models.Plane
import kotlinx.coroutines.flow.Flow

interface PlaneCacheService {

    fun getListOfPlane(): Flow<List<Plane>>

    suspend fun insertListOfPlane(list: List<Plane>)
}
