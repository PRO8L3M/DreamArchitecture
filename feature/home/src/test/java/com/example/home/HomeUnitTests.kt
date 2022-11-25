package com.example.home

import com.example.core.EventsDispatcher
import com.example.domain.models.TestItemModel
import com.example.domain.usecases.FetchTestItemsUseCase
import com.example.home.events.dispatcher.DefaultHomeEventsDispatcher
import com.example.home.events.FetchTestItems
import com.example.home.state.HomeState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

@OptIn(ExperimentalCoroutinesApi::class)
class MainDispatcherRule(
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
) : TestWatcher() {

    override fun starting(description: Description) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        Dispatchers.resetMain()
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
class HomeUnitTests {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var updater: StateUpdater<HomeState>

    @MockK
    private lateinit var handler: EventsDispatcher

    @MockK
    private lateinit var useCase: FetchTestItemsUseCase

    private lateinit var viewModel: HomeViewModel

    @Before
    fun start() {
        MockKAnnotations.init(this)
        useCase = spyk(FetchTestItemsUseCase(UnconfinedTestDispatcher()))
        updater = spyk(DefaultHomeStateUpdater())
        handler = spyk(DefaultHomeEventsDispatcher(useCase))
        viewModel = spyk(HomeViewModel(updater, handler))
    }

    @Test
    fun `given loading state off, when fetching event is call, then loading state turns on`() {
        val event = FetchTestItems
        assertEquals(false, viewModel.viewState.value.isLoading)
        viewModel.setEvent(event)
        assertEquals(true, viewModel.viewState.value.isLoading)
    }

    @Test
    fun `given empty test items, when fetched items, then test items are updated`() {
        val event = FetchTestItems
        val initModel = HomeState.init()
        assertEquals(initModel.feedList, viewModel.viewState.value.feedList)
        coEvery { useCase() } returns Result.success(listOf(TestItemModel(666, "Hi", "Buu")))
        viewModel.setEvent(event)
        assertNotEquals(initModel, viewModel.viewState.value)
    }
}
