package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.clients.newWorkflow
import io.infinitic.pulsar.InfiniticClient

fun main(args: Array<String>) {
    val client = InfiniticClient.fromConfigFile("infinitic.yml")
    val name = args.firstOrNull() ?: "World"

    // create a stub from HelloWorld interface
    val helloWorld = client.newWorkflow<HelloWorld>()
    client.async(helloWorld) { greet(name) }

    println("workflow ${HelloWorld::class} dispatched!")
}
