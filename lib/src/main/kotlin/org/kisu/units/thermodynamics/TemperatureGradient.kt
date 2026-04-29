package org.kisu.units.thermodynamics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kelvin
import org.kisu.units.base.Metre
import org.kisu.units.representation.Quotient
import java.math.BigDecimal

/**
 * Represents the physical quantity of **temperature gradient**, measured in
 * [KelvinPerMetre].
 *
 * Temperature gradient quantifies how rapidly temperature changes across space. It is
 * the spatial counterpart of a thermal slope and is central to heat conduction and
 * transport analysis.
 *
 * Typical examples include the temperature drop through a wall, geothermal gradients in
 * the ground, or thermal fields inside a device.
 *
 * The associated SI unit representation is [KelvinPerMetre] (`K/m`).
 */
class TemperatureGradient(
    magnitude: BigDecimal,
    expression: KelvinPerMetre
) : Measure<TemperatureGradient.KelvinPerMetre, TemperatureGradient>(
    magnitude = magnitude,
    expression = expression,
    create = ::TemperatureGradient
) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, KelvinPerMetre(prefix))

    /**
     * Represents the SI unit **kelvin per metre (K/m)**.
     *
     * This unit measures a **temperature gradient**, i.e., the rate of change of temperature
     * with respect to distance.
     * It is defined as the [Quotient] of [Kelvin] (temperature) divided by [Metre] (length).
     *
     * Example usages include:
     * - Heat conduction through materials (Fourier’s law)
     * - Atmospheric or oceanic temperature gradients
     * - Thermal engineering calculations
     *
     * @see TemperatureGradient for the physical quantity represented by this unit.
     */
    typealias KelvinPerMetre = Quotient<Kelvin, Metre>

    companion object {
        /**
         * Creates a measure of **kelvins per metre** (K/m).
         *
         * This derived unit expresses a temperature gradient — the change
         * in temperature per unit length.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Kelvin] (temperature difference) with the specified [prefix]
         *  - divided by a [Metre] (length)
         *
         * @param prefix Metric prefix to apply to the kelvin unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing K/m.
         */
        @Suppress("FunctionNaming")
        internal fun KelvinPerMetre(prefix: Metric = Metric.BASE): KelvinPerMetre =
            Quotient(Kelvin(prefix), Metre())
    }
}
