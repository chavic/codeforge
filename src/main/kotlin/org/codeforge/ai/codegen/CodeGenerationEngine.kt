package org.codeforge.ai.codegen

class CodeGenerationEngine(private val templateEngine: TemplateEngine) {
    fun generateCode(projectType: String, requirements: String): String {
        val template = templateEngine.loadTemplate(projectType)
        val variables = mapOf(
            "projectType" to projectType,
            "requirements" to requirements
        )
        return templateEngine.applyTemplate(template, variables)
    }

    // Add more code generation methods as needed
}
