/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package rectangle

// Understands polygon with four-sides at right angles
class Rectangle(length: Number, width: Number) {
    private val length = length.toDouble()
    private val width = width.toDouble()

    init {
        require (length.toDouble() > 0.0 && width.toDouble() > 0.0) {
            "Each dimension must be greater than zero"
        }
    }

    fun area() = length * width

    val perimeter get() = 2 * (length + width)
}