package com.example.database.services

import com.example.data.cacheservices.PlaneCacheService
import com.example.database.daos.PlaneDao
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType.IO
import com.example.domain.models.Plane
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultPlaneCacheService @Inject constructor(
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher,
    private val dao: PlaneDao,
) : PlaneCacheService {

    override fun getListOfPlane(): Flow<List<Plane>> = dao.planeList

    override suspend fun insertListOfPlane(list: List<Plane>) = withContext(dispatcher) {
        dao.insertPlaneList(list)
    }
}
