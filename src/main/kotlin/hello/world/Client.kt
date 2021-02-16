package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.pulsar.InfiniticClient

fun main(args: Array<String>) {
    val client = InfiniticClient.fromConfigFile("infinitic.yml")
    val name = args.firstOrNull() ?: "World"

    // create a stub from HelloWorld interface
    val helloWorld = client.workflow<HelloWorld>()

    // dispatch a workflow
    client.async(helloWorld) { greet("async $name") }

    // dispatch a workflow and get result
    val greetings = helloWorld.greet("sync $name")

    println(greetings)

    client.close()
}