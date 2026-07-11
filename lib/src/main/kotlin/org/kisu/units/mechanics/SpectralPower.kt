@file:Suppress("TooManyFunctions")

package org.kisu.units.mechanics

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Length
import org.kisu.units.base.Metre
import org.kisu.units.mechanics.SpectralPower.Companion.WattPerMetre
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Area
import org.kisu.units.special.Power
import org.kisu.units.special.Watt

/**
 * Represents the physical quantity of **spectral power**, measured in [WattPerMetre].
 *
 * Spectral power quantifies how radiant power is distributed with respect to a spectral
 * coordinate. It is frequently used when analyzing sources by wavelength or another
 * one-dimensional spectral variable.
 *
 * Typical examples include source spectra, laser outputs, and optical transmission
 * analysis.
 *
 * The associated unit representation is [WattPerMetre].
 */
class SpectralPower(
    magnitude: Magnitude,
    expression: WattPerMetre
) : Measure<SpectralPower.WattPerMetre, SpectralPower>(magnitude, expression, ::SpectralPower) {
    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, WattPerMetre(prefix))

    /**
     * Unit of [SpectralPower].
     *
     * Represents the unit of **spectral power**, i.e., the physical quantity measuring
     * radiant power per unit length.
     *
     * Symbol: `W/m`
     * SI: `kg·s⁻³`
     *
     * @see SpectralPower
     */
    typealias WattPerMetre = Quotient<Watt, Metre>

    companion object {
        /**
         * Creates a [WattPerMetre] expression for **watt per metre** (`W/m`).
         *
         * @param prefix Metric prefix applied to the watt unit component.
         * Defaults to [Metric.BASE] (no prefix).
         * @return A [WattPerMetre] expression for `W/m`.
         */
        @Suppress("FunctionNaming")
        internal fun WattPerMetre(prefix: Metric = Metric.BASE): WattPerMetre =
            Quotient(Watt(prefix), Metre())
    }

    // Dimension-aware arithmetic
    /**
     * Divides this [SpectralPower] by [SpectralIrradiance],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SpectralIrradiance
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [SpectralPower] by [Area],
     * yielding [SpectralIrradiance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): SpectralIrradiance =
        SpectralIrradiance(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [SpectralPower] by [Length],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Length
    ): Power =
        Power(canonical.component1() * other.canonical.component1())
}
