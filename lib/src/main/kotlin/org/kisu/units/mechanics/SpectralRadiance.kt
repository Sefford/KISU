package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.representation.Product
import org.kisu.units.representation.Quotient
import org.kisu.units.special.CubicMetre
import org.kisu.units.special.Steradian
import org.kisu.units.special.Watt
import java.math.BigDecimal

/**
 * Represents the physical quantity of **spectral radiance**, measured in
 * [WattPerSteradianCubicMetre].
 *
 * Spectral radiance combines directional radiance with spectral resolution. It is used
 * when both angular distribution and spectral content of radiation must be described at
 * once.
 *
 * Typical examples include atmospheric radiation models, plasma emission studies, and
 * remote-sensing radiative transfer.
 *
 * The associated unit representation is [WattPerSteradianCubicMetre].
 */
class SpectralRadiance(
    magnitude: BigDecimal,
    expression: WattPerSteradianCubicMetre
) : Measure<SpectralRadiance.WattPerSteradianCubicMetre, SpectralRadiance>(
    magnitude = magnitude,
    expression = expression,
    create = ::SpectralRadiance
) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, WattPerSteradianCubicMetre(prefix))

    /**
     * Unit of [SpectralRadiance].
     *
     * Represents the unit of **spectral radiance**, i.e., the physical quantity measuring
     * radiant power per unit volume per unit solid angle.
     *
     * Symbol: `W/(sr·m³)`
     * SI: `kg·m⁻¹·s⁻³`
     *
     * @see SpectralRadiance
     */
    typealias WattPerSteradianCubicMetre = Quotient<Watt, Product<Steradian, CubicMetre>>

    companion object {
        /**
         * Creates a measure of **watts per steradian per cubic metre** (W/(sr·m³)).
         *
         * This derived unit expresses **radiant intensity per unit volume** —
         * the power emitted per unit solid angle and per unit volume.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Watt] (power) with the specified [prefix]
         *  - divided by the product of a [Steradian] (solid angle) and a [CubicMetre] (volume)
         *
         * @param prefix Metric prefix to apply to the watt unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [WattPerSteradianCubicMetre] representing W/(sr·m³).
         */
        @Suppress("FunctionNaming")
        internal fun WattPerSteradianCubicMetre(prefix: Metric = Metric.BASE): WattPerSteradianCubicMetre =
            Quotient(Watt(prefix), Product(Steradian(), CubicMetre()))
    }
}
