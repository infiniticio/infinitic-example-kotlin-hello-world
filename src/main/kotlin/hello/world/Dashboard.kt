package hello.world

import io.infinitic.dashboard.DashboardServer

fun main() {
    // start server on port defined in infinitic.yml
    DashboardServer.fromConfigResource("/infinitic.yml").start()
}
