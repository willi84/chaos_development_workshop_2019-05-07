# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

require 'minitest/autorun'
require_relative '../lib/rectangle'

# Confirms behavior of Rectangle
class RectangleTest < Minitest::Test

  def test_area
    assert_equal(24, Rectangle.new(4, 6).area)
  end

  def test_perimeter
    assert_equal(20, Rectangle.new(4, 6).perimeter)
  end

  def test_invalid_dimensions
    assert_raises(ArgumentError) { Rectangle.new(0, 6) }
    assert_raises(ArgumentError) { Rectangle.new(4, 0) }
  end

end
