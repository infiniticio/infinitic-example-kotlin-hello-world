package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.factory.InfiniticClientFactory

fun main() {
    InfiniticClientFactory.fromConfigFile("infinitic.yml").use { client ->
        // create a stub from HelloWorld interface
        val helloWorld = client.newWorkflow(HelloWorld::class.java)

        // dispatch workflows
        repeat(10) {
            // dispatch workflow
            client.dispatchAsync(helloWorld::greet, "$it")
                .thenApply { deferred -> println("Workflow ${HelloWorld::class} ${deferred.id} ($it) dispatched!") }
                .exceptionally { error -> System.err.println("Failed to dispatch ($it): $error") }
        }
    }
}
