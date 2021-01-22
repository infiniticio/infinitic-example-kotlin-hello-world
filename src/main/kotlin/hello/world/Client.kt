package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.pulsar.InfiniticClient
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val client = InfiniticClient.fromFile("infinitic.yml")

    client.startWorkflow<HelloWorld> { greet(args.firstOrNull()) }

    client.close()
}