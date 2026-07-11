@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Current
import org.kisu.units.base.Length
import org.kisu.units.base.Temperature
import org.kisu.units.kinematics.linear.Speed
import org.kisu.units.mechanics.HeatFluxDensity
import org.kisu.units.mechanics.RadiantIntensity
import org.kisu.units.mechanics.SpectralPower
import org.kisu.units.photometric.Efficacy
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.thermodynamics.ThermalResistance

/**
 * Represents the physical quantity of **power**, measured in [Watt].
 *
 * Power quantifies how quickly energy is transferred, converted, or expended. It is
 * the rate form of energy, appearing in electrical systems, mechanical devices,
 * heating, radiation, and fluid transport.
 *
 * Typical examples include the output of a motor, the consumption of an appliance, the
 * thermal power of a heater, or the radiant output of a source.
 *
 * The canonical SI unit is the [Watt] (`W`), commonly scaled as `mW`, `kW`, or `MW`.
 */
class Power internal constructor(magnitude: Magnitude, expression: Watt) :
    Measure<Watt, Power>(magnitude, expression, ::Power) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Watt(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [Power] by [Current],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Current
    ): ElectricPotential =
        ElectricPotential(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [Length],
     * yielding [SpectralPower].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): SpectralPower =
        SpectralPower(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [Speed],
     * yielding [Force].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Speed
    ): Force =
        Force(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [HeatFluxDensity],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: HeatFluxDensity
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [RadiantIntensity],
     * yielding [SolidAngle].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: RadiantIntensity
    ): SolidAngle =
        SolidAngle(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [SpectralPower],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SpectralPower
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [Area],
     * yielding [HeatFluxDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): HeatFluxDensity =
        HeatFluxDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [ElectricPotential],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricPotential
    ): Current =
        Current(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [Force],
     * yielding [Speed].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Force
    ): Speed =
        Speed(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Power] by [SolidAngle],
     * yielding [RadiantIntensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SolidAngle
    ): RadiantIntensity =
        RadiantIntensity(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Power] by [Efficacy],
     * yielding [LuminousFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Efficacy
    ): LuminousFlux =
        LuminousFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Power] by [ThermalResistance],
     * yielding [Temperature].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ThermalResistance
    ): Temperature =
        Temperature(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **watt** (`W`), used to express [Power].
 *
 * A watt quantifies the rate at which energy is transferred or work is performed. One
 * watt means one [Joule] of energy transferred each second.
 *
 * This unit is used for light bulb ratings, motor output, appliance consumption,
 * battery charging, and thermal transfer rates.
 *
 * In unit form, `W = J/s = m²·kg·s⁻³`.
 *
 * @see Power
 * @see Joule
 * @see Volt
 */
class Watt private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Watt>(algebra, prefix, unit, ::Watt) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for watt: "W". */
        internal val UNIT = Unit("W", 1)
    }
}
