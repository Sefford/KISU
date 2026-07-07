package org.kisu.prefixes

import org.kisu.Magnitude
import org.kisu.prefixes.primitives.LinearEnumSystem
import org.kisu.prefixes.primitives.Representation
import org.kisu.prefixes.primitives.Symbol
import org.kisu.prefixes.primitives.System
import java.math.BigInteger

/**
 * Human-friendly time prefixes expressed as fixed factors of one second.
 *
 * Unlike [Metric], these values are not exponents. They are linear multipliers: [MINUTE] is 60 seconds, [HOUR] is
 * 3,600 seconds, and so on. SI time quantities should continue to use metric prefixes with seconds; this prefix
 * family is for readable elapsed durations.
 *
 * Subsecond values use explicit second-unit names such as [MILLISECOND], [NANOSECOND], and [QUECTOSECOND].
 *
 * Calendar-like values use explicit fixed-duration names: [MONTH] is always 30 days, [YEAR] is
 * always 365 days, and decade, century, and millennium are fixed multiples of that 365-day year. They are elapsed
 * durations, not calendar periods.
 */
@Suppress("MagicNumber", "DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
enum class Time(
    override val factor: Magnitude,
    symbol: String,
) : LinearPrefix<Time>,
    System<Time> by LinearEnumSystem(Time::class),
    Symbol by Representation(symbol) {
    /** 10^-30 seconds */
    QUECTOSECOND(Magnitude(BigInteger.ONE, 30), "qs"),

    /** 10^-27 seconds */
    RONTOSECOND(Magnitude(BigInteger.ONE, 27), "rs"),

    /** 10^-24 seconds */
    YOCTOSECOND(Magnitude(BigInteger.ONE, 24), "ys"),

    /** 10^-21 seconds */
    ZEPTOSECOND(Magnitude(BigInteger.ONE, 21), "zs"),

    /** 10^-18 seconds */
    ATTOSECOND(Magnitude(BigInteger.ONE, 18), "as"),

    /** 10^-15 seconds */
    FEMTOSECOND(Magnitude(BigInteger.ONE, 15), "fs"),

    /** 10^-12 seconds */
    PICOSECOND(Magnitude(BigInteger.ONE, 12), "ps"),

    /** 10^-9 seconds */
    NANOSECOND(Magnitude(BigInteger.ONE, 9), "ns"),

    /** 10^-6 seconds */
    MICROSECOND(Magnitude(BigInteger.ONE, 6), "μs"),

    /** 10^-3 seconds */
    MILLISECOND(Magnitude(BigInteger.ONE, 3), "ms"),

    /** 1 second */
    SECOND(Magnitude.valueOf(1), "s"),

    /** 60 seconds */
    MINUTE(Magnitude.valueOf(60), "min"),

    /** 3,600 seconds */
    HOUR(Magnitude.valueOf(3_600), "h"),

    /** 86,400 seconds */
    DAY(Magnitude.valueOf(86_400), "day"),

    /** 604,800 seconds */
    WEEK(Magnitude.valueOf(604_800), "wk"),

    /** Fixed 30-day month = 2,592,000 seconds */
    MONTH(Magnitude.valueOf(2_592_000), "month"),

    /** Fixed 365-day year = 31,536,000 seconds */
    YEAR(Magnitude.valueOf(31_536_000), "year"),

    /** Fixed 10-year decade using [YEAR] = 315,360,000 seconds */
    DECADE(Magnitude.valueOf(315_360_000), "decade"),

    /** Fixed 100-year century using [YEAR] = 3,153,600,000 seconds */
    CENTURY(Magnitude.valueOf(3_153_600_000), "century"),

    /** Fixed 1,000-year millennium using [YEAR] = 31,536,000,000 seconds */
    MILLENNIUM(Magnitude.valueOf(31_536_000_000), "millenium"),
}
