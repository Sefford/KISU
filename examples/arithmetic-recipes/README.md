# Arithmetic Recipes

This example project is a playground for KISU's dimension-aware arithmetic.

The recipe entry points are intentionally scaffold-only: they describe problems to solve, but do not perform the
calculations yet. Fill them in by hand when testing the public API.

`ConsoleInput` and `ConsoleOutput` handle the repetitive CLI boundary without supplying any recipe logic. For example:

```kotlin
val output = ConsoleOutput()
val input = ConsoleInput(output)

val distance = input.magnitude("Distance in kilometres") { value ->
    if (value <= Magnitude.ZERO) "distance must be greater than zero" else null
}
val unit = input.choice("Output unit", mapOf("km" to Metric.KILO, "m" to Metric.BASE))

// Build KISU measures and perform the recipe calculation here.

output.result("Distance", distance)
output.result("Unit", unit)
```

Text is trimmed, numeric input is parsed directly as `Magnitude`, choices are case-insensitive, and invalid input is
re-prompted with a concise error. Input is limited to 128 characters and terminal control characters are rejected.
`EndOfInputException` is thrown if standard input closes before a valid answer is available.

Run all recipe stubs:

```bash
./gradlew :examples:arithmetic-recipes:run
```

Run an individual recipe stub:

```bash
./gradlew :examples:arithmetic-recipes:runTripPlannerRecipe
./gradlew :examples:arithmetic-recipes:runRoomGeometryRecipe
./gradlew :examples:arithmetic-recipes:runForceWorkRecipe
./gradlew :examples:arithmetic-recipes:runElectricBasicsRecipe
./gradlew :examples:arithmetic-recipes:runDataTransferRecipe
./gradlew :examples:arithmetic-recipes:runLightingRecipe
./gradlew :examples:arithmetic-recipes:runPressureRecipe
./gradlew :examples:arithmetic-recipes:runChemistryRecipe
./gradlew :examples:arithmetic-recipes:runDisplayFormsRecipe
```
