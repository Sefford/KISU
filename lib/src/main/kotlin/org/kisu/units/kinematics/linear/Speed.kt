@file:Suppress("TooManyFunctions")

package org.kisu.units.kinematics.linear

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Length
import org.kisu.units.base.Mass
import org.kisu.units.base.Metre
import org.kisu.units.base.Second
import org.kisu.units.base.Time
import org.kisu.units.kinematics.linear.Speed.Companion.MetrePerSecond
import org.kisu.units.mechanics.Momentum
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Force
import org.kisu.units.special.Power

/**
 * Represents the physical quantity of **speed**, measured in [MetrePerSecond].
 *
 * Speed quantifies how quickly position changes, without encoding direction. It is the
 * scalar magnitude commonly used in everyday descriptions of motion.
 *
 * Typical examples include vehicle speed, fluid speed in a pipe, or the speed of a
 * moving object in a simulation.
 *
 * The associated unit representation is [MetrePerSecond] (`m/s`).
 */
class Speed(
    magnitude: Magnitude,
    expression: MetrePerSecond
) : Measure<Speed.MetrePerSecond, Speed>(magnitude, expression, ::Speed) {
    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, MetrePerSecond(prefix))

    /**
     * Represents the SI unit **metre per second (m/s)**.
     *
     * This unit is used to measure **linear velocity**,
     * i.e., the rate of change of position with respect to time.
     * It is defined as the [Quotient] of [Metre] (length) divided by [Second] (time).
     *
     * Example usages include:
     * - Measuring the speed of vehicles, projectiles, or moving objects
     * - Describing fluid flow rates in physics and engineering
     * - Analysing motion in mechanics and kinematics
     *
     * @see Speed
     */
    typealias MetrePerSecond = Quotient<Metre, Second>

    companion object {
        /**
         * Creates a [MetrePerSecond] expression for **metre per second** (`m/s`).
         *
         * @param prefix Metric prefix applied to the metre unit component.
         * Defaults to [Metric.BASE] (no prefix).
         * @return A [MetrePerSecond] expression for `m/s`.
         */
        @Suppress("FunctionNaming")
        internal fun MetrePerSecond(prefix: Metric = Metric.BASE): MetrePerSecond =
            Quotient(Metre(prefix), Second())
    }

    // Dimension-aware arithmetic
    /**
     * Divides this [Speed] by [Time],
     * yielding [Acceleration].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): Acceleration =
        Acceleration(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Speed] by [Acceleration],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Acceleration
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Speed] by [Mass],
     * yielding [Momentum].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Mass
    ): Momentum =
        Momentum(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Speed] by [Time],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): Length =
        Length(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Speed] by [Force],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Force
    ): Power =
        Power(canonical.component1() * other.canonical.component1())
}
