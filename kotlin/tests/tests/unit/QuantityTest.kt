/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import quantity.Unit
import quantity.Quantity

// Ensures RatioQuantity operates correctly
internal class QuantityTest {

    @Test internal fun `equality of like units`() {
        assertEquals(Quantity(4.0, Unit.tablespoon), Quantity(4.0, Unit.tablespoon))
        assertNotEquals(Quantity(4, Unit.tablespoon), Quantity(6, Unit.tablespoon))
        assertNotEquals(Quantity(4.0, Unit.tablespoon), Any())
        assertNotEquals(Quantity(4.0, Unit.tablespoon), null)
    }

    @Test internal fun `equality of different units`() {
        assertNotEquals(Quantity(4.0, Unit.tablespoon), Quantity(4, Unit.teaspoon))
    }

    @Test internal fun `set operations`() {
        assertTrue(Quantity(4.0, Unit.tablespoon) in hashSetOf(Quantity(4.0, Unit.tablespoon)))
        assertEquals(1, hashSetOf(Quantity(4.0, Unit.tablespoon), Quantity(4.0, Unit.tablespoon)).size)
    }

    @Test internal fun hash() {
        assertEquals(Quantity(4.0, Unit.tablespoon).hashCode(), Quantity(4.0, Unit.tablespoon).hashCode())
    }
}