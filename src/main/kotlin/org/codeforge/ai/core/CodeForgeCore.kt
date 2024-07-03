package org.codeforge.ai.core

import org.codeforge.ai.projectmanager.ProjectManager
import org.codeforge.ai.ai.AIAssistant
import org.codeforge.ai.codegen.CodeGenerationEngine
import org.codeforge.ai.pkl.PklIntegrationModule

class CodeForgeCore {
    private val projectManager = ProjectManager()
    private val aiAssistant = AIAssistant()
    private val codeGenerationEngine = CodeGenerationEngine()
    private val pklIntegrationModule = PklIntegrationModule()
    private val projectDefinitionEngine = ProjectDefinitionEngine(aiAssistant)

    fun createProject(name: String, type: String, requirements: String): String {
        val projectDefinition = projectDefinitionEngine.defineProject(name, type, requirements)
        val projectId = projectManager.createProject(projectDefinition)
        return "Project $name of type $type created with ID: $projectId"
    }

    fun generateCode(projectId: String): String {
        val projectDefinition = projectManager.getProject(projectId)
        val generatedCode = codeGenerationEngine.generateCode(
            projectDefinition["type"] as String,
            projectDefinition["requirements"] as String
        )
        return "Code generated for project $projectId: $generatedCode"
    }

    // Add more methods as needed
}
