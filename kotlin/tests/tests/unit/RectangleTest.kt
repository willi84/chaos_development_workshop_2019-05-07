/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import rectangle.Rectangle
import java.lang.IllegalArgumentException
import kotlin.test.assertFailsWith

// Ensures Rectangle works correctly
internal class RectangleTest {

    @Test internal fun area() {
        assertEquals(24.0, Rectangle(4.0, 6.0).area())
        assertEquals(24.0, Rectangle(4, 6).area())
    }

    @Test internal fun perimeter() {
        assertEquals(20.0, Rectangle(4, 6.0).perimeter)
    }

    @Test internal fun `valid dimensions`() {
        assertFailsWith(IllegalArgumentException::class) { Rectangle(0, 6.0) }
        assertFailsWith(IllegalArgumentException::class) { Rectangle(4.0, 0.0) }
    }
}