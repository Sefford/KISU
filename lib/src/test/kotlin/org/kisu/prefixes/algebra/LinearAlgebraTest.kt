package org.kisu.prefixes.algebra

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.kisu.Magnitude
import org.kisu.prefixes.HumanTime

class LinearAlgebraTest : StringSpec({
    "resolves concrete factors" {
        val algebra = LinearAlgebra<HumanTime>()

        algebra.factor(HumanTime.HOUR) shouldBe Magnitude.valueOf(3_600)
    }

    "multiplies concrete factors" {
        val algebra = LinearAlgebra<HumanTime>()

        algebra.multiply(HumanTime.MINUTE, HumanTime.MINUTE) shouldBe (HumanTime.HOUR to Magnitude.ONE)
    }

    "divides concrete factors" {
        val algebra = LinearAlgebra<HumanTime>()

        algebra.divide(HumanTime.HOUR, HumanTime.MINUTE) shouldBe (HumanTime.MINUTE to Magnitude.ONE)
    }
})
