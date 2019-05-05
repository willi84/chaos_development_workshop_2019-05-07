/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

 using static OoBootCamp.Quantities.Unit;

namespace OoBootCamp.Quantities
{
    // Understands a specific metric
    public class Unit
    {
        public static readonly Unit Teaspoon = new Unit();
        public static readonly Unit Tablespoon = new Unit(3, Teaspoon);
        public static readonly Unit Ounce = new Unit(2, Tablespoon);
        public static readonly Unit Cup = new Unit(8, Ounce);
        public static readonly Unit Pint = new Unit(2, Cup);
        public static readonly Unit Quart = new Unit(2, Pint);
        public static readonly Unit Gallon = new Unit(4, Quart);

        private readonly double _baseUnitRatio;
        private Unit()
        {
            _baseUnitRatio = 1;
        }

        private Unit(double relativeRatio, Unit relativeUnit)
        {
            _baseUnitRatio = relativeRatio * relativeUnit._baseUnitRatio;
        }

        public Quantity S(double amount) => new Quantity(amount, this);

        internal double ConvertedAmount(double otherAmount, Unit other) => otherAmount * other._baseUnitRatio / this._baseUnitRatio;

        internal int HashCode(double amount) => (amount * _baseUnitRatio).GetHashCode();
    }

    namespace ExtensionMethods
    {
        public static class QuantityConstructors
        {
            public static Quantity Teaspoons(this double amount) => Teaspoon.S(amount);
            public static Quantity Teaspoons(this int amount) => Teaspoon.S(amount);
            public static Quantity Tablespoons(this double amount) => Tablespoon.S(amount);
            public static Quantity Tablespoons(this int amount) => Tablespoon.S(amount);
            public static Quantity Ounces(this double amount) => Ounce.S(amount);
            public static Quantity Ounces(this int amount) => Ounce.S(amount);
            public static Quantity Cups(this double amount) => Cup.S(amount);
            public static Quantity Cups(this int amount) => Cup.S(amount);
            public static Quantity Pints(this double amount) => Pint.S(amount);
            public static Quantity Pints(this int amount) => Pint.S(amount);
            public static Quantity Quarts(this double amount) => Quart.S(amount);
            public static Quantity Quarts(this int amount) => Quart.S(amount);
            public static Quantity Gallons(this double amount) => Gallon.S(amount);
            public static Quantity Gallons(this int amount) => Gallon.S(amount);

        }
    }

}