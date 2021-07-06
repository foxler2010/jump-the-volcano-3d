package top.drewssite.volcano;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	//Main method
	public static void main(String args[]) {
		//make scanner
		Scanner scanner = new Scanner(System.in);
		
		//welcome the player to the game
		System.out.println("Welcome to Jump The Volcano! Please enter in your starting level and money to begin.");
		System.out.println("The reccomended values are 0 and 0, as a traditional game means you start with no money or experience.");
		System.out.println();
		
		//set starting level
		System.out.print("Please enter in starting level here: ");
		//because of the initialization here, if an exception occurs the default will be zero
		int startLevel = 0;
		try {
			startLevel = scanner.nextInt();
		} catch(InputMismatchException e) {
			//tell the user what happened and "catch" the value they typed into a variable
			//this is required or else the next prompt would scan the invalid token.
			//since this one scans it the next prompt doesn't end up with an exception.
			System.out.println("Either that's not an integer or you tried to be overpowered and gave yourself an experience level above 2^31-1! Until I implement a better error handler it has been auto-set to 0 for you.");
			System.out.println();
			@SuppressWarnings("unused")
			String catcher = scanner.next();
		}
		//newline for better readability
		System.out.println();
		
		//set starting money
		System.out.println("Okay, now let's set your starting money.");
		System.out.print("Input it here: ");
		//because of the initialization here, if an exception occurs the default will be zero
		double startMoney = 0;
		try {
			//scan what's typed in the console
			//output to var
			startMoney = scanner.nextDouble();
		} catch(InputMismatchException e) {
			//tell the user what happened and "catch" the value they typed into a variable
			//this is required or else the next prompt would scan the invalid token.
			//since this one scans it the next prompt doesn't end up with an exception.
			System.out.println("Either that's not a decimal or whole number, or you've gone above and beyond and typed in a number that's so big it coudn't be written in here even if I used scientififc notation! Until I implement a better error handler it has been auto-set to 0 for you.");
			System.out.println();
			@SuppressWarnings("unused")
			String catcher = scanner.next();
		}
		//newline for better readability
		System.out.println();
		
		//make player
		Player player = new Player(startLevel, startMoney);
		System.out.println("Great! Your level is " + player.getLevel() + "...\n...and you have $" + player.getMoney() + " in your wallet.");
		System.out.println();
		
		
		
		/*
		 * MAIN LOOP WILL BE HERE
		 * 
		 * Structure of it:
		 * 
		 * 1. Report info to the player on their level, balance, and important inventory items
		 * 2. Prompt them on what they would like to do. This prompt has different choices every time
		 * 3. Carry out the action. changing the player's instance vars along the way. This is the only step where the vars are changed.
		 * 	  Report on what has changed.
		 * 4. Repeat from step 1, starting a new turn
		 */
		
		
		
		//thanks for playing! shown after the player has chosen to quit
		System.out.println("Thank you for playing Jump The Volcano! I hope you enjoyed the game, and have a good day,");
		//close scanner
		scanner.close();
	}
}
