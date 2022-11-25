package com.example.core.di

import com.example.core.Event
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.PROPERTY_GETTER,
)
@Retention
@MapKey
annotation class EventHandlerKey(val value: KClass<out Event>)
