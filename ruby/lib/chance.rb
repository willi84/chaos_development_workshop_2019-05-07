# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

# Understands the likelihood of something occurring
class Chance
  attr_reader :fraction
  protected :fraction

  def initialize likelihood_as_fraction
    @fraction = likelihood_as_fraction
  end

  def == other
    self.eql? other
  end

  def eql? other
    return false unless other.is_a? Chance
    self.fraction == other.fraction
  end

  def hash
    @fraction.hash
  end

end
