task :default => :test
task :test do
  Dir.glob('./*/*_test.rb').each { |file| require file}
end
