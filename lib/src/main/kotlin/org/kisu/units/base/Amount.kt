@file:Suppress("TooManyFunctions")

package org.kisu.units.base

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Amount.Companion.AVOGADROS_NUMBER
import org.kisu.units.chemistry.CatalyticEfficiency
import org.kisu.units.chemistry.Molality
import org.kisu.units.chemistry.MolarEnergy
import org.kisu.units.chemistry.MolarHeatCapacity
import org.kisu.units.chemistry.MolarMass
import org.kisu.units.chemistry.MolarVolume
import org.kisu.units.chemistry.Molarity
import org.kisu.units.chemistry.ReciprocalAmount
import org.kisu.units.kinematics.VolumetricFlow
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.special.CatalyticActivity
import org.kisu.units.special.Energy
import org.kisu.units.special.Volume
import org.kisu.units.thermodynamics.HeatCapacity

/**
 * Represents the physical quantity of **amount of substance**, measured in moles (mol).
 *
 * This class models the SI base unit for counting discrete entities like atoms, molecules, or particles in a substance.
 * One mole corresponds to [AVOGADROS_NUMBER] elementary entities, typically used in chemistry and physics.
 *
 * The amount is composed of a `magnitude` and an optional metric `expression`, allowing expressions such as millimoles
 * (mmol), micromoles (µmol), or kilomoles (kmol).
 *
 * The value must not be negative, as a physical quantity representing a count of real entities cannot be less than
 * zero.
 *
 * Negative amounts would be physically meaningless in the context of matter.
 *
 * Instances of this class are immutable and preserve their precision using [Magnitude].
 */
class Amount internal constructor(magnitude: Magnitude, expression: Mole) :
    Measure<Mole, Amount>(magnitude, expression, ::Amount) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Mole(prefix))

    /**
     * Returns this amount as a reciprocal amount (`mol⁻¹`) by inverting its canonical magnitude.
     */
    val reciprocalAmount: ReciprocalAmount
        get() = ReciprocalAmount(canonical.component1().inverted)

    companion object {
        /**
         * Avogadro's number — the number of entities in one mole:
         * 6.02214076 × 10²³ entities per mole.
         *
         * This is a fundamental physical constant.
         */
        val AVOGADROS_NUMBER: Magnitude = Magnitude("6.02214076e23")
    }

    // Dimension-aware arithmetic
    /**
     * Divides this [Amount] by [Mass],
     * yielding [Molality].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Mass
    ): Molality =
        Molality(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Amount] by [Time],
     * yielding [CatalyticActivity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): CatalyticActivity =
        CatalyticActivity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Amount] by [Molality],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Molality
    ): Mass =
        Mass(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Amount] by [Molarity],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Molarity
    ): Volume =
        Volume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Amount] by [CatalyticActivity],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: CatalyticActivity
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Amount] by [Volume],
     * yielding [Molarity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Volume
    ): Molarity =
        Molarity(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Amount] by [CatalyticEfficiency],
     * yielding [VolumetricFlow].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: CatalyticEfficiency
    ): VolumetricFlow =
        VolumetricFlow(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Amount] by [MolarEnergy],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MolarEnergy
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Amount] by [MolarHeatCapacity],
     * yielding [HeatCapacity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MolarHeatCapacity
    ): HeatCapacity =
        HeatCapacity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Amount] by [MolarMass],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MolarMass
    ): Mass =
        Mass(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Amount] by [MolarVolume],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MolarVolume
    ): Volume =
        Volume(canonical.component1() * other.canonical.component1())
}

class Mole private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit,
) : Scalar<Metric, Mole>(algebra, prefix, unit, ::Mole) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The SI symbol for amount of substance: "mol". */
        internal val UNIT = Unit("mol", 1)
    }
}
