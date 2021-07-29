package hello.world

import io.infinitic.dashboard.DashboardServer

fun main(args: Array<String>) {
    // get name of config file
    val file = args.getOrNull(0) ?: throw RuntimeException("Please provide a DashboardConfig configuration file")
    // start server
    DashboardServer.fromConfigFile(file).start()
}
