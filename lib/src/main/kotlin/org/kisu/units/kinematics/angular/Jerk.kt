package org.kisu.units.kinematics.angular

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.SecondCubed
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Radian
import java.math.BigDecimal

/**
 * Represents the physical quantity of **angular jerk**, measured in
 * [RadianPerSecondCubed].
 *
 * Angular jerk is the time derivative of angular acceleration. It quantifies how
 * abruptly rotational acceleration changes and is important in motion comfort,
 * actuator limits, and high-quality trajectory generation.
 *
 * The associated unit representation is [RadianPerSecondCubed] (`rad/s³`).
 */
class Jerk(
    magnitude: BigDecimal,
    expression: RadianPerSecondCubed
) : Measure<Jerk.RadianPerSecondCubed, Jerk>(magnitude, expression, ::Jerk) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, RadianPerSecondCubed(prefix))

    /**
     * Represents the SI unit **radian per second cubed (rad/s³)**.
     *
     * This unit is used to measure the **third time derivative of angular position**,
     * commonly called **angular jerk** or **angular jolt**,
     * i.e., the rate of change of angular acceleration with respect to time.
     * It is defined as the [Quotient] of [Radian] (angle) divided by [SecondCubed] (time³).
     *
     * Example usages include:
     * - Analysing rapid changes in angular acceleration in robotics or aerospace
     * - Modelling rotational dynamics of precision mechanisms
     * - Designing control systems where higher-order derivatives of motion are relevant
     *
     * @see Jerk
     */
    typealias RadianPerSecondCubed = Quotient<Radian, SecondCubed>

    companion object {
        /**
         * Creates a measure of **radians per second cubed** (rad/s³).
         *
         * This derived unit expresses the third-order time derivative of angular position —
         * also known as **angular jerk** or **angular jolt**, i.e. the rate of change of angular acceleration.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Radian] (angle) with the specified [prefix]
         *  - divided by a [SecondCubed] (time³)
         *
         * @param prefix Metric prefix to apply to the radian unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing rad/s³.
         */
        @Suppress("FunctionNaming")
        internal fun RadianPerSecondCubed(prefix: Metric = Metric.BASE): RadianPerSecondCubed =
            Quotient(Radian(prefix), SecondCubed())
    }
}
