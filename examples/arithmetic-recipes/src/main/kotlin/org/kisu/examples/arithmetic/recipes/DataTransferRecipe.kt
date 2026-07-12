package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val dataTransferRecipe = RecipeScaffold(
    title = "Data Transfer",
    problem = "Model payload size, elapsed time, and transfer rate.",
    tasks = listOf(
        "Calculate transmission from information divided by time.",
        "Calculate transferred information from transmission multiplied by time.",
        "Try SI and IEC information prefixes and inspect canonical bits.",
    ),
)

fun main() = dataTransferRecipe.print()
