package org.kisu.units.electromagnetic

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Ampere
import org.kisu.units.base.Metre
import org.kisu.units.representation.Quotient
import java.math.BigDecimal

/**
 * Represents the physical quantity of **magnetization**, measured in
 * [AmperePerMetre].
 *
 * Magnetization quantifies magnetic dipole moment per unit volume in a material. It
 * describes how strongly a substance responds internally to an applied magnetic field.
 *
 * Typical examples include ferromagnetic materials, magnetic media, and constitutive
 * modeling in electromagnetism.
 *
 * The associated unit representation is [AmperePerMetre] (`A/m`).
 */
class Magnetization(
    magnitude: BigDecimal,
    expression: AmperePerMetre
) : Measure<Magnetization.AmperePerMetre, Magnetization>(magnitude, expression, ::Magnetization) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, AmperePerMetre(prefix))

    /**
     * Represents the SI unit **ampere per metre (A/m)**.
     *
     * This unit is used for magnetization, commonly interpreted as magnetic dipole
     * moment per unit volume. It is defined here as the [Quotient] of [Ampere] and
     * [Metre].
     *
     * @see Magnetization
     */
    typealias AmperePerMetre = Quotient<Ampere, Metre>

    companion object {
        /**
         * Creates a unit expression in **amperes per metre** (A/m).
         *
         * This representation is used by [Magnetization]. Internally it returns a
         * [Quotient] of [Ampere] by [Metre].
         *
         * @param prefix Metric prefix to apply to the ampere unit.
         * @return An [AmperePerMetre] representing A/m.
         */
        @Suppress("FunctionNaming")
        internal fun AmperePerMetre(prefix: Metric = Metric.BASE): AmperePerMetre =
            Quotient(Ampere(prefix), Metre())
    }
}
