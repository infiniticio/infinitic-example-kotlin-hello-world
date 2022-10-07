package hello.world.tasks

import io.infinitic.annotations.Name

@Name("HelloWorldService")
interface HelloWorldService {
    fun sayHello(name: String): String

    fun addEnthusiasm(str: String): String
}
