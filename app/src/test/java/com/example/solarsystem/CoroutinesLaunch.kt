package com.example.solarsystem

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import org.junit.Test

class CoroutinesLaunchTest {

    @Test
    fun startWithLaunchNoSleep() {
        println("Starting...")

        //The context of the launch is the thread it is gonna run on
        launch(CommonPool) {
            delay(1_000) //Using that, will make us done with the test before the coroutine has the chance to complete
            println("Inside...")

        }

        println("Stopping...")

    }

    @Test
    fun startWithLaunchSleep() {
        println("Starting...")

        launch(CommonPool) {
            delay(1_000)
            println("Inside...")

        }
        Thread.sleep(1_500) //Will give the coroutine the chance to complete its work

        println("Stopping...")
    }

    @Test
    fun startWithLaunchMultiple() {
        println("Starting...")

        //Couroutines allows you to process requests in parallel
        launch(CommonPool) {
            delay(1_000)
            println("Inside 1...")

        }

        launch(CommonPool) {
            delay(1_000)
            println("Inside 2...")

        }

        Thread.sleep(1_500)

        println("Stopping...")
    }

    @Test
    fun startWithLaunchLazy() {
        println("Starting...")

        //Changing our launch function to start lazily, so it will not be executed unless it gets called
        val job = launch(CommonPool, CoroutineStart.LAZY) {
            delay(1_000)
            println("Inside...")

        }
        job.start()
//        val x = 1
//        if (x == 1) {
//            job.cancel()
//        }
        Thread.sleep(1_500)

        println("Stopping...")
    }

}
