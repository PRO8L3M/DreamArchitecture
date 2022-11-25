package com.example.home.state

import com.example.core.UiState
import com.example.resources.R

data class HomeState(
    val planeHeaderRes: Int = R.string.text_plane_header,
    val planes: PlanesUiState,
    val carHeaderRes: Int = R.string.text_car_header,
    val cars: CarsUiState,
    val carButton: CarButtonUiState,
    val motorcycleHeaderRes: Int = R.string.text_motorcycle_header,
    val motorcycles: MotorcycleUiState,
) : UiState {

    companion object {
        fun init() = HomeState(
            planes = PlanesUiState.Loading,
            cars = CarsUiState.Loading,
            motorcycles = MotorcycleUiState.Loading,
            carButton = CarButtonUiState.Default
        )
    }

    //todo Consider improving approach with Factory pattern
}
