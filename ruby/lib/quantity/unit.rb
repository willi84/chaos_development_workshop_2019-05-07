# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

# Understands a specific metric
class Unit

  TEASPOON = Unit.new()
  TABLESPOON = Unit.new()
  OUNCE = Unit.new()
  CUP = Unit.new()
  PINT = Unit.new()
  QUART = Unit.new()
  GALLON = Unit.new()

  private_class_method :new
end
