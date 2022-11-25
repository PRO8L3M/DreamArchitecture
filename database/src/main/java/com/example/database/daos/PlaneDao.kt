package com.example.database.daos

import com.example.domain.models.Plane
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf

object PlaneDao {

    private val _planeList = MutableStateFlow<List<Plane>>(emptyList())
    val planeList = _planeList.asStateFlow()

    fun insertPlaneList(list: List<Plane>) {
        _planeList.value = list
    }
}
