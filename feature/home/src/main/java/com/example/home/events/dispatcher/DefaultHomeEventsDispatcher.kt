package com.example.home.events.dispatcher

import com.example.core.Event
import com.example.core.EventHandler
import com.example.core.EventsDispatcher
import javax.inject.Inject

class DefaultHomeEventsDispatcher @Inject constructor(
    private val eventHandlerMap: Map<Class<out Event>, @JvmSuppressWildcards EventHandler>
) : EventsDispatcher {

    override fun dispatchEvent(event: Event) {
        eventHandlerMap[event::class.java]?.handle(event)
    }

    companion object {
        const val NAME = "HomeEventsHandler"
    }
}