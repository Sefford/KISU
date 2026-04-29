package org.kisu.units.thermodynamics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kelvin
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Watt
import java.math.BigDecimal

/**
 * Represents the physical quantity of **thermal resistance**, measured in
 * [KelvinPerWatt].
 *
 * Thermal resistance quantifies how strongly a material, component, or interface
 * opposes heat flow. It tells how much temperature difference is required to sustain a
 * given rate of heat transfer.
 *
 * Typical examples include insulation layers, heat sinks, package-to-ambient thermal
 * paths, and building-envelope calculations.
 *
 * The associated SI unit representation is [KelvinPerWatt] (`K/W`).
 */
class ThermalResistance(
    magnitude: BigDecimal,
    expression: KelvinPerWatt
) : Measure<ThermalResistance.KelvinPerWatt, ThermalResistance>(magnitude, expression, ::ThermalResistance) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, KelvinPerWatt(prefix))

    /**
     * Represents the SI unit **kelvin per watt (K/W)**.
     *
     * This unit measures **thermal resistance**, i.e., a material’s or system’s
     * opposition to heat flow.
     * It is defined as the [Quotient] of [Kelvin] (temperature difference) divided by [Watt] (heat flow rate).
     *
     * Example usages include:
     * - Evaluating insulation performance in buildings
     * - Thermal management of electronic components
     * - Heat transfer analysis in engineering systems
     *
     * @see ThermalResistance for the physical quantity represented by this unit.
     */
    typealias KelvinPerWatt = Quotient<Kelvin, Watt>

    companion object {
        /**
         * Creates a measure of **kelvins per watt** (K/W).
         *
         * This derived unit expresses thermal resistance — the temperature
         * difference per unit of power flow.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Kelvin] (temperature difference) with the specified [prefix]
         *  - divided by a [Watt] (power)
         *
         * @param prefix Metric prefix to apply to the kelvin unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing K/W.
         */
        @Suppress("FunctionNaming")
        internal fun KelvinPerWatt(prefix: Metric = Metric.BASE): KelvinPerWatt =
            Quotient(Kelvin(prefix), Watt())
    }
}
