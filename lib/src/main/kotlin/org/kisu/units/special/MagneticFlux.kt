@file:Suppress("TooManyFunctions")

package org.kisu.units.special

import org.kisu.Magnitude
import org.kisu.prefixes.Metric
import org.kisu.prefixes.algebra.Algebra
import org.kisu.prefixes.algebra.ExponentialAlgebra
import org.kisu.units.Measure
import org.kisu.units.base.Current
import org.kisu.units.base.Length
import org.kisu.units.base.Time
import org.kisu.units.electromagnetic.MagneticMoment
import org.kisu.units.electromagnetic.MagneticReluctance
import org.kisu.units.electromagnetic.MagneticVectorPotential
import org.kisu.units.representation.Scalar
import org.kisu.units.representation.Unit

/**
 * Represents the physical quantity of **magnetic flux**, measured in [Weber].
 *
 * Magnetic flux quantifies how much magnetic field passes through a surface. It is the
 * quantity that appears naturally in electromagnetic induction: changing flux produces
 * induced voltage.
 *
 * Typical examples include the flux linked by a transformer winding, the flux through
 * a loop in a magnetic field, or the working flux inside a magnetic core.
 *
 * The canonical SI unit is the [Weber] (`Wb`), often scaled to `mWb` or `µWb`.
 */
class MagneticFlux internal constructor(magnitude: Magnitude, expression: Weber) :
    Measure<Weber, MagneticFlux>(magnitude, expression, ::MagneticFlux) {

    internal constructor(magnitude: Magnitude, prefix: Metric = Metric.BASE) :
        this(magnitude, Weber(prefix))

    // Dimension-aware arithmetic
    /**
     * Divides this [MagneticFlux] by [Current],
     * yielding [Inductance].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Current
    ): Inductance =
        Inductance(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [Length],
     * yielding [MagneticVectorPotential].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Length
    ): MagneticVectorPotential =
        MagneticVectorPotential(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [Time],
     * yielding [ElectricPotential].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Time
    ): ElectricPotential =
        ElectricPotential(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [MagneticVectorPotential],
     * yielding [Length].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MagneticVectorPotential
    ): Length =
        Length(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [Area],
     * yielding [MagneticFluxDensity].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Area
    ): MagneticFluxDensity =
        MagneticFluxDensity(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [ElectricPotential],
     * yielding [Time].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: ElectricPotential
    ): Time =
        Time(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [Inductance],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: Inductance
    ): Current =
        Current(canonical.component1() / other.canonical.component1())

    /**
     * Divides this [MagneticFlux] by [MagneticFluxDensity],
     * yielding [Area].
     *
     * Both operands are converted to their canonical units before the division result is calculated.
     */
    operator fun div(
        other: MagneticFluxDensity
    ): Area =
        Area(canonical.component1() / other.canonical.component1())

    /**
     * Multiplies this [MagneticFlux] by [Current],
     * yielding [Energy].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Current
    ): Energy =
        Energy(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [MagneticFlux] by [Length],
     * yielding [MagneticMoment].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Length
    ): MagneticMoment =
        MagneticMoment(canonical.component1() * other.canonical.component1())

    /**
     * Multiplies this [MagneticFlux] by [MagneticReluctance],
     * yielding [Current].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: MagneticReluctance
    ): Current =
        Current(canonical.component1() * other.canonical.component1())
}

/**
 * Represents the unit **weber** (`Wb`), used to express [MagneticFlux].
 *
 * A weber quantifies the total magnetic field passing through a surface or circuit. It
 * is especially useful when discussing induction, where changing magnetic flux induces
 * an electromotive force.
 *
 * This unit appears in transformers, electric machines, magnetic cores, and field
 * calculations involving loops, coils, and enclosed areas.
 *
 * In unit form, `Wb = V·s = T·m² = m²·kg·s⁻²·A⁻¹`.
 *
 * @see MagneticFlux
 * @see Tesla
 * @see Volt
 */
class Weber private constructor(
    algebra: Algebra<Metric> = ExponentialAlgebra(),
    prefix: Metric,
    unit: Unit
) : Scalar<Metric, Weber>(algebra, prefix, unit, ::Weber) {

    constructor(prefix: Metric = Metric.BASE) : this(prefix = prefix, unit = UNIT)

    companion object {
        /** The canonical symbol for weber: "Wb". */
        internal val UNIT = Unit("Wb", 1)
    }
}
