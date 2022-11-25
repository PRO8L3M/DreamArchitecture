package com.example.database.daos

import com.example.domain.models.Car
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object CarDao {

    private val _listOfCar = MutableStateFlow<List<Car>>(emptyList())
    val listOfCar: Flow<List<Car>> = _listOfCar.asStateFlow()

    fun insertListOfCar(list: List<Car>) {
        _listOfCar.value = list
    }
}
