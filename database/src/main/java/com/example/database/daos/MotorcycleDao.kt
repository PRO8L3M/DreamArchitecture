package com.example.database.daos

import com.example.domain.models.Motorcycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

object MotorcycleDao {

    private val _motorcycleList = MutableStateFlow<List<Motorcycle>>(emptyList())
    val motorcycleList = _motorcycleList.asStateFlow()

    fun insertMotorcycleList(list: List<Motorcycle>) {
        _motorcycleList.value = list
    }
}
