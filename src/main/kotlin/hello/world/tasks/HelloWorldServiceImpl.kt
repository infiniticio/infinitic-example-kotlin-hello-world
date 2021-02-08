package hello.world.tasks

class HelloWorldServiceImpl : HelloWorldService {
    override fun sayHello(name: String) = "Hello $name"

    override fun addEnthusiasm(str: String) = "$str!"

    fun getRetryDelay() = 5F
}