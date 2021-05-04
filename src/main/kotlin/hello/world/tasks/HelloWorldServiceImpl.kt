package hello.world.tasks

import io.infinitic.tasks.Task

class HelloWorldServiceImpl : Task(), HelloWorldService {
    override fun sayHello(name: String) = "Hello $name"

    override fun addEnthusiasm(str: String) = "$str!"
}
