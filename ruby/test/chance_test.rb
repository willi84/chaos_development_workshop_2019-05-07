# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

require 'minitest/autorun'
require 'set'
require_relative '../lib/chance'

# Confirms behavior of Chance
class ChanceTest < Minitest::Test

  CERTAIN = 1.0.chance
  LIKELY = 0.75.chance
  EQUALLY_LIKELY = 0.5.chance
  UNLIKELY = 0.25.chance
  IMPOSSIBLE = 0.0.chance

  def test_equality
    assert_equal(LIKELY, 0.75.chance)
    refute_equal(LIKELY, UNLIKELY)
    refute_equal(LIKELY, Object.new)
    refute_equal(LIKELY, nil)
  end

  def test_hash_set
    assert(Set.new([LIKELY]).include?(0.75.chance))
    assert_equal(1, Set.new([LIKELY, 0.75.chance]).count)
  end

  def test_hash
    assert_equal(LIKELY.hash, 0.75.chance.hash)
  end

  def test_not
    assert_equal(LIKELY, !UNLIKELY)
    assert_equal(LIKELY, !!LIKELY)
    assert_equal(LIKELY, UNLIKELY.not)
    assert_equal(CERTAIN, !IMPOSSIBLE)
    assert_equal(0.3.chance, !!0.3.chance)
  end

  def test_and
    assert_equal(UNLIKELY, EQUALLY_LIKELY & EQUALLY_LIKELY)
    assert_equal(0.1875.chance, LIKELY & UNLIKELY)
    assert_equal(UNLIKELY & LIKELY, LIKELY & UNLIKELY)
    assert_equal(0.09.chance, 0.9.chance & 0.1.chance)
    assert_equal(LIKELY, LIKELY & CERTAIN)
    assert_equal(IMPOSSIBLE, LIKELY & IMPOSSIBLE)
  end

end
