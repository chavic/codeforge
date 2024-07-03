package org.codeforge.ai

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.codeforge.ai.core.CodeForgeCore
import org.codeforge.ai.database.DatabaseManager
import org.codeforge.ai.web.configureRouting

fun main() {
    // Initialize the database
    DatabaseManager.init()

    // Initialize CodeForgeCore
    val codeForgeCore = CodeForgeCore()

    // Start the web server
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting(codeForgeCore)
    }.start(wait = true)
}
