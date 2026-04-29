package org.kisu.units.thermodynamics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kelvin
import org.kisu.units.base.Kilogram
import org.kisu.units.representation.Product
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Joule
import java.math.BigDecimal

/**
 * Represents the physical quantity of **specific heat capacity**, measured in
 * [JoulePerKilogramKelvin].
 *
 * Specific heat capacity quantifies how much heat is required to raise the temperature
 * of one kilogram of a substance by one kelvin. It is one of the most important
 * descriptors of a material's thermal response.
 *
 * Typical examples include comparing water, metals, or building materials for heating,
 * cooling, and energy-storage behavior.
 *
 * The associated SI unit representation is [JoulePerKilogramKelvin] (`J/(kg·K)`).
 */
class SpecificHeatCapacity(
    magnitude: BigDecimal,
    expression: JoulePerKilogramKelvin
) : Measure<SpecificHeatCapacity.JoulePerKilogramKelvin, SpecificHeatCapacity>(
    magnitude = magnitude,
    expression = expression,
    create = ::SpecificHeatCapacity
) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(
            magnitude,
            JoulePerKilogramKelvin(prefix)
        )

    /**
     * Represents the SI unit **joule per kilogram kelvin (J/(kg·K))**.
     *
     * This unit measures **specific heat capacity**, i.e., the amount of energy required
     * to raise the temperature of one kilogram of a substance by one kelvin.
     * It is defined as the [Quotient] of [Joule] (energy) divided by the [Product] of
     * [Kilogram] (mass) and [Kelvin] (temperature).
     *
     * Example usages include:
     * - Specific heat capacity of water (~4184 J/(kg·K) at 25 °C)
     * - Material science and thermodynamics calculations
     *
     * @see SpecificHeatCapacity for the physical quantity represented by this unit.
     */
    typealias JoulePerKilogramKelvin = Quotient<Joule, Product<Kilogram, Kelvin>>

    companion object {
        /**
         * Creates a measure of **joules per kilogram-kelvin** (J/(kg·K)).
         *
         * This derived unit is used to express specific heat capacity or
         * specific entropy — energy per unit mass per unit temperature.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Joule] (energy) with the specified [prefix]
         *  - divided by a [Product] of [Kilogram] (mass) with the specified [prefix]
         *    and [Kelvin] (temperature)
         *
         * @param prefix Metric prefix to apply to the kilogram unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing J/(kg·K).
         */
        @Suppress("FunctionNaming")
        internal fun JoulePerKilogramKelvin(prefix: Metric = Metric.BASE): JoulePerKilogramKelvin =
            Quotient(
                Joule(),
                Product(Kilogram(prefix), Kelvin())
            )
    }
}
