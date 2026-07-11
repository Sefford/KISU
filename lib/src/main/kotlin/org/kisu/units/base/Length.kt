@file:Suppress("TooManyFunctions")

package org.kisu.units.base

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.electromagnetic.ElectricConductivity
import org.kisu.units.electromagnetic.ElectricFieldStrength
import org.kisu.units.electromagnetic.LinearChargeDensity
import org.kisu.units.electromagnetic.MagneticMoment
import org.kisu.units.electromagnetic.MagneticPermittivity
import org.kisu.units.electromagnetic.MagneticRigidity
import org.kisu.units.electromagnetic.MagneticSusceptibility
import org.kisu.units.electromagnetic.MagneticVectorPotential
import org.kisu.units.electromagnetic.Magnetization
import org.kisu.units.electromagnetic.Permittivity
import org.kisu.units.electromagnetic.Resistivity
import org.kisu.units.kinematics.linear.Speed
import org.kisu.units.mechanics.AngularMomentum
import org.kisu.units.mechanics.FuelEfficiency
import org.kisu.units.mechanics.LinearMassDensity
import org.kisu.units.mechanics.Momentum
import org.kisu.units.mechanics.Radiance
import org.kisu.units.mechanics.RadiantIntensity
import org.kisu.units.mechanics.SpectralIntensity
import org.kisu.units.mechanics.SpectralPower
import org.kisu.units.mechanics.SpectralRadiance
import org.kisu.units.mechanics.SurfaceTension
import org.kisu.units.mechanics.WaveNumber
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit
import org.kisu.units.special.Area
import org.kisu.units.special.Capacitance
import org.kisu.units.special.Conductance
import org.kisu.units.special.ElectricCharge
import org.kisu.units.special.ElectricPotential
import org.kisu.units.special.Energy
import org.kisu.units.special.Force
import org.kisu.units.special.Inductance
import org.kisu.units.special.MagneticFlux
import org.kisu.units.special.MagneticFluxDensity
import org.kisu.units.special.Power
import org.kisu.units.special.Resistance
import org.kisu.units.special.Volume
import org.kisu.units.thermodynamics.TemperatureGradient

/**
 * Represents the physical quantity of **length**, measured in metres (m).
 *
 * Length describes the extent of objects or the distance between points in space. This class models length
 * as defined by the SI system, using the metre as the base unit and supporting metric prefixes such as millimetre (mm),
 * centimetre (cm), and kilometre (km).
 *
 * The quantity is expressed with a `magnitude` and an `expression`, enabling precise representation of both small- and
 * large-scale measurements using [Magnitude] for accuracy.
 */
class Length internal constructor(magnitude: Magnitude, expression: Metre) :
    Measure<Metre, Length>(magnitude, expression, ::Length) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Metre(prefix))

    /**
     * Returns the wave number associated with this length by inverting its canonical magnitude.
     */
    val waveNumber: WaveNumber
        get() = WaveNumber(canonical.component1().inverted)

    // Dimension-aware arithmetic
    /**
     * Divides this [Length] by [Time],
     * yielding [Speed].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): Speed =
        Speed(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Length] by [MagneticSusceptibility],
     * yielding [Inductance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MagneticSusceptibility
    ): Inductance =
        Inductance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Length] by [Speed],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Speed
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Length] by [FuelEfficiency],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: FuelEfficiency
    ): Volume =
        Volume(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Length] by [Inductance],
     * yielding [MagneticSusceptibility].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Inductance
    ): MagneticSusceptibility =
        MagneticSusceptibility(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [Length] by [Volume],
     * yielding [FuelEfficiency].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Volume
    ): FuelEfficiency =
        FuelEfficiency(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [Length] by [Length],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Length
    ): Area =
        Area(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [ElectricConductivity],
     * yielding [Conductance].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricConductivity
    ): Conductance =
        Conductance(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [ElectricFieldStrength],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: ElectricFieldStrength
    ): ElectricPotential =
        ElectricPotential(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [LinearChargeDensity],
     * yielding [ElectricCharge].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearChargeDensity
    ): ElectricCharge =
        ElectricCharge(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [MagneticPermittivity],
     * yielding [Inductance].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticPermittivity
    ): Inductance =
        Inductance(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [MagneticVectorPotential],
     * yielding [MagneticFlux].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticVectorPotential
    ): MagneticFlux =
        MagneticFlux(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [Magnetization],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Magnetization
    ): Current =
        Current(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [Permittivity],
     * yielding [Capacitance].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Permittivity
    ): Capacitance =
        Capacitance(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [LinearMassDensity],
     * yielding [Mass].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: LinearMassDensity
    ): Mass =
        Mass(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [Momentum],
     * yielding [AngularMomentum].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Momentum
    ): AngularMomentum =
        AngularMomentum(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [SpectralIntensity],
     * yielding [RadiantIntensity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpectralIntensity
    ): RadiantIntensity =
        RadiantIntensity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [SpectralPower],
     * yielding [Power].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpectralPower
    ): Power =
        Power(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [SpectralRadiance],
     * yielding [Radiance].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SpectralRadiance
    ): Radiance =
        Radiance(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [SurfaceTension],
     * yielding [Force].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: SurfaceTension
    ): Force =
        Force(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [Area],
     * yielding [Volume].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Area
    ): Volume =
        Volume(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [Force],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Force
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [MagneticFlux],
     * yielding [MagneticMoment].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticFlux
    ): MagneticMoment =
        MagneticMoment(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [MagneticFluxDensity],
     * yielding [MagneticRigidity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticFluxDensity
    ): MagneticRigidity =
        MagneticRigidity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [Resistance],
     * yielding [Resistivity].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Resistance
    ): Resistivity =
        Resistivity(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [Length] by [TemperatureGradient],
     * yielding [Temperature].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: TemperatureGradient
    ): Temperature =
        Temperature(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the SI base unit of **length**.
 *
 * The metre (m) is the standard unit for measuring distance.
 */
class Metre private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Metre>(algebra, prefix, unit, ::Metre) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical SI symbol for length: "m". */
        internal val UNIT = Unit("m", 1)
    }
}
