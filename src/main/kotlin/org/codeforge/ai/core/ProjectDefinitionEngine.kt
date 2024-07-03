package org.codeforge.ai.core

import org.codeforge.ai.ai.AIAssistant

class ProjectDefinitionEngine(private val aiAssistant: AIAssistant) {
    fun defineProject(name: String, type: String, requirements: String): Map<String, Any> {
        val analysis = aiAssistant.analyzeRequirements(requirements)
        val techStack = aiAssistant.suggestTechnologyStack(type)
        val structure = aiAssistant.generateProjectStructure(type)

        return mapOf(
            "name" to name,
            "type" to type,
            "requirements" to requirements,
            "analysis" to analysis,
            "techStack" to techStack,
            "structure" to structure
        )
    }
}
