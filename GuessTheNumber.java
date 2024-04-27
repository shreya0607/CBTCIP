import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int rounds = 3;
        int totalScore = 0;

        for (int round = 1; round <= rounds; round++) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int guessedNumber;
            int score = 0;

            System.out.println("Round " + round + ": Guess the number between " + minRange + " and " + maxRange);

            do {
                System.out.print("Enter your guess: ");
                guessedNumber = scanner.nextInt();
                attempts++;

                if (guessedNumber == randomNumber) {
                    score = maxRange - (attempts - 1);
                    totalScore += score;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Score for this round: " + score);
                } else if (guessedNumber < randomNumber) {
                    System.out.println("Try again! The number is higher.");
                } else {
                    System.out.println("Try again! The number is lower.");
                }
            } while (guessedNumber != randomNumber);

            attempts = 0;
        }

        System.out.println("Game Over!\nTotal Score: " + totalScore);
        scanner.close();
    }
}