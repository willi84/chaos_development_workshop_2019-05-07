# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

require 'minitest/autorun'
require 'set'
require_relative '../lib/quantity/quantity'

# Confirms behavior of Quantity
class QuantityTest < Minitest::Test

  def test_equality_of_like_units
    assert_equal(4.tablespoons, 4.tablespoons)
    refute_equal(4.tablespoons, 6.tablespoons)
    refute_equal(4.tablespoons, Object.new)
    refute_equal(4.tablespoons, nil)
  end

  def test_equality_of_unlike_units
    refute_equal(4.tablespoons, 4.teaspoons)
  end

  def test_hash_set
    assert(Set.new([4.tablespoons]).include?(4.tablespoons))
    assert_equal(1, Set.new([4.tablespoons, 4.tablespoons]).count)
  end

  def test_hash
    assert_equal(4.tablespoons.hash, 4.tablespoons.hash)
  end

end
