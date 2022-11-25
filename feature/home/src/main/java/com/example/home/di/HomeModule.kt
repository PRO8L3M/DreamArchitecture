package com.example.home.di

import com.example.core.EventsDispatcher
import com.example.core.StateProvider
import com.example.home.DefaultHomeUiComponentsStateHolder
import com.example.home.HomeUiComponentsStateHolder
import com.example.home.events.dispatcher.DefaultHomeEventsDispatcher
import com.example.home.state.DefaultHomeStateProvider
import com.example.home.state.HomeState
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
interface HomeModule {

    @Binds
    @ViewModelScoped
    fun bindHomeStateProvider(provider: DefaultHomeStateProvider): StateProvider<HomeState>

    @Binds
    @ViewModelScoped
    @Named(DefaultHomeEventsDispatcher.NAME)
    fun bindHomeEventsDispatcher(dispatcher: DefaultHomeEventsDispatcher): EventsDispatcher

    @Binds
    @ViewModelScoped
    fun bindHomeUiComponentsStateHolder(stateHolder: DefaultHomeUiComponentsStateHolder): HomeUiComponentsStateHolder
}
