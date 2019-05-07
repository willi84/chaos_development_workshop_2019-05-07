# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

# Understands the likelihood of something occurring
class Chance
  attr_reader :fraction
  protected :fraction

  CERTAIN_FRACTION = 1.0
  EPSILON = 0.000000001

  def initialize likelihood_as_fraction
    @fraction = likelihood_as_fraction
  end

  def == other
    self.eql? other
  end

  def eql? other
    return false unless other.is_a? Chance
    (self.fraction - other.fraction).abs < EPSILON
  end

  def hash
    @fraction.hash
  end

  def !@
    (CERTAIN_FRACTION - @fraction).chance
  end

  alias not !

  def & other
    (self.fraction * other.fraction).chance
  end

  alias and &

  # Implemented via DeMorgan's Law (https://en.wikipedia.org/wiki/De_Morgan%27s_laws)
  def | other
    !(!self & !other)
  end

  alias or |

  Numeric.class_eval do
    define_method :chance do
      Chance.send(:new, self)
    end
  end

  private_class_method :new

end
