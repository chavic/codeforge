package org.codeforge.ai.ai

class AIAssistant {
    fun analyzeRequirements(requirements: String): Map<String, Any> {
        // Simulate AI-powered requirements analysis
        val keywords = requirements.toLowerCase().split(" ")
        val projectType = when {
            "web" in keywords -> "Web Application"
            "mobile" in keywords -> "Mobile Application"
            "desktop" in keywords -> "Desktop Application"
            "backend" in keywords -> "Backend Service"
            else -> "Unknown"
        }
        
        val complexity = when {
            keywords.size < 10 -> "Low"
            keywords.size < 20 -> "Medium"
            else -> "High"
        }
        
        return mapOf(
            "projectType" to projectType,
            "complexity" to complexity,
            "estimatedDuration" to "${keywords.size / 2} days",
            "keyFeatures" to keywords.filter { it.length > 5 }
        )
    }

    fun suggestTechnologyStack(projectType: String): List<String> {
        return when (projectType) {
            "Web Application" -> listOf("React", "Node.js", "Express", "MongoDB")
            "Mobile Application" -> listOf("React Native", "Firebase")
            "Desktop Application" -> listOf("Electron", "TypeScript")
            "Backend Service" -> listOf("Kotlin", "Spring Boot", "PostgreSQL")
            else -> listOf("Unable to suggest technology stack for unknown project type")
        }
    }

    fun generateProjectStructure(projectType: String): List<String> {
        return when (projectType) {
            "Web Application" -> listOf(
                "src/",
                "src/components/",
                "src/pages/",
                "src/utils/",
                "public/",
                "package.json",
                "README.md"
            )
            "Mobile Application" -> listOf(
                "src/",
                "src/components/",
                "src/screens/",
                "src/utils/",
                "assets/",
                "App.js",
                "package.json",
                "README.md"
            )
            "Desktop Application" -> listOf(
                "src/",
                "src/components/",
                "src/windows/",
                "src/utils/",
                "assets/",
                "main.js",
                "package.json",
                "README.md"
            )
            "Backend Service" -> listOf(
                "src/main/kotlin/",
                "src/main/resources/",
                "src/test/kotlin/",
                "build.gradle.kts",
                "README.md"
            )
            else -> listOf("Unable to generate project structure for unknown project type")
        }
    }
}
