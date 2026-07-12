package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val forceWorkRecipe = RecipeScaffold(
    title = "Force And Work",
    problem = "Model a moving mass and the work done over a distance.",
    tasks = listOf(
        "Calculate force from mass multiplied by acceleration.",
        "Calculate energy from force multiplied by length.",
        "Recover force by dividing energy by length.",
    ),
)

fun main() = forceWorkRecipe.print()
