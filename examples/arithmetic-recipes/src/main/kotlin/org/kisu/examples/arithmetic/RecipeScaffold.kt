package org.kisu.examples.arithmetic

data class RecipeScaffold(
    val title: String,
    val problem: String,
    val tasks: List<String>,
) {
    fun print() {
        println(title)
        println(problem)
        tasks.forEach { task -> println("- $task") }
        println()
    }
}
