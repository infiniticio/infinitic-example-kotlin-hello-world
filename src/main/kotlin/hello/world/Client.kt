package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.client.newWorkflow
import io.infinitic.pulsar.PulsarInfiniticClient

fun main(args: Array<String>) {
    val client = PulsarInfiniticClient.fromConfigFile("infinitic.yml")
    val name = args.firstOrNull() ?: "World"

    // create a stub from HelloWorld interface
    val helloWorld = client.newWorkflow<HelloWorld>()
    client.async(helloWorld) { greet(name) }

    println("workflow ${HelloWorld::class} dispatched!")
}
