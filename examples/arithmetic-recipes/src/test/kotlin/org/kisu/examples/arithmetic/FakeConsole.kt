package org.kisu.examples.arithmetic

class FakeConsole(
    private val registry: MutableList<String> = mutableListOf(),
) {

    val lines: List<String>
        get() = registry.toList()
    val last: String
        get() = registry.last()

    fun record(line: String) {
        registry.add(line)
    }

}