package com.example.home

import com.example.home.state.CarButtonUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class DefaultHomeUiComponentsStateHolder @Inject constructor() : HomeUiComponentsStateHolder {

    private val _carButtonState = MutableStateFlow<CarButtonUiState>(CarButtonUiState.Default)
    override val carButtonState: Flow<CarButtonUiState> = _carButtonState

    override fun setCarButtonState(state: CarButtonUiState) {
        _carButtonState.value = state
    }
}