package org.kisu.examples.arithmetic

data class RecipeScaffold(
    val title: String,
    val problem: String,
    val tasks: List<String>,
) {
    fun print(output: ConsoleOutput = ConsoleOutput()) {
        output.heading(problem)
        tasks.forEach { task -> output.write("- $task") }
    }
}
