package org.kisu.units.chemistry

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Mole
import org.kisu.units.representation.Quotient
import org.kisu.units.special.CubicMetre
import java.math.BigDecimal

/**
 * Represents the physical quantity of **molarity**, also called molar concentration,
 * measured in [MolePerCubicMetre].
 *
 * Molarity quantifies how much solute is present per unit volume of solution. It is one
 * of the most familiar ways to describe concentration in chemistry, especially in
 * laboratory and industrial solution preparation.
 *
 * Typical examples include reagent concentrations, buffer preparation, and analytical
 * chemistry workflows.
 *
 * The associated SI unit representation is [MolePerCubicMetre] (`mol/m³`), though
 * litre-based forms are also common in practice.
 */
class Molarity(
    magnitude: BigDecimal,
    expression: MolePerCubicMetre
) : Measure<Molarity.MolePerCubicMetre, Molarity>(magnitude, expression, ::Molarity) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, MolePerCubicMetre(prefix))

    /**
     * Represents the SI unit **mole per cubic metre (mol/m³)**.
     *
     * This unit measures **molarity**, i.e., the number of moles of a substance
     * present in a unit volume of solution.
     * It is defined as the [Quotient] of [Mole] (amount of substance) divided by [CubicMetre] (volume).
     *
     * Example usages include:
     * - Expressing the concentration of a solution in chemistry and chemical engineering
     * - Calculating reactant availability in volumetric reactions
     * - Thermodynamic and solution property analyses
     *
     * @see Molarity for the physical quantity represented by this unit.
     */
    typealias MolePerCubicMetre = Quotient<Mole, CubicMetre>

    companion object {
        /**
         * Creates a measure of **moles per cubic metre** (mol/m³).
         *
         * This derived unit is widely used in chemistry and physics
         * to express the amount of substance per unit volume
         * (molar concentration in SI base units).
         *
         * Internally this returns a [Quotient] of:
         *  - a [Mole] (amount of substance) with the specified [prefix]
         *  - divided by a [CubicMetre] (volume)
         *
         * @param prefix Metric prefix to apply to the mole unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [Quotient] representing mol/m³.
         */
        @Suppress("FunctionNaming")
        internal fun MolePerCubicMetre(prefix: Metric = Metric.BASE): MolePerCubicMetre =
            Quotient(Mole(prefix), CubicMetre())
    }
}
