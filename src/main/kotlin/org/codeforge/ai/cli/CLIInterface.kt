package org.codeforge.ai.cli

import org.codeforge.ai.core.CodeForgeCore
import kotlinx.coroutines.runBlocking

class CLIInterface(private val codeForgeCore: CodeForgeCore) {
    fun start() {
        println("Welcome to CodeForge CLI!")
        while (true) {
            print("> ")
            val input = readLine() ?: break
            when (input) {
                "exit" -> break
                "help" -> printHelp()
                else -> processCommand(input)
            }
        }
        println("Thank you for using CodeForge CLI!")
    }

    private fun printHelp() {
        println("""
            Available commands:
            create <project_name> <project_type> - Create a new project
            generate <project_id> - Generate code for an existing project
            help - Show this help message
            exit - Exit the CLI
        """.trimIndent())
    }

    private fun processCommand(input: String) {
        val parts = input.split(" ")
        when (parts[0]) {
            "create" -> {
                if (parts.size < 4) {
                    println("Usage: create <project_name> <project_type> <requirements>")
                    return
                }
                val name = parts[1]
                val type = parts[2]
                val requirements = parts.subList(3, parts.size).joinToString(" ")
                val result = codeForgeCore.createProject(name, type, requirements)
                println(result)
            }
            "generate" -> {
                if (parts.size < 2) {
                    println("Usage: generate <project_id>")
                    return
                }
                val result = codeForgeCore.generateCode(parts[1])
                println(result)
            }
            else -> println("Unknown command. Type 'help' for available commands.")
        }
    }
}
