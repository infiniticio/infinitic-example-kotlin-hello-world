package hello.world

import io.infinitic.factory.InfiniticWorkerFactory

fun main() {
    InfiniticWorkerFactory.fromConfigResource("/infinitic.yml").use { worker ->
        worker.start()
    }
}
