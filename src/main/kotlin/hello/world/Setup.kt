package hello.world

import io.infinitic.pulsar.InfiniticAdmin
import io.infinitic.pulsar.topics.*

fun main() {
    val infiniticAdmin = InfiniticAdmin.fromConfigFile("infinitic.yml")

    infiniticAdmin.setupPulsar()

    infiniticAdmin.printTopicStats()

    infiniticAdmin.close()
}
