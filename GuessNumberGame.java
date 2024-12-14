import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;  // To track total number of rounds won
        int maxRounds = 5;  // Limit the number of rounds
        int attemptsLimit = 10; // Limit attempts per round
        
        while (totalRounds < maxRounds) {
            int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;  // Count attempts for this round
            boolean guessedCorrectly = false;
            
            System.out.println("Round " + (totalRounds + 1) + " of " + maxRounds);
            System.out.println("Guess the number between 1 and 100.");
            
            // Limit the number of attempts
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    totalRounds++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Try again!");
                } else {
                    System.out.println("Your guess is too high. Try again!");
                }
                
                if (attempts == attemptsLimit && !guessedCorrectly) {
                    System.out.println("Sorry, you've reached the maximum attempts. The correct number was: " + numberToGuess);
                    break;
                }
            }

            // Ask the user if they want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        
        // Display the score based on rounds won
        System.out.println("Game over! You won " + totalRounds + " rounds.");
        
        // Close scanner
        scanner.close();
    }
}