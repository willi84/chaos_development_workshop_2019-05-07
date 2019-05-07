# Copyright (c) 2019 by Fred George
# May be used freely except for training; license required for training.
# @author Fred George  fredgeorge@acm.org

# Dockerfile to build a Ruby runtime for unit testing
#   docker build --tag="fredgeorge/ruby_w_guard:latest" .
#   docker tag fredgeorge/ruby_w_guard:latest fredgeorge/ruby_w_guard:v0.5
# Pushed as fredgeorge/ruby_w_guard:v0.5 and :latest on 6 Feb 2017

# Create bash container for Windows 10:
#   docker create --name="ruby_boot_camp" -it -v c:/Users/dev/src/oo_boot_camp_polyglot_reference_01/ruby:/oo_boot_camp -w /oo_boot_camp fredgeorge/ruby_w_guard:latest

# Start container with Guard running automatically:
#   docker start -i ruby_boot_camp
# Only once, run the bundler on that instance
#   docker exec ruby_boot_camp bundle package

# Get a console in alread-running container:
#   docker exec -it ruby_boot_camp bash

# Get a pry console in alread-running container:
#   docker exec -it ruby_boot_camp pry

FROM ruby:latest
MAINTAINER Fred George "fredgeorge@acm.org"

RUN apt-get update -y && apt-get install -y curl nano
RUN gem install minitest
RUN gem install pry
RUN gem install pry-nav
RUN gem install pry-doc
RUN gem install guard
RUN gem install guard-minitest

CMD ["guard", "-p"]
