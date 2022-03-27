package hello.world

import io.infinitic.factory.InfiniticWorkerFactory

fun main() {
    InfiniticWorkerFactory.fromConfigFile("infinitic.yml").use { worker ->
        worker.start()
    }
}
