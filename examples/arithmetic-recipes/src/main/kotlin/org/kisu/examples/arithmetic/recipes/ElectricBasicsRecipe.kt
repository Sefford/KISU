package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val electricBasicsRecipe = RecipeScaffold(
    title = "Electric Basics",
    problem = "Model a simple DC circuit with current, resistance, voltage, power, and charge.",
    tasks = listOf(
        "Calculate electric potential from current multiplied by resistance.",
        "Calculate power from electric potential multiplied by current.",
        "Calculate electric charge from current multiplied by time.",
    ),
)

fun main() = electricBasicsRecipe.print()
