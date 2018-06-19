package com.example.solarsystem

import kotlinx.coroutines.experimental.*
import org.junit.Test

class CoroutinesAsyncTest {

    //The Async Function is useful when you want to return a value from your coroutine

    @Test
    fun usingAsync() {
        println("Starting...")

        async(CommonPool) {
            delay(1_000)
            println("Inside...")
        }
        Thread.sleep(1_500)

        println("Stopping...")
    }

    @Test
    fun usingAsyncWithDeferred() {
        //Deferred is a future or a promise of a value
        println("Starting...")

        launch(CommonPool) {
            val result: Deferred<Int> = async(CommonPool) {
                delay(1_000)
                println("Inside...")
                42
            }

            //.await is to get the value from inside the Deferred
            //.await() is a suspending function, it has to be called from another suspending function or a couroutine
            println("The result: ${result.await()}")
        }

        Thread.sleep(1_500)

        println("Stopping...")

    }

    @Test
    fun usingAsyncTwice() {
        println("Starting...")

        launch(CommonPool) {
            val result: Deferred<Int> = async(CommonPool) {
                delay(1_000)
                println("Inside...")
                42
            }

            val result2: Deferred<Int> = async(CommonPool) {
                delay(1_000)
                println("Inside...")
                8
            }

            //the .await() function allows the implementing of this method to be suspended until those asynchronous coroutines are completed
            println("The result: ${result.await() + result2.await()}")
        }

        Thread.sleep(1_500)

        println("Stopping...")
    }

}
