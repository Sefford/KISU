package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kilogram
import org.kisu.units.base.Second
import org.kisu.units.representation.Quotient
import java.math.BigDecimal

/**
 * Represents the physical quantity of **mass flow rate**, measured in
 * [KilogramPerSecond].
 *
 * Mass flow rate quantifies how much mass crosses a section or boundary per unit time.
 * It is often preferred over volumetric flow when density changes matter.
 *
 * Typical examples include fuel feed to an engine, airflow through a duct, and process
 * streams in chemical plants.
 *
 * The associated unit representation is [KilogramPerSecond] (`kg/s`).
 */
class MassFlowRate(
    magnitude: BigDecimal,
    expression: KilogramPerSecond
) : Measure<MassFlowRate.KilogramPerSecond, MassFlowRate>(magnitude, expression, ::MassFlowRate) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, KilogramPerSecond(prefix))

    /**
     * Unit of [MassFlowRate].
     *
     * Represents the unit of **mass flow rate**, i.e., the physical quantity measuring
     * mass transported per unit time.
     *
     * Symbol: `kg/s`
     * SI: `kg·s⁻¹`
     *
     * @see MassFlowRate
     */
    typealias KilogramPerSecond = Quotient<Kilogram, Second>

    companion object {
        /**
         * Creates a measure of **kilograms per second** (kg/s).
         *
         * This derived unit expresses **mass flow rate** —
         * how much mass passes through a point or system per unit time.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Kilogram] (mass) with the specified [prefix]
         *  - divided by a [Second] (time)
         *
         * @param prefix Metric prefix to apply to the kilogram unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [KilogramPerSecond] representing kg/s.
         */
        @Suppress("FunctionNaming")
        internal fun KilogramPerSecond(prefix: Metric = Metric.BASE): KilogramPerSecond =
            Quotient(Kilogram(prefix), Second())
    }
}
