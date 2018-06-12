package com.example.solarsystem

import org.junit.Test


fun multiply(left: Int, right: Int): Int {
    return left * right
}

class FunctionsTest {

    @Test
    fun functionCreation() {
        println(multiply(2,3))
        println(multiply(left = 2,right = 3))

    }

    @Test
    fun functionDefaultValues() {

    }
}