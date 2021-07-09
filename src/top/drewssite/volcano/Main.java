/*
 * COMMENTING FORMAT!
 * 
 * ALL CAPS = new section of code
 * 
 * anything else = notes
 */


/*
 * ANSI color codes for me to use when coding
 * Red:   \u001b[31m
 * Green: \u001b[32m
 * Reset: \u001b[0m
 */

package top.drewssite.volcano;
import java.util.Scanner;

public class Main {
	
	//MAKE SCANNER
	public Scanner scanner = new Scanner(System.in);
	
	//MAIN METHOD
	public static void main(String args[]) {
		
		//RUN SETUP
		Setup.setup(args);
		
		//MAKE PLAYER
		Player player = new Player(Setup.getStartLevel(), Setup.getStartMoney());
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
		
		
		
		//ENDGAME (NOT TO BE CONFUSED WITH AVENGERS)
		System.out.println("Thank you for playing Jump The Volcano! I hope you enjoyed the game, and have a good day.");
		
		//CLOSE SCANNER
		scanner.close();
	}
}
