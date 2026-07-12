package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val tripPlannerRecipe = RecipeScaffold(
    title = "Trip Planner",
    problem = "Model a trip with distance and elapsed time.",
    tasks = listOf(
        "Calculate speed from distance divided by time.",
        "Calculate distance again from speed multiplied by time.",
        "Compare representation, canonical, optimal, and toString output.",
    ),
)

fun main() = tripPlannerRecipe.print()
