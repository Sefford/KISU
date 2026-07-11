@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Length
import org.kisu.units.base.Mass
import org.kisu.units.base.Time
import org.kisu.units.kinematics.Yank
import org.kisu.units.kinematics.linear.Acceleration
import org.kisu.units.kinematics.linear.Speed
import org.kisu.units.mechanics.Compressibility
import org.kisu.units.mechanics.Momentum
import org.kisu.units.mechanics.SurfaceTension
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

/**
 * Represents the physical quantity of **force**, measured in [Newton].
 *
 * Force quantifies an interaction capable of changing motion or deforming a body. It
 * is the language used to describe pushes, pulls, tension, weight, contact reactions,
 * and many field interactions in classical mechanics.
 *
 * Typical examples include the weight of an object, the thrust of a motor, the pull in
 * a cable, or the load applied to a structural element.
 *
 * The canonical SI unit is the [Newton] (`N`), often scaled to `mN` or `kN` depending
 * on the application.
 */
class Force internal constructor(magnitude: Magnitude, expression: Newton) :
    Measure<Newton, Force>(magnitude, expression, ::Force) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Newton(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [Force] by [Length],
     * yielding [SurfaceTension].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): SurfaceTension =
        SurfaceTension(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [Mass],
     * yielding [Acceleration].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Mass
    ): Acceleration =
        Acceleration(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [Time],
     * yielding [Yank].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): Yank =
        Yank(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [Yank],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Yank
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [Acceleration],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Acceleration
    ): Mass =
        Mass(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [SurfaceTension],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SurfaceTension
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [Area],
     * yielding [Pressure].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): Pressure =
        Pressure(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Force] by [Pressure],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Pressure
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Force] by [Length],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Length
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Force] by [Time],
     * yielding [Momentum].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): Momentum =
        Momentum(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Force] by [Speed],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Speed
    ): Power =
        Power(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Force] by [Compressibility],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Compressibility
    ): Area =
        Area(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **newton** (`N`), used to express [Force].
 *
 * A newton quantifies force: the push or pull that changes motion or balances another
 * force. One newton is the force required to accelerate a one-kilogram mass by one
 * metre per second squared.
 *
 * This unit is used for mechanical loads, contact forces, weight near Earth's surface,
 * spring forces, and structural calculations.
 *
 * In unit form, `N = kg·m/s² = m·kg·s⁻²`.
 *
 * @see Force
 * @see Joule
 * @see Pascal
 */
class Newton private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Newton>(algebra, prefix, unit, ::Newton) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for newton: "N". */
        internal val UNIT = Unit("N", 1)
    }
}
