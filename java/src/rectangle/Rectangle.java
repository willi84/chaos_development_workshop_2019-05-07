/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package rectangle;

// Understands a four-sided polygon with sides at right angles
public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0.0 || height <= 0.0) throw new IllegalArgumentException("Dimensions must be > 0");
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }
}
