/* 
 * Copyright (c) 2017 by Fred George
 * May be used freely except for training; license required for training.
 */

using System;
using OoBootCamp;

namespace OoBootCamp
{
    // Understands the likelihood of something occurring
    public class Chance
    {
        private readonly double _fraction;
        
        public Chance(double likelihoodAsFraction)
        {
            _fraction = likelihoodAsFraction;
        }

        public override bool Equals(object other)
        {
            if (ReferenceEquals(this, other)) return true;
            if (ReferenceEquals(null, other)) return false;
            return other.GetType() == this.GetType() && Equals((Chance)other);
        }

        private bool Equals(Chance other) => this._fraction == other._fraction;

        public override int GetHashCode() => _fraction.GetHashCode();
    }
}
