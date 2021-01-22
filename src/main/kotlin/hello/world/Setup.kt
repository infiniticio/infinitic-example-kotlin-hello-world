package hello.world

import io.infinitic.pulsar.InfiniticAdmin
import org.apache.pulsar.client.admin.PulsarAdmin

fun main() {
    val pulsarAdmin = PulsarAdmin
        .builder()
        .serviceHttpUrl("http://localhost:8080")
        .build()

    val infiniticAdmin = InfiniticAdmin(pulsarAdmin, "infinitic", "dev")

    infiniticAdmin.init()
    infiniticAdmin.close()
}
