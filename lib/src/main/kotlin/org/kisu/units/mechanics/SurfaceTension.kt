package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Newton
import java.math.BigDecimal

/**
 * Represents the physical quantity of **surface tension**, measured in
 * [NewtonPerMetre].
 *
 * Surface tension quantifies the contractive tendency of a liquid surface caused by
 * intermolecular cohesion. It governs capillarity, droplet shape, wetting, and many
 * interface phenomena.
 *
 * Typical examples include water droplets, detergency, coating processes, and
 * microfluidic behavior.
 *
 * The associated unit representation is [NewtonPerMetre] (`N/m`).
 */
class SurfaceTension(
    magnitude: BigDecimal,
    expression: NewtonPerMetre
) : Measure<SurfaceTension.NewtonPerMetre, SurfaceTension>(magnitude, expression, ::SurfaceTension) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, NewtonPerMetre(prefix))

    /**
     * Unit of [SurfaceTension].
     *
     * Represents the unit of **surface tension**, i.e., the physical quantity measuring
     * force per unit length along a liquid surface.
     *
     * Symbol: `N/m`
     * SI: `kg·s⁻²`
     *
     * @see SurfaceTension
     */
    typealias NewtonPerMetre = Quotient<Newton, Metre>

    companion object {
        /**
         * Creates a measure of **newtons per metre** (N/m).
         *
         * This derived unit expresses **linear force density or stiffness** —
         * how much force is applied per unit length, commonly used in springs and tension calculations.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Newton] (force) with the specified [prefix]
         *  - divided by a [Metre] (length)
         *
         * @param prefix Metric prefix to apply to the newton unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [NewtonPerMetre] representing N/m.
         */
        @Suppress("FunctionNaming")
        internal fun NewtonPerMetre(prefix: Metric = Metric.BASE): NewtonPerMetre =
            Quotient(Newton(prefix), Metre())
    }
}
