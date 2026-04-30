package org.kisu.units.photometric

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Lumen
import org.kisu.units.special.Watt
import java.math.BigDecimal

/**
 * Represents the physical quantity of **luminous efficacy**, measured in
 * [LumenPerWatt].
 *
 * Luminous efficacy quantifies how efficiently a source turns power into visible light
 * as perceived by the human eye. It compares useful luminous output with the power
 * supplied or emitted.
 *
 * Typical examples include comparing incandescent bulbs, LEDs, display backlights, or
 * optical emitters for lighting efficiency.
 *
 * The associated unit representation is [LumenPerWatt] (`lm/W`).
 */
class Efficacy(
    magnitude: BigDecimal,
    expression: LumenPerWatt
) : Measure<Efficacy.LumenPerWatt, Efficacy>(magnitude, expression, ::Efficacy) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, LumenPerWatt(prefix))

    /**
     * Represents the SI unit **lumen per watt (lm/W)**.
     *
     * This unit is used to measure **luminous efficacy**,
     * i.e., the efficiency with which a light source converts electrical power into visible light.
     * It is defined as the [Quotient] of [Lumen] (luminous flux) divided by [Watt] (power).
     *
     * Example usages include:
     * - Comparing the efficiency of different light bulbs or LEDs
     * - Designing energy-efficient lighting systems
     * - Evaluating performance in photometry and lighting engineering
     *
     * @see Efficacy
     */
    typealias LumenPerWatt = Quotient<Lumen, Watt>

    companion object {
        /**
         * Creates a measure of **lumens per watt** (lm/W).
         *
         * This derived unit expresses luminous efficacy — how much visible
         * light (luminous flux) is produced per unit of power.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Lumen] (luminous flux) with the specified [prefix]
         *  - divided by a [Watt] (power)
         *
         * @param prefix Metric prefix to apply to the lumen unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing lm/W.
         */
        @Suppress("FunctionNaming")
        internal fun LumenPerWatt(prefix: Metric = Metric.BASE): LumenPerWatt =
            Quotient(Lumen(prefix), Watt())
    }
}
