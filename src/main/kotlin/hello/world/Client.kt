package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.client.newTask
import io.infinitic.client.newWorkflow
import io.infinitic.common.proxies.ProxyInvokeType
import io.infinitic.common.proxies.TaskProxyHandler
import io.infinitic.pulsar.PulsarInfiniticClient
import kotlin.reflect.KFunction1
import kotlin.reflect.KFunction2
import kotlin.reflect.KFunction3
import kotlin.reflect.KFunction4
import kotlin.reflect.KFunction5

fun main(args: Array<String>) {
    val name = args.firstOrNull() ?: "World"

    PulsarInfiniticClient.fromConfigFile("infinitic.yml").use {
        val client = it

        repeat(0) {
            // create a stub from HelloWorld interface
            val helloWorld = client.newWorkflow<HelloWorld>()
            val deferred = client.dispatch(helloWorld) { greet(name) }
            println("workflow ${HelloWorld::class} ${deferred.id} dispatched!")
        }

        val helloWorld = client.newTask<HelloWorld>()
        println(helloWorld.channel)

        dispatch(helloWorld::greet)("a")
    }
}

private fun <T> run(method: () -> T) : T {
        TaskProxyHandler.invocationType.set(ProxyInvokeType.ASYNC)
        val out = method()
        val handler = TaskProxyHandler.invocationHandler.get()
        TaskProxyHandler.invocationHandler.set(null)
        when (handler) {
            is TaskProxyHandler<*> -> {
                println("Task ${handler.taskName} ${handler.methodName}")
            }
            else -> throw Exception()
        }

        return out
}

fun <S, T> dispatch(method: KFunction1<S, T>) : (S) -> T =
    { s: S -> run { method(s) } }

fun <S1, S2, T> dispatch(method: KFunction2<S1, S2, T>) : (S1, S2) -> T =
    { s1: S1, s2: S2 -> run { method(s1, s2) } }

fun <S1, S2, S3, T> dispatch(method: KFunction3<S1, S2, S3, T>) : (S1, S2, S3) -> T =
    { s1: S1, s2: S2, s3: S3 -> run { method(s1, s2, s3) } }

fun <S1, S2, S3, S4, T> dispatch(method: KFunction4<S1, S2, S3, S4, T>) : (S1, S2, S3, S4) -> T =
    { s1: S1, s2: S2, s3: S3, s4: S4 -> run { method(s1, s2, s3, s4) } }

fun <S1, S2, S3, S4, S5, T> dispatch(method: KFunction5<S1, S2, S3, S4, S5, T>) : (S1, S2, S3, S4, S5) -> T =
    { s1: S1, s2: S2, s3: S3, s4: S4, s5: S5 -> run { method(s1, s2, s3, s4, s5) } }