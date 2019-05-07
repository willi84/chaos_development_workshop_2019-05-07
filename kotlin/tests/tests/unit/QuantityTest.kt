/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import quantity.*
import kotlin.test.assertFailsWith

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
        assertEquals(18.inches, 0.5.yards)
        assertEquals(1.miles, (12 * 5280).inches)
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
        assertEquals(18.inches.hashCode(), 0.5.yards.hashCode())
    }

    @Test internal fun arithmetic() {
        assertEquals(0.5.quarts, +(6.tablespoons) + 13.ounces)
        assertEquals((-6).tablespoons, -(6.tablespoons))
        assertEquals((-0.5).pints, 10.tablespoons - 13.ounces)
        assertEquals(-(4.feet), 24.inches - 2.yards)
        assertEquals(8.chains, 1.furlongs - 44.yards)
    }

    @Test internal fun crossMetricType()  {
        assertNotEquals(1.inches, 1.teaspoons)
        assertNotEquals(4.ounces, 2.feet)
    }

    @Test internal fun `incompatible units`() {
        assertFailsWith(IllegalArgumentException::class) { 3.yards - 4.tablespoons}
    }
}