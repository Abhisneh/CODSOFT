import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
        public static void main(String[] args) {
        
        Random random = new Random();

        int min = 1;
        int max = 100;

        int randomNumber = random.nextInt(max - min + 1) + min;
        Scanner scanner = new Scanner(System.in);
        int numberOfAttempts = 0;
        while (true) {  
            System.out.println("Guess the random number between " + min + " and " + max + ": ");

            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! Your guess is correct. It took you " + numberOfAttempts + " attempts.");
                break; 
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        
        scanner.close();
    }
}
