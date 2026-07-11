@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Amount
import org.kisu.units.base.Length
import org.kisu.units.base.Mass
import org.kisu.units.base.Time
import org.kisu.units.chemistry.MolarVolume
import org.kisu.units.chemistry.Molarity
import org.kisu.units.electromagnetic.ElectricChargeDensity
import org.kisu.units.kinematics.VolumetricFlow
import org.kisu.units.mechanics.Density
import org.kisu.units.mechanics.EnergyDensity
import org.kisu.units.mechanics.FuelEfficiency
import org.kisu.units.mechanics.SpecificVolume
import org.kisu.units.mechanics.WaveNumber
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

private const val CUBIC_METRE_PREFIX_BASE = 1000

/**
 * Represents the physical quantity of **volume**, measured in [CubicMetre].
 *
 * Volume quantifies how much three-dimensional space is occupied or enclosed. It is
 * used for containers, rooms, solids, fluids, and any region with spatial extent in
 * three dimensions.
 *
 * Typical examples include the capacity of a tank, the internal space of a room, the
 * volume of fuel consumed, or the size of a solid object.
 *
 * The canonical SI unit is the [CubicMetre] (`m³`), with smaller or larger metric
 * forms such as `cm³` or `km³` used when appropriate.
 */
class Volume internal constructor(magnitude: Magnitude, expression: CubicMetre) :
    Measure<CubicMetre, Volume>(magnitude, expression, ::Volume) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, CubicMetre(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [Volume] by [Amount],
     * yielding [MolarVolume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Amount
    ): MolarVolume =
        MolarVolume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [Length],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [Mass],
     * yielding [SpecificVolume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Mass
    ): SpecificVolume =
        SpecificVolume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [Time],
     * yielding [VolumetricFlow].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): VolumetricFlow =
        VolumetricFlow(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [MolarVolume],
     * yielding [Amount].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MolarVolume
    ): Amount =
        Amount(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [VolumetricFlow],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: VolumetricFlow
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [SpecificVolume],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SpecificVolume
    ): Mass =
        Mass(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Volume] by [Area],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Volume] by [Molarity],
     * yielding [Amount].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Molarity
    ): Amount =
        Amount(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Volume] by [ElectricChargeDensity],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricChargeDensity
    ): ElectricCharge =
        ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Volume] by [Density],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Density
    ): Mass =
        Mass(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Volume] by [EnergyDensity],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: EnergyDensity
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Volume] by [FuelEfficiency],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: FuelEfficiency
    ): Length =
        Length(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Volume] by [WaveNumber],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: WaveNumber
    ): Area =
        Area(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **cubic metre** (`m³`), used to express [Volume].
 *
 * A cubic metre quantifies three-dimensional space. It is the volume enclosed by a
 * cube whose edges are each one metre long.
 *
 * This unit is used for the capacity of rooms, tanks, containers, natural gas usage,
 * rainfall storage, and many engineering calculations involving occupied space.
 *
 * In unit form, `m³` is the product of three lengths.
 *
 * @see Volume
 * @see SquareMetre
 */
class CubicMetre private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(CUBIC_METRE_PREFIX_BASE),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, CubicMetre>(algebra, prefix, unit, ::CubicMetre) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for cubic metre: "m³". */
        internal val UNIT = Unit("m³", 1)
    }
}
