/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package probability

import kotlin.math.absoluteValue

// Understands the likelihood of something specific occurring
class Chance(likelihoodAsFraction: Number) {
    private val certainFraction = 1.0
    private val epsilon = 0.00000001

    private val fraction = likelihoodAsFraction.toDouble()

    override fun equals(other: Any?) = this === other || other is Chance && this.equals(other)

    private fun equals(other: Chance) = (this.fraction - other.fraction).absoluteValue < epsilon

    override fun hashCode() = fraction.hashCode()

    operator fun not() = Chance(certainFraction - fraction)

    fun and(other: Chance) = Chance(this.fraction * other.fraction)

    // Implemented with DeMorgan's Law https://en.wikipedia.org/wiki/De_Morgan%27s_laws
    fun or(other: Chance) = !(!this).and(!other)
}
