package hello.world

import io.infinitic.pulsar.InfiniticAdmin
import org.apache.pulsar.client.admin.PulsarAdmin

fun main() {
    val infiniticAdmin = InfiniticAdmin.fromConfigFile("infinitic.yml")

    infiniticAdmin.setupPulsar()

    infiniticAdmin.close()
}
