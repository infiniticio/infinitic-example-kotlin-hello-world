package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.pulsar.InfiniticClient
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val client = InfiniticClient.fromFile("infinitic.yml")

    // create a stub from HelloWorld interface
    val helloWorld = client.workflow<HelloWorld>()
    // dispatch a workflow
    client.async(helloWorld) { greet(args.firstOrNull()) }

    client.close()
}