package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kilogram
import org.kisu.units.base.Metre
import org.kisu.units.base.Second
import org.kisu.units.representation.Product
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Newton
import java.math.BigDecimal

/**
 * Represents the physical quantity of **specific angular momentum**, measured in
 * [NewtonMetreSecondPerKilogram].
 *
 * Specific angular momentum quantifies angular momentum per unit mass. It is especially
 * useful in orbital mechanics and continuum descriptions where total mass varies or is
 * not the natural comparison basis.
 *
 * Typical examples include planetary orbits, rotating flows, and trajectory analysis in
 * astrodynamics.
 *
 * The associated unit representation is [NewtonMetreSecondPerKilogram] (`N·m·s/kg`).
 */
class SpecificAngularMomentum(
    magnitude: BigDecimal,
    expression: NewtonMetreSecondPerKilogram
) : Measure<SpecificAngularMomentum.NewtonMetreSecondPerKilogram, SpecificAngularMomentum>(
    magnitude,
    expression,
    ::SpecificAngularMomentum
) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, NetwonMetreSecondPerKilogram(prefix))

    /**
     * Unit of [SpecificAngularMomentum].
     *
     * Represents the unit of **specific angular momentum**, i.e., the physical quantity measuring
     * angular momentum per unit mass.
     *
     * Symbol: `N·m·s/kg`
     * SI: `m²·s⁻¹`
     *
     * @see SpecificAngularMomentum
     */
    typealias NewtonMetreSecondPerKilogram = Quotient<AngularMomentum.NewtonMeterSecond, Kilogram>

    companion object {
        /**
         * Creates a measure of **newton-metre-seconds per kilogram** (N·m·s/kg).
         *
         * This derived unit expresses a quantity combining **force, distance, and time per unit mass** —
         * it can be used in contexts such as rotational dynamics or specific mechanical impulses.
         *
         * Internally this returns a [Quotient] of:
         *  - the product of a [Newton] (force) with the specified [prefix], a [Metre] (distance), and a [Second] (time)
         *  - divided by a [Kilogram] (mass)
         *
         * @param prefix Metric prefix to apply to the newton unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [NewtonMetreSecondPerKilogram] representing N·m·s/kg.
         */
        @Suppress("FunctionNaming")
        internal fun NetwonMetreSecondPerKilogram(prefix: Metric = Metric.BASE): NewtonMetreSecondPerKilogram =
            Quotient(
                Product(Newton(prefix), Product(Metre(), Second())),
                Kilogram()
            )
    }
}
