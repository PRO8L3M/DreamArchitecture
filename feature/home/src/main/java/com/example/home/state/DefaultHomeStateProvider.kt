package com.example.home.state

import com.example.core.StateProvider
import com.example.domain.models.Car
import com.example.domain.models.Motorcycle
import com.example.domain.models.Plane
import com.example.domain.models.wrappers.Result
import com.example.domain.repositories.CarRepository
import com.example.domain.repositories.MotorcycleRepository
import com.example.domain.repositories.PlaneRepository
import com.example.home.HomeUiComponentsStateHolder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class DefaultHomeStateProvider @Inject constructor(
    planeRepository: PlaneRepository,
    carRepository: CarRepository,
    motorcycleRepository: MotorcycleRepository,
    homeUiComponentsStateHolder: HomeUiComponentsStateHolder,
) : StateProvider<HomeState> {

    override val screenState: Flow<HomeState> = combine(
        planeRepository.getPlaneList(),
        carRepository.getCarList(),
        motorcycleRepository.getMotorcycleList(),
        homeUiComponentsStateHolder.carButtonState,
    ) { planes, cars, motorcycles, carButtonState ->
        buildHomeState(planes, cars, motorcycles, carButtonState)
    }

    private fun buildHomeState(
        // domain results
        planeResult: Result<List<Plane>>,
        carResult: Result<List<Car>>,
        motorcycleResult: Result<List<Motorcycle>>,
        // UI components states
        carButtonState: CarButtonUiState,
    ): HomeState {
        val planesUiState = when (planeResult) {
            is Result.Loading -> PlanesUiState.Loading
            is Result.Success -> PlanesUiState.Success(planeResult.data)
            is Result.Error -> PlanesUiState.Error(planeResult.error)
        }
        val carsUiState = when (carResult) {
            is Result.Loading -> CarsUiState.Loading
            is Result.Success -> { CarsUiState.Success(carResult.data) }
            is Result.Error -> CarsUiState.Error(carResult.error)
        }
        val motorcyclesUiState = when (motorcycleResult) {
            is Result.Loading -> MotorcycleUiState.Loading
            is Result.Success -> MotorcycleUiState.Success(motorcycleResult.data)
            is Result.Error -> MotorcycleUiState.Error(motorcycleResult.error)
        }
        return HomeState(
            planes = planesUiState,
            cars = carsUiState,
            motorcycles = motorcyclesUiState,
            carButton = carButtonState,
        )
    }
}
