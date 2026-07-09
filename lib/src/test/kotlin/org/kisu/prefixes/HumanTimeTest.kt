package org.kisu.prefixes

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeUnique
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.kisu.Magnitude
import java.math.BigInteger

class HumanTimeTest : StringSpec({
    "defines exact human-readable elapsed durations" {
        HumanTime.entries.shouldContainExactly(
            HumanTime.QUECTOSECOND,
            HumanTime.RONTOSECOND,
            HumanTime.YOCTOSECOND,
            HumanTime.ZEPTOSECOND,
            HumanTime.ATTOSECOND,
            HumanTime.FEMTOSECOND,
            HumanTime.PICOSECOND,
            HumanTime.NANOSECOND,
            HumanTime.MICROSECOND,
            HumanTime.MILLISECOND,
            HumanTime.SECOND,
            HumanTime.MINUTE,
            HumanTime.HOUR,
            HumanTime.DAY,
            HumanTime.WEEK,
            HumanTime.MONTH,
            HumanTime.YEAR,
            HumanTime.DECADE,
            HumanTime.CENTURY,
            HumanTime.MILLENNIUM,
        )
    }

    "uses unique unit symbols" {
        HumanTime.entries.map(HumanTime::symbol).shouldBeUnique()
    }

    "uses second as the canonical unit" {
        HumanTime.SECOND.canonical shouldBe HumanTime.SECOND
    }

    "uses exact second factors" {
        HumanTime.QUECTOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 30)
        HumanTime.RONTOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 27)
        HumanTime.YOCTOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 24)
        HumanTime.ZEPTOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 21)
        HumanTime.ATTOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 18)
        HumanTime.FEMTOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 15)
        HumanTime.PICOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 12)
        HumanTime.NANOSECOND.factor shouldBe Magnitude(BigInteger.ONE, 9)
        HumanTime.MICROSECOND.factor shouldBe Magnitude(BigInteger.ONE, 6)
        HumanTime.MILLISECOND.factor shouldBe Magnitude(BigInteger.ONE, 3)
        HumanTime.SECOND.factor shouldBe Magnitude.ONE
        HumanTime.MINUTE.factor shouldBe Magnitude(60)
        HumanTime.HOUR.factor shouldBe Magnitude(3_600)
        HumanTime.DAY.factor shouldBe Magnitude(86_400)
        HumanTime.WEEK.factor shouldBe Magnitude(604_800)
        HumanTime.MONTH.factor shouldBe Magnitude(2_592_000)
        HumanTime.YEAR.factor shouldBe Magnitude(31_536_000)
        HumanTime.DECADE.factor shouldBe Magnitude(315_360_000)
        HumanTime.CENTURY.factor shouldBe Magnitude(3_153_600_000)
        HumanTime.MILLENNIUM.factor shouldBe Magnitude(31_536_000_000)
    }

    "converts SI prefixes with named human-time equivalents" {
        Metric.QUECTO.asHumanTime() shouldBe HumanTime.QUECTOSECOND
        Metric.RONTO.asHumanTime() shouldBe HumanTime.RONTOSECOND
        Metric.YOCTO.asHumanTime() shouldBe HumanTime.YOCTOSECOND
        Metric.ZEPTO.asHumanTime() shouldBe HumanTime.ZEPTOSECOND
        Metric.ATTO.asHumanTime() shouldBe HumanTime.ATTOSECOND
        Metric.FEMTO.asHumanTime() shouldBe HumanTime.FEMTOSECOND
        Metric.PICO.asHumanTime() shouldBe HumanTime.PICOSECOND
        Metric.NANO.asHumanTime() shouldBe HumanTime.NANOSECOND
        Metric.MICRO.asHumanTime() shouldBe HumanTime.MICROSECOND
        Metric.MILLI.asHumanTime() shouldBe HumanTime.MILLISECOND
        Metric.BASE.asHumanTime() shouldBe HumanTime.SECOND
    }

    "rejects SI prefixes without a named human-time equivalent" {
        shouldThrow<IllegalArgumentException> {
            Metric.CENTI.asHumanTime()
        }
        shouldThrow<IllegalArgumentException> {
            Metric.KILO.asHumanTime()
        }
    }
})
