package org.kisu.units.information

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.of
import io.kotest.property.arbitrary.positiveLong
import io.kotest.property.checkAll
import org.kisu.Magnitude
import org.kisu.magnitude
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.test.generators.magnitude
import org.kisu.test.matchers.plusOrMinus
import org.kisu.units.base.Bit
import org.kisu.units.base.Byte
import org.kisu.units.base.Information
import org.kisu.units.base.Time
import org.kisu.units.builders.bitsPerSecond
import org.kisu.units.builders.bytesPerSecond
import org.kisu.units.builders.kilo
import org.kisu.units.information.Transmission.Companion.InformationPerSecond
import org.kisu.prefixes.Binary as Iec
import org.kisu.prefixes.Decimal as Si
import org.kisu.test.generators.Binaries as IecPrefixes
import org.kisu.test.generators.BinaryBuilders as IecBuilders
import org.kisu.test.generators.Decimals as SiPrefixes

class TransmissionTest : StringSpec({
    val iecAlgebra = ExponentialAlgebra<Iec>(Magnitude.TWO)
    val siAlgebra = ExponentialAlgebra<Si>()
    val bitsPerByte = Magnitude(8)
    val precisionTolerance = Magnitude("0.000000000000000000000000000001")
    val exactIecPrefixes = Arb.of(Iec.BASE, Iec.KIBI, Iec.MEBI, Iec.GIBI)

    "creates base bit Transmission from a Number" {
        checkAll(Arb.magnitude()) { magnitude ->
            magnitude.bitsPerSecond.should { (amount, expression, symbol) ->
                amount shouldBe magnitude
                expression shouldBe InformationPerSecond(Bit(Iec.BASE))
                symbol shouldBe InformationPerSecond().toString()
            }
        }
    }

    "creates base byte Transmission from a Number" {
        checkAll(Arb.magnitude()) { magnitude ->
            magnitude.bytesPerSecond.should { (amount, expression, symbol) ->
                amount shouldBe magnitude
                expression shouldBe InformationPerSecond(Byte(Si.BASE))
                symbol shouldBe InformationPerSecond().toString()
            }
        }
    }

    "creates decimal Transmission from decimal builders" {
        checkAll(Arb.positiveLong()) { magnitude ->
            val amount = magnitude.magnitude

            magnitude.kilo.bitsPerSecond.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe InformationPerSecond(Bit(Si.KILO))
                symbol shouldBe InformationPerSecond().toString()
            }

            magnitude.kilo.bytesPerSecond.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe InformationPerSecond(Byte(Si.KILO))
                symbol shouldBe InformationPerSecond().toString()
            }
        }
    }

    "creates Transmission with an explicit decimal prefix" {
        Transmission(Magnitude.ONE, Si.KILO).should { (amount, expression, symbol) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe InformationPerSecond(Bit(Si.KILO))
            symbol shouldBe InformationPerSecond().toString()
        }
    }

    "creates IEC Transmission from binary builders" {
        checkAll(Arb.positiveLong(), IecBuilders.generator) { magnitude, builder ->
            val amount = magnitude.magnitude
            val binaryBuilder = magnitude.builder()

            binaryBuilder.bitsPerSecond.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe InformationPerSecond(Bit(binaryBuilder.binary))
                symbol shouldBe InformationPerSecond().toString()
            }

            binaryBuilder.bytesPerSecond.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe InformationPerSecond(Byte(binaryBuilder.binary))
                symbol shouldBe InformationPerSecond().toString()
            }
        }
    }

    "keeps optimal transmission representation in its original scale" {
        checkAll(SiPrefixes.generator) { prefix ->
            val factor = siAlgebra.factor(prefix)

            Transmission(factor, InformationPerSecond(Bit(Si.BASE))).optimal.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe InformationPerSecond(Bit(prefix))
            }
            Transmission(factor, InformationPerSecond(Byte(Si.BASE))).optimal.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe InformationPerSecond(Byte(prefix))
            }
        }

        checkAll(exactIecPrefixes) { prefix ->
            val factor = iecAlgebra.factor(prefix)

            Transmission(factor, InformationPerSecond(Bit(Iec.BASE))).optimal.should { (amount, expression) ->
                amount shouldBe (Magnitude.ONE plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Bit(prefix))
            }
            Transmission(factor, InformationPerSecond(Byte(Iec.BASE))).optimal.should { (amount, expression) ->
                amount shouldBe (Magnitude.ONE plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Byte(prefix))
            }
        }
    }

    "canonicalizes byte transmission to bits per second" {
        checkAll(Arb.positiveLong(), SiPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude

            Transmission(amount, InformationPerSecond(Byte(prefix))).canonical.should {
                    (canonicalAmount, expression, symbol) ->
                canonicalAmount shouldBe amount * bitsPerByte * siAlgebra.factor(prefix)
                expression shouldBe InformationPerSecond(Bit(Iec.BASE))
                symbol shouldBe InformationPerSecond().toString()
            }
        }

        checkAll(Arb.positiveLong(), IecPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude

            Transmission(amount, InformationPerSecond(Byte(prefix))).canonical.should {
                    (canonicalAmount, expression, symbol) ->
                canonicalAmount shouldBe amount * bitsPerByte * iecAlgebra.factor(prefix)
                expression shouldBe InformationPerSecond(Bit(Iec.BASE))
                symbol shouldBe InformationPerSecond().toString()
            }
        }
    }

    "converts between bit and byte rates" {
        checkAll(SiPrefixes.generator) { prefix ->
            Transmission(Magnitude.ONE, InformationPerSecond(Bit(prefix))).bits.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe InformationPerSecond(Bit(prefix))
            }
            Transmission(bitsPerByte, InformationPerSecond(Bit(prefix))).bytes.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe InformationPerSecond(Byte(prefix))
            }
            Transmission(Magnitude.ONE, InformationPerSecond(Byte(prefix))).bits.should { (amount, expression) ->
                amount shouldBe (bitsPerByte plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Bit(prefix))
            }
            Transmission(Magnitude.ONE, InformationPerSecond(Byte(prefix))).bytes.should { (amount, expression) ->
                amount shouldBe (Magnitude.ONE plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Byte(prefix))
            }
        }

        checkAll(exactIecPrefixes) { prefix ->
            Transmission(Magnitude.ONE, InformationPerSecond(Bit(prefix))).bits.should { (amount, expression) ->
                amount shouldBe (Magnitude.ONE plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Bit(prefix))
            }
            Transmission(bitsPerByte, InformationPerSecond(Bit(prefix))).bytes.should { (amount, expression) ->
                amount shouldBe (Magnitude.ONE plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Byte(prefix))
            }
            Transmission(Magnitude.ONE, InformationPerSecond(Byte(prefix))).bits.should { (amount, expression) ->
                amount shouldBe (bitsPerByte plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Bit(prefix))
            }
            Transmission(Magnitude.ONE, InformationPerSecond(Byte(prefix))).bytes.should { (amount, expression) ->
                amount shouldBe (Magnitude.ONE plusOrMinus precisionTolerance)
                expression shouldBe InformationPerSecond(Byte(prefix))
            }
        }
    }

    "converts between SI and IEC rate scales" {
        Transmission(Magnitude(1024), InformationPerSecond(Bit(Si.BASE))).iec.should {
                (amount, expression) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe InformationPerSecond(Bit(Iec.KIBI))
        }

        Transmission(Magnitude(1024), InformationPerSecond(Byte(Si.BASE))).iec.should {
                (amount, expression) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe InformationPerSecond(Byte(Iec.KIBI))
        }

        Transmission(Magnitude(1000), InformationPerSecond(Bit(Iec.BASE))).decimal.should {
                (amount, expression) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe InformationPerSecond(Bit(Si.KILO))
        }

        Transmission(Magnitude(1000), InformationPerSecond(Byte(Iec.BASE))).decimal.should {
                (amount, expression) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe InformationPerSecond(Byte(Si.KILO))
        }
    }

    "uses binary as an alias for IEC scale conversion" {
        Transmission(Magnitude(1024), InformationPerSecond(Bit(Si.BASE))).binary.should { converted ->
            converted shouldBe Transmission(Magnitude(1024), InformationPerSecond(Bit(Si.BASE)))
            converted.component2() shouldBe InformationPerSecond(Bit(Iec.KIBI))
        }
    }

    // Dimension-aware arithmetic properties
    "multiplying a Transmission by a Time returns Information" {
        checkAll(
            50,
            Arb.positiveLong(),
            Arb.positiveLong(),
            IecPrefixes.generator,
        ) { leftMagnitude, rightMagnitude, prefix ->
            val left = Transmission(leftMagnitude.magnitude, Bit(prefix))
            val right = Time(rightMagnitude.magnitude)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Information(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    // End dimension-aware arithmetic properties
})
