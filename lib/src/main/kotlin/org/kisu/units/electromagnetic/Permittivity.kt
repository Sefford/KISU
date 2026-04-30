package org.kisu.units.electromagnetic

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.representation.Quotient
import org.kisu.units.special.Farad
import java.math.BigDecimal

/**
 * Represents the physical quantity of **electric permittivity**, measured in
 * [FaradPerMetre].
 *
 * Electric permittivity quantifies how a medium responds to an electric field. It links
 * electric displacement to electric field strength and is one of the core constitutive
 * properties of dielectric materials.
 *
 * Typical examples include capacitor dielectrics, insulating materials, and wave
 * propagation in media.
 *
 * The associated unit representation is [FaradPerMetre] (`F/m`).
 */
class Permittivity(
    magnitude: BigDecimal,
    expression: FaradPerMetre
) : Measure<Permittivity.FaradPerMetre, Permittivity>(magnitude, expression, ::Permittivity) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, FaradPerMetre(prefix))

    /**
     * Represents the SI unit **farad per metre (F/m)**.
     *
     * This unit measures **electric permittivity**, i.e., the ability of a material
     * to permit the formation of an electric field within it.
     * It is defined as the [Quotient] of [Farad] (capacitance) and [Metre] (length).
     *
     * Example usages include:
     * - Characterizing dielectric materials
     * - Designing capacitors and insulating systems
     *
     * @see Permittivity for the physical quantity represented by this unit.
     */
    typealias FaradPerMetre = Quotient<Farad, Metre>

    companion object {
        /**
         * Creates a measure of **farads per metre** (F/m).
         *
         * This derived unit expresses **electric permittivity** — a material property quantifying how a medium
         * responds to an electric field.
         *
         * Internally this returns a [Quotient] of:
         *  - a [Farad] (capacitance) with the specified [prefix]
         *  - divided by a [Metre] (length)
         *
         * @param prefix Metric prefix to apply to the farad unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [FaradPerMetre] representing F/m.
         */
        @Suppress("FunctionNaming")
        internal fun FaradPerMetre(prefix: Metric = Metric.BASE): FaradPerMetre =
            Quotient(Farad(prefix), Metre())
    }
}
