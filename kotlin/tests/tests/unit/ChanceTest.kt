/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import probability.Chance

// Ensures Chance operates correctly
internal class ChanceTest {

    @Test internal fun equality() {
        assertEquals(Chance(0.75), Chance(0.75))
        assertNotEquals(Chance(0.75), Chance(0.25))
        assertNotEquals(Chance(0.75), Any())
        assertNotEquals(Chance(0.75), null)
    }

    @Test internal fun `set operations`() {
        assertTrue(Chance(0.75) in hashSetOf(Chance(0.75)))
        assertEquals(1, hashSetOf(Chance(0.75), Chance(0.75)).size)
    }

    @Test internal fun hash() {
        assertEquals(Chance(0.75).hashCode(), Chance(0.75).hashCode())
    }
}