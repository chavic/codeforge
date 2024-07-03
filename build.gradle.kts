plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    application
}

group = "org.codeforge.ai"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("io.ktor:ktor-server-core:2.3.9")
    implementation("io.ktor:ktor-server-netty:2.3.9")
    implementation("io.ktor:ktor-serialization:2.3.9")
    implementation("ch.qos.logback:logback-classic:1.5.3")
    implementation("org.jetbrains.exposed:exposed-core:0.48.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.48.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.48.0")
    implementation("org.surrealdb:surrealdb-driver:0.1.0")
    implementation("com.apple:pkl-config:0.26.0")
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host:2.3.9")
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("org.codeforge.ai.MainKt")
}
