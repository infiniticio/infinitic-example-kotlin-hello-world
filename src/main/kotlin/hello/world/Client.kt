package hello.world

import hello.world.workflows.HelloWorld
import io.infinitic.clients.InfiniticClient

fun main() {
    InfiniticClient.fromConfigResource("/infinitic.yml").use { client ->
        // create a stub from HelloWorld interface
        val helloWorld = client.newWorkflow(HelloWorld::class.java)

        // dispatch workflows
        repeat(10) {
            // dispatch workflow
            client.dispatchAsync(helloWorld::greet, "$it")
                .thenApply { deferred -> println("Workflow ${deferred.id} ($it) dispatched!") }
                .exceptionally { error -> println("Failed to dispatch ($it): $error") }
        }
    }
}
