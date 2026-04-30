package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Second
import org.kisu.units.representation.Quotient
import org.kisu.units.special.SquareMetre
import java.math.BigDecimal

/**
 * Represents the physical quantity of **kinematic viscosity**, measured in
 * [SquareMetrePerSecond].
 *
 * Kinematic viscosity quantifies the diffusive tendency of momentum in a fluid by
 * relating dynamic viscosity to density. It is especially convenient in fluid flow
 * analysis because it appears directly in many transport equations.
 *
 * Typical examples include oil grading, hydraulic calculations, and atmospheric or
 * aerodynamic flow studies.
 *
 * The associated unit representation is [SquareMetrePerSecond] (`m²/s`).
 */
class KinematicViscosity(
    magnitude: BigDecimal,
    expression: SquareMetrePerSecond
) : Measure<KinematicViscosity.SquareMetrePerSecond, KinematicViscosity>(
    magnitude = magnitude,
    expression = expression,
    create = ::KinematicViscosity
) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, SquareMetrePerSecond(prefix))

    /**
     * Unit of [KinematicViscosity].
     *
     * Represents the unit of **kinematic viscosity**, i.e., the physical quantity measuring
     * a fluid's resistance to flow relative to its density.
     *
     * Symbol: `m²/s`
     * SI: `m²·s⁻¹`
     *
     * @see KinematicViscosity
     */
    typealias SquareMetrePerSecond = Quotient<SquareMetre, Second>

    companion object {
        /**
         * Creates a measure of **square metres per second** (m²/s).
         *
         * This derived unit expresses **kinematic viscosity** (momentum diffusivity) — the ratio of dynamic viscosity
         * to density, commonly used in fluid-flow and transport analysis.
         *
         * Internally this returns a [Quotient] of:
         *  - a [SquareMetre] (area) with the specified [prefix]
         *  - divided by a [Second] (time)
         *
         * @param prefix Metric prefix to apply to the square metre unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [SquareMetrePerSecond] representing m²/s.
         */
        @Suppress("FunctionNaming")
        internal fun SquareMetrePerSecond(prefix: Metric = Metric.BASE): SquareMetrePerSecond =
            Quotient(SquareMetre(prefix), Second())
    }
}
