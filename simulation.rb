# Roulette Martingale Strategy Simulation (port from Java to Ruby)
class RouletteMartingale
    def initialize
      puts 'Roulette Martingale Theory Simulation'
      puts 'written in Ruby by Will Holbrook'
  
      puts "\nPlease enter the starting account balance: "
      @account_balance = gets.chomp.to_i
  
      puts "\nPlease enter the bet amount: "
      @bet_amount = gets.chomp.to_i
      @original_bet_amount = @bet_amount
  
      puts "\n1. Red"
      puts "2. Black"
      puts "3. Green"
  
      puts "\nPlease enter the betting choice for the sim: "
      @choice = gets.chomp.to_i
  
      @bet_count = 0
      @win_count = 0
      @loss_count = 0
    end
  
    def simulate
      loop do
        roulette_result = rand(37)
        win_result = 0
  
        if roulette_result.zero?
          # value is 0 (green)
          puts 'green'
          win_result = 3
        else
          case roulette_result % 2
          when 0
            # even number so number is 'black'
            puts 'black'
            win_result = 2
          when 1
            # odd number so number is 'red'
            puts 'red'
            win_result = 1
          end
        end
  
        if win_result == @choice && win_result == 1
          puts 'Bet won'
          @bet_amount = @original_bet_amount
          @account_balance += @bet_amount * 2
          @win_count += 1
          @bet_count += 1
          puts ''
        elsif win_result == @choice && win_result == 2
          puts 'Bet won'
          @bet_amount = @original_bet_amount
          @account_balance += @bet_amount * 2
          @win_count += 1
          @bet_count += 1
          puts ''
        elsif win_result == @choice && win_result == 3
          puts 'Bet won'
          @bet_amount = @original_bet_amount
          @account_balance += @bet_amount * 35
          @win_count += 1
          @bet_count += 1
          puts ''
        else
          puts 'Bet lost'
          @bet_amount *= 2
          @loss_count += 1
          @bet_count += 1
          puts ''
        end
  
        sleep(0.2)
  
        if @bet_count % 10 == 0
          puts "The number of bets made before termination was: #{@bet_count}"
          puts "The number of wins was: #{@win_count}"
          puts "The number of losses was: #{@loss_count}"
          puts "The resulting account balance was: #{@account_balance}"
          sleep(5)
        end
      end
    end
  end
  
  roulette_simulation = RoulettesMartingale.new
  roulette_simulation.initialize
  roulette_simulation.simulate