/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package quantity

// Understands a specific measurement
class Quantity internal constructor(amount: Number, private val unit: Unit) {
    private val amount = amount.toDouble()

    override fun equals(other: Any?) = this === other || other is Quantity && this.equals(other)

    private fun equals(other: Quantity) = this.amount == convertedAmount(other)

    private fun convertedAmount(other: Quantity) =
        this.unit.convertedAmount(other.amount, other.unit)

    override fun hashCode() = unit.hashCode(amount)
}