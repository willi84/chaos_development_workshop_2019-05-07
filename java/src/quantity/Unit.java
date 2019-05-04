/*
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

package quantity;

// Understands a specific metric
public class Unit {
    public static final Unit TEASPOON = new Unit();
    public static final Unit TABLESPOON = new Unit();
    public static final Unit OUNCE = new Unit();
    public static final Unit CUP = new Unit();
    public static final Unit PINT = new Unit();
    public static final Unit QUART = new Unit();
    public static final Unit GALLON = new Unit();

    private Unit() {}
}
