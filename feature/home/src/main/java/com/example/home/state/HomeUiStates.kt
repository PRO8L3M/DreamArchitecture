package com.example.home.state

import com.example.domain.error.ErrorEntity
import com.example.domain.models.Car
import com.example.domain.models.Motorcycle
import com.example.domain.models.Plane

sealed interface CarsUiState {
    data class Success(val cars: List<Car>) : CarsUiState
    data class Error(val error: ErrorEntity) : CarsUiState
    object Loading : CarsUiState
}

sealed interface PlanesUiState {
    data class Success(val planes: List<Plane>) : PlanesUiState
    data class Error(val error: ErrorEntity) : PlanesUiState
    object Loading : PlanesUiState
}

sealed interface MotorcycleUiState {
    data class Success(val motorcycles: List<Motorcycle>) : MotorcycleUiState
    data class Error(val error: ErrorEntity) : MotorcycleUiState
    object Loading : MotorcycleUiState
}

sealed interface CarButtonUiState {
    object Default : CarButtonUiState
    data class Error(val error: ErrorEntity) : CarButtonUiState
    object Loading : CarButtonUiState
}