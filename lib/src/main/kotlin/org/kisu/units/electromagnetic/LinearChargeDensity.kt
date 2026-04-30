package org.kisu.units.electromagnetic

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Coulomb
import java.math.BigDecimal

/**
 * Represents the physical quantity of **linear charge density**, measured in
 * [CoulombPerMetre].
 *
 * Linear charge density quantifies how much electric charge is distributed along a unit
 * length. It is the natural description for charged wires, rods, filaments, and other
 * effectively one-dimensional charge distributions.
 *
 * The associated unit representation is [CoulombPerMetre] (`C/m`).
 */
class LinearChargeDensity(
    magnitude: BigDecimal,
    expression: CoulombPerMetre
) : Measure<LinearChargeDensity.CoulombPerMetre, LinearChargeDensity>(
    magnitude = magnitude,
    expression = expression,
    create = ::LinearChargeDensity
) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, CoulombPerMetre(prefix))

    /**
     * Represents the SI unit **coulomb per metre (C/m)**.
     *
     * This unit measures **linear charge density**, i.e., the amount of electric
     * charge distributed per unit length.
     * It is defined as the [Quotient] of [Coulomb] (electric charge) and [Metre] (length).
     *
     * Example usages include:
     * - Describing charge along wires, filaments, or rods
     * - Calculating electric fields from line charge distributions
     *
     * @see LinearChargeDensity for the physical quantity represented by this unit.
     */
    typealias CoulombPerMetre = Quotient<Coulomb, Metre>

    companion object {
        /**
         * Creates a measure of **coulombs per metre** (C/m).
         *
         * This derived unit expresses **linear charge density** —
         * how much electric charge (in coulombs) is distributed per unit length.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Coulomb] (electric charge) with the specified [prefix]
         *  - divided by a [Metre] (length)
         *
         * @param prefix Metric prefix to apply to the coulomb unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [CoulombPerMetre] representing C/m.
         */
        @Suppress("FunctionNaming")
        internal fun CoulombPerMetre(prefix: Metric = Metric.BASE): CoulombPerMetre =
            Quotient(Coulomb(prefix), Metre())
    }
}
