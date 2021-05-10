package hello.world

import io.infinitic.pulsar.PulsarInfiniticAdmin

fun main() {
    val infiniticAdmin = PulsarInfiniticAdmin.fromConfigFile("infinitic.yml")

    infiniticAdmin.setupPulsar()

    infiniticAdmin.printTopicStats()

    infiniticAdmin.close()
}
