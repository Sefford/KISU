package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Second
import org.kisu.units.representation.Product
import org.kisu.units.special.Newton
import java.math.BigDecimal

/**
 * Represents the physical quantity of **momentum**, measured in [NewtonSecond].
 *
 * Momentum quantifies the amount of motion carried by a body. Because it is conserved in
 * isolated systems, it is one of the central bookkeeping quantities of mechanics.
 *
 * Typical examples include collisions, propulsion, recoil, and particle-beam dynamics.
 *
 * The associated unit representation is [NewtonSecond].
 */
class Momentum(
    magnitude: BigDecimal,
    expression: NewtonSecond
) : Measure<Momentum.NewtonSecond, Momentum>(magnitude, expression, ::Momentum) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, NewtonSecond(prefix))

    /**
     * Unit of [Momentum].
     *
     * Represents the unit of **momentum**, i.e., the physical quantity measuring
     * the product of mass and velocity of a body.
     *
     * Symbol: `N·s`
     * SI: `kg·m·s⁻¹`
     *
     * @see Momentum
     */
    typealias NewtonSecond = Product<Newton, Second>

    companion object {
        /**
         * Creates a measure of **newton-seconds** (N·s).
         *
         * This compound unit represents the product of:
         *  - a [Newton] (force) with the specified [prefix]
         *  - multiplied by a [Second] (time)
         *
         * It is commonly used to express **impulse** in mechanics —
         * the change in momentum resulting from a force applied over time.
         *
         * @param prefix Metric prefix to apply to the newton unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [NewtonSecond] representing N·s.
         */
        @Suppress("FunctionNaming")
        internal fun NewtonSecond(prefix: Metric = Metric.BASE): NewtonSecond =
            Product(Newton(prefix), Second())
    }
}
