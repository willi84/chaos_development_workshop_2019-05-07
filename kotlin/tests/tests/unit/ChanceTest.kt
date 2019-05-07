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
    companion object {
        private val impossible = Chance(0)
        private val unlikely = Chance(0.25)
        private val equallyLikely = Chance(0.5)
        private val likely = Chance(0.75)
        private val certain = Chance(1)
    }

    @Test internal fun equality() {
        assertEquals(likely, Chance(0.75))
        assertNotEquals(likely, unlikely)
        assertNotEquals(likely, Any())
        assertNotEquals(likely, null)
    }

    @Test internal fun `set operations`() {
        assertTrue(Chance(0.75) in hashSetOf(likely))
        assertEquals(1, hashSetOf(likely, Chance(0.75)).size)
    }

    @Test internal fun hash() {
        assertEquals(likely.hashCode(), Chance(0.75).hashCode())
    }

    @Test internal fun not() {
        assertEquals(unlikely, likely.not())
        assertEquals(unlikely, !likely)
        assertEquals(likely, !!likely)
        assertEquals(certain, !impossible)
        assertEquals(Chance(0.3), !!Chance(0.3))
    }

    @Test internal fun and() {
        assertEquals(unlikely, equallyLikely.and(equallyLikely))
        assertEquals(Chance(0.1875), likely.and(unlikely))
        assertEquals(likely.and(unlikely), unlikely.and(likely))
        assertEquals(impossible, likely.and(impossible))
        assertEquals(likely, certain.and(likely))
    }

    @Test internal fun or() {
        assertEquals(likely, equallyLikely.or(equallyLikely))
        assertEquals(Chance(0.8125), likely.or(unlikely))
        assertEquals(likely.or(unlikely), unlikely.or(likely))
        assertEquals(likely, likely.or(impossible))
        assertEquals(certain, certain.or(likely))
    }
}