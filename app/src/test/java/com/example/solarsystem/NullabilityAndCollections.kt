package com.example.solarsystem

import org.junit.Test

class NullabilityAndCollectionsTest {

    @Test
    fun listCannotBeNull() {
        var flavours: List<String> = listOf("Vanilla, Strawberry")
//        flavours = null
        flavours.forEach { println(it) }
    }

    @Test
    fun listCanBeNull() {
        var flavours: List<String>? = listOf("Vanilla, Strawberry")
        flavours = null
        flavours?.forEach { println(it) }
    }

    @Test
    fun valuesCannotBeNull() {
        var flavours: List<String>? = listOf("Vanilla, Strawberry")
        flavours?.forEach { println(it) }
    }

    @Test
    fun valuesCanBeNull() {
        var flavours: MutableList<String?>? = mutableListOf("Vanilla, Strawberry", null)
        flavours?.add("Orange")
        flavours?.forEach { println(it) }
    }

}