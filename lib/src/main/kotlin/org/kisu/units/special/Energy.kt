@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Amount
import org.kisu.units.base.Current
import org.kisu.units.base.Length
import org.kisu.units.base.Mass
import org.kisu.units.base.Temperature
import org.kisu.units.base.Time
import org.kisu.units.chemistry.MolarEnergy
import org.kisu.units.mechanics.Action
import org.kisu.units.mechanics.EnergyDensity
import org.kisu.units.mechanics.RadiantExposure
import org.kisu.units.mechanics.SpecificEnergy
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.thermodynamics.HeatCapacity

/**
 * Represents the physical quantity of **energy**, measured in [Joule].
 *
 * Energy quantifies the capacity to perform work, transfer heat, or produce change. In
 * mechanics it appears as kinetic or potential energy; in thermodynamics as heat; in
 * electricity as energy delivered or stored.
 *
 * Typical examples include the energy consumed by an appliance, the work done lifting
 * a load, the heat delivered to a sample, or the stored energy in a battery.
 *
 * The canonical SI unit is the [Joule] (`J`), commonly scaled as `mJ`, `kJ`, or `MJ`.
 */
class Energy internal constructor(magnitude: Magnitude, expression: Joule) :
    Measure<Joule, Energy>(magnitude, expression, ::Energy) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Joule(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [Energy] by [Amount],
     * yielding [MolarEnergy].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Amount
    ): MolarEnergy =
        MolarEnergy(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Current],
     * yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Current
    ): MagneticFlux =
        MagneticFlux(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Length],
     * yielding [Force].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): Force =
        Force(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Mass],
     * yielding [SpecificEnergy].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Mass
    ): SpecificEnergy =
        SpecificEnergy(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Temperature],
     * yielding [HeatCapacity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Temperature
    ): HeatCapacity =
        HeatCapacity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [MolarEnergy],
     * yielding [Amount].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MolarEnergy
    ): Amount =
        Amount(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [EnergyDensity],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: EnergyDensity
    ): Volume =
        Volume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [RadiantExposure],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: RadiantExposure
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [SpecificEnergy],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: SpecificEnergy
    ): Mass =
        Mass(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Area],
     * yielding [RadiantExposure].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): RadiantExposure =
        RadiantExposure(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [ElectricCharge],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricCharge
    ): ElectricPotential =
        ElectricPotential(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [ElectricPotential],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricPotential
    ): ElectricCharge =
        ElectricCharge(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Force],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Force
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [MagneticFlux],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MagneticFlux
    ): Current =
        Current(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [Volume],
     * yielding [EnergyDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Volume
    ): EnergyDensity =
        EnergyDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Energy] by [HeatCapacity],
     * yielding [Temperature].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: HeatCapacity
    ): Temperature =
        Temperature(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Energy] by [Time],
     * yielding [Action].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): Action =
        Action(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **joule** (`J`), used to express [Energy].
 *
 * A joule quantifies energy, work, or heat. One joule is the energy transferred when
 * a force of one [Newton] acts through a distance of one metre.
 *
 * It is used for mechanical work, thermal energy, electrical energy delivered over
 * time, and many everyday quantities such as the energy content of food or the energy
 * stored in a battery cell.
 *
 * In unit form, `J = N·m = m²·kg·s⁻²`.
 *
 * @see Energy
 * @see Newton
 * @see Watt
 */
class Joule private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Joule>(algebra, prefix, unit, ::Joule) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for joule: "J". */
        internal val UNIT = Unit("J", 1)
    }
}
