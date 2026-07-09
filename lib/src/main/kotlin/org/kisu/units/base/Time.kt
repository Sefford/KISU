@file:Suppress("TooManyFunctions")

package org.kisu.units.base

import org.kisu.Magnitude
import org.kisu.prefixes.HumanTime
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.prefixes.algebra.LinearAlgebra
import org.kisu.units.Measure
import org.kisu.units.chemistry.CatalyticEfficiency
import org.kisu.units.chemistry.MolarVolume
import org.kisu.units.kinematics.FrequencyDrift
import org.kisu.units.kinematics.VolumetricFlow
import org.kisu.units.kinematics.Yank
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
import org.kisu.units.representation.Expression
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
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
import org.kisu.units.special.Radioactivity
import org.kisu.units.special.Volume
import org.kisu.units.kinematics.angular.Acceleration as AngularAcceleration
import org.kisu.units.kinematics.angular.Crackle as AngularCrackle
import org.kisu.units.kinematics.angular.Jerk as AngularJerk
import org.kisu.units.kinematics.angular.Pop as AngularPop
import org.kisu.units.kinematics.angular.Snap as AngularSnap
import org.kisu.units.kinematics.angular.Velocity as AngularVelocity
import org.kisu.units.kinematics.linear.Acceleration as LinearAcceleration
import org.kisu.units.kinematics.linear.Crackle as LinearCrackle
import org.kisu.units.kinematics.linear.Jerk as LinearJerk
import org.kisu.units.kinematics.linear.Pop as LinearPop
import org.kisu.units.kinematics.linear.Snap as LinearSnap

/**
 * Represents the physical quantity of **time**, measured in seconds (s).
 *
 * Time quantifies the duration of events or intervals. It is one of the fundamental SI base quantities
 * and is universally measured in **seconds**. Values can use [Seconds] with SI [Metric] prefixes or [Human] with
 * fixed [HumanTime] units such as minutes, hours, and days.
 *
 * Time values must not be negative. In physical systems and real-world contexts, negative time has no
 * meaning — you cannot go back and create a duration with a negative length. Zero represents an
 * instantaneous or null duration, while positive values represent elapsed or measurable intervals.
 *
 * The magnitude is stored using [Magnitude] to ensure high precision. Instances of this class are immutable
 * and validated to reflect physical reality.
 */
class Time private constructor(magnitude: Magnitude, expression: TimeUnit) :
    Measure<TimeUnit, Time>(magnitude, expression, ::Time) {

    /**
     * Returns this duration expressed on the SI second scale.
     */
    val si: Time
        get() = to(Seconds()).optimal

    /**
     * Returns this duration expressed on the fixed human-time scale.
     */
    val human: Time
        get() = to(Human()).optimal

    override fun convert(magnitude: Magnitude, from: TimeUnit, to: TimeUnit): Magnitude =
        (magnitude * from.factor) / to.factor

    /**
     * Returns the frequency associated with this period by inverting its canonical magnitude.
     */
    val frequency: Frequency
        get() = Frequency(canonical.component1().inverted)

    /**
     * Returns the activity associated with this mean interval by inverting its canonical magnitude.
     */
    val activity: Radioactivity
        get() = Radioactivity(canonical.component1().inverted)

    companion object {
        /**
         * Creates a [Time] quantity with the given [magnitude] and [expression].
         */
        operator fun invoke(magnitude: Magnitude, expression: TimeUnit): Time =
            Time(magnitude, expression)

        /**
         * Creates a [Time] quantity in unprefixed SI seconds.
         */
        operator fun invoke(magnitude: Magnitude): Time =
            Time(magnitude, Seconds())

        /**
         * Creates a [Time] quantity in SI seconds with [prefix].
         */
        operator fun invoke(magnitude: Magnitude, prefix: Metric): Time =
            Time(magnitude, Seconds(prefix))

        /**
         * Creates a [Time] quantity with a fixed human-readable [unit].
         */
        operator fun invoke(magnitude: Magnitude, unit: HumanTime): Time =
            Time(magnitude, Human(unit))
    }

    // Dimension-aware arithmetic
    /**
     * Multiplies this [Time] by [Current], yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Current
    ): ElectricCharge = ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [CatalyticEfficiency], yielding [MolarVolume].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: CatalyticEfficiency
    ): MolarVolume = MolarVolume(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [FrequencyDrift], yielding [Frequency].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: FrequencyDrift
    ): Frequency = Frequency(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [VolumetricFlow], yielding [Volume].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: VolumetricFlow
    ): Volume = Volume(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [Yank], yielding [Force].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Yank
    ): Force = Force(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AngularAcceleration], yielding [AngularVelocity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AngularAcceleration
    ): AngularVelocity = AngularVelocity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AngularCrackle], yielding [AngularSnap].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AngularCrackle
    ): AngularSnap = AngularSnap(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AngularJerk], yielding [AngularAcceleration].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AngularJerk
    ): AngularAcceleration = AngularAcceleration(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AngularPop], yielding [AngularCrackle].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AngularPop
    ): AngularCrackle = AngularCrackle(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AngularSnap], yielding [AngularJerk].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AngularSnap
    ): AngularJerk = AngularJerk(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AngularVelocity], yielding [PlaneAngle].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AngularVelocity
    ): PlaneAngle = PlaneAngle(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [LinearAcceleration], yielding [Speed].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearAcceleration
    ): Speed = Speed(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [LinearCrackle], yielding [LinearSnap].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearCrackle
    ): LinearSnap = LinearSnap(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [LinearJerk], yielding [LinearAcceleration].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearJerk
    ): LinearAcceleration = LinearAcceleration(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [LinearPop], yielding [LinearCrackle].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearPop
    ): LinearCrackle = LinearCrackle(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [LinearSnap], yielding [LinearJerk].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearSnap
    ): LinearJerk = LinearJerk(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [Speed], yielding [Length].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Speed
    ): Length = Length(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [AbsorbedDoseRate], yielding [AbsorbedDose].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AbsorbedDoseRate
    ): AbsorbedDose = AbsorbedDose(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [EnergyFluxDensity], yielding [RadiantExposure].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: EnergyFluxDensity
    ): RadiantExposure = RadiantExposure(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [KinematicViscosity], yielding [Area].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: KinematicViscosity
    ): Area = Area(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [MassFlowRate], yielding [Mass].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MassFlowRate
    ): Mass = Mass(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [CatalyticActivity], yielding [Amount].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: CatalyticActivity
    ): Amount = Amount(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [ElectricPotential], yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricPotential
    ): MagneticFlux = MagneticFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [Energy], yielding [Action].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Energy
    ): Action = Action(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [Force], yielding [Momentum].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Force
    ): Momentum = Momentum(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [Illuminance], yielding [Exposure].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Illuminance
    ): Exposure = Exposure(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [LuminousFlux], yielding [LuminousEnergy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LuminousFlux
    ): LuminousEnergy = LuminousEnergy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Time] by [Pressure], yielding [DynamicViscosity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Pressure
    ): DynamicViscosity = DynamicViscosity(canonical.component1() * other.canonical.component1())
}

/**
 * Closed expression family for time units.
 *
 * A time expression is either an SI-prefixed [Seconds] value or a fixed [Human] elapsed-time unit. Both variants
 * canonicalize to an unprefixed SI [Seconds] expression.
 */
sealed class TimeUnit : Expression<TimeUnit>() {
    protected abstract val scalar: Scalar<*, *>

    override val smallest: TimeUnit
        get() = all.first()

    override val largest: TimeUnit
        get() = all.last()

    override val factor: Magnitude
        get() = scalar.factor

    override val factors: Set<Scalar<*, *>>
        get() = scalar.factors

    override val symbol: String
        get() = scalar.symbol

    override fun find(coordinate: Magnitude): TimeUnit =
        all.lastOrNull { expression -> expression.factor <= coordinate } ?: smallest

    override fun to(other: TimeUnit): Magnitude =
        factor / other.factor
}

/**
 * SI second expression using a [Metric] prefix.
 *
 * Examples include milliseconds (`ms`), seconds (`s`), and kiloseconds (`ks`).
 */
class Seconds(val prefix: Metric = Metric.BASE) : TimeUnit() {
    override val scalar: Scalar<*, *> = Second(prefix)

    override val canonical: TimeUnit
        get() = Seconds()

    override val all: List<TimeUnit>
        get() = prefix.all.map(::Seconds)

    override fun decompose(magnitude: Magnitude): List<Pair<Magnitude, TimeUnit>> =
        Second(prefix).decompose(magnitude)
            .map { (amount, expression) -> amount to Seconds(expression.prefix) }
}

/**
 * Fixed human-readable elapsed-time expression using a [HumanTime] unit.
 *
 * Calendar-like values are deterministic durations rather than calendar periods.
 */
class Human(val unit: HumanTime = HumanTime.SECOND) : TimeUnit() {
    override val scalar: Scalar<*, *> = HumanSecond(unit)

    override val canonical: TimeUnit
        get() = Seconds()

    override val all: List<TimeUnit>
        get() = unit.all.map(::Human)

    override fun decompose(magnitude: Magnitude): List<Pair<Magnitude, TimeUnit>> =
        HumanSecond(unit).decompose(magnitude)
            .map { (amount, expression) -> amount to Human(expression.prefix) }
}

/**
 * Represents the SI base unit of **time** used in derived unit expressions.
 */
class Second private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    val prefix: Metric,
    unit: Unit,
) : Scalar<Metric, Second>(algebra, prefix, unit, ::Second) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical SI symbol for time: "s". */
        internal val UNIT = Unit("s", 1)
    }
}

private class HumanSecond private constructor(
    algebra: Algebra<HumanTime> = LinearAlgebra(),
    val prefix: HumanTime,
    second: Unit,
) : Scalar<HumanTime, HumanSecond>(algebra, prefix, second, ::HumanSecond) {

    constructor(prefix: HumanTime) : this(prefix = prefix, second = Second.UNIT)

    override val symbol: String
        get() = prefix.symbol
}
