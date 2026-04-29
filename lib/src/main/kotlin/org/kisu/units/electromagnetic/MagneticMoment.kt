package org.kisu.units.electromagnetic

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.representation.Product
import org.kisu.units.special.Weber
import java.math.BigDecimal

/**
 * Represents magnetic moment in terms of [WeberMetre].
 *
 * In this API the quantity is modeled as magnetic flux multiplied by length. Read this
 * as a derived representation used by the library, not as the more common textbook
 * form `A·m²` usually associated with magnetic dipole moment.
 *
 * Typical uses include electromagnetic calculations where magnetic interaction
 * strength is expressed through a flux-length construction.
 *
 * @param magnitude numerical value of the measure
 * @param expression unit expression in weber metre (Wb·m)
 */
class MagneticMoment(
    magnitude: BigDecimal,
    expression: WeberMetre
) : Measure<MagneticMoment.WeberMetre, MagneticMoment>(magnitude, expression, ::MagneticMoment) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, WeberMetre(prefix))

    /**
     * Represents the library unit **weber metre (Wb·m)** for [MagneticMoment].
     *
     * It is defined as the [Product] of [Weber] and [Metre].
     *
     * @see MagneticMoment
     */
    typealias WeberMetre = Product<Weber, Metre>

    companion object {
        /**
         * Creates a unit expression in **weber-metres** (Wb·m).
         *
         * This representation is built as a [Product] of [Weber] and [Metre].
         *
         * @param prefix Metric prefix to apply to the weber unit.
         * @return A [WeberMetre] representing Wb·m.
         */
        @Suppress("FunctionNaming")
        internal fun WeberMetre(prefix: Metric = Metric.BASE): WeberMetre =
            Product(Weber(prefix), Metre())
    }
}
