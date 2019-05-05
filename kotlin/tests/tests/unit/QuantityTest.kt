/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import quantity.*

// Ensures RatioQuantity operates correctly
internal class QuantityTest {

    @Test internal fun `equality of like units`() {
        assertEquals(4.0.tablespoons, 4.0.tablespoons)
        assertNotEquals(4.tablespoons, 6.tablespoons)
        assertNotEquals(4.0.tablespoons, Any())
        assertNotEquals(4.0.tablespoons, null)
    }

    @Test internal fun `equality of different units`() {
        assertEquals(8.tablespoons, 0.5.cups)
        assertEquals(768.teaspoons, 1.gallons)
        assertNotEquals(4.0.tablespoons, 4.teaspoons)
    }

    @Test internal fun `set operations`() {
        assertTrue(4.0.tablespoons in hashSetOf(4.0.tablespoons))
        assertTrue(0.25.cups in hashSetOf(4.0.tablespoons))
        assertEquals(1, hashSetOf(4.0.tablespoons, 4.0.tablespoons).size)
        assertEquals(1, hashSetOf(4.0.tablespoons, 2.ounces).size)
    }

    @Test internal fun hash() {
        assertEquals(4.0.tablespoons.hashCode(), 4.0.tablespoons.hashCode())
        assertEquals(8.tablespoons.hashCode(), 0.5.cups.hashCode())
    }
}