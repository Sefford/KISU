@file:Suppress("TooManyFunctions")

package org.kisu.units.mechanics

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Length
import org.kisu.units.mechanics.RadiantIntensity.Companion.WattPerSteradian
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Area
import org.kisu.units.special.Power
import org.kisu.units.special.SolidAngle
import org.kisu.units.special.Steradian
import org.kisu.units.special.Watt

/**
 * Represents the physical quantity of **radiant intensity**, measured in
 * [WattPerSteradian].
 *
 * Radiant intensity quantifies how radiant power is distributed by direction. It is
 * especially useful for point-like or directional sources whose emission pattern
 * matters.
 *
 * Typical examples include lamps, LEDs, laser sources, and astronomical emitters.
 *
 * The associated unit representation is [WattPerSteradian] (`W/sr`).
 */
class RadiantIntensity(
    magnitude: Magnitude,
    expression: WattPerSteradian
) : Measure<RadiantIntensity.WattPerSteradian, RadiantIntensity>(magnitude, expression, ::RadiantIntensity) {
    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, WattPerSteradian(prefix))

    /**
     * Unit of [RadiantIntensity].
     *
     * Represents the unit of **radiant intensity**, i.e., the physical quantity measuring
     * radiant power emitted per unit solid angle.
     *
     * Symbol: `W/sr`
     * SI: `kg·m²·s⁻³`
     *
     * @see RadiantIntensity
     */
    typealias WattPerSteradian = Quotient<Watt, Steradian>

    companion object {
        /**
         * Creates a [WattPerSteradian] expression for **watt per steradian** (`W/sr`).
         *
         * @param prefix Metric prefix applied to the watt unit component.
         * Defaults to [Metric.BASE] (no prefix).
         * @return A [WattPerSteradian] expression for `W/sr`.
         */
        @Suppress("FunctionNaming")
        internal fun WattPerSteradian(prefix: Metric = Metric.BASE): WattPerSteradian =
            Quotient(Watt(prefix), Steradian())
    }

    // Dimension-aware arithmetic
    /**
     * Divides this [RadiantIntensity] by [Length],
     * yielding [SpectralIntensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): SpectralIntensity =
        SpectralIntensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [RadiantIntensity] by [Radiance],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Radiance
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [RadiantIntensity] by [SpectralIntensity],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SpectralIntensity
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [RadiantIntensity] by [Area],
     * yielding [Radiance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): Radiance =
        Radiance(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [RadiantIntensity] by [SolidAngle],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SolidAngle
    ): Power =
        Power(canonical.component1() * other.canonical.component1())
}
