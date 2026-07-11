@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Current
import org.kisu.units.base.Length
import org.kisu.units.base.LuminousIntensity
import org.kisu.units.base.Mass
import org.kisu.units.base.Time
import org.kisu.units.electromagnetic.ElectricCurrentDensity
import org.kisu.units.electromagnetic.ElectricDisplacementField
import org.kisu.units.electromagnetic.MagneticDipoleMoment
import org.kisu.units.mechanics.AreaDensity
import org.kisu.units.mechanics.Compressibility
import org.kisu.units.mechanics.HeatFluxDensity
import org.kisu.units.mechanics.KinematicViscosity
import org.kisu.units.mechanics.MomentOfInertia
import org.kisu.units.mechanics.Radiance
import org.kisu.units.mechanics.RadiantExposure
import org.kisu.units.mechanics.RadiantIntensity
import org.kisu.units.mechanics.SpectralIrradiance
import org.kisu.units.mechanics.SpectralPower
import org.kisu.units.mechanics.WaveNumber
import org.kisu.units.photometric.Luminance
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

private const val SQUARE_METRE_SCALE_BASE = 100

/**
 * Represents the physical quantity of **area**, measured in [SquareMetre].
 *
 * Area quantifies the extent of a surface. It answers how much two-dimensional space a
 * region occupies, regardless of whether that surface is a floor plan, a field, a
 * sheet of material, or a cross section in an engineering model.
 *
 * Typical examples include the surface of a room, the footprint of a building, the
 * cross-sectional area of a pipe, or the exposed face of a solar panel.
 *
 * The canonical SI unit is the [SquareMetre] (`m²`), with smaller or larger metric
 * forms such as `cm²` or `km²` used when convenient.
 */
class Area internal constructor(magnitude: Magnitude, expression: SquareMetre) :
    Measure<SquareMetre, Area>(magnitude, expression, ::Area) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, SquareMetre(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [Area] by [Length],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Area] by [Time],
     * yielding [KinematicViscosity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): KinematicViscosity =
        KinematicViscosity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Area] by [Compressibility],
     * yielding [Force].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Compressibility
    ): Force =
        Force(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Area] by [KinematicViscosity],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: KinematicViscosity
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Area] by [WaveNumber],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: WaveNumber
    ): Volume =
        Volume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Area] by [Force],
     * yielding [Compressibility].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Force
    ): Compressibility =
        Compressibility(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Area] by [Volume],
     * yielding [WaveNumber].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Volume
    ): WaveNumber =
        WaveNumber(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Area] by [Current],
     * yielding [MagneticDipoleMoment].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Current
    ): MagneticDipoleMoment =
        MagneticDipoleMoment(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [Length],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Length
    ): Volume =
        Volume(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [Mass],
     * yielding [MomentOfInertia].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Mass
    ): MomentOfInertia =
        MomentOfInertia(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [ElectricCurrentDensity],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricCurrentDensity
    ): Current =
        Current(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [ElectricDisplacementField],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricDisplacementField
    ): ElectricCharge =
        ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [AreaDensity],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: AreaDensity
    ): Mass =
        Mass(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [HeatFluxDensity],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: HeatFluxDensity
    ): Power =
        Power(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [Radiance],
     * yielding [RadiantIntensity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Radiance
    ): RadiantIntensity =
        RadiantIntensity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [RadiantExposure],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: RadiantExposure
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [SpectralIrradiance],
     * yielding [SpectralPower].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpectralIrradiance
    ): SpectralPower =
        SpectralPower(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [Luminance],
     * yielding [LuminousIntensity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Luminance
    ): LuminousIntensity =
        LuminousIntensity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [Illuminance],
     * yielding [LuminousFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Illuminance
    ): LuminousFlux =
        LuminousFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [MagneticFluxDensity],
     * yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticFluxDensity
    ): MagneticFlux =
        MagneticFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Area] by [Pressure],
     * yielding [Force].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Pressure
    ): Force =
        Force(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **square metre** (`m²`), used to express [Area].
 *
 * A square metre quantifies the extent of a two-dimensional surface. It is the area
 * enclosed by a square whose sides are each one metre long.
 *
 * This unit is used for the floor area of a room, the footprint of a building, the
 * size of a solar panel, or the surface of a wall to be painted.
 *
 * In unit form, `m²` is the product of two lengths.
 *
 * @see Area
 * @see CubicMetre
 */
class SquareMetre private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(SQUARE_METRE_SCALE_BASE),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, SquareMetre>(algebra, prefix, unit, ::SquareMetre) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for square metre: "m²". */
        internal val UNIT = Unit("m²", 1)
    }
}
