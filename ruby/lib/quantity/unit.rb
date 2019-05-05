# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

# Understands a specific metric
class Unit
  attr_reader :base_unit_ratio
  protected :base_unit_ratio

  def initialize(plural_label, relative_ratio = 1.0, relative_unit = nil)
    @base_unit_ratio = relative_unit.nil? ? 1.0 : relative_ratio * relative_unit.base_unit_ratio
    create_convenience_constructor plural_label
  end

  private

    def create_convenience_constructor plural_label
      unit = self
      Numeric.class_eval do
        define_method plural_label do
          Quantity.new(self, unit)
        end
      end
    end

    teaspoon = Unit.new(:teaspoons)
    tablespoon = Unit.new(:tablespoons, 3, teaspoon)
    ounce = Unit.new(:ounces, 2, tablespoon)
    cup = Unit.new(:cups, 8, ounce)
    pint = Unit.new(:pints, 2, cup)
    quart = Unit.new(:quarts, 2, pint)
    gallon = Unit.new(:gallons, 4, quart)

  private_class_method :new
end
