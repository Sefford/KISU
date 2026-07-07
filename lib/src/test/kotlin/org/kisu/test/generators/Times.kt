package org.kisu.test.generators

import io.kotest.property.Arb
import io.kotest.property.arbitrary.of
import org.kisu.prefixes.HumanTime
import org.kisu.prefixes.primitives.LinearEnumSystem

object Times : Generator<HumanTime> {
    override val generator: Arb<HumanTime> = Arb.of(LinearEnumSystem(HumanTime::class).all)
}
