package org.kisu.examples.arithmetic

val String.safe: String
    get() = buildString(length) {
        this@safe.forEach { character ->
            append(if (character.isISOControl()) ' ' else character)
        }
    }