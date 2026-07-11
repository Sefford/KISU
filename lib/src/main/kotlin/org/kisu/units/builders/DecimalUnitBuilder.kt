package org.kisu.units.builders

import org.kisu.prefixes.Metric
import org.kisu.units.base.Bit
import org.kisu.units.base.Byte
import org.kisu.units.base.Information
import org.kisu.units.information.Transmission

/**
 * Builder marker for SI-prefixed information quantities.
 *
 * Only metric builders with decimal information equivalents implement this interface. The [bits] and [bytes]
 * extensions are intentionally scoped here so prefixes without a [Metric.asDecimal] mapping cannot build decimal
 * information units.
 */
interface DecimalUnitBuilder : MetricUnitBuilder

/**
 * Creates an [Information] quantity in bit units using the current builder's SI information prefix.
 *
 * For example, `25.kilo.bits` produces `25 kbit`.
 */
val DecimalUnitBuilder.bits: Information
    get() = Information(magnitude, Bit(metric.asDecimal()))

/**
 * Creates a [Transmission] rate in bit-per-second units using the current builder's SI information prefix.
 *
 * For example, `25.kilo.bitsPerSecond` produces `25 kbit/s`.
 */
val DecimalUnitBuilder.bitsPerSecond: Transmission
    get() = Transmission(magnitude, Bit(metric.asDecimal()))

/**
 * Creates an [Information] quantity in byte units using the current builder's SI information prefix.
 *
 * For example, `25.kilo.bytes` produces `25 kB`.
 */
val DecimalUnitBuilder.bytes: Information
    get() = Information(magnitude, Byte(metric.asDecimal()))

/**
 * Creates a [Transmission] rate in byte-per-second units using the current builder's SI information prefix.
 *
 * For example, `25.kilo.bytesPerSecond` produces `25 kB/s`.
 */
val DecimalUnitBuilder.bytesPerSecond: Transmission
    get() = Transmission(magnitude, Byte(metric.asDecimal()))
