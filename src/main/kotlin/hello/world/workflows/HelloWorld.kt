package hello.world.workflows

import io.infinitic.workflows.SendChannel

interface HelloWorld {
    val channel: SendChannel<String>
    fun greet(name: String): String
}
