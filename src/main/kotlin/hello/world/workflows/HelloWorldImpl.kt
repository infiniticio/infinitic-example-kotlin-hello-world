package hello.world.workflows

import hello.world.tasks.HelloWorldService
import io.infinitic.workflows.AbstractWorkflow
import io.infinitic.workflows.task

class HelloWorldImpl : AbstractWorkflow(), HelloWorld {
    private val helloWorldService = task<HelloWorldService>()

    override fun greet(name: String?): String {
        val str = helloWorldService.sayHello(name)
        val greeting =  helloWorldService.addEnthusiasm(str)
        inline { println(greeting) }

        return  greeting
    }
}
