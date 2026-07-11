package org.kisu.prefixes

import org.kisu.Magnitude
import org.kisu.prefixes.primitives.LinearEnumSystem
import org.kisu.prefixes.primitives.Representation
import org.kisu.prefixes.primitives.Symbol
import org.kisu.prefixes.primitives.System
import org.kisu.units.base.Second
import java.math.BigInteger

/**
 * Human-readable elapsed-time units expressed as fixed factors of one second.
 *
 * Unlike [Metric], these values are complete time-unit names rather than SI prefixes. [MINUTE] is exactly 60 seconds,
 * [HOUR] is exactly 3,600 seconds, and so on. Use [Metric] with [Second] for SI expressions such as milliseconds
 * or kiloseconds.
 *
 * Calendar-like values are deterministic elapsed durations: [MONTH] is always 30 days, [YEAR] is always 365 days,
 * and decade, century, and millennium are fixed multiples of that year. They are not calendar periods.
 */
@Suppress("MagicNumber", "DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
enum class HumanTime(
    override val factor: Magnitude,
    symbol: String,
) : LinearPrefix<HumanTime>,
    System<HumanTime> by LinearEnumSystem(HumanTime::class),
    Symbol by Representation(symbol) {
    /** 10^-30 seconds. */
    QUECTOSECOND(Magnitude(BigInteger.ONE, 30), "qs"),

    /** 10^-27 seconds. */
    RONTOSECOND(Magnitude(BigInteger.ONE, 27), "rs"),

    /** 10^-24 seconds. */
    YOCTOSECOND(Magnitude(BigInteger.ONE, 24), "ys"),

    /** 10^-21 seconds. */
    ZEPTOSECOND(Magnitude(BigInteger.ONE, 21), "zs"),

    /** 10^-18 seconds. */
    ATTOSECOND(Magnitude(BigInteger.ONE, 18), "as"),

    /** 10^-15 seconds. */
    FEMTOSECOND(Magnitude(BigInteger.ONE, 15), "fs"),

    /** 10^-12 seconds. */
    PICOSECOND(Magnitude(BigInteger.ONE, 12), "ps"),

    /** 10^-9 seconds. */
    NANOSECOND(Magnitude(BigInteger.ONE, 9), "ns"),

    /** 10^-6 seconds. */
    MICROSECOND(Magnitude(BigInteger.ONE, 6), "μs"),

    /** 10^-3 seconds. */
    MILLISECOND(Magnitude(BigInteger.ONE, 3), "ms"),

    /** One second. */
    SECOND(Magnitude.ONE, "s"),

    /** 60 seconds. */
    MINUTE(Magnitude(60), "min"),

    /** 3,600 seconds. */
    HOUR(Magnitude(3_600), "h"),

    /** 86,400 seconds. */
    DAY(Magnitude(86_400), "day"),

    /** 604,800 seconds. */
    WEEK(Magnitude(604_800), "wk"),

    /** Fixed 30-day month: 2,592,000 seconds. */
    MONTH(Magnitude(2_592_000), "month"),

    /** Fixed 365-day year: 31,536,000 seconds. */
    YEAR(Magnitude(31_536_000), "year"),

    /** Fixed 10-year decade: 315,360,000 seconds. */
    DECADE(Magnitude(315_360_000), "decade"),

    /** Fixed 100-year century: 3,153,600,000 seconds. */
    CENTURY(Magnitude(3_153_600_000), "century"),

    /** Fixed 1,000-year millennium: 31,536,000,000 seconds. */
    MILLENNIUM(Magnitude(31_536_000_000), "millennium"),
}
