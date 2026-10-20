
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int totalRounds = 0;
    static int totalWins = 0;

    public static void main(String[] args) {

        boolean playAgain = true;

        System.out.println("==================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("==================================");

        while (playAgain) {

            playGame();

            System.out.print("\nPlay Again? (yes/no): ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("y")) {
                playAgain = true;
            } else {
                playAgain = false;
            }
        }

        displayFinalScore();

        System.out.println("\nThank you for playing!");

        scanner.close();
    }

    public static void playGame() {

        int minimum;
        int maximum;
        int maxAttempts;
        int secretNumber;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nChoose Difficulty:");
        System.out.println("1. Easy   (1-50, 10 attempts)");
        System.out.println("2. Medium (1-100, 7 attempts)");
        System.out.println("3. Hard   (1-200, 5 attempts)");

        int difficulty = getDifficulty();

        switch (difficulty) {
            case 1:
                minimum = 1;
                maximum = 50;
                maxAttempts = 10;
                break;

            case 2:
                minimum = 1;
                maximum = 100;
                maxAttempts = 7;
                break;

            case 3:
                minimum = 1;
                maximum = 200;
                maxAttempts = 5;
                break;

            default:
                minimum = 1;
                maximum = 100;
                maxAttempts = 7;
                break;
        }

        secretNumber = random.nextInt(maximum - minimum + 1) + minimum;

        totalRounds++;

        System.out.println("\nI have generated a number from " + minimum + " to " + maximum + ".");

        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts && !guessedCorrectly) {

            System.out.print("\nEnter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int guess = scanner.nextInt();
            scanner.nextLine();

            if (guess < minimum || guess > maximum) {
                System.out.println("Please enter a number between " + minimum + " and " + maximum + ".");
                continue;
            }

            attempts++;

            System.out.println("Attempt: " + attempts + " / " + maxAttempts);

            if (guess < secretNumber) {
                System.out.println("Too Low!");
            } else if (guess > secretNumber) {
                System.out.println("Too High!");
            } else {
                System.out.println("Correct! You guessed the number!");
                System.out.println("You got it in " + attempts + " attempt(s).");

                guessedCorrectly = true;
                totalWins++;
            }

            if (!guessedCorrectly && attempts < maxAttempts) {
                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }
        }

        if (!guessedCorrectly) {
            System.out.println("\nYou Lost!");
            System.out.println("The correct number was: " + secretNumber);
        }

        System.out.println("\n========== ROUND SUMMARY ==========");
        System.out.println("Round: " + totalRounds);
        System.out.println("Result: " + (guessedCorrectly ? "WIN" : "LOSS"));
        System.out.println("Attempts used: " + attempts);
        System.out.println("Correct answer: " + secretNumber);
        System.out.println("===================================");
    }


    public static int getDifficulty() {

        while (true) {
            System.out.print("Enter difficulty (1-3): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Invalid choice! Please enter 1, 2, or 3.");
        }
    }

    public static void displayFinalScore() {

        System.out.println("\n==================================");
        System.out.println("          FINAL SCORE");
        System.out.println("==================================");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + totalWins);
        System.out.println("Rounds lost: " + (totalRounds - totalWins));

        if (totalRounds > 0) {
            double winRate = (double) totalWins / totalRounds * 100;

            System.out.printf("Win rate: %.2f%%%n", winRate);
        }

        System.out.println("==================================");
    }
}
