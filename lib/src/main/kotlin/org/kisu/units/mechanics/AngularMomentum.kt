package org.kisu.units.mechanics

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.base.Second
import org.kisu.units.representation.Product
import org.kisu.units.special.Newton
import java.math.BigDecimal

/**
 * Represents the physical quantity of **angular momentum**, measured in
 * [NewtonMeterSecond].
 *
 * Angular momentum quantifies rotational motion and the resistance of that motion to
 * change. It is conserved in isolated systems and therefore fundamental in mechanics
 * from spinning rotors to orbiting bodies.
 *
 * Typical examples include flywheels, planetary orbits, gyroscopic stabilization, and
 * quantum angular momentum.
 *
 * The associated unit representation is [NewtonMeterSecond].
 */
class AngularMomentum(
    magnitude: BigDecimal,
    expression: NewtonMeterSecond
) : Measure<AngularMomentum.NewtonMeterSecond, AngularMomentum>(magnitude, expression, ::AngularMomentum) {
    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, NewtonMeterSecond(prefix))

    /**
     * Unit of [AngularMomentum].
     *
     * Represents the unit of **angular momentum**, i.e., the physical quantity measuring
     * rotational momentum of a body.
     *
     * Symbol: `N·m·s`
     * SI: `m²·kg·s⁻¹`
     *
     * @see AngularMomentum
     */
    typealias NewtonMeterSecond = Product<Newton, Product<Metre, Second>>

    companion object {
        /**
         * Creates a measure of **newton-metre-seconds** (N·m·s).
         *
         * This compound unit represents the product of:
         *  - a [Newton] (force) with the specified [prefix]
         *  - multiplied by a [Metre] (length)
         *  - multiplied by a [Second] (time)
         *
         * It can be used in mechanics to express **angular impulse** or related
         * physical quantities combining force, distance, and time.
         *
         * @param prefix Metric prefix to apply to the newton unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [NewtonMeterSecond] representing N·m·s.
         */
        @Suppress("FunctionNaming")
        internal fun NewtonMeterSecond(prefix: Metric = Metric.BASE): NewtonMeterSecond =
            Product(Newton(prefix), Product(Metre(), Second()))
    }
}
