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
    }
    private val baseUnitRatio: Double

    private constructor() {
        baseUnitRatio = 1.0
    }

    private constructor(relativeRatio: Number, relativeUnit: Unit) {
        baseUnitRatio = relativeRatio.toDouble() * relativeUnit.baseUnitRatio
    }
}

val Number.teaspoons get() = Quantity(this, Unit.teaspoon)
val Number.tablespoons get() = Quantity(this, Unit.tablespoon)
val Number.ounces get() = Quantity(this, Unit.ounce)
val Number.cups get() = Quantity(this, Unit.cup)
val Number.pints get() = Quantity(this, Unit.pint)
val Number.quarts get() = Quantity(this, Unit.quart)
val Number.gallons get() = Quantity(this, Unit.gallon)