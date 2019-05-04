/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package unit;

import org.junit.jupiter.api.Test;
import quantity.Quantity;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static quantity.Unit.*;

// Ensures RatioQuantity works correctly
class QuantityTest {

    @Test void equalityOfLikeUnits() {
        assertEquals(new Quantity(4, TABLESPOON), new Quantity(4, TABLESPOON));
        assertNotEquals(new Quantity(4, TABLESPOON), new Quantity(6, TABLESPOON));
        assertNotEquals(new Quantity(4, TABLESPOON), new Object());
        assertNotEquals(new Quantity(4, TABLESPOON), null);
    }

    @Test void equalityOfDifferentUnits() {
        assertNotEquals(new Quantity(4, TABLESPOON), new Quantity(4, TEASPOON));
    }

    @Test void setOperations() {
        assertTrue(new HashSet<>(Collections.singletonList(new Quantity(4, TABLESPOON))).contains(new Quantity(4, TABLESPOON)));
        assertEquals(1, new HashSet<>(Arrays.asList(new Quantity(4, TABLESPOON), new Quantity(4, TABLESPOON))).size());
    }

    @Test void hash() {
        assertEquals(new Quantity(4, TABLESPOON).hashCode(), new Quantity(4, TABLESPOON).hashCode());
    }
}
