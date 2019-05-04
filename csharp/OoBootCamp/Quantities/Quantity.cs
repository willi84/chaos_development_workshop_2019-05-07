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

        public Quantity(double amount, Unit unit)
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

        private bool Equals(Quantity other) => this._amount.Equals(other._amount) && this._unit == other._unit;

        public override int GetHashCode() => _amount.GetHashCode() * 37 + _unit.GetHashCode();
    }
}