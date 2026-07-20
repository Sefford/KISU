package org.kisu.examples.arithmetic

import org.kisu.Magnitude
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ConsoleInputTest {
//    @Test
//    fun `magnitude retries until input is numeric and accepted`() {
//        val console = TestConsole("nope", "-2", " 12.50 ")
//        val input = ConsoleInput(console.output, console::read)
//
//        val value = input.magnitude("Distance") {
//            if (it <= Magnitude.ZERO) "must be positive" else null
//        }
//
//        assertEquals(Magnitude("12.50"), value)
//        assertEquals(
//            "Distance: Invalid input: enter a number, for example 12.5\n" +
//                "Distance: Invalid input: must be positive\n" +
//                "Distance: ",
//            console.printed.toString(),
//        )
//    }
//
//    @Test
//    fun `choice ignores surrounding whitespace and case`() {
//        val console = TestConsole("  KM  ")
//        val input = ConsoleInput(console.output, console::read)
//
//        val unit = input.choice("Unit", mapOf("km" to 1, "m" to 2))
//
//        assertEquals(1, unit)
//    }
//
//    @Test
//    fun `control characters are rejected before parsing`() {
//        val console = TestConsole("12\u001B", "7")
//        val input = ConsoleInput(console.output, console::read)
//
//        assertEquals(Magnitude(7), input.magnitude("Value"))
//        assertEquals(
//            "Value: Invalid input: control characters are not allowed\nValue: ",
//            console.printed.toString(),
//        )
//    }
//
//    @Test
//    fun `closed input is explicit`() {
//        val console = TestConsole()
//        val input = ConsoleInput(console.output, console::read)
//
//        assertFailsWith<EndOfInputException> { input.text("Name") }
//    }

    private class TestConsole(vararg input: String) {
        private val lines = ArrayDeque(input.toList())
        val printed = StringBuilder()
        val output = ConsoleOutput(printed::append)

        fun read(): String? = lines.removeFirstOrNull()
    }
}
