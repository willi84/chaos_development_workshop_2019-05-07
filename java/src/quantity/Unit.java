/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package quantity;

// Understands a specific metric
public class Unit {
    public static final Unit TEASPOON = new Unit();
    public static final Unit TABLESPOON = new Unit(3, TEASPOON);
    public static final Unit OUNCE = new Unit(2, TABLESPOON);
    public static final Unit CUP = new Unit(8, OUNCE);
    public static final Unit PINT = new Unit(2, CUP);
    public static final Unit QUART = new Unit(2, PINT);
    public static final Unit GALLON = new Unit(4, QUART);

    private final double baseUnitRatio;

    private Unit() {
        baseUnitRatio = 1.0;
    }

    private Unit(double relativeRatio, Unit relativeUnit) {
        baseUnitRatio = relativeRatio * relativeUnit.baseUnitRatio;
    }

    public Quantity s(double amount) {
        return new Quantity(amount, this);
    }

    double convertedAmount(double otherAmount, Unit other) {
        return otherAmount * other.baseUnitRatio / this.baseUnitRatio;
    }

    int hashCode(double amount) {
        return Double.hashCode(amount * baseUnitRatio);
    }
}
