import kotlinx.coroutines.*
import kotlinx.coroutines.delay

fun main() {
    //1
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("hello, ")
    Thread.sleep(2000L)

    //2
    globalScopeWithRunBlocking()
    globalScopeWithRunBlockingDirect()

    waitingForAJob()
    simplerWaitingForAJob()
    scopeBuilder()
}

private fun globalScopeWithRunBlocking() {
    GlobalScope.launch {
        delay(1000L)
        println("world-2")
    }
    println("\n 2-hello, ") // main thread continues here immediately
    runBlocking {
        //// but this expression blocks the main thread
        delay(2000L) //// ... while we delay for 2 seconds to keep JVM alive
    }
}

//Here runBlocking<Unit> { ... } works as an adaptor that is used to start the top-level main coroutine. We explicitly specify its Unit return type, because a well-formed main function in Kotlin has to return Unit.
private fun globalScopeWithRunBlockingDirect() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("world-3")
    }
    println("\n 3-hello, ")
    ////  blocks the main thread
    delay(2000L) //// ... while we delay for 2 seconds to keep JVM alive
}

private fun waitingForAJob() = runBlocking {
    //start
    val job = GlobalScope.launch {
        delay(1000L)
        println("world-4")
    }
    println("\n 4-hello, ")
    job.join() //wait until child coroutine completes
    //end
}

private fun simplerWaitingForAJob() = runBlocking { //CoroutineScope
    println("\n simplerWaitingForAJob: ")
    //because an outer coroutine (runBlocking in our example) does not complete until all the coroutines launched in its scope complete. Thus, we can make our example simpler:
    //launch a new coroutine in the scope of runblocking
    launch {
        delay(1000L)
        println("world-5")
    }
    println("\n 5-hello, ")
}

private fun scopeBuilder() = runBlocking {
    println("\n scopeBuilder: ")

    launch {
        delay(200L)
        println("Task from runblocking")
    }

    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }
        kotlinx.coroutines.delay(100L)
        println("Task from coroutine scope")
    }
    println("Coroutine scope is over")
}