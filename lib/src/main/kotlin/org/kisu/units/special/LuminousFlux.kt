@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.LuminousIntensity
import org.kisu.units.base.Time
import org.kisu.units.photometric.Efficacy
import org.kisu.units.photometric.LuminousEnergy
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

/**
 * Represents the physical quantity of **luminous flux**, measured in [Lumen].
 *
 * Luminous flux quantifies the total visible light output of a source, weighted by the
 * response of human vision. It describes how much light is emitted overall, without
 * yet saying how that light is distributed.
 *
 * Typical examples include the rated output of a lamp, flashlight, LED panel, or
 * projector.
 *
 * The canonical SI unit is the [Lumen] (`lm`), often scaled to `klm` for larger
 * lighting systems.
 */
class LuminousFlux internal constructor(magnitude: Magnitude, expression: Lumen) :
    Measure<Lumen, LuminousFlux>(magnitude, expression, ::LuminousFlux) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Lumen(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [LuminousFlux] by [LuminousIntensity],
     * yielding [SolidAngle].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: LuminousIntensity
    ): SolidAngle =
        SolidAngle(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [LuminousFlux] by [Efficacy],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Efficacy
    ): Power =
        Power(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [LuminousFlux] by [Area],
     * yielding [Illuminance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): Illuminance =
        Illuminance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [LuminousFlux] by [Illuminance],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Illuminance
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [LuminousFlux] by [Power],
     * yielding [Efficacy].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Power
    ): Efficacy =
        Efficacy(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [LuminousFlux] by [SolidAngle],
     * yielding [LuminousIntensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SolidAngle
    ): LuminousIntensity =
        LuminousIntensity(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [LuminousFlux] by [Time],
     * yielding [LuminousEnergy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): LuminousEnergy =
        LuminousEnergy(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **lumen** (`lm`), used to express [LuminousFlux].
 *
 * A lumen quantifies the total visible light emitted by a source, weighted by the
 * sensitivity of human vision. It describes overall light output rather than how that
 * light is distributed over an area.
 *
 * This unit is commonly used to compare light bulbs, LED fixtures, flashlights, and
 * other sources where total visible output matters.
 *
 * In unit form, `lm = cd·sr`.
 *
 * @see LuminousFlux
 * @see Lux
 * @see Steradian
 */
class Lumen private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Lumen>(algebra, prefix, unit, ::Lumen) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for lumen: "lm". */
        internal val UNIT = Unit("lm", 1)
    }
}
