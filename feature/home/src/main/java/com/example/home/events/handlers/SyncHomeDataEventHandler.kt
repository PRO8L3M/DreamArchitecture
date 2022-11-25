package com.example.home.events.handlers

import com.example.core.Event
import com.example.core.EventHandler
import com.example.domain.usecases.SyncHomeDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SyncHomeDataEventHandler @Inject constructor(
   private val viewModelScope: CoroutineScope,
   private val syncHomeData: SyncHomeDataUseCase,
) : EventHandler {

    override fun handle(event: Event) {
        viewModelScope.launch {
            syncHomeData()
        }
    }
}
