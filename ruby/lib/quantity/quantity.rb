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
    self.amount == other.amount && self.unit == other.unit
  end

  def hash
    @amount.hash * 37 + @unit.hash
  end

end
