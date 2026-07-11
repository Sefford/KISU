@file:Suppress("TooManyFunctions")

package org.kisu.units.base

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.chemistry.Molality
import org.kisu.units.chemistry.MolarMass
import org.kisu.units.electromagnetic.Exposure
import org.kisu.units.kinematics.linear.Acceleration
import org.kisu.units.kinematics.linear.Speed
import org.kisu.units.mechanics.AngularMomentum
import org.kisu.units.mechanics.AreaDensity
import org.kisu.units.mechanics.Density
import org.kisu.units.mechanics.LinearMassDensity
import org.kisu.units.mechanics.MassFlowRate
import org.kisu.units.mechanics.MomentOfInertia
import org.kisu.units.mechanics.Momentum
import org.kisu.units.mechanics.SpecificAngularMomentum
import org.kisu.units.mechanics.SpecificEnergy
import org.kisu.units.mechanics.SpecificVolume
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.special.Area
import org.kisu.units.special.ElectricCharge
import org.kisu.units.special.Energy
import org.kisu.units.special.Force
import org.kisu.units.special.Volume
import org.kisu.units.thermodynamics.HeatCapacity
import org.kisu.units.thermodynamics.SpecificHeatCapacity

/**
 * Represents the physical quantity of **mass**, measured in grams (g).
 *
 * Mass quantifies the amount of matter contained in a physical object. It is one of the most fundamental physical
 * properties and a key SI base quantity.
 *
 * Mass values must not be negative. A negative mass is not physically meaningful — it would imply the existence of
 * “negative matter,” which is not observed in any real-world context. A mass of zero may be used to represent the
 * absence of matter, but any valid amount of substance must have a non-negative mass.
 *
 * This class models mass as a combination of a `magnitude` and an `expression`, allowing precise values such as
 * milligrams (mg), kilograms (kg), or megagrams (Mg). All values are represented using [Magnitude] for high-precision
 * calculations.
 *
 * Instances of this class are immutable and validated at construction.
 */
class Mass internal constructor(magnitude: Magnitude, expression: Kilogram) :
    Measure<Kilogram, Mass>(magnitude, expression, ::Mass) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.KILO) :
        this(magnitude, Kilogram(prefix to Magnitude.ONE))

    // Dimension-aware arithmetic
    /**
     * Divides this [Mass] by [Amount],
     * yielding [MolarMass].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Amount
    ): MolarMass =
        MolarMass(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [Length],
     * yielding [LinearMassDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): LinearMassDensity =
        LinearMassDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [Time],
     * yielding [MassFlowRate].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): MassFlowRate =
        MassFlowRate(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [MolarMass],
     * yielding [Amount].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MolarMass
    ): Amount =
        Amount(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [AreaDensity],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: AreaDensity
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [Density],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Density
    ): Volume =
        Volume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [LinearMassDensity],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: LinearMassDensity
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [MassFlowRate],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MassFlowRate
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [Area],
     * yielding [AreaDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): AreaDensity =
        AreaDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Mass] by [Volume],
     * yielding [Density].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Volume
    ): Density =
        Density(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Mass] by [Molality],
     * yielding [Amount].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Molality
    ): Amount =
        Amount(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [Exposure],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Exposure
    ): ElectricCharge =
        ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [Acceleration],
     * yielding [Force].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Acceleration
    ): Force =
        Force(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [Speed],
     * yielding [Momentum].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Speed
    ): Momentum =
        Momentum(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [SpecificAngularMomentum],
     * yielding [AngularMomentum].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpecificAngularMomentum
    ): AngularMomentum =
        AngularMomentum(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [SpecificEnergy],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpecificEnergy
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [SpecificVolume],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpecificVolume
    ): Volume =
        Volume(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [Area],
     * yielding [MomentOfInertia].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Area
    ): MomentOfInertia =
        MomentOfInertia(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Mass] by [SpecificHeatCapacity],
     * yielding [HeatCapacity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpecificHeatCapacity
    ): HeatCapacity =
        HeatCapacity(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the SI base unit of **mass**.
 *
 * The kilogram (kg) is the SI base unit for mass.
 *
 * Internally, this scalar normalizes through grams (`g`) so metric prefixes work consistently,
 * while the public canonical symbol remains `kg`:
 * - Kilogram(Metric.BASE) = 1 kg
 * - Kilogram(Metric.KILO) = 1 Mg
 * - Kilogram(Metric.MILLI) = 1 g
 * - Kilogram(Metric.MICRO) = 1 mg
 */
class Kilogram private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Kilogram>(algebra, prefix, unit, ::Kilogram) {

    constructor(pair: Pair<Metric, Magnitude>) : this(
        algebra = ExponentialAlgebra<Metric>().adjustedBy(pair.second),
        prefix = pair.first,
        unit = UNIT,
    )

    constructor(prefix: Metric = Metric.BASE) : this(ExponentialAlgebra<Metric>().multiply(prefix, Metric.KILO))

    /** The public canonical mass unit is always kilogram (`kg`). */
    override val canonical: Kilogram by lazy { Kilogram() }

    companion object {
        /** The canonical unit symbol used internally: "g". */
        internal val UNIT = Unit("g", 1)
    }
}

private fun Algebra<Metric>.adjustedBy(remainder: Magnitude): Algebra<Metric> {
    if (remainder == Magnitude.ONE) {
        return this
    }

    val delegate = this
    return object : Algebra<Metric> {
        override fun factor(prefix: Metric): Magnitude = delegate.factor(prefix) * remainder

        override fun multiply(left: Metric, right: Metric): Pair<Metric, Magnitude> =
            delegate.multiply(left, right).let { (prefix, overflow) -> prefix to overflow * remainder }

        override fun divide(left: Metric, right: Metric): Pair<Metric, Magnitude> =
            delegate.divide(left, right).let { (prefix, overflow) ->
                prefix to overflow / remainder
            }
    }
}
