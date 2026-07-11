@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Current
import org.kisu.units.base.Length
import org.kisu.units.base.Mass
import org.kisu.units.base.Time
import org.kisu.units.electromagnetic.ElectricChargeDensity
import org.kisu.units.electromagnetic.ElectricDisplacementField
import org.kisu.units.electromagnetic.Exposure
import org.kisu.units.electromagnetic.LinearChargeDensity
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

/**
 * Represents the physical quantity of **electric charge**, measured in [Coulomb].
 *
 * Electric charge quantifies how much electrically active matter or imbalance is
 * present. It is the conserved quantity behind electrostatics, current flow, and the
 * behavior of capacitors, batteries, and charged particles.
 *
 * Typical examples include the charge stored on a capacitor plate, the charge moved
 * through a circuit during a pulse, or the charge associated with ions in an
 * electrochemical process.
 *
 * The canonical SI unit is the [Coulomb] (`C`), often written as `mC` or `µC` for
 * laboratory-scale quantities.
 */
class ElectricCharge internal constructor(magnitude: Magnitude, expression: Coulomb) :
    Measure<Coulomb, ElectricCharge>(magnitude, expression, ::ElectricCharge) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Coulomb(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [ElectricCharge] by [Current],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Current
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Length],
     * yielding [LinearChargeDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): LinearChargeDensity =
        LinearChargeDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Mass],
     * yielding [Exposure].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Mass
    ): Exposure =
        Exposure(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Time],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): Current =
        Current(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [ElectricChargeDensity],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricChargeDensity
    ): Volume =
        Volume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by
     * [ElectricDisplacementField],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricDisplacementField
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Exposure],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Exposure
    ): Mass =
        Mass(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [LinearChargeDensity],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: LinearChargeDensity
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Area],
     * yielding [ElectricDisplacementField].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): ElectricDisplacementField =
        ElectricDisplacementField(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Capacitance],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Capacitance
    ): ElectricPotential =
        ElectricPotential(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [ElectricPotential],
     * yielding [Capacitance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricPotential
    ): Capacitance =
        Capacitance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricCharge] by [Volume],
     * yielding [ElectricChargeDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Volume
    ): ElectricChargeDensity =
        ElectricChargeDensity(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [ElectricCharge] by [Elastance],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Elastance
    ): ElectricPotential =
        ElectricPotential(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [ElectricCharge] by [ElectricPotential],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricPotential
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **coulomb** (`C`), used to express [ElectricCharge].
 *
 * A coulomb quantifies the amount of electric charge. One coulomb is the charge
 * transported by a current of one ampere flowing for one second.
 *
 * This unit appears in electrostatics, capacitor calculations, battery analysis, and
 * any context where the quantity of charge itself matters rather than only current or
 * voltage.
 *
 * In unit form, `C = A·s`.
 *
 * @see ElectricCharge
 * @see Volt
 * @see Farad
 */
class Coulomb private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Coulomb>(algebra, prefix, unit, ::Coulomb) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for coulomb: "C". */
        internal val UNIT = Unit("C", 1)
    }
}
