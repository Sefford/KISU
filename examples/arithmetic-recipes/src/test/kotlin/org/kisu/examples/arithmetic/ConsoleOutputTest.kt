package org.kisu.examples.arithmetic

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll
import sun.nio.ch.IOStatus.checkAll
import kotlin.test.Test
import kotlin.test.assertEquals

class ConsoleOutputTest: StringSpec( {
    isolationMode = IsolationMode.InstancePerTest

    val console = FakeConsole()

    "writes a line" {
        checkAll(Arb.string()) { text ->
            val output = ConsoleOutput(console::record)

            output.write(text)

            console.last shouldBe text
        }
    }

    "writes a text with a newline" {
        checkAll(Arb.string()) { text ->
            val output = ConsoleOutput(console::record)

            output.writeLine(text)

            console.lines.should { lines ->
                lines.size.shouldBeExactly(2)
                lines.first().shouldBe(text)
                lines.last().shouldBe("\\\\s")
            }
        }
    }
})
