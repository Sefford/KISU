@file:Suppress("TooManyFunctions")

package org.kisu.units.information

import org.kisu.Magnitude
import org.kisu.prefixes.Binary
import org.kisu.prefixes.Decimal
import org.kisu.units.Measure
import org.kisu.units.base.Bit
import org.kisu.units.base.Information
import org.kisu.units.base.InformationUnit
import org.kisu.units.base.Second
import org.kisu.units.base.Time
import org.kisu.units.information.Transmission.Companion.InformationPerSecond
import org.kisu.units.representation.Quotient

/**
 * Represents a rate of **information transmission**, measured in [InformationPerSecond].
 *
 * Transmission quantifies how much digital information moves or is processed per unit time. It is useful for network
 * bandwidth, storage throughput, encoder rates, and any data-rate value expressed as information divided by time.
 *
 * The numerator preserves the existing [InformationUnit] expression family, so rates can be represented as decimal or
 * IEC-prefixed bit rates and byte rates. The canonical representation is unprefixed IEC bits per second (`bit/s`).
 */
class Transmission(
    magnitude: Magnitude,
    expression: InformationPerSecond
) : Measure<Transmission.InformationPerSecond, Transmission>(magnitude, expression, ::Transmission) {
    internal constructor(magnitude: Magnitude) :
        this(magnitude, Bit(Binary.BASE))

    internal constructor(magnitude: Magnitude, unit: InformationUnit) :
        this(magnitude, InformationPerSecond(unit))

    internal constructor(magnitude: Magnitude, prefix: Binary) :
        this(magnitude, Bit(prefix))

    internal constructor(magnitude: Magnitude, prefix: Decimal) :
        this(magnitude, Bit(prefix))

    /**
     * Returns this transmission rate expressed in bit units, preserving the current SI or IEC scale.
     */
    val bits: Transmission
        get() = convertedTo(unit.bits).optimal

    /**
     * Returns this transmission rate expressed in byte units, preserving the current SI or IEC scale.
     */
    val bytes: Transmission
        get() = convertedTo(unit.bytes).optimal

    /**
     * Returns this transmission rate expressed with SI information prefixes.
     */
    val decimal: Transmission
        get() = convertedTo(unit.decimal).optimal

    /**
     * Returns this transmission rate expressed with IEC information prefixes.
     */
    val iec: Transmission
        get() = convertedTo(unit.iec).optimal

    /**
     * Alias for [iec].
     */
    val binary: Transmission
        get() = iec

    private val unit: InformationUnit
        get() = component2().component1()

    private fun convertedTo(unit: InformationUnit): Transmission {
        val target = InformationPerSecond(unit)
        return Transmission(convert(component1(), component2(), target), target)
    }

    /**
     * Represents the unit **information per second** (`bit/s`, `B/s`, `Kibit/s`, `MB/s`, etc.).
     *
     * This unit is defined as a [Quotient] of [InformationUnit] divided by [Second].
     */
    typealias InformationPerSecond = Quotient<InformationUnit, Second>

    companion object {
        /**
         * Creates an [InformationPerSecond] expression for an information unit divided by seconds.
         *
         * @param unit Information unit used in the numerator. Defaults to unprefixed IEC bits.
         * @return An [InformationPerSecond] expression for the selected information unit per second.
         */
        @Suppress("FunctionNaming")
        internal fun InformationPerSecond(unit: InformationUnit = Bit(Binary.BASE)): InformationPerSecond =
            Quotient(unit, Second())
    }

    // Dimension-aware arithmetic
    /**
     * Multiplies this [Transmission] by [Time], yielding [Information].
     *
     * Both operands are converted to their canonical units before the multiplication result is calculated.
     */
    operator fun times(
        other: Time
    ): Information = Information(canonical.component1() * other.canonical.component1())
}
