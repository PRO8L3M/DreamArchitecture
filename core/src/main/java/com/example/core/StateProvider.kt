package com.example.core

import kotlinx.coroutines.flow.Flow

interface StateProvider<T : UiState> {
    val screenState: Flow<T>
}
