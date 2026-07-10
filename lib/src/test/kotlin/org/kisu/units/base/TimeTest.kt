package org.kisu.units.base

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.positiveLong
import io.kotest.property.checkAll
import org.kisu.Magnitude
import org.kisu.magnitude
import org.kisu.prefixes.HumanTime
import org.kisu.prefixes.Metric
import org.kisu.test.generators.MetricBuilders
import org.kisu.test.generators.Metrics
import org.kisu.test.generators.Times
import org.kisu.test.generators.magnitude
import org.kisu.test.generators.reciprocalMagnitude
import org.kisu.units.builders.attoseconds
import org.kisu.units.builders.centuries
import org.kisu.units.builders.days
import org.kisu.units.builders.decades
import org.kisu.units.builders.femtoseconds
import org.kisu.units.builders.hours
import org.kisu.units.builders.microseconds
import org.kisu.units.builders.millennia
import org.kisu.units.builders.milli
import org.kisu.units.builders.milliseconds
import org.kisu.units.builders.minutes
import org.kisu.units.builders.months
import org.kisu.units.builders.nanoseconds
import org.kisu.units.builders.picoseconds
import org.kisu.units.builders.quectoseconds
import org.kisu.units.builders.rontoseconds
import org.kisu.units.builders.seconds
import org.kisu.units.builders.weeks
import org.kisu.units.builders.years
import org.kisu.units.builders.yoctoseconds
import org.kisu.units.builders.zeptoseconds
import org.kisu.units.chemistry.CatalyticEfficiency
import org.kisu.units.chemistry.MolarVolume
import org.kisu.units.information.Transmission
import org.kisu.units.kinematics.FrequencyDrift
import org.kisu.units.kinematics.VolumetricFlow
import org.kisu.units.kinematics.Yank
import org.kisu.units.kinematics.angular.Velocity
import org.kisu.units.kinematics.linear.Speed
import org.kisu.units.mechanics.AbsorbedDoseRate
import org.kisu.units.mechanics.Action
import org.kisu.units.mechanics.DynamicViscosity
import org.kisu.units.mechanics.EnergyFluxDensity
import org.kisu.units.mechanics.KinematicViscosity
import org.kisu.units.mechanics.MassFlowRate
import org.kisu.units.mechanics.Momentum
import org.kisu.units.mechanics.RadiantExposure
import org.kisu.units.photometric.Exposure
import org.kisu.units.photometric.LuminousEnergy
import org.kisu.units.special.AbsorbedDose
import org.kisu.units.special.Area
import org.kisu.units.special.CatalyticActivity
import org.kisu.units.special.ElectricCharge
import org.kisu.units.special.ElectricPotential
import org.kisu.units.special.Energy
import org.kisu.units.special.Force
import org.kisu.units.special.Frequency
import org.kisu.units.special.Illuminance
import org.kisu.units.special.LuminousFlux
import org.kisu.units.special.MagneticFlux
import org.kisu.units.special.PlaneAngle
import org.kisu.units.special.Pressure
import org.kisu.units.special.Volume
import org.kisu.test.generators.Binaries as IecPrefixes
import org.kisu.units.kinematics.angular.Acceleration as AngularAcceleration
import org.kisu.units.kinematics.angular.Crackle as AngularCrackle
import org.kisu.units.kinematics.angular.Jerk as AngularJerk
import org.kisu.units.kinematics.angular.Pop as AngularPop
import org.kisu.units.kinematics.angular.Snap as AngularSnap
import org.kisu.units.kinematics.linear.Acceleration as LinearAcceleration
import org.kisu.units.kinematics.linear.Crackle as LinearCrackle
import org.kisu.units.kinematics.linear.Jerk as LinearJerk
import org.kisu.units.kinematics.linear.Pop as LinearPop
import org.kisu.units.kinematics.linear.Snap as LinearSnap

class TimeTest : StringSpec({
    "creates Time" {
        checkAll(Arb.positiveLong(), MetricBuilders.generator) { magnitude, builder ->
            magnitude.builder().seconds.should { (amount, expression, symbol) ->
                amount shouldBe magnitude.magnitude
                expression shouldBe Seconds(magnitude.builder().metric)
                symbol shouldBe Second.UNIT.toString()
            }
        }
    }

    "creates a base Time" {
        checkAll(Arb.magnitude()) { magnitude ->
            magnitude.seconds.should { (amount, expression, symbol) ->
                amount shouldBe magnitude
                expression shouldBe Seconds()
                symbol shouldBe Second.UNIT.toString()
            }
        }
    }

    "creates Time with human-readable units" {
        checkAll(Arb.magnitude(), Times.generator) { magnitude, unit ->
            Time(magnitude, unit).should { (amount, expression, symbol) ->
                amount shouldBe magnitude
                expression shouldBe Human(unit)
                symbol shouldBe Second.UNIT.toString()
            }
        }
    }

    "creates Time from explicit TimeUnit expressions" {
        Time(Magnitude.ONE, Seconds(Metric.KILO)).component2() shouldBe Seconds(Metric.KILO)
        Time(Magnitude.ONE, Human(HumanTime.HOUR)).component2() shouldBe Human(HumanTime.HOUR)
    }

    "creates every human time unit from Number extensions" {
        listOf(
            1.quectoseconds to HumanTime.QUECTOSECOND,
            1.rontoseconds to HumanTime.RONTOSECOND,
            1.yoctoseconds to HumanTime.YOCTOSECOND,
            1.zeptoseconds to HumanTime.ZEPTOSECOND,
            1.attoseconds to HumanTime.ATTOSECOND,
            1.femtoseconds to HumanTime.FEMTOSECOND,
            1.picoseconds to HumanTime.PICOSECOND,
            1.nanoseconds to HumanTime.NANOSECOND,
            1.microseconds to HumanTime.MICROSECOND,
            1.milliseconds to HumanTime.MILLISECOND,
            1.minutes to HumanTime.MINUTE,
            1.hours to HumanTime.HOUR,
            1.days to HumanTime.DAY,
            1.weeks to HumanTime.WEEK,
            1.months to HumanTime.MONTH,
            1.years to HumanTime.YEAR,
            1.decades to HumanTime.DECADE,
            1.centuries to HumanTime.CENTURY,
            1.millennia to HumanTime.MILLENNIUM,
        ).forEach { (time, unit) ->
            time.component1() shouldBe Magnitude.ONE
            time.component2() shouldBe Human(unit)
        }
    }

    "canonicalizes human-readable units to SI seconds" {
        checkAll(Arb.magnitude(), Times.generator) { magnitude, unit ->
            Time(magnitude, unit).canonical.should { (amount, expression, symbol) ->
                amount shouldBe magnitude * unit.factor
                expression shouldBe Seconds()
                symbol shouldBe Second.UNIT.toString()
            }
        }
    }

    "switches between SI and human time scales" {
        3_600.seconds.human shouldBe 1.hours
        2.hours.si.canonical shouldBe 7_200.seconds
        1.milliseconds shouldBe 1.milli.seconds
    }

    "keeps SI and human TimeUnit expressions distinct" {
        Seconds(Metric.MILLI) shouldBe Seconds(Metric.MILLI)
        Human(HumanTime.MILLISECOND) shouldBe Human(HumanTime.MILLISECOND)
        (Seconds(Metric.MILLI) == Human(HumanTime.MILLISECOND)) shouldBe false
        2.hours.representation shouldBe "2 h"
        9.minutes.representation shouldBe "9 min"
    }

    "uses the selected scale in TimeUnit expressions" {
        Seconds(Metric.KILO).factor shouldBe Magnitude(1_000)
        Seconds(Metric.KILO).symbol shouldBe "ks"
        Human(HumanTime.HOUR).factor shouldBe Magnitude(3_600)
        Human(HumanTime.HOUR).symbol shouldBe "h"
        Human(HumanTime.HOUR).canonical shouldBe Seconds()
    }

    "preserves SI and human scales in TimeUnit systems" {
        Seconds().all.map(TimeUnit::symbol) shouldBe Metric.entries.map { prefix -> "${prefix.symbol}s" }
        Human().all.map(TimeUnit::symbol) shouldBe HumanTime.entries.map(HumanTime::symbol)
    }

    "exposes TimeUnit scalar factors" {
        Seconds(Metric.MILLI).factors.single().symbol shouldBe "ms"
        Human(HumanTime.HOUR).factors.single().symbol shouldBe "h"
    }

    "finds TimeUnit expressions within their selected scale" {
        Seconds().find(Magnitude(1_500)) shouldBe Seconds(Metric.KILO)
        Seconds().find(Magnitude.ZERO) shouldBe Seconds(Metric.QUECTO)
        Human().find(Magnitude(3_661)) shouldBe Human(HumanTime.HOUR)
        Human().find(Magnitude.ZERO) shouldBe Human(HumanTime.QUECTOSECOND)
    }

    "decomposes each TimeUnit within its own scale" {
        Seconds().decompose(Magnitude(1_000)) shouldBe
            listOf(Magnitude.ONE to Seconds(Metric.KILO))
        Human().decompose(Magnitude(3_661)) shouldBe
            listOf(
                Magnitude.ONE to Human(HumanTime.HOUR),
                Magnitude.ONE to Human(HumanTime.MINUTE),
                Magnitude.ONE to Human(HumanTime.SECOND),
            )
    }

    "keeps Second as the SI scalar for derived expressions" {
        (Second(Metric.KILO) + Second(Metric.KILO)).factor shouldBe Magnitude(1_000_000)
    }

    "converts to Frequency" {
        checkAll(Arb.reciprocalMagnitude()) { magnitude ->
            magnitude.seconds.frequency.period.should { (amount, expression, symbol) ->
                amount shouldBe magnitude
                expression shouldBe Seconds()
                symbol shouldBe Second.UNIT.toString()
            }
        }
    }

    "converts to Radioactivity" {
        checkAll(Arb.reciprocalMagnitude()) { magnitude ->
            magnitude.seconds.activity.meanInterval.should { (amount, expression, symbol) ->
                amount shouldBe magnitude
                expression shouldBe Seconds()
                symbol shouldBe Second.UNIT.toString()
            }
        }
    }
    // Dimension-aware arithmetic properties
    "multiplying a Time by a Current returns an ElectricCharge" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Current(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = ElectricCharge(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a CatalyticEfficiency returns a MolarVolume" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = CatalyticEfficiency(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = MolarVolume(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a FrequencyDrift returns a Frequency" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = FrequencyDrift(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Frequency(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a VolumetricFlow returns a Volume" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = VolumetricFlow(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Volume(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a Yank returns a Force" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Yank(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Force(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an AngularAcceleration returns a Velocity" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = AngularAcceleration(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Velocity(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an AngularCrackle returns an AngularSnap" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = AngularCrackle(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = AngularSnap(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an AngularJerk returns an AngularAcceleration" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = AngularJerk(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = AngularAcceleration(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an AngularPop returns an AngularCrackle" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = AngularPop(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = AngularCrackle(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an AngularSnap returns an AngularJerk" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = AngularSnap(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = AngularJerk(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a Velocity returns a PlaneAngle" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Velocity(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = PlaneAngle(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a LinearAcceleration returns a Speed" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = LinearAcceleration(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Speed(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a LinearCrackle returns a LinearSnap" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = LinearCrackle(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = LinearSnap(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a LinearJerk returns a LinearAcceleration" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = LinearJerk(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = LinearAcceleration(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a LinearPop returns a LinearCrackle" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = LinearPop(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = LinearCrackle(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a LinearSnap returns a LinearJerk" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = LinearSnap(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = LinearJerk(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a Speed returns a Length" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Speed(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Length(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an AbsorbedDoseRate returns an AbsorbedDose" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = AbsorbedDoseRate(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = AbsorbedDose(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an EnergyFluxDensity returns a RadiantExposure" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = EnergyFluxDensity(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = RadiantExposure(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a KinematicViscosity returns an Area" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = KinematicViscosity(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Area(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a MassFlowRate returns a Mass" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = MassFlowRate(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Mass(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a Transmission returns Information" {
        checkAll(
            50,
            Arb.positiveLong(),
            Arb.positiveLong(),
            IecPrefixes.generator,
        ) { leftMagnitude, rightMagnitude, rightPrefix ->
            val left = Time(leftMagnitude.magnitude)
            val right = Transmission(rightMagnitude.magnitude, Bit(rightPrefix))
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Information(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a CatalyticActivity returns an Amount" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = CatalyticActivity(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Amount(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an ElectricPotential returns a MagneticFlux" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = ElectricPotential(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = MagneticFlux(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an Energy returns an Action" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Energy(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Action(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a Force returns a Momentum" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Force(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Momentum(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by an Illuminance returns an Exposure" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Illuminance(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = Exposure(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a LuminousFlux returns a LuminousEnergy" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = LuminousFlux(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = LuminousEnergy(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    "multiplying a Time by a Pressure returns a DynamicViscosity" {
        checkAll(
            50,
            Arb.magnitude(),
            Arb.magnitude(),
            Metrics.generator,
            Metrics.generator,
        ) { leftMagnitude, rightMagnitude, leftPrefix, rightPrefix ->
            val left = Time(leftMagnitude, leftPrefix)
            val right = Pressure(rightMagnitude, rightPrefix)
            val expectedMagnitude = left.canonical.component1() * right.canonical.component1()
            val expected = DynamicViscosity(expectedMagnitude)

            (left * right) shouldBe expected
        }
    }
    // End dimension-aware arithmetic properties
})
