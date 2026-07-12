package org.kisu.examples.arithmetic

import org.kisu.examples.arithmetic.recipes.chemistryRecipe
import org.kisu.examples.arithmetic.recipes.dataTransferRecipe
import org.kisu.examples.arithmetic.recipes.displayFormsRecipe
import org.kisu.examples.arithmetic.recipes.electricBasicsRecipe
import org.kisu.examples.arithmetic.recipes.forceWorkRecipe
import org.kisu.examples.arithmetic.recipes.lightingRecipe
import org.kisu.examples.arithmetic.recipes.pressureRecipe
import org.kisu.examples.arithmetic.recipes.roomGeometryRecipe
import org.kisu.examples.arithmetic.recipes.tripPlannerRecipe

fun main() {
    listOf(
        tripPlannerRecipe,
        roomGeometryRecipe,
        forceWorkRecipe,
        electricBasicsRecipe,
        dataTransferRecipe,
        lightingRecipe,
        pressureRecipe,
        chemistryRecipe,
        displayFormsRecipe,
    ).forEach { recipe ->
        recipe.print()
    }
}
