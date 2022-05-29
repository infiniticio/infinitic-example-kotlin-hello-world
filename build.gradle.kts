plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.6.10"

    // Apply the application plugin
    application
}

repositories {
    mavenCentral()
    // necessary for the dashboard
    maven("https://jitpack.io")
}

dependencies {
    // add a logger
    implementation("org.slf4j:slf4j-simple:1.7.36")
    // infinitic framework
    implementation("io.infinitic:infinitic-factory:0.9.8")
    // infinitic dashboard
    implementation("io.infinitic:infinitic-dashboard:0.9.8")
}

application {
    // Define the main class for the application.
    mainClass.set("hello.world.AppKt")
}

task("dispatch", JavaExec::class) {
    group = "infinitic"
    main = "hello.world.ClientKt"
    classpath = sourceSets["main"].runtimeClasspath
}

task("dashboard", JavaExec::class) {
    group = "infinitic"
    main = "hello.world.DashboardKt"
    classpath = sourceSets["main"].runtimeClasspath
    setArgsString("infinitic.yml")
}
