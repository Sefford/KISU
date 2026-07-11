@file:Suppress("TooManyFunctions")

package org.kisu.units.mechanics

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Time
import org.kisu.units.mechanics.RadiantExposure.Companion.JoulePerSquareMetre
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Area
import org.kisu.units.special.Energy
import org.kisu.units.special.Joule
import org.kisu.units.special.SquareMetre

/**
 * Represents the physical quantity of **radiant exposure**, measured in
 * [JoulePerSquareMetre].
 *
 * Radiant exposure quantifies the total radiant energy received by a surface per unit
 * area over a finite interval. It is the cumulative counterpart of irradiance.
 *
 * Typical examples include pulse-laser exposure, solar energy received over a time
 * window, and optical or radiation treatment delivery.
 *
 * The associated unit representation is [JoulePerSquareMetre] (`J/m²`).
 */
class RadiantExposure(
    magnitude: Magnitude,
    expression: JoulePerSquareMetre
) : Measure<RadiantExposure.JoulePerSquareMetre, RadiantExposure>(
    magnitude = magnitude,
    expression = expression,
    create = ::RadiantExposure
) {
    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, JoulePerSquareMetre(prefix))

    /**
     * Unit of [RadiantExposure].
     *
     * Represents the unit of **radiant exposure**, i.e., the physical quantity measuring
     * energy received per unit area from electromagnetic radiation.
     *
     * Symbol: `J/m²`
     * SI: `kg·s⁻²`
     *
     * @see RadiantExposure
     */
    typealias JoulePerSquareMetre = Quotient<Joule, SquareMetre>

    companion object {
        /**
         * Creates a [JoulePerSquareMetre] expression for **joule per square metre** (`J/m²`).
         *
         * @param prefix Metric prefix applied to the joule unit component.
         * Defaults to [Metric.BASE] (no prefix).
         * @return A [JoulePerSquareMetre] expression for `J/m²`.
         */
        @Suppress("FunctionNaming")
        internal fun JoulePerSquareMetre(prefix: Metric = Metric.BASE): JoulePerSquareMetre =
            Quotient(Joule(prefix), SquareMetre())
    }

    // Dimension-aware arithmetic
    /**
     * Divides this [RadiantExposure] by [Time],
     * yielding [EnergyFluxDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): EnergyFluxDensity =
        EnergyFluxDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [RadiantExposure] by [EnergyFluxDensity],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: EnergyFluxDensity
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [RadiantExposure] by [Area],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Area
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())
}
