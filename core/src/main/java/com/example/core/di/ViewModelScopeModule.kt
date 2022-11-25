package com.example.core.di

import com.example.domain.di.Dispatcher
import com.example.domain.di.DispatcherType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@InstallIn(ViewModelComponent::class)
@Module
interface ViewModelScopeModule {

    companion object {

        @Provides
        @ViewModelScoped
        fun bindViewModelScope(
            @Dispatcher(DispatcherType.MAIN) dispatcher: CoroutineDispatcher,
        ) = CoroutineScope(dispatcher + SupervisorJob())
    }
}
