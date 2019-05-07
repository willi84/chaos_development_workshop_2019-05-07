# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

require_relative './unit'

# Understands a specific measurement
class Quantity
  attr_reader :amount, :unit
  protected :amount, :unit

  def initialize amount, unit
    @amount, @unit = amount.to_f, unit
  end

  def == other
    self.eql? other
  end

  def eql? other
    return false unless other.is_a? Quantity
    compatible?(other) && self.amount == converted_amount(other)
  end

  def hash
    @unit.hash_code @amount
  end

  def +@
    self
  end

  def -@
    Quantity.new -amount, unit
  end

  def + other
    Quantity.new self.amount + converted_amount(other), self.unit
  end

  def - other
    self + -other
  end

  private

    def compatible? other
      self.unit.compatible? other.unit
    end

    def converted_amount other
      self.unit.converted_amount other.amount, other.unit
    end

end
