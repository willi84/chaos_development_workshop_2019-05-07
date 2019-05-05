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
    assert_equal(3.teaspoons, 1.tablespoons)
    assert_equal(0.5.cups, 8.tablespoons)
    assert_equal(768.teaspoons, 1.gallons)
    refute_equal(4.tablespoons, 4.teaspoons)
    assert_equal(0.5.furlongs, 330.feet)
    assert_equal(126720.inches, 2.miles)
  end

  def test_hash_set
    assert(Set.new([4.tablespoons]).include?(4.tablespoons))
    assert(Set.new([8.tablespoons]).include?(0.5.cups))
    assert_equal(1, Set.new([4.tablespoons, 4.tablespoons]).count)
    assert_equal(1, Set.new([8.tablespoons, 0.5.cups]).count)
  end

  def test_hash
    assert_equal(4.tablespoons.hash, 4.tablespoons.hash)
    assert_equal(8.tablespoons.hash, 0.5.cups.hash)
    assert_equal(0.5.furlongs.hash, 330.feet.hash)
  end

  def test_arithmetic
    assert_equal(0.5.pints, +(8.ounces))
    assert_equal(0.5.pints, +4.ounces + 0.5.cups)
    assert_equal(0.5.cups + 4.ounces, 4.ounces + 0.5.cups)
    assert_equal(-0.75.quarts, -(0.75.quarts))
    assert_equal(-2.pints, 2.cups - 1.5.quarts)
    assert_equal(-100.yards, 30.feet - 0.5.furlongs)
  end

  def test_inequality_of_unlike_types
    refute_equal(1.inches, 1.teaspoons)
    refute_equal(1.celsius, 1.teaspoons)
  end

  def test_forbidden_arithmetic
    assert_raises(ArgumentError) { 2.tablespoons - 4.yards }
    assert_raises(ArgumentError) { 4.yards - 2.tablespoons }
  end

end
