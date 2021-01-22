package hello.world.tasks

class HelloWorldServiceImpl : HelloWorldService {
    override fun sayHello(name: String?) = "Hello ${name ?: "World"}"

    override fun addEnthusiasm(str: String) = "$str!"
}