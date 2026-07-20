package org.kisu.examples.arithmetic

/** Small, terminal-safe output helper for the interactive recipes. */
class ConsoleOutput(
    private val output: (String) -> Unit = ::print,
) {
    fun write(text: String) {
        output(text.safe)
    }

    fun newLine() { write("\n") }

    fun writeLine(text: String) {
        write(text)
        newLine()
    }

    fun heading(title: String) {
        newLine()
        writeLine("=== ${title.safe} ===")
        newLine()
    }
}
