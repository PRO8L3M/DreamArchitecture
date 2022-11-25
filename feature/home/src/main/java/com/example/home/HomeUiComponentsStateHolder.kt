package com.example.home

import com.example.home.state.CarButtonUiState
import kotlinx.coroutines.flow.Flow

interface HomeUiComponentsStateHolder {

    val carButtonState: Flow<CarButtonUiState>

    fun setCarButtonState(state: CarButtonUiState)
}
