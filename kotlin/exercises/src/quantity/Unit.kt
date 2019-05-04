/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package quantity

// Understands a specific metric
class Unit private constructor() {
    companion object {
        val teaspoon = Unit()
        val tablespoon = Unit()
        val ounce = Unit()
        val cup = Unit()
        val pint = Unit()
        val quart = Unit()
        val gallon = Unit()
    }
}