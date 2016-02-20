package gra;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	Random rand = new Random(); // Creates a random number to guess
	int numberToGuess = rand.nextInt(1001);
	int numberOfTries = 0;
	int player = 0; // 0 = human, 1 = computer
		
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int guess;
		boolean win = false;
		int computerMin = 0;
		int computerMax = 1000;

		GuessingGame game = new GuessingGame();

		System.out.println("Human(0) or Computer(1) game? (0/1)");
		game.player = input.nextInt();
		
		System.out.println("Current player is: "
				+ (game.player == 0 ? "Human" : "Computer"));
		// Keeps playing until we guess the correct number
		while (win == false) {
			// Asks us to guess a number
			System.out.println("Guess a number between 1 and 1000: ");
			if (game.player == 0) {
				guess = input.nextInt(); // Let user input a number
			} else {
				try {
				    Thread.sleep(3000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				guess = (computerMin + computerMax)/2;
				System.out.println(guess);			
			}
			game.numberOfTries++; // Keeps track of number of guesses

			// Tells us whether we're guessing too high or too low
			if (guess == game.numberToGuess) {
				win = true;
			} else if (guess < game.numberToGuess) {
				System.out.println("Your guess is too low");
				if (game.player == 1) {computerMin = guess;}
			} else if (guess > game.numberToGuess) {
				System.out.println("Your guess is too high");
				if (game.player == 1) {computerMax = guess;}
			}
		}
		
		game.sayHello(game);

		
	}

	public void sayHello (GuessingGame game) {
		System.out.println("You win "
				+ (game.player == 0 ? "Human" : "Computer") + "!");
		System.out.println("The number was " + numberToGuess);
		System.out.println("It took you " + numberOfTries + " tries");
	}
}