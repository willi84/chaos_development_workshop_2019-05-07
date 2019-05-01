# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

require 'minitest/autorun'
require 'set'
require_relative '../lib/chance'

# Confirms behavior of Chance
class ChanceTest < Minitest::Test

  def test_equality
    assert_equal(Chance.new(0.75), Chance.new(0.75))
    refute_equal(Chance.new(0.75), Chance.new(0.25))
    refute_equal(Chance.new(0.75), Object.new)
    refute_equal(Chance.new(0.75), nil)
  end

  def test_hash_set
    assert(Set.new([Chance.new(0.75)]).include?(Chance.new(0.75)))
    assert_equal(1, Set.new([Chance.new(0.75), Chance.new(0.75)]).count)
  end

  def test_hash
    assert_equal(Chance.new(0.75).hash, Chance.new(0.75).hash)
  end

end
