package com.example.solarsystem

import org.junit.Test


fun doubleString(str: String): String {
    return str.repeat(2)
}

class NullabilityTest {

    @Test
    fun canNotBeNull() {

        var flavor = "mint"
        //flavor = null
        println((doubleString(flavor)))
    }

    @Test
    fun canBeNull() {
        var flavor: String? = "mint"
        flavor = null
//        println((doubleString(flavor)))
    }

    @Test
    fun ifNotNullCheck() {
        var flavor: String? = "mint"
        flavor = null
        if (flavor != null) {
            println((doubleString(flavor)))
        }
    }

    @Test
    fun letCheck() {
        var flavor: String? = null
        /** Let: if the variable is null then it does nothing
         */
        flavor?.let { println((doubleString(flavor))) }

    }

    @Test
    fun elvisCheck() {
        var flavor: String? = null
        /** Elvis: Uses a placeholder if the string is null
         */
        //doubleString repeats the text twice
        println((doubleString(flavor ?: "something else")))

    }

    @Test
    fun notNullAssertion() {
        var flavor: String? = null
        /** !!: It will convert any value to a non-null type. It is discouraged
         * because it takes away the ability of your compiler to verify your assertion
         * This test will fail
         */
        //doubleString repeats the text twice
        println((doubleString(flavor!!)))

    }

}