/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package unit;

import org.junit.jupiter.api.Test;
import probability.Chance;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// Ensures Chance operates correctly
class ChanceTest {

    @Test void equality() {
        assertEquals(new Chance(0.75), new Chance(0.75));
        assertNotEquals(new Chance(0.75), new Chance(0.25));
        assertNotEquals(new Chance(0.75), new Object());
        assertNotEquals(new Chance(0.75), null);
    }

    @Test void setOperations() {
        assertTrue(new HashSet<>(Collections.singletonList(new Chance(0.75))).contains(new Chance(0.75)));
        assertEquals(1, new HashSet<>(Arrays.asList(new Chance(0.75), new Chance(0.75))).size());
    }

    @Test void hash() {
        assertEquals(new Chance(0.75).hashCode(), new Chance(0.75).hashCode());
    }
}
