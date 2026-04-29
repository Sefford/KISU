package org.kisu.units.kinematics.linear

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.base.SecondSixth
import org.kisu.units.representation.Quotient
import java.math.BigDecimal

/**
 * Represents the physical quantity of **pop**, measured in [MetrePerSecondSixth].
 *
 * Pop is the sixth time derivative of position. It is a specialized high-order
 * kinematic quantity used in very smooth trajectory generation and theoretical motion
 * analysis.
 *
 * The associated unit representation is [MetrePerSecondSixth] (`m/s⁶`).
 */
class Pop internal constructor(
    magnitude: BigDecimal,
    expression: MetrePerSecondSixth
) : Measure<Pop.MetrePerSecondSixth, Pop>(magnitude, expression, ::Pop) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, MetrePerSecondSixth(prefix))

    /**
     * Represents the SI unit **metre per second to the sixth power (m/s⁶)**.
     *
     * This unit is used to measure the **sixth time derivative of position**,
     * i.e., how rapidly the fifth derivative of displacement changes over time.
     * It is defined as the [Quotient] of [Metre] (length) divided by [SecondSixth] (time⁶).
     *
     * Example usages include:
     * - Very high-order motion analysis in physics or engineering simulations
     * - Advanced vibration studies or precision control systems
     * - Modelling complex dynamic systems requiring higher-order derivatives
     *
     * @see Pop
     */
    typealias MetrePerSecondSixth = Quotient<Metre, SecondSixth>

    companion object {
        /**
         * Creates a measure of **metres per second to the sixth power** (m/s⁶).
         *
         * This derived unit expresses the sixth-order time derivative of linear position —
         * i.e., the rate of change of the fifth derivative of velocity.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Metre] (length) with the specified [prefix]
         *  - divided by a [SecondSixth] (time⁶)
         *
         * @param prefix Metric prefix to apply to the metre unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing m/s⁶.
         */
        @Suppress("FunctionNaming")
        internal fun MetrePerSecondSixth(prefix: Metric = Metric.BASE): MetrePerSecondSixth =
            Quotient(Metre(prefix), SecondSixth())
    }
}
