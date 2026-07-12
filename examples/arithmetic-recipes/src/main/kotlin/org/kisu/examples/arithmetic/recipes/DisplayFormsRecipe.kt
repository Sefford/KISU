package org.kisu.examples.arithmetic.recipes

import org.kisu.examples.arithmetic.RecipeScaffold

val displayFormsRecipe = RecipeScaffold(
    title = "Display Forms",
    problem = "Compare literal, canonical, optimal, and default string output for the same measure.",
    tasks = listOf(
        "Print representation for the stored form.",
        "Print canonical.representation for the canonical form.",
        "Print optimal.representation and toString for display-oriented output.",
    ),
)

fun main() = displayFormsRecipe.print()
