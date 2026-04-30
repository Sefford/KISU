package org.kisu.units.electromagnetic

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Ampere
import org.kisu.units.representation.Quotient
import org.kisu.units.special.SquareMetre
import java.math.BigDecimal

/**
 * Represents the physical quantity of **electric current density**, measured in
 * [AmperePerSquareMetre].
 *
 * Electric current density quantifies how much electric current passes through a unit
 * cross-sectional area. It describes how concentrated current flow is inside a
 * conductor, plasma, or continuous medium.
 *
 * The associated unit representation is [AmperePerSquareMetre] (`A/m²`).
 */
class ElectricCurrentDensity(
    magnitude: BigDecimal,
    expression: AmperePerSquareMetre
) : Measure<ElectricCurrentDensity.AmperePerSquareMetre, ElectricCurrentDensity>(
    magnitude = magnitude,
    expression = expression,
    create = ::ElectricCurrentDensity
) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, AmperePerSquareMetre(prefix))

    /**
     * Represents the SI unit **ampere per square metre (A/m²)**.
     *
     * This unit measures **electric current density**, i.e., the amount of electric
     * current flowing per unit cross-sectional area.
     * It is defined as the [Quotient] of [Ampere] (electric current) and [SquareMetre] (area).
     *
     * Example usages include:
     * - Describing current flow in conductors
     * - Modeling electromagnetics and circuit behavior
     *
     * @see ElectricCurrentDensity for the physical quantity represented by this unit.
     */
    typealias AmperePerSquareMetre = Quotient<Ampere, SquareMetre>

    companion object {
        /**
         * Creates a measure of **amperes per square metre** (A/m²).
         *
         * This derived unit expresses **current density** —
         * how much electric current flows through a given cross-sectional area.
         *
         * Internally this returns a [Quotient] of:
         *  - an [Ampere] (electric current) with the specified [prefix]
         *  - divided by a [SquareMetre] (area)
         *
         * @param prefix Metric prefix to apply to the ampere unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return An [AmperePerSquareMetre] representing A/m².
         */
        @Suppress("FunctionNaming")
        internal fun AmperePerSquareMetre(prefix: Metric = Metric.BASE): AmperePerSquareMetre =
            Quotient(Ampere(prefix), SquareMetre())
    }
}
