package com.example.domain.utils

interface Mapper<T1, T2> {

    fun map(source: T1): T2
    fun mapAll(source: Collection<T1>): Collection<T2> = source.map(::map)
}