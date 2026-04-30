package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kilogram
import org.kisu.units.representation.Quotient
import org.kisu.units.special.CubicMetre
import java.math.BigDecimal

/**
 * Represents the physical quantity of **specific volume**, measured in
 * [CubicMetrePerKilogram].
 *
 * Specific volume quantifies how much volume is occupied per unit mass. It is the
 * reciprocal viewpoint of density and is especially common in thermodynamics and fluid
 * property tables.
 *
 * Typical examples include steam tables, gas-property analysis, and compressible-flow
 * calculations.
 *
 * The associated unit representation is [CubicMetrePerKilogram] (`m³/kg`).
 */
class SpecificVolume(
    magnitude: BigDecimal,
    expression: CubicMetrePerKilogram
) : Measure<SpecificVolume.CubicMetrePerKilogram, SpecificVolume>(magnitude, expression, ::SpecificVolume) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, CubicMetrePerKilogram(prefix))

    /**
     * Unit of [SpecificVolume].
     *
     * Represents the unit of **specific volume**, i.e., the physical quantity measuring
     * volume per unit mass.
     *
     * Symbol: `m³/kg`
     * SI: `m³·kg⁻¹`
     *
     * @see SpecificVolume
     */
    typealias CubicMetrePerKilogram = Quotient<CubicMetre, Kilogram>

    companion object {
        /**
         * Creates a measure of **cubic metres per kilogram** (m³/kg).
         *
         * This derived unit expresses **specific volume** —
         * how much volume is associated with a unit mass.
         *
         * Internally this returns a [Quotient] of:
         *  - a [CubicMetre] (volume) with the specified [prefix]
         *  - divided by a [Kilogram] (mass)
         *
         * @param prefix Metric prefix to apply to the cubic metre unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [CubicMetrePerKilogram] representing m³/kg.
         */
        @Suppress("FunctionNaming")
        internal fun CubicMetrePerKilogram(prefix: Metric = Metric.BASE): CubicMetrePerKilogram =
            Quotient(CubicMetre(prefix), Kilogram())
    }
}
