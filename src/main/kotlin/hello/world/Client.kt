package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.client.Deferred
import io.infinitic.factory.InfiniticClientFactory

fun main(args: Array<String>) {
    InfiniticClientFactory.fromConfigFile("infinitic.yml").use { client ->
        // create a stub from HelloWorld interface
        val helloWorld = client.newWorkflow(HelloWorld::class.java)

        repeat(100) {
            // dispatch workflow
            val deferred: Deferred<String> = client.dispatch(helloWorld::greet, "$it")

            println("workflow ${HelloWorld::class} ${deferred.id} ($it) dispatched!")
        }
    }
}
