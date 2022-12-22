//roulette martingale strategy simulation
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class roulette_martingale
{

public static void main(String args[])
{
    System.out.println("Roulette Martingale Theory Simulation");
    System.out.println("written in Java by Will Holbrook");

    Scanner scanner = new Scanner(System.in);

    System.out.println("\nPlease enter the starting account balance: ");
    int account_balance = scanner.nextInt();

    System.out.println("\nPlease enter the bet amount: ");
    int bet_amount = scanner.nextInt();
    int original_bet_amount = bet_amount;

    System.out.println("\n1. Red");
    System.out.println("2. Black");
    System.out.println("3. Green");

    System.out.println("\nPlease enter the betting choice for the sim: ");
    int choice = scanner.nextInt();

    scanner.close();

    int bet_count = 0;
    int win_count = 0;
    int loss_count = 0;

    while (true)
    {
        Random random = new Random();
        int roulette_result = random.nextInt(37);
        int winResult = 0;

        if (roulette_result == 0)
        {
            //value is 0 (green)
            System.out.println("green");
            winResult = 3;
        }
        else
        {
            switch (roulette_result %2)
            {
                case 0:
                    //even number so number is 'black'
                    System.out.println("black");
                    winResult = 2;
                    break;
                case 1:
                    //odd number so number is 'red'
                    System.out.println("red");
                    winResult = 1;
                    break;
            }
        }

        if (winResult == choice && winResult == 1)
        {
            System.out.println("Bet won");
            bet_amount = original_bet_amount;
            account_balance = account_balance + (bet_amount*2);
            win_count++;
            bet_count++;
            System.out.println("");
        }
        else if (winResult == choice && winResult == 2)
        {
            System.out.println("Bet won");
            bet_amount = original_bet_amount;
            account_balance = account_balance + (bet_amount*2);
            win_count++;
            bet_count++;
            System.out.println("");
        }
        else if (winResult == choice && winResult == 3)
        {
            System.out.println("Bet won");
            bet_amount = original_bet_amount;
            account_balance = account_balance + (bet_amount*35);
            win_count++;
            bet_count++;
            System.out.println("");
        }
        else
        {
            System.out.println("Bet lost");
            bet_amount = bet_amount*2;
            loss_count++;
            bet_count++;
            System.out.println("");
        }

        try 
        {
            Thread.sleep(200);
        }
        catch (InterruptedException e) {
            // Handle the exception
        }

        if (bet_count %10 == 0)
        {
            System.out.printf("The number of bets made before termination was: %d\n", bet_count);
            System.out.printf("The number of wins was: %d\n", win_count);
            System.out.printf("The number of losses was: %d\n", loss_count);
            System.out.printf("The resulting account balance was: %d\n", account_balance);
            try 
            {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                // Handle the exception
            }
        }
    }
}
}