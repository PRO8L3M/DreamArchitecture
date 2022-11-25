package com.example.home.events.handlers

import com.example.core.Event
import com.example.core.EventHandler
import com.example.domain.usecases.AddCarUseCase
import com.example.home.HomeUiComponentsStateHolder
import com.example.home.events.AddCar
import com.example.home.state.CarButtonUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddCarEventHandler @Inject constructor(
    private val viewModelScope: CoroutineScope,
    private val addCar: AddCarUseCase,
    private val homeUiComponentsStateHolder: HomeUiComponentsStateHolder,
) : EventHandler {

    override fun handle(event: Event) {
        if (event !is AddCar) return
        viewModelScope.launch {
            homeUiComponentsStateHolder.setCarButtonState(CarButtonUiState.Loading)
            addCar(event.car)
                .onSuccess { homeUiComponentsStateHolder.setCarButtonState(CarButtonUiState.Default) }
                .onError { homeUiComponentsStateHolder.setCarButtonState(CarButtonUiState.Error(it)) }
        }
    }
}
