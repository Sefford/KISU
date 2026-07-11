@file:Suppress("TooManyFunctions")

package org.kisu.units.base

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.electromagnetic.ElectricCurrentDensity
import org.kisu.units.electromagnetic.MagneticDipoleMoment
import org.kisu.units.electromagnetic.MagneticReluctance
import org.kisu.units.electromagnetic.Magnetization
import org.kisu.units.electromagnetic.MagnetomotiveForce
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.special.Area
import org.kisu.units.special.Conductance
import org.kisu.units.special.ElectricCharge
import org.kisu.units.special.ElectricPotential
import org.kisu.units.special.Energy
import org.kisu.units.special.Inductance
import org.kisu.units.special.MagneticFlux
import org.kisu.units.special.PlaneAngle
import org.kisu.units.special.Power
import org.kisu.units.special.Resistance

/**
 * Represents the physical quantity of **electric current**, measured in amperes (A).
 *
 * Electric current quantifies the flow of electric charge over time.
 * One ampere corresponds to one coulomb of charge passing through a point in a circuit per second.
 *
 * This quantity is one of the seven SI base units and is typically used to describe the intensity of electrical flow
 * in conductors, circuits, and electromagnetic systems.
 *
 * This class expresses current as a combination of a `magnitude` and an `expression`, supporting values such as
 * milliamperes (mA), microamperes (µA), or kiloamperes (kA).
 *
 * Instances of this class are immutable and use [Magnitude] for precision.
 */
class Current internal constructor(magnitude: Magnitude, expression: Ampere) :
    Measure<Ampere, Current>(magnitude, expression, ::Current) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Ampere(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [Current] by [Length],
     * yielding [Magnetization].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): Magnetization =
        Magnetization(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [ElectricCurrentDensity],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricCurrentDensity
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [MagneticReluctance],
     * yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MagneticReluctance
    ): MagneticFlux =
        MagneticFlux(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [Magnetization],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Magnetization
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [Area],
     * yielding [ElectricCurrentDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): ElectricCurrentDensity =
        ElectricCurrentDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [Conductance],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Conductance
    ): ElectricPotential =
        ElectricPotential(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [ElectricPotential],
     * yielding [Conductance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricPotential
    ): Conductance =
        Conductance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Current] by [MagneticFlux],
     * yielding [MagneticReluctance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MagneticFlux
    ): MagneticReluctance =
        MagneticReluctance(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Current] by [Time],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): ElectricCharge =
        ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Current] by [Area],
     * yielding [MagneticDipoleMoment].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Area
    ): MagneticDipoleMoment =
        MagneticDipoleMoment(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Current] by [ElectricPotential],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricPotential
    ): Power =
        Power(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Current] by [Inductance],
     * yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Inductance
    ): MagneticFlux =
        MagneticFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Current] by [MagneticFlux],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticFlux
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Current] by [PlaneAngle],
     * yielding [MagnetomotiveForce].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: PlaneAngle
    ): MagnetomotiveForce =
        MagnetomotiveForce(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Current] by [Resistance],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Resistance
    ): ElectricPotential =
        ElectricPotential(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the SI base unit of **electric current**.
 *
 * The ampere (A) is the standard unit for measuring electric current.
 */
class Ampere private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Ampere>(algebra, prefix, unit, ::Ampere) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical SI symbol for electric current: "A". */
        internal val UNIT = Unit("A", 1)
    }
}
