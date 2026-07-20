package org.kisu.examples.arithmetic

import org.kisu.Magnitude

/**
 * Reads trimmed, bounded input and keeps prompting until it receives a valid value.
 *
 * A validator returns `null` for an accepted value or a short explanation for a rejected one.
 */
class ConsoleInput(
    private val output: ConsoleOutput = ConsoleOutput(),
    private val input: () -> String? = ::readlnOrNull,
) {

    fun read(title: String): Magnitude {
        var value: Magnitude? = null
        output.heading(title)
        while (value == null) {
            runCatching {
                Magnitude(input()?.toBigDecimal()!!)
            }.fold(onFailure = { error ->
                output.writeLine(error.message ?: "Unknown error")
            }, onSuccess = { input -> value = input })
        }
        return value
    }
}
