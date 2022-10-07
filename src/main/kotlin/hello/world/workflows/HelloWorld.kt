package hello.world.workflows

import io.infinitic.annotations.Name

@Name("HelloWorld")
interface HelloWorld {
    fun greet(name: String): String
}
