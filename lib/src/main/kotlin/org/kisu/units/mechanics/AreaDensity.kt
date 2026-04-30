package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kilogram
import org.kisu.units.representation.Quotient
import org.kisu.units.special.SquareMetre
import java.math.BigDecimal

/**
 * Represents the physical quantity of **area density**, measured in
 * [KilogramPerSquareMetre].
 *
 * Area density quantifies how much mass is distributed across a surface. It is useful
 * whenever mass is naturally associated with sheets, layers, or coatings rather than
 * with bulk volume.
 *
 * Typical examples include fabric weight, paper grammage, roofing membranes, and soil
 * or snow loading per ground area.
 *
 * The associated unit representation is [KilogramPerSquareMetre] (`kg/m²`).
 */
class AreaDensity(
    magnitude: BigDecimal,
    expression: KilogramPerSquareMetre
) : Measure<AreaDensity.KilogramPerSquareMetre, AreaDensity>(magnitude, expression, ::AreaDensity) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, KilogramPerSquareMetre(prefix))

    /**
     * Unit of [AreaDensity].
     *
     * Represents the unit of **area density**, i.e., the physical quantity measuring
     * mass per unit area.
     *
     * Symbol: `kg/m²`
     * SI: `kg·m⁻²`
     *
     * @see AreaDensity
     */
    typealias KilogramPerSquareMetre = Quotient<Kilogram, SquareMetre>

    companion object {
        /**
         * Creates a measure of **kilograms per square metre** (kg/m²).
         *
         * This derived unit expresses **surface mass density** —
         * how much mass is distributed per unit area.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Kilogram] (mass) with the specified [prefix]
         *  - divided by a [SquareMetre] (area)
         *
         * @param prefix Metric prefix to apply to the kilogram unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [KilogramPerSquareMetre] representing kg/m².
         */
        @Suppress("FunctionNaming")
        internal fun KilogramPerSquareMetre(prefix: Metric = Metric.BASE): KilogramPerSquareMetre =
            Quotient(Kilogram(prefix), SquareMetre())
    }
}
