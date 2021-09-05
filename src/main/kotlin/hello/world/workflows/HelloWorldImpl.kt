package hello.world.workflows

import hello.world.tasks.HelloWorldService
import io.infinitic.workflows.Workflow

class HelloWorldImpl : Workflow(), HelloWorld {
    private val helloWorldService = newTask<HelloWorldService>()

    override val channel = channel<String>()

    override fun greet(name: String): String {
        val str = helloWorldService.sayHello(name)

        val greeting = helloWorldService.addEnthusiasm(str)

        inline { println(greeting) }

        return greeting
    }
}
