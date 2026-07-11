@file:Suppress("TooManyFunctions")

package org.kisu.units.kinematics.linear

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.base.SecondFifth
import org.kisu.units.base.Time
import org.kisu.units.kinematics.linear.Crackle.Companion.MetrePerSecondFifth
import org.kisu.units.representation.Quotient

/**
 * Represents the physical quantity of **crackle**, measured in
 * [MetrePerSecondFifth].
 *
 * Crackle is the fifth time derivative of position. It is a higher-order kinematic
 * quantity used mainly in advanced motion planning, smooth trajectory design, and
 * analytical treatments of precise motion.
 *
 * The associated unit representation is [MetrePerSecondFifth] (`m/s⁵`).
 */
class Crackle internal constructor(
    magnitude: Magnitude,
    expression: MetrePerSecondFifth
) : Measure<Crackle.MetrePerSecondFifth, Crackle>(magnitude, expression, ::Crackle) {
    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, MetrePerSecondFifth(prefix))

    /**
     * Represents the SI unit **metre per second to the fifth power (m/s⁵)**.
     *
     * This unit is used to measure the **fifth time derivative of position**,
     * sometimes referred to as **fifth-order linear rate change**,
     * i.e., how rapidly the fourth derivative of displacement changes over time.
     * It is defined as the [Quotient] of [Metre] (length) divided by [SecondFifth] (time⁵).
     *
     * Example usages include:
     * - Advanced dynamics simulations in physics or engineering
     * - Modelling high-order motion derivatives in vibration analysis
     * - Control systems requiring extremely precise motion prediction
     *
     * @see Crackle
     */
    typealias MetrePerSecondFifth = Quotient<Metre, SecondFifth>

    companion object {
        /**
         * Creates a [MetrePerSecondFifth] expression for **metre per second fifth** (`m/s⁵`).
         *
         * @param prefix Metric prefix applied to the metre unit component.
         * Defaults to [Metric.BASE] (no prefix).
         * @return A [MetrePerSecondFifth] expression for `m/s⁵`.
         */
        @Suppress("FunctionNaming")
        internal fun MetrePerSecondFifth(prefix: Metric = Metric.BASE): MetrePerSecondFifth =
            Quotient(Metre(prefix), SecondFifth())
    }

    // Dimension-aware arithmetic
    /**
     * Divides this [Crackle] by [Time],
     * yielding [Pop].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): Pop =
        Pop(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Crackle] by [Pop],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Pop
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Crackle] by [Time],
     * yielding [Snap].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): Snap =
        Snap(canonical.component1() * other.canonical.component1())
}
