/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package unit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static quantity.Unit.*;

// Ensures RatioQuantity works correctly
class QuantityTest {

    @Test void equalityOfLikeUnits() {
        assertEquals(TABLESPOON.s(4), TABLESPOON.s(4));
        assertNotEquals(TABLESPOON.s(4), TABLESPOON.s(6));
        assertNotEquals(TABLESPOON.s(4), new Object());
        assertNotEquals(TABLESPOON.s(4), null);
    }

    @Test void equalityOfDifferentUnits() {
        assertNotEquals(TABLESPOON.s(4), TEASPOON.s(4));
    }

    @Test void setOperations() {
        assertTrue(new HashSet<>(Collections.singletonList(TABLESPOON.s(4))).contains(TABLESPOON.s(4)));
        assertEquals(1, new HashSet<>(Arrays.asList(TABLESPOON.s(4), TABLESPOON.s(4))).size());
    }

    @Test void hash() {
        assertEquals(TABLESPOON.s(4).hashCode(), TABLESPOON.s(4).hashCode());
    }
}
