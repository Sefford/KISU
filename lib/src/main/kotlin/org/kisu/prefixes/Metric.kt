package org.kisu.prefixes

import org.kisu.prefixes.primitives.ExponentialEnumSystem
import org.kisu.prefixes.primitives.Representation
import org.kisu.prefixes.primitives.Symbol
import org.kisu.prefixes.primitives.System

/**
 * The `Metric` prefix system defines unit prefixes based on powers of 10 (10ⁿ), standardized by the International
 * System of Units (SI).
 *
 * These prefixes are used to express decimal multiples and submultiples of base units such as meters, grams, liters,
 * and more.
 *
 * They are essential for representing very large or very small quantities in science, engineering, and daily life.
 *
 * ### Use in Science, Engineering, and Everyday Measurements
 * Metric prefixes are foundational in the metric system and appear in countless contexts:
 *
 * - **Distance**: kilometers (km), centimeters (cm), nanometers (nm)
 * - **Mass**: milligrams (mg), kilograms (kg), megagrams (Mg)
 * - **Volume**: milliliters (mL), liters (L), megaliters (ML)
 * - **Electricity**: microamperes (μA), kilovolts (kV)
 *
 * The system provides a uniform, scalable, and intuitive way to denote values across magnitudes ranging from `10⁻³⁰`
 * (quecto) to `10³⁰` (quetta).
 *
 * ### Relationship to Other Systems
 * Unlike the **Decimal** prefix system used in some computing contexts, and the **Binary** system used in memory
 * representation, the **Metric** system is strictly decimal and applies across both scientific and non-scientific
 * domains.
 *
 * It should not be confused with the use of SI prefixes like "kilo" and "mega" to denote binary magnitudes (as in
 * `1 kilobyte = 1024 bytes`), which has led to confusion.
 *
 * For clarity, binary-specific prefixes like `kibi` (2¹⁰), `mebi` (2²⁰), etc., are standardized separately.
 */
@Suppress("MagicNumber", "DELEGATED_MEMBER_HIDES_SUPERTYPE_OVERRIDE")
enum class Metric(
    override val power: Int,
    symbol: String,
) : ExponentialPrefix<Metric>,
    System<Metric> by ExponentialEnumSystem(Metric::class),
    Symbol by Representation(symbol) {

    /** 10⁻³⁰ = 0.000000000000000000000000000001 */
    QUECTO(-30, "q"),

    /** 10⁻²⁷ = 0.000000000000000000000000001 */
    RONTO(-27, "r"),

    /** 10⁻²⁴ = 0.000000000000000000000001 */
    YOCTO(-24, "y"),

    /** 10⁻²¹ = 0.000000000000000000001 */
    ZEPTO(-21, "z"),

    /** 10⁻¹⁸ = 0.000000000000000001 */
    ATTO(-18, "a"),

    /** 10⁻¹⁵ = 0.000000000000001 */
    FEMTO(-15, "f"),

    /** 10⁻¹² = 0.000000000001 */
    PICO(-12, "p"),

    /** 10⁻⁹ = 0.000000001 */
    NANO(-9, "n"),

    /** 10⁻⁶ = 0.000001 */
    MICRO(-6, "μ"),

    /** 10⁻³ = 0.001 */
    MILLI(-3, "m"),

    /** 10⁻² = 0.01 */
    CENTI(-2, "c"),

    /** 10⁻¹ = 0.1 */
    DECI(-1, "d"),

    /** 10⁰ = 1 */
    BASE(0, ""),

    /** 10¹ = 10 */
    DECA(1, "da"),

    /** 10² = 100 */
    HECTO(2, "h"),

    /** 10³ = 1,000 */
    KILO(3, "k"),

    /** 10⁶ = 1,000,000 */
    MEGA(6, "M"),

    /** 10⁹ = 1,000,000,000 */
    GIGA(9, "G"),

    /** 10¹² = 1,000,000,000,000 */
    TERA(12, "T"),

    /** 10¹⁵ = 1,000,000,000,000,000 */
    PETA(15, "P"),

    /** 10¹⁸ = 1,000,000,000,000,000,000 */
    EXA(18, "E"),

    /** 10²¹ = 1,000,000,000,000,000,000,000 */
    ZETTA(21, "Z"),

    /** 10²⁴ = 1,000,000,000,000,000,000,000,000 */
    YOTTA(24, "Y"),

    /** 10²⁷ = 1,000,000,000,000,000,000,000,000,000 */
    RONNA(27, "R"),

    /** 10³⁰ = 1,000,000,000,000,000,000,000,000,000,000 */
    QUETTA(30, "Q");

    /**
     * Converts this metric prefix to the corresponding decimal information prefix.
     *
     * Decimal information units use the unprefixed base value plus the thousand-step SI prefixes from kilo through
     * quetta. Smaller metric prefixes, deca, and hecto do not have decimal information counterparts.
     *
     * @throws IllegalArgumentException if this metric prefix cannot represent a decimal information prefix.
     */
    fun asDecimal(): Decimal = when (this) {
        BASE -> Decimal.BASE
        KILO -> Decimal.KILO
        MEGA -> Decimal.MEGA
        GIGA -> Decimal.GIGA
        TERA -> Decimal.TERA
        PETA -> Decimal.PETA
        EXA -> Decimal.EXA
        ZETTA -> Decimal.ZETTA
        YOTTA -> Decimal.YOTTA
        RONNA -> Decimal.RONNA
        QUETTA -> Decimal.QUETTA
        else -> throw IllegalArgumentException(
            "Metric prefix $this cannot be used with decimal information units. Use BASE or prefixes from KILO " +
                "through QUETTA.",
        )
    }

    /**
     * Converts this SI prefix to the equivalent [HumanTime] unit.
     *
     * Human time has direct equivalents for the standard thousand-step subsecond units and the unprefixed second.
     * Other SI prefixes remain valid for seconds but do not have a named human-time counterpart.
     *
     * @throws IllegalArgumentException if this prefix has no human-time equivalent.
     */
    fun asHumanTime(): HumanTime = when (this) {
        QUECTO -> HumanTime.QUECTOSECOND
        RONTO -> HumanTime.RONTOSECOND
        YOCTO -> HumanTime.YOCTOSECOND
        ZEPTO -> HumanTime.ZEPTOSECOND
        ATTO -> HumanTime.ATTOSECOND
        FEMTO -> HumanTime.FEMTOSECOND
        PICO -> HumanTime.PICOSECOND
        NANO -> HumanTime.NANOSECOND
        MICRO -> HumanTime.MICROSECOND
        MILLI -> HumanTime.MILLISECOND
        BASE -> HumanTime.SECOND
        else -> throw IllegalArgumentException(
            "Metric prefix $this has no human-time equivalent. Use BASE or a thousand-step prefix from QUECTO " +
                "through MILLI.",
        )
    }
}
