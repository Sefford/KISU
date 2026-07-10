package org.kisu.units.base

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.element
import io.kotest.property.arbitrary.map
import io.kotest.property.arbitrary.positiveLong
import io.kotest.property.checkAll
import org.kisu.Magnitude
import org.kisu.magnitude
import org.kisu.prefixes.InformationPrefix
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.test.assertions.shouldEqualCanonicalBits
import org.kisu.test.assertions.shouldUseIecBitScale
import org.kisu.test.assertions.shouldUseIecByteScale
import org.kisu.test.assertions.shouldUseSiBitScale
import org.kisu.test.assertions.shouldUseSiByteScale
import org.kisu.test.generators.magnitude
import org.kisu.test.generators.reciprocalMagnitude
import org.kisu.units.builders.DecimalUnitBuilder
import org.kisu.units.builders.ExaBuilder
import org.kisu.units.builders.GigaBuilder
import org.kisu.units.builders.HectoBuilder
import org.kisu.units.builders.KiloBuilder
import org.kisu.units.builders.MegaBuilder
import org.kisu.units.builders.MetricUnitBuilder
import org.kisu.units.builders.PetaBuilder
import org.kisu.units.builders.QuettaBuilder
import org.kisu.units.builders.RonnaBuilder
import org.kisu.units.builders.TeraBuilder
import org.kisu.units.builders.YottaBuilder
import org.kisu.units.builders.ZettaBuilder
import org.kisu.units.builders.bits
import org.kisu.units.builders.bytes
import org.kisu.units.builders.kilo
import org.kisu.units.exceptions.SubBitInformation
import org.kisu.units.information.Transmission
import org.kisu.prefixes.Binary as Iec
import org.kisu.prefixes.Decimal as Si
import org.kisu.test.generators.Binaries as IecPrefixes
import org.kisu.test.generators.BinaryBuilders as IecBuilders
import org.kisu.test.generators.Decimals as SiPrefixes
import org.kisu.test.generators.Metrics as MetricPrefixes

class InformationTest : StringSpec({
    val iecAlgebra = ExponentialAlgebra<Iec>(Magnitude.TWO)
    val siAlgebra = ExponentialAlgebra<Si>()
    val bitsPerByte = Magnitude(8)

    "fractional information is physically meaningless" {
        checkAll(
            Arb.magnitude(minFractionalDigits = 1).map { it.abs },
            IecBuilders.generator
        ) { magnitude, builder ->
            val scaled = magnitude / iecAlgebra.factor(magnitude.builder().binary)
            shouldThrow<SubBitInformation> { scaled.builder().bits }
        }
    }

    "creates Information" {
        checkAll(Arb.positiveLong(), IecBuilders.generator) { magnitude, builder ->
            magnitude.builder().bits.should { (amount, expression, symbol) ->
                amount shouldBe magnitude.magnitude
                expression shouldBe Bit(magnitude.builder().binary)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "creates a base Information" {
        checkAll(Arb.positiveLong()) { magnitude ->
            magnitude.bits.should { (amount, expression, symbol) ->
                amount shouldBe magnitude.magnitude
                expression shouldBe Bit(Iec.BASE)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "creates a base Information from the companion shortcut" {
        Information(Magnitude.ONE).should { (amount, expression, symbol) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe Bit(Iec.BASE)
            symbol shouldBe Bit.UNIT.toString()
        }
    }

    "creates Information with an explicit IEC prefix" {
        Information(Magnitude.ONE, Iec.KIBI).should { (amount, expression, symbol) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe Bit(Iec.KIBI)
            symbol shouldBe Bit.UNIT.toString()
        }
    }

    "creates Information through the default IEC prefix overload" {
        val companionClass = Class.forName("org.kisu.units.base.Information\$Companion")
        val defaultInvoke = companionClass.getDeclaredMethod(
            "invoke\$default",
            companionClass,
            Magnitude::class.java,
            Iec::class.java,
            java.lang.Integer.TYPE,
            Any::class.java,
        )
        val information = defaultInvoke.invoke(null, Information, Magnitude.ONE, null, 2, null) as Information

        information.should { (amount, expression, symbol) ->
            amount shouldBe Magnitude.ONE
            expression shouldBe Bit(Iec.BASE)
            symbol shouldBe Bit.UNIT.toString()
        }
    }

    "creates byte Information from a Number" {
        7.bytes.should { (amount, expression, symbol) ->
            amount shouldBe 7.magnitude
            expression shouldBe Byte(Si.BASE)
            symbol shouldBe Bit.UNIT.toString()
        }
    }

    "creates decimal byte Information from decimal builder locations" {
        checkAll(Arb.positiveLong(), Arb.element(supportedDecimalByteBuilders)) { magnitude, builderCase ->
            val amount = magnitude.magnitude
            val (builder, prefix) = builderCase

            builder(amount).bytes.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe Byte(prefix)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "creates decimal bit Information from decimal builders" {
        checkAll(Arb.positiveLong(), Arb.element(supportedDecimalInformationBuilders)) { magnitude, builderCase ->
            val amount = magnitude.magnitude
            val (builder, prefix) = builderCase

            builder(amount).bits.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe Bit(prefix)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "creates decimal byte Information from decimal builders" {
        checkAll(Arb.positiveLong(), Arb.element(supportedDecimalInformationBuilders)) { magnitude, builderCase ->
            val amount = magnitude.magnitude
            val (builder, prefix) = builderCase

            builder(amount).bytes.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe Byte(prefix)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "creates decimal Information from number prefix extensions" {
        checkAll(Arb.positiveLong()) { magnitude ->
            val amount = magnitude.magnitude

            magnitude.kilo.bits.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe Bit(Si.KILO)
                symbol shouldBe Bit.UNIT.toString()
            }

            magnitude.kilo.bytes.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe Byte(Si.KILO)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "creates IEC byte Information from binary builders" {
        checkAll(Arb.positiveLong(), IecBuilders.generator) { magnitude, builder ->
            val amount = magnitude.magnitude
            val binaryBuilder = magnitude.builder()

            binaryBuilder.bytes.should { (actualAmount, expression, symbol) ->
                actualAmount shouldBe amount
                expression shouldBe Byte(binaryBuilder.binary)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "maps every supported metric prefix to a decimal information prefix" {
        supportedMetricPrefixes.forEach { (metric, decimal) ->
            metric.toDecimalInformationPrefixForTest() shouldBe decimal
        }
    }

    "rejects metric byte prefixes without decimal information equivalents" {
        unsupportedMetricPrefixes.forEach { metric ->
            shouldThrow<IllegalArgumentException> { metric.toDecimalInformationPrefixForTest() }
        }

        val unsupportedBuilder: MetricUnitBuilder = HectoBuilder(Magnitude.ONE)

        (unsupportedBuilder is DecimalUnitBuilder) shouldBe false
    }

    "keeps optimal information representation in its original scale" {
        checkAll(SiPrefixes.generator) { prefix ->
            val factor = siAlgebra.factor(prefix)

            Information(factor, Bit(Si.BASE)).optimal.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Bit(prefix)
            }
            Information(factor, Byte(Si.BASE)).optimal.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Byte(prefix)
            }
        }

        checkAll(IecPrefixes.generator) { prefix ->
            val factor = iecAlgebra.factor(prefix)

            Information(factor, Bit(Iec.BASE)).optimal.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Bit(prefix)
            }
            Information(factor, Byte(Iec.BASE)).optimal.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Byte(prefix)
            }
        }
    }

    "canonicalizes byte information to bits" {
        checkAll(Arb.positiveLong(), SiPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude

            Information(amount, Byte(prefix)).canonical.should { (canonicalAmount, expression, symbol) ->
                canonicalAmount shouldBe amount * bitsPerByte * siAlgebra.factor(prefix)
                expression shouldBe Bit(Iec.BASE)
                symbol shouldBe Bit.UNIT.toString()
            }
        }

        checkAll(Arb.positiveLong(), IecPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude

            Information(amount, Byte(prefix)).canonical.should { (canonicalAmount, expression, symbol) ->
                canonicalAmount shouldBe amount * bitsPerByte * iecAlgebra.factor(prefix)
                expression shouldBe Bit(Iec.BASE)
                symbol shouldBe Bit.UNIT.toString()
            }
        }
    }

    "matches SI and IEC bit and byte units by canonical bits" {
        checkAll(Arb.positiveLong(), SiPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude
            val factor = siAlgebra.factor(prefix)

            Information(amount, Bit(prefix)).shouldEqualCanonicalBits(amount * factor)
            Information(amount, Byte(prefix)).shouldEqualCanonicalBits(amount * bitsPerByte * factor)
            Information(amount, Byte(prefix)) shouldBe Information(amount * bitsPerByte, Bit(prefix))
        }

        checkAll(Arb.positiveLong(), IecPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude
            val factor = iecAlgebra.factor(prefix)

            Information(amount, Bit(prefix)).shouldEqualCanonicalBits(amount * factor)
            Information(amount, Byte(prefix)).shouldEqualCanonicalBits(amount * bitsPerByte * factor)
            Information(amount, Byte(prefix)) shouldBe Information(amount * bitsPerByte, Bit(prefix))
        }
    }

    "orders information prefixes through the marker interface" {
        val base: InformationPrefix<Si> = Si.BASE

        base.compareTo(Si.KILO) shouldBe Si.BASE.power.compareTo(Si.KILO.power)
        base.sortWith(Si.KILO) shouldBe (Si.BASE to Si.KILO)
    }

    "uses information prefix default comparison helpers" {
        val defaultImpls = Class.forName("org.kisu.prefixes.InformationPrefix\$DefaultImpls")
        val compareTo = defaultImpls.getDeclaredMethod(
            "compareTo",
            InformationPrefix::class.java,
            InformationPrefix::class.java,
        )
        val sortWith = defaultImpls.getDeclaredMethod(
            "sortWith",
            InformationPrefix::class.java,
            InformationPrefix::class.java,
        )

        compareTo.invoke(null, Si.BASE, Si.KILO) shouldBe Si.BASE.power.compareTo(Si.KILO.power)
        sortWith.invoke(null, Si.KILO, Si.BASE) shouldBe (Si.BASE to Si.KILO)
    }

    "exposes information unit scalar factors" {
        Bit(Si.KILO).factors.single().symbol shouldBe "kbit"
        Byte(Iec.KIBI).factors.single().symbol shouldBe "KiB"
    }

    "decomposes information units into prefixed components" {
        Bit(Si.BASE).decompose(Magnitude(1000)) shouldBe listOf(Magnitude.ONE to Bit(Si.KILO))
        Byte(Si.BASE).decompose(Magnitude(1000)) shouldBe listOf(Magnitude.ONE to Byte(Si.KILO))
    }

    "hashes information units by prefix" {
        Bit(Si.KILO).hashCode() shouldBe Si.KILO.hashCode()
        Byte(Iec.KIBI).hashCode() shouldBe Iec.KIBI.hashCode()
    }

    "converts between bit and byte units" {
        checkAll(SiPrefixes.generator) { prefix ->
            Information(Magnitude.ONE, Bit(prefix)).bits.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Bit(prefix)
            }
            Information(bitsPerByte, Bit(prefix)).bytes.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Byte(prefix)
            }
            Information(Magnitude.ONE, Byte(prefix)).bits.should { (amount, expression) ->
                amount shouldBe bitsPerByte
                expression shouldBe Bit(prefix)
            }
            Information(Magnitude.ONE, Byte(prefix)).bytes.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Byte(prefix)
            }
        }

        checkAll(IecPrefixes.generator) { prefix ->
            Information(Magnitude.ONE, Bit(prefix)).bits.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Bit(prefix)
            }
            Information(bitsPerByte, Bit(prefix)).bytes.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Byte(prefix)
            }
            Information(Magnitude.ONE, Byte(prefix)).bits.should { (amount, expression) ->
                amount shouldBe bitsPerByte
                expression shouldBe Bit(prefix)
            }
            Information(Magnitude.ONE, Byte(prefix)).bytes.should { (amount, expression) ->
                amount shouldBe Magnitude.ONE
                expression shouldBe Byte(prefix)
            }
        }
    }

    "converts between SI and IEC scales" {
        checkAll(Arb.positiveLong(), SiPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude
            val bits = Information(amount, Bit(prefix))
            val bytes = Information(amount, Byte(prefix))

            bits.iec.should { converted ->
                converted shouldBe bits
                converted.component2().shouldUseIecBitScale()
            }
            bytes.iec.should { converted ->
                converted shouldBe bytes
                converted.component2().shouldUseIecByteScale()
            }
        }

        checkAll(Arb.positiveLong(), IecPrefixes.generator) { magnitude, prefix ->
            val amount = magnitude.magnitude
            val bits = Information(amount, Bit(prefix))
            val bytes = Information(amount, Byte(prefix))

            bits.decimal.should { converted ->
                converted shouldBe bits
                converted.component2().shouldUseSiBitScale()
            }
            bytes.decimal.should { converted ->
                converted shouldBe bytes
                converted.component2().shouldUseSiByteScale()
            }
        }
    }

    "uses binary as an alias for IEC scale conversion" {
        Information(Magnitude(1024), Bit(Si.BASE)).binary.should { converted ->
            converted shouldBe Information(Magnitude(1024), Bit(Si.BASE))
            converted.component2().shouldUseIecBitScale()
        }
    }

    // Dimension-aware arithmetic properties
    "dividing Information by Time returns Transmission" {
        checkAll(
            50,
            Arb.positiveLong(),
            Arb.reciprocalMagnitude(),
            IecPrefixes.generator,
            MetricPrefixes.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Information(leftMagnitude.magnitude, Bit(leftPrefix))
            val right = Time(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() / right.canonical.component1()
            val expected = Transmission(expectedMagnitude)

            (left / right) shouldBe expected
        }
    }

    "dividing Information by Transmission returns Time" {
        checkAll(
            50,
            Arb.positiveLong(),
            Arb.reciprocalMagnitude(),
            IecPrefixes.generator,
            IecPrefixes.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Information(leftMagnitude.magnitude, Bit(leftPrefix))
            val right = Transmission(rightMagnitude, Bit(rightPrefix))
            val expectedMagnitude = left.canonical.component1() / right.canonical.component1()
            val expected = Time(expectedMagnitude)

            (left / right) shouldBe expected
        }
    }
    // End dimension-aware arithmetic properties
})

private val supportedDecimalByteBuilders: List<Pair<(Magnitude) -> DecimalUnitBuilder, Si>> = listOf(
    { magnitude: Magnitude -> KiloBuilder(magnitude) } to Si.KILO,
    { magnitude: Magnitude -> MegaBuilder(magnitude) } to Si.MEGA,
    { magnitude: Magnitude -> GigaBuilder(magnitude) } to Si.GIGA,
    { magnitude: Magnitude -> TeraBuilder(magnitude) } to Si.TERA,
    { magnitude: Magnitude -> PetaBuilder(magnitude) } to Si.PETA,
    { magnitude: Magnitude -> ExaBuilder(magnitude) } to Si.EXA,
    { magnitude: Magnitude -> ZettaBuilder(magnitude) } to Si.ZETTA,
    { magnitude: Magnitude -> YottaBuilder(magnitude) } to Si.YOTTA,
    { magnitude: Magnitude -> RonnaBuilder(magnitude) } to Si.RONNA,
    { magnitude: Magnitude -> QuettaBuilder(magnitude) } to Si.QUETTA,
)

private val supportedDecimalInformationBuilders: List<Pair<(Magnitude) -> DecimalUnitBuilder, Si>> = listOf(
    { magnitude: Magnitude -> KiloBuilder(magnitude) } to Si.KILO,
    { magnitude: Magnitude -> MegaBuilder(magnitude) } to Si.MEGA,
    { magnitude: Magnitude -> GigaBuilder(magnitude) } to Si.GIGA,
    { magnitude: Magnitude -> TeraBuilder(magnitude) } to Si.TERA,
    { magnitude: Magnitude -> PetaBuilder(magnitude) } to Si.PETA,
    { magnitude: Magnitude -> ExaBuilder(magnitude) } to Si.EXA,
    { magnitude: Magnitude -> ZettaBuilder(magnitude) } to Si.ZETTA,
    { magnitude: Magnitude -> YottaBuilder(magnitude) } to Si.YOTTA,
    { magnitude: Magnitude -> RonnaBuilder(magnitude) } to Si.RONNA,
    { magnitude: Magnitude -> QuettaBuilder(magnitude) } to Si.QUETTA,
)

private val supportedMetricPrefixes: List<Pair<Metric, Si>> = listOf(
    Metric.BASE to Si.BASE,
    Metric.KILO to Si.KILO,
    Metric.MEGA to Si.MEGA,
    Metric.GIGA to Si.GIGA,
    Metric.TERA to Si.TERA,
    Metric.PETA to Si.PETA,
    Metric.EXA to Si.EXA,
    Metric.ZETTA to Si.ZETTA,
    Metric.YOTTA to Si.YOTTA,
    Metric.RONNA to Si.RONNA,
    Metric.QUETTA to Si.QUETTA,
)

private val unsupportedMetricPrefixes: List<Metric> = listOf(
    Metric.QUECTO,
    Metric.RONTO,
    Metric.YOCTO,
    Metric.ZEPTO,
    Metric.ATTO,
    Metric.FEMTO,
    Metric.PICO,
    Metric.NANO,
    Metric.MICRO,
    Metric.MILLI,
    Metric.CENTI,
    Metric.DECI,
    Metric.DECA,
    Metric.HECTO,
)

private fun Metric.toDecimalInformationPrefixForTest(): Si = asDecimal()
