/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */

using System;
using OoBootCamp;

namespace OoBootCamp
{
    // Understands the likelihood of something occurring
    public class Chance
    {
        private const double CertainFraction = 1.0;
        private const double Epsilon = 1e-6;

        private readonly double _fraction;
        
        internal Chance(double likelihoodAsFraction)
        {
            _fraction = likelihoodAsFraction;
        }

        public override bool Equals(object other)
        {
            if (ReferenceEquals(this, other)) return true;
            if (ReferenceEquals(null, other)) return false;
            return other.GetType() == this.GetType() && Equals((Chance)other);
        }

        private bool Equals(Chance other) => Math.Abs(this._fraction - other._fraction) < Epsilon;

        public override int GetHashCode() => _fraction.GetHashCode();

        public static Chance operator !(Chance c) => new Chance(CertainFraction - c._fraction);

        public Chance Not() => !this;

        public Chance And(Chance other) => new Chance(this._fraction * other._fraction);

        public static Chance operator &(Chance left, Chance right) => left.And(right);

        // DeMorgan's Law: https://en.wikipedia.org/wiki/De_Morgan%27s_laws
        public static Chance operator |(Chance left, Chance right) => !(!left & !right);

        public Chance Or(Chance other) => this | other;

    }
}

namespace ExtensionMethods
{
    public static class ChanceConstructors
    {
        public static Chance Chance(this double fraction) => new Chance(fraction);

        public static Chance Chance(this int wholeNumber) => new Chance(wholeNumber);
    }
}
