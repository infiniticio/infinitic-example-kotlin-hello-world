package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.client.newWorkflow
import io.infinitic.factory.InfiniticClientFactory

fun main(args: Array<String>) {
    val name = args.firstOrNull() ?: "World"

    InfiniticClientFactory.fromConfigFile("infinitic.yml").use {
        val client = it

        repeat(1) {
            // create a stub from HelloWorld interface
            val helloWorld = client.newWorkflow<HelloWorld>()
            val deferred = client.async(helloWorld) { greet(name) }

            println("workflow ${HelloWorld::class} ${deferred.id} dispatched!")
        }
    }
}
