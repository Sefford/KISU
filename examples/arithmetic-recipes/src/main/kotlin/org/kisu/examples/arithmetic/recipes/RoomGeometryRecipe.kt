package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val roomGeometryRecipe = RecipeScaffold(
    title = "Room Geometry",
    problem = "Model a rectangular room using mixed length prefixes.",
    tasks = listOf(
        "Calculate floor area from two lengths.",
        "Calculate room volume from area and height.",
        "Use mixed prefixes to make canonical conversion visible.",
    ),
)

fun main() = roomGeometryRecipe.print()
