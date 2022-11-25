package com.example.database.services

import com.example.data.cacheservices.CarCacheService
import com.example.database.daos.CarDao
import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType.IO
import com.example.domain.models.Car
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultCarCacheService @Inject constructor(
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher,
    private val dao: CarDao,
) : CarCacheService {

    override fun getListOfCar(): Flow<List<Car>> = dao.listOfCar

    override suspend fun insertListOfCar(list: List<Car>) = withContext(dispatcher) {
        dao.insertListOfCar(list)
    }
}
