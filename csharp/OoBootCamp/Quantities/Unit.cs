/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

using System;
using static OoBootCamp.Quantities.Unit;

namespace OoBootCamp.Quantities
{
    // Understands a specific metric
    public class Unit
    {
        internal static readonly Unit Teaspoon = new Unit();
        internal static readonly Unit Tablespoon = new Unit(3, Teaspoon);
        internal static readonly Unit Ounce = new Unit(2, Tablespoon);
        internal static readonly Unit Cup = new Unit(8, Ounce);
        internal static readonly Unit Pint = new Unit(2, Cup);
        internal static readonly Unit Quart = new Unit(2, Pint);
        internal static readonly Unit Gallon = new Unit(4, Quart);

        internal static readonly Unit Inch = new Unit();
        internal static readonly Unit Foot = new Unit(12, Inch);
        internal static readonly Unit Yard = new Unit(3, Foot);
        internal static readonly Unit Furlong = new Unit(220, Yard);
        internal static readonly Unit Mile = new Unit(8, Furlong);

        private readonly Unit _baseUnit;
        private readonly double _baseUnitRatio;
        private Unit()
        {
            _baseUnit = this;
            _baseUnitRatio = 1;
        }

        private Unit(double relativeRatio, Unit relativeUnit)
        {
            _baseUnit = relativeUnit._baseUnit;
            _baseUnitRatio = relativeRatio * relativeUnit._baseUnitRatio;
        }

        public Quantity S(double amount) => new Quantity(amount, this);

        internal double ConvertedAmount(double otherAmount, Unit other)
        {
            if (!(this.IsCompatible(other))) throw new InvalidOperationException("Incompatible Unit types");
            return otherAmount * other._baseUnitRatio / this._baseUnitRatio;
        }

        internal int HashCode(double amount) => (amount * _baseUnitRatio).GetHashCode();

        internal bool IsCompatible(Unit other) => this._baseUnit == other._baseUnit;
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

            public static Quantity Inches(this double amount) => Inch.S(amount);
            public static Quantity Inches(this int amount) => Inch.S(amount);
            public static Quantity Feet(this double amount) => Foot.S(amount);
            public static Quantity Feet(this int amount) => Foot.S(amount);
            public static Quantity Yards(this double amount) => Yard.S(amount);
            public static Quantity Yards(this int amount) => Yard.S(amount);
            public static Quantity Furlongs(this double amount) => Furlong.S(amount);
            public static Quantity Furlongs(this int amount) => Furlong.S(amount);
            public static Quantity Miles(this double amount) => Mile.S(amount);
            public static Quantity Miles(this int amount) => Mile.S(amount);

        }
    }

}