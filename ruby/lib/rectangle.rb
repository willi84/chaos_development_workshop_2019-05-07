# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

# Understands a four-sided polygon with sides at right angles
class Rectangle

  def initialize(length, width)
    raise ArgumentError.new('Invalid dimensions') unless length > 0 && width > 0
    @length, @width = length, width
  end

  def area
    @length * @width
  end

  def perimeter
    2 * (@length + @width)
  end

end
