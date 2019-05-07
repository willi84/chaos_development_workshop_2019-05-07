/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package quantity;

// Understands a specific measurement
public class Quantity {

    private final double amount;
    private final Unit unit;

    Quantity(double amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        return this == other || other instanceof Quantity && this.equals((Quantity)other);
    }

    private boolean equals(Quantity other) {
        return this.isCompatible(other) && this.amount == convertedAmount(other);
    }

    private boolean isCompatible(Quantity other) {
        return this.unit.isCompatible(other.unit);
    }

    private double convertedAmount(Quantity other) {
        return this.unit.convertedAmount(other.amount, other.unit);
    }

    @Override
    public int hashCode() {
        return unit.hashCode(amount);
    }

    public Quantity negate() {
        return new Quantity(-amount, unit);
    }

    public Quantity plus(Quantity other) {
        return new Quantity(this.amount + convertedAmount(other), this.unit);
    }

    public Quantity minus(Quantity other) {
        return this.plus(other.negate());
    }
}
