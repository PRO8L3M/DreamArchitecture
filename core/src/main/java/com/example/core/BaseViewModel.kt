package com.example.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel<T : UiState> : ViewModel() {

    private val initialState: T by lazy { setInitialState() }

    abstract val viewModelScope: CoroutineScope

    abstract fun setInitialState(): T

    var viewState by mutableStateOf(initialState)
       private set

    protected fun setState(state: T) {
        viewState = state
    }

    abstract fun onEvent(event: Event)

    fun setEvent(event: Event) { onEvent(event) }
}
