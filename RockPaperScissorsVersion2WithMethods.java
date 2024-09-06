/**
 * 
 */
package challenge_RockPaperScissors;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */
public class RockPaperScissorsVersion2WithMethods {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Initialise and Declare Variables
		int numberOfRounds = 5;
		int win = 0;
		int draw = 0;
		int loss = 0;

		// Instantiate Scanner and Random		

		printGameWelcome();
		numberOfRounds = howManyRounds(numberOfRounds);
		int[] computerSelections = computerSelections(numberOfRounds);

		// loop for game

		for (int i = 0; i < computerSelections.length; i++) {

			Scanner myScan = new Scanner(System.in);
			
			String userInput = "";
			String computerPlayed = "";

			roundPrinter(i);

			userInput = myScan.nextLine();
			System.out.println("Player played: " + userInput);

			computerPlayed = computerSelectionConverter(computerSelections, i);
			
			System.out.println("Computer Played: " + computerPlayed);

			// logic for deciding winner

			if (userInput.equalsIgnoreCase("Rock") && computerPlayed.equalsIgnoreCase("Scissors")
					|| userInput.equalsIgnoreCase("Paper") && computerPlayed.equalsIgnoreCase("Rock")
					|| userInput.equalsIgnoreCase("Scissors") && computerPlayed.equalsIgnoreCase("Paper")) {

				System.out.println("Result: Player Wins\n");
				win++;
			} else if (userInput.equalsIgnoreCase(computerPlayed)) {

				System.out.println("Result: Draw Game\n");
				draw++;
			} else {
				System.out.println("Result: Computer Wins\n");
				loss++;
			}

		}

		// logic for stats
		System.out.println("Final Statistics");
		float winPercentage = percentage(win, computerSelections);
		float lossPercentage = percentage(loss, computerSelections);
		float drawPercentage = percentage(draw, computerSelections);
		System.out.printf("Win Percentage\t %.2f%%%n", winPercentage);
		System.out.printf("Loss Percentage\t %.2f%%%n", lossPercentage);
		System.out.printf("Draw Percentage\t %.2f%%%n", drawPercentage);
	}

	/**
	 * This method works out the percentage of the games played won, lost or drawn
	 * @param winLossDraw - win, loss or draw value
	 * @param computerSelections
	 * @return - percentage of games won, lost or drawn
	 */
	public static float percentage(int winLossDraw, int[] computerSelections) {
		float percentage = ((float) winLossDraw / computerSelections.length) * 100;
		return percentage;
	}

	/** 
	 * This method convert the computer selection to the appropriate string, rock, paper or scissors
	 * @param computerSelections - computers selections
	 * @param i
	 * @return returns the computer's selection
	 */
	public static String computerSelectionConverter(int[] computerSelections, int i) {
		String computerPlayed;
		// Computer Selection Converter - 1 = rock, 2 = paper, 3 = scissors

		if (computerSelections[i] == 1) {
			computerPlayed = "rock";
		} else if (computerSelections[i] == 2) {
			computerPlayed = "paper";
		} else {
			computerPlayed = "scissors";
		}
		return computerPlayed;
	}

	/**
	 * This method prints the header for each round
	 * @param i
	 */
	public static void roundPrinter(int i) {
		System.out.println("*************\nRound " + (i + 1) + "\n*************\n");
		System.out.println("Choose Rock, Paper or Scissors");
	}

	/**
	 * This method generates the computer selections to play against the user and stores them as an array
	 * @param numberOfRounds - number of rounds to be played
	 * @return - Computer Selections as an Array of Integers
	 */
	public static int[] computerSelections(int numberOfRounds) {
		// Computer Selections

		int[] computerSelections = new int[numberOfRounds];
		
		Random myRand = new Random();
		for (int i = 0; i < computerSelections.length; i++) {
			computerSelections[i] = myRand.nextInt(1, 4);
		}

		System.out.println(Arrays.toString(computerSelections));
		return computerSelections;
	}

	
	/**
	 * This method allows the user to decide how many round of the game they would like to play. This is defaulted to 5 and will catch any erroneous input from the user
	 * @param numberOfRounds - defaulted to 5 as spec
	 * @return - returns the requested number of rounds
	 */
	public static int howManyRounds(int numberOfRounds) {
		// Make decision about number of rounds
		
		Scanner myScan1 = new Scanner(System.in);

		String yesOrNoSelection = "";
		yesOrNoSelection = myScan1.nextLine();

		if (yesOrNoSelection.charAt(0) == 'Y' || yesOrNoSelection.charAt(0) == 'y') {
			System.out.println("How many rounds do you suggest?");
			numberOfRounds = myScan1.nextInt();
			myScan1.nextLine(); // clear buffer
			System.out.println("Ok " + numberOfRounds + " rounds it is!");
		} else if (yesOrNoSelection.charAt(0) == 'N' || yesOrNoSelection.charAt(0) == 'n') {
			System.out.println("Ok " + numberOfRounds + " rounds it is!");
		} else {
			System.out.println("Invalid input - restart game to play!");
			numberOfRounds = 0;
		}
		return numberOfRounds;
	}

	/**
	 * This method prints a welcome to the game
	 */
	public static void printGameWelcome() {
		System.out.println(
				"Welcome to Rock, Paper, Scissors!\n\nIt's you against the computer! \n\nThe usual number of rounds is 5.\nWould you like to change this? Y/N");
	}

}
