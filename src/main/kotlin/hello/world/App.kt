package hello.world

import io.infinitic.pulsar.InfiniticWorker

fun main(args: Array<String>) {
    InfiniticWorker.fromFile("infinitic.yml").start()
}
