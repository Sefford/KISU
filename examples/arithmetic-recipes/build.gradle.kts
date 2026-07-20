import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm")
    application
}

dependencies {
    implementation(project(":lib"))

    // Test Dependencies
    testImplementation(kotlin("test"))

    // Kotest
    testImplementation(libs.kotest)
    testImplementation(libs.kotest.assertions)
    testImplementation(libs.kotest.property)
}

kotlin {
    jvmToolchain(25)
    compilerOptions {
        apiVersion.set(KotlinVersion.KOTLIN_2_4)
        languageVersion.set(KotlinVersion.KOTLIN_2_4)
    }
}

application {
    mainClass.set("org.kisu.examples.arithmetic.MainKt")
}

fun registerRecipe(name: String, mainClassName: String) {
    tasks.register<JavaExec>(name) {
        group = "examples"
        description = "Runs the $name arithmetic recipe scaffold."
        classpath = sourceSets.main.get().runtimeClasspath
        mainClass.set(mainClassName)
    }
}

registerRecipe("runTripPlannerRecipe", "org.kisu.examples.arithmetic.recipes.TripPlannerRecipeKt")
registerRecipe("runRoomGeometryRecipe", "org.kisu.examples.arithmetic.recipes.RoomGeometryRecipeKt")
registerRecipe("runForceWorkRecipe", "org.kisu.examples.arithmetic.recipes.ForceWorkRecipeKt")
registerRecipe("runElectricBasicsRecipe", "org.kisu.examples.arithmetic.recipes.ElectricBasicsRecipeKt")
registerRecipe("runDataTransferRecipe", "org.kisu.examples.arithmetic.recipes.DataTransferRecipeKt")
registerRecipe("runLightingRecipe", "org.kisu.examples.arithmetic.recipes.LightingRecipeKt")
registerRecipe("runPressureRecipe", "org.kisu.examples.arithmetic.recipes.PressureRecipeKt")
registerRecipe("runChemistryRecipe", "org.kisu.examples.arithmetic.recipes.ChemistryRecipeKt")
registerRecipe("runDisplayFormsRecipe", "org.kisu.examples.arithmetic.recipes.DisplayFormsRecipeKt")
