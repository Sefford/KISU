package org.kisu.units.electromagnetic

import org.kisu.prefixes.Metric
import org.kisu.units.Measure
import org.kisu.units.base.Metre
import org.kisu.units.representation.Product
import org.kisu.units.special.Tesla
import java.math.BigDecimal

/**
 * Represents the physical quantity of **magnetic rigidity**, measured in [TeslaMetre].
 *
 * Magnetic rigidity quantifies how resistant a charged particle beam is to bending by a
 * magnetic field. Larger rigidity means a trajectory is harder to deflect.
 *
 * This quantity is widely used in accelerator physics, beam transport, and magnetic
 * spectrometry.
 *
 * The associated unit representation is [TeslaMetre] (`T·m`).
 */
class MagneticRigidity(
    magnitude: BigDecimal,
    expression: TeslaMetre
) : Measure<MagneticRigidity.TeslaMetre, MagneticRigidity>(magnitude, expression, ::MagneticRigidity) {

    internal constructor(magnitude: BigDecimal, prefix: Metric = Metric.BASE) :
        this(magnitude, TeslaMetre(prefix))

    /**
     * Represents the SI unit **tesla metre (T·m)**.
     *
     * This unit measures **magnetic rigidity**, i.e., the resistance of a charged
     * particle to deflection by a magnetic field.
     * It is defined as the [Product] of [Tesla] (magnetic flux density) and [Metre] (length).
     *
     * Example usages include:
     * - Calculating particle trajectory bending in magnetic fields
     * - Designing magnetic spectrometers and accelerator beamlines
     *
     * @see MagneticRigidity for the physical quantity represented by this unit.
     */
    typealias TeslaMetre = Product<Tesla, Metre>

    companion object {
        /**
         * Creates a measure of **tesla-metres** (T·m).
         *
         * This compound unit represents the product of:
         *  - a [Tesla] (magnetic flux density) with the specified [prefix]
         *  - multiplied by a [Metre] (length)
         *
         * It’s commonly used in electromagnetism when expressing quantities like
         * magnetic flux over a distance.
         *
         * @param prefix Metric prefix to apply to the tesla unit.
         * Defaults to [Metric.BASE] (no prefix).
         *
         * @return A [TeslaMetre] representing T·m.
         */
        @Suppress("FunctionNaming")
        internal fun TeslaMetre(prefix: Metric = Metric.BASE): TeslaMetre =
            Product(Tesla(prefix), Metre())
    }
}
