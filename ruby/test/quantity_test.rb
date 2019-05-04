# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

require 'minitest/autorun'
require 'set'
require_relative '../lib/quantity/quantity'

# Confirms behavior of Quantity
class QuantityTest < Minitest::Test

  def test_equality_of_like_units
    assert_equal(Quantity.new(4, Unit::TABLESPOON), Quantity.new(4, Unit::TABLESPOON))
    refute_equal(Quantity.new(4, Unit::TABLESPOON), Quantity.new(6, Unit::TABLESPOON))
    refute_equal(Quantity.new(4, Unit::TABLESPOON), Object.new)
    refute_equal(Quantity.new(4, Unit::TABLESPOON), nil)
  end

  def test_equality_of_unlike_units
    refute_equal(Quantity.new(4, Unit::TABLESPOON),Quantity.new(4, Unit::TEASPOON))
  end

  def test_hash_set
    assert(Set.new([Quantity.new(4, Unit::TABLESPOON)]).include?(Quantity.new(4, Unit::TABLESPOON)))
    assert_equal(1, Set.new([Quantity.new(4, Unit::TABLESPOON), Quantity.new(4, Unit::TABLESPOON)]).count)
  end

  def test_hash
    assert_equal(Quantity.new(4, Unit::TABLESPOON).hash, Quantity.new(4, Unit::TABLESPOON).hash)
  end

end
