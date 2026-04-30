package org.kisu.units.chemistry

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Kilogram
import org.kisu.units.base.Mole
import org.kisu.units.representation.Quotient
import java.math.BigDecimal

/**
 * Represents the physical quantity of **molar mass**, measured in [KilogramPerMole].
 *
 * Molar mass quantifies the mass associated with one mole of a substance. It provides
 * the bridge between microscopic counting in moles and macroscopic mass measured in the
 * laboratory.
 *
 * This quantity is fundamental in stoichiometry, solution preparation, and molecular
 * property calculations.
 *
 * The associated SI unit representation is [KilogramPerMole] (`kg/mol`).
 */
class MolarMass(
    magnitude: BigDecimal,
    expression: KilogramPerMole
) : Measure<MolarMass.KilogramPerMole, MolarMass>(magnitude, expression, ::MolarMass) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, KilogramPerMole(prefix))

    /**
     * Represents the SI unit **kilogram per mole (kg/mol)**.
     *
     * This unit measures **molar mass**, i.e., the mass of one mole of a substance.
     * It is defined as the [Quotient] of [Kilogram] (mass) divided by [Mole] (amount of substance).
     *
     * Example usages include:
     * - Determining the mass of one mole of water (~0.018 kg/mol)
     * - Stoichiometric calculations in chemical reactions
     * - Molecular and thermodynamic property analyses
     *
     * @see MolarMass for the physical quantity represented by this unit.
     */
    typealias KilogramPerMole = Quotient<Kilogram, Mole>

    companion object {
        /**
         * Creates a measure of **kilograms per mole** (kg/mol).
         *
         * This derived unit is used to express mass per amount of substance,
         * for example molar mass in chemistry.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Kilogram] (mass) with the specified [prefix]
         *  - divided by a [Mole] (amount of substance)
         *
         * @param prefix Metric prefix to apply to the kilogram unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing kg/mol.
         */
        @Suppress("FunctionNaming")
        internal fun KilogramPerMole(prefix: Metric = Metric.BASE): KilogramPerMole =
            Quotient(Kilogram(prefix), Mole())
    }
}
