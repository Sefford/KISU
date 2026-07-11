@file:Suppress("TooManyFunctions")

package org.kisu.units.base

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.chemistry.MolarEnergy
import org.kisu.units.chemistry.MolarHeatCapacity
import org.kisu.units.mechanics.SpecificEnergy
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.special.Celsius
import org.kisu.units.special.CelsiusTemperature
import org.kisu.units.special.Energy
import org.kisu.units.special.Power
import org.kisu.units.thermodynamics.HeatCapacity
import org.kisu.units.thermodynamics.SpecificHeatCapacity
import org.kisu.units.thermodynamics.TemperatureGradient
import org.kisu.units.thermodynamics.ThermalExpansionCoefficient
import org.kisu.units.thermodynamics.ThermalResistance

/**
 * Represents the physical quantity of **thermodynamic temperature**, measured in kelvin (K).
 *
 * Temperature quantifies the thermal state of a system in absolute terms,
 * using the **kelvin** as the SI base unit. Unlike degrees Celsius or Fahrenheit, the kelvin scale
 * starts at **absolute zero**, the lowest possible temperature in nature, where particles have
 * minimal thermal motion.
 *
 * Because the kelvin scale is absolute, **negative values are not physically meaningful** — no system
 * can exist below absolute zero. A temperature of zero kelvin represents a complete absence of thermal energy.
 *
 * This class models temperature as a combination of a `magnitude` and an optional metric `expression`,
 * enabling precise representation of values such as millikelvin (mK) or kilokelvin (kK).
 *
 * The magnitude is stored using [Magnitude] for accuracy. All instances are validated to ensure they
 * respect physical constraints and are immutable once created.
 */
class Temperature internal constructor(magnitude: Magnitude, expression: Kelvin) :
    Measure<Kelvin, Temperature>(magnitude, expression, ::Temperature) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Kelvin(prefix))

    /**
     * Returns this absolute temperature on the Celsius scale.
     */
    val celsius: CelsiusTemperature
        get() = CelsiusTemperature(canonical.component1() - Celsius.CELSIUS_TO_KELVIN_OFFSET)

    /**
     * Returns the reciprocal-kelvin coefficient associated with this temperature.
     */
    val thermalExpansionCoefficient: ThermalExpansionCoefficient
        get() = ThermalExpansionCoefficient(canonical.component1().inverted)

    // Dimension-aware arithmetic
    /**
     * Divides this [Temperature] by [Length],
     * yielding [TemperatureGradient].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): TemperatureGradient =
        TemperatureGradient(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Temperature] by [Power],
     * yielding [ThermalResistance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Power
    ): ThermalResistance =
        ThermalResistance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Temperature] by [TemperatureGradient],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: TemperatureGradient
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Temperature] by [ThermalResistance],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ThermalResistance
    ): Power =
        Power(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Temperature] by [MolarHeatCapacity],
     * yielding [MolarEnergy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MolarHeatCapacity
    ): MolarEnergy =
        MolarEnergy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Temperature] by [HeatCapacity],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: HeatCapacity
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Temperature] by [SpecificHeatCapacity],
     * yielding [SpecificEnergy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpecificHeatCapacity
    ): SpecificEnergy =
        SpecificEnergy(canonical.component1() * other.canonical.component1())
}

class Kelvin private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Kelvin>(algebra, prefix, unit, ::Kelvin) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The SI symbol for temperature: "K". */
        internal val UNIT = Unit("K", 1)
    }
}
