package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val lightingRecipe = RecipeScaffold(
    title = "Lighting",
    problem = "Model light falling on a surface.",
    tasks = listOf(
        "Calculate luminous flux from illuminance multiplied by area.",
        "Recover illuminance by dividing luminous flux by area.",
        "Try luminous exposure by combining illuminance and time.",
    ),
)

fun main() = lightingRecipe.print()
