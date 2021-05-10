package hello.world

import io.infinitic.pulsar.PulsarInfiniticWorker

fun main(args: Array<String>) {
    PulsarInfiniticWorker.fromConfigFile("infinitic.yml").start()
}
