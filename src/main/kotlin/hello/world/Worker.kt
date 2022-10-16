package hello.world // ktlint-disable filename

import io.infinitic.workers.InfiniticWorker

fun main() {
    InfiniticWorker.fromConfigResource("/infinitic.yml").use { worker ->
        worker.start()
    }
}
