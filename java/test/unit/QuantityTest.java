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
        assertEquals(CUP.s(1/4.0), TABLESPOON.s(4));
        assertEquals(GALLON.s(1), TEASPOON.s(768));
        assertNotEquals(TABLESPOON.s(4), TEASPOON.s(4));
        assertEquals(INCH.es(18), YARD.s(0.5));
        assertEquals(MILE.s(1), INCH.es(12 * 5280));
    }

    @Test void setOperations() {
        assertTrue(new HashSet<>(Collections.singletonList(TABLESPOON.s(4))).contains(TABLESPOON.s(4)));
        assertTrue(new HashSet<>(Collections.singletonList(TABLESPOON.s(4))).contains(OUNCE.s(2)));
        assertEquals(1, new HashSet<>(Arrays.asList(TABLESPOON.s(4), TABLESPOON.s(4))).size());
        assertEquals(1, new HashSet<>(Arrays.asList(TABLESPOON.s(4), OUNCE.s(2))).size());
    }

    @Test void hash() {
        assertEquals(TABLESPOON.s(4).hashCode(), TABLESPOON.s(4).hashCode());
        assertEquals(TABLESPOON.s(4).hashCode(), CUP.s(1/4.0).hashCode());
        assertEquals(INCH.es(18).hashCode(), YARD.s(0.5).hashCode());
    }

    @Test void arithmetic() {
        assertEquals(QUART.s(0.5), TABLESPOON.s(6).plus(OUNCE.s(13)));
        assertEquals(TABLESPOON.s(-6), TABLESPOON.s(6).negate());
        assertEquals(PINT.s(-0.5), TABLESPOON.s(10).minus(OUNCE.s(13)));
        assertEquals(FOOT.s(-4), INCH.es(24).minus(YARD.s(2)));
    }

    @Test void crossMetricType()  {
        assertNotEquals(INCH.es(1), TEASPOON.s(1));
        assertNotEquals(OUNCE.s(4), FOOT.s(2));
    }

    @Test void mixedUnitArithmetic() {
        assertThrows(IllegalArgumentException.class, () ->
                YARD.s(3).minus(TABLESPOON.s(4)));
    }
}
