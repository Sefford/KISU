@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Current
import org.kisu.units.base.Length
import org.kisu.units.base.Time
import org.kisu.units.electromagnetic.ElectricFieldStrength
import org.kisu.units.electromagnetic.ElectronMobility
import org.kisu.units.mechanics.KinematicViscosity
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

/**
 * Represents the physical quantity of **electric potential difference**, measured in
 * [Volt].
 *
 * Electric potential difference quantifies how much energy is available per unit charge
 * between two points. It is the quantity usually called voltage in circuits and field
 * problems.
 *
 * Typical examples include the output of a battery, the voltage across a resistor, the
 * supply level of a device, or the potential between two electrodes.
 *
 * The canonical SI unit is the [Volt] (`V`), with common practical forms such as `mV`,
 * `kV`, and everything in between.
 */
class ElectricPotential internal constructor(magnitude: Magnitude, expression: Volt) :
    Measure<Volt, ElectricPotential>(magnitude, expression, ::ElectricPotential) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Volt(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [ElectricPotential] by [Current],
     * yielding [Resistance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Current
    ): Resistance =
        Resistance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricPotential] by [Length],
     * yielding [ElectricFieldStrength].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): ElectricFieldStrength =
        ElectricFieldStrength(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricPotential] by
     * [ElectricFieldStrength],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricFieldStrength
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricPotential] by [Elastance],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Elastance
    ): ElectricCharge =
        ElectricCharge(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricPotential] by [ElectricCharge],
     * yielding [Elastance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricCharge
    ): Elastance =
        Elastance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [ElectricPotential] by [Resistance],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Resistance
    ): Current =
        Current(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [ElectricPotential] by [Current],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Current
    ): Power =
        Power(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [ElectricPotential] by [Time],
     * yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): MagneticFlux =
        MagneticFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [ElectricPotential] by [ElectronMobility],
     * yielding [KinematicViscosity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectronMobility
    ): KinematicViscosity =
        KinematicViscosity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [ElectricPotential] by [Capacitance],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Capacitance
    ): ElectricCharge =
        ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [ElectricPotential] by [Conductance],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Conductance
    ): Current =
        Current(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [ElectricPotential] by [ElectricCharge],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricCharge
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **volt** (`V`), used to express [ElectricPotential].
 *
 * A volt quantifies electric potential difference, or energy available per unit charge.
 * It tells how strongly a source can drive charges through a circuit.
 *
 * Everyday examples include the output of a battery cell, the charging voltage of a
 * USB power supply, or the potential difference across a component in an electric
 * circuit.
 *
 * In unit form, `V = W/A = J/C = m²·kg·s⁻³·A⁻¹`.
 *
 * @see ElectricPotential
 * @see Watt
 * @see Coulomb
 */
class Volt private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Volt>(algebra, prefix, unit, ::Volt) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for volt: "V". */
        internal val UNIT = Unit("V", 1)
    }
}
