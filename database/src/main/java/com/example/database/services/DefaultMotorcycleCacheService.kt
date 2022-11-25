package com.example.database.services

import com.example.data.cacheservices.MotorcycleCacheService
import com.example.database.daos.MotorcycleDao
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType.IO
import com.example.domain.models.Motorcycle
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultMotorcycleCacheService @Inject constructor(
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher,
    private val dao: MotorcycleDao,
) : MotorcycleCacheService {

    override fun getListOfMotorcycle(): Flow<List<Motorcycle>> = dao.motorcycleList

    override suspend fun insertListOfMotorcycle(list: List<Motorcycle>) = withContext(dispatcher) {
        dao.insertMotorcycleList(list)
    }
}
