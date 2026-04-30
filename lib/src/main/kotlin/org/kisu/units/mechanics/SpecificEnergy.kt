package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kilogram
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Joule
import java.math.BigDecimal

/**
 * Represents the physical quantity of **specific energy**, measured in
 * [JoulePerKilogram].
 *
 * Specific energy quantifies energy per unit mass. It is useful when comparing fuels,
 * flows, or materials independently of total sample size.
 *
 * Typical examples include fuel energy content, gravitational or kinetic energy per unit
 * mass, and absorbed energy in irradiated matter.
 *
 * The associated unit representation is [JoulePerKilogram] (`J/kg`).
 */
class SpecificEnergy(
    magnitude: BigDecimal,
    expression: JoulePerKilogram
) : Measure<SpecificEnergy.JoulePerKilogram, SpecificEnergy>(magnitude, expression, ::SpecificEnergy) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, JoulePerKilogram(prefix))

    /**
     * Unit of [SpecificEnergy].
     *
     * Represents the unit of **specific energy**, i.e., the physical quantity measuring
     * energy per unit mass.
     *
     * Symbol: `J/kg`
     * SI: `m²·s⁻²`
     *
     * @see SpecificEnergy
     */
    typealias JoulePerKilogram = Quotient<Joule, Kilogram>

    companion object {
        /**
         * Creates a measure of **joules per kilogram** (J/kg).
         *
         * This derived unit expresses **specific energy** —
         * how much energy is associated with a unit mass.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Joule] (energy) with the specified [prefix]
         *  - divided by a [Kilogram] (mass)
         *
         * @param prefix Metric prefix to apply to the joule unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [JoulePerKilogram] representing J/kg.
         */
        @Suppress("FunctionNaming")
        internal fun JoulePerKilogram(prefix: Metric = Metric.BASE): JoulePerKilogram =
            Quotient(Joule(prefix), Kilogram())
    }
}
