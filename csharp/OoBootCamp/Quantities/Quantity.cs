/* 
 * Copyright (c) 2019 by Fred George
 * May be used freely except for training; license required for training.
 */
 
namespace OoBootCamp.Quantities
{
    // Understands a specific scale-based measurement
    public class Quantity 
    {
        private readonly double _amount;
        private readonly Unit _unit;

        internal Quantity(double amount, Unit unit)
        {
            _amount = amount;
            _unit = unit;
        }

        public override bool Equals(object other)
        {
            if (ReferenceEquals(this, other)) return true;
            if (ReferenceEquals(null, other)) return false;
            return other.GetType() == this.GetType() && Equals((Quantity)other);
        }

        private bool Equals(Quantity other) => this.IsCompatible(other) && this._amount.Equals(ConvertedAmount(other));

        private bool IsCompatible(Quantity other) => this._unit.IsCompatible(other._unit);

        private double ConvertedAmount(Quantity other) => this._unit.ConvertedAmount(other._amount, other._unit);

        public override int GetHashCode() => _unit.HashCode(_amount);

        public static Quantity operator +(Quantity q) => q;

        public static Quantity operator -(Quantity q) => new Quantity(-q._amount, q._unit);

        public static Quantity operator +(Quantity left, Quantity right)
            => new Quantity(left._amount + left.ConvertedAmount(right), left._unit);

        public static Quantity operator -(Quantity left, Quantity right) => left + -right;

    }
}