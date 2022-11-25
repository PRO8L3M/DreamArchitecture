package com.example.home

import com.example.core.BaseViewModel
import com.example.core.Event
import com.example.core.EventsDispatcher
import com.example.core.StateProvider
import com.example.home.events.Sync
import com.example.home.events.dispatcher.DefaultHomeEventsDispatcher
import com.example.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Named(DefaultHomeEventsDispatcher.NAME) private val dispatcher: EventsDispatcher,
    stateProvider: StateProvider<HomeState>,
    override val viewModelScope: CoroutineScope,
) : BaseViewModel<HomeState>() {

    init {
        stateProvider.screenState
            .onEach(::setState)
            .launchIn(viewModelScope)
        setEvent(Sync)
    }

    override fun setInitialState(): HomeState = HomeState.init()

    override fun onEvent(event: Event) = dispatcher.dispatchEvent(event)
}
