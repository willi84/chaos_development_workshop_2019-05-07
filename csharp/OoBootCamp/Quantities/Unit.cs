/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

namespace OoBootCamp.Quantities
{
    // Understands a specific metric
    public class Unit
    {
        public static readonly Unit Teaspoon = new Unit();
        public static readonly Unit Tablespoon = new Unit();
        public static readonly Unit Ounce = new Unit();
        public static readonly Unit Cup = new Unit();
        public static readonly Unit Pint = new Unit();
        public static readonly Unit Quart = new Unit();
        public static readonly Unit Gallon = new Unit();

        private Unit() { }
    }
}