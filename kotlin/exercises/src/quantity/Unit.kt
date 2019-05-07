/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package quantity

// Understands a specific metric
class Unit {
    companion object {
        internal val teaspoon = Unit()
        internal val tablespoon = Unit(3, teaspoon)
        internal val ounce = Unit(2, tablespoon)
        internal val cup = Unit(8, ounce)
        internal val pint = Unit(2, cup)
        internal val quart = Unit(2, pint)
        internal val gallon = Unit(4, quart)

        internal val inch = Unit()
        internal val foot = Unit(12, inch)
        internal val yard = Unit(3, foot)
        internal val chain = Unit(22, yard)
        internal val furlong = Unit(10, chain)
        internal val mile = Unit(8, furlong)
    }

    private val baseUnit: Unit
    private val baseUnitRatio: Double

    private constructor() {
        baseUnit = this
        baseUnitRatio = 1.0
    }

    private constructor(relativeRatio: Number, relativeUnit: Unit) {
        baseUnit = relativeUnit.baseUnit
        baseUnitRatio = relativeRatio.toDouble() * relativeUnit.baseUnitRatio
    }

    internal fun isCompatible(other: Unit) = this.baseUnit == other.baseUnit

    internal fun convertedAmount(otherAmount: Double, other: Unit): Double {
        require (this.isCompatible(other)) { "Incompatible Unit types" }
        return otherAmount * other.baseUnitRatio / this.baseUnitRatio
    }

    internal fun hashCode(amount: Double) = (amount * baseUnitRatio).hashCode()

}

val Number.teaspoons get() = Quantity(this, Unit.teaspoon)
val Number.tablespoons get() = Quantity(this, Unit.tablespoon)
val Number.ounces get() = Quantity(this, Unit.ounce)
val Number.cups get() = Quantity(this, Unit.cup)
val Number.pints get() = Quantity(this, Unit.pint)
val Number.quarts get() = Quantity(this, Unit.quart)
val Number.gallons get() = Quantity(this, Unit.gallon)

val Number.inch get(): Quantity = Quantity(this, Unit.inch)
val Number.inches get() = this.inch
val Number.foot get(): Quantity = Quantity(this, Unit.foot)
val Number.feet get() = this.foot
val Number.yards get(): Quantity = Quantity(this, Unit.yard)
val Number.chains get(): Quantity = Quantity(this, Unit.chain)
val Number.furlongs get(): Quantity = Quantity(this, Unit.furlong)
val Number.miles get(): Quantity = Quantity(this, Unit.mile)