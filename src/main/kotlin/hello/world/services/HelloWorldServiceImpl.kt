package hello.world.services

@Suppress("unused")
class HelloWorldServiceImpl : HelloWorldService {
    override fun sayHello(name: String) = "Hello $name"

    override fun addEnthusiasm(str: String) = "$str!"
}
