package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val pressureRecipe = RecipeScaffold(
    title = "Pressure",
    problem = "Model a force distributed over an area.",
    tasks = listOf(
        "Calculate pressure from force divided by area.",
        "Calculate force from pressure multiplied by area.",
        "Use this recipe to inspect reciprocal operations.",
    ),
)

fun main() = pressureRecipe.print()
