package org.kisu.units.builders

import org.kisu.Magnitude
import org.kisu.prefixes.Binary
import org.kisu.units.base.Byte
import org.kisu.units.base.Information
import org.kisu.units.information.Transmission

/**
 * Builder interface for IEC-prefixed quantities.
 *
 * This interface is implemented by all IEC prefix builders, such as [KibiBuilder], [MebiBuilder], and [GibiBuilder].
 * It provides access to the numeric magnitude and the corresponding [Binary] prefix.
 */
interface BinaryUnitBuilder {
    /** The numeric value of the quantity before applying the IEC prefix. */
    val magnitude: Magnitude

    /** The IEC prefix associated with this builder (for example, [Binary.KIBI] or [Binary.MEBI]). */
    val binary: Binary
}

/**
 * Creates an [Information] quantity in bit units using the current builder's IEC prefix.
 *
 * For example, `25.kibi.bits` produces `25 Kibit`.
 */
val BinaryUnitBuilder.bits: Information
    get() = Information(magnitude, binary)

/**
 * Creates a [Transmission] rate in bit-per-second units using the current builder's IEC prefix.
 *
 * For example, `25.kibi.bitsPerSecond` produces `25 Kibit/s`.
 */
val BinaryUnitBuilder.bitsPerSecond: Transmission
    get() = Transmission(magnitude, binary)

/**
 * Creates an [Information] quantity in byte units using the current builder's IEC prefix.
 *
 * For example, `25.kibi.bytes` produces `25 KiB`.
 */
val BinaryUnitBuilder.bytes: Information
    get() = Information(magnitude, Byte(binary))

/**
 * Creates a [Transmission] rate in byte-per-second units using the current builder's IEC prefix.
 *
 * For example, `25.kibi.bytesPerSecond` produces `25 KiB/s`.
 */
val BinaryUnitBuilder.bytesPerSecond: Transmission
    get() = Transmission(magnitude, Byte(binary))
