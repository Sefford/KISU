package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val chemistryRecipe = RecipeScaffold(
    title = "Chemistry",
    problem = "Model amount of substance, solution volume, and concentration.",
    tasks = listOf(
        "Calculate molarity from amount divided by volume.",
        "Calculate amount from molarity multiplied by volume.",
        "Try molar energy and heat capacity relationships.",
    ),
)

fun main() = chemistryRecipe.print()
