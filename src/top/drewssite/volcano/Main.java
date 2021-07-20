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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	//VARS
	private static int startLevel;
	private static double startMoney;
	private static boolean colorsOn;
	
	//GETTERS AND SETTERS
	public static int getStartLevel() {
		return startLevel;
	}
	
	public static double getStartMoney() {
		return startMoney;
	}
	
	//named without a 'get' since it reads better as a question (are the colorsOn()?)
	public static boolean colorsOn() {
		return colorsOn;
	}
	
	//setters only ever used once per var... typed them anyway...
	public static void setStartLevel(int newStartLevel) {
		startLevel = newStartLevel;
	}
	
	public static void setStartMoney(double newStartMoney) {
		startMoney = newStartMoney;
	}
	
	//setColorsOn() would sound weird so i opted to use 'Mode' instead of 'On'
	public static void setColorMode(boolean newColorMode) {
		colorsOn = newColorMode;
	}
	
	
	
	//MAKE SCANNER
	public static Scanner scanner = new Scanner(System.in);
	
	
	
	//SETUP METHOD (very long, but collapsible if you use a good IDE to view the file)
	public static void setup(String args[]) {
		//WELCOME THE PLAYER TO THE GAME
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Welcome to Jump The Volcano! Please enter in the display mode, your starting level, and beginning money to begin.");
		System.out.println("The reccomended values for level and money are 0 and 0, respectively, as a traditional game means you start with no money or experience.");
		System.out.println();
			
		
		
		//SET DISPLAY MODE
		//print a lot of words to signify the super-importance-ness of this decision
		System.out.println("Please specify your display mode. There are two modes to choose from.");
		System.out.println("To enable ANSI escape codes coloring, type in the number 1.");
		System.out.println("To disable this functionality and use only default color text please enter the number 2");
		System.out.println("It is highly reccomended to use color mode unless your console does not support it.");
		System.out.println("Chances are you support it, if you are running a graphical environment with a console emulator.");
		System.out.println();
		System.out.print("Enter in your display mode number here: ");
		//make a boolean and integer, both of which are important.
		//initialize integer with value of 1, so it is initialized/set somewhere other than the scanner.
		//for some reason it is a compile error if that requirement is not satisfied.
		int displayModeNumber = 1;
		try {
			//set integer to scanned number
			displayModeNumber = scanner.nextInt();
		} catch(InputMismatchException e) {
			//tell the user what happened and "catch" the value they typed into a variable.
			//this is required or else the next prompt would scan the invalid token.
			//since this one scans it the next prompt doesn't end up with an exception.
			System.out.println("That's not an integer. Until I implement a better error handler it has been auto-set to 1 for you.");
			@SuppressWarnings("unused")
			String catcher = scanner.next();
		}
		//convert string to boolean. auto-set boolean to true if string doesn't match either '1' or '2'
		//also if no match, then notify player.
		if (displayModeNumber == 1) {
			setColorMode(true);
			System.out.println();
			System.out.println("OK. The following text should be in color: \n\u001b[31mThis text should be red!\n\u001b[32mThis text should be green!\n\u001b[0mThis text should be the default color.");
			System.out.println();
			System.out.println("If you saw any weird codes in the text and/or it wasn't colored correctly,\nyou should kill this program and select display mode 2 next time.");
		} else if (displayModeNumber == 2) {
			setColorMode(false);
			System.out.println();
			System.out.println("OK. The game will display all text using the default color.");
			System.out.println("ANSI escape codes coloring has been disabled.");
		} else {
			setColorMode(true);
			System.out.println();
			System.out.println("You didn't enter a 1 or 2. Until I implement a better error handler it has been auto-set to 1 for you.");
			System.out.println("If you aren't okay with colors being active, kill the program and enter the number 2 next time instead of doing something else.");
		}
		//NEWLINE FOR BETTER READABILITY
		System.out.println();
		
		
		
		//SET STARTING LEVEL
		System.out.print("Please enter in starting level here: ");
		//because of the initialization here, if an exception occurs the default will be whatever parameter you entered when calling the program.
		//if the parameter is invalid then the default will be 0
		try {
			//parameter is a string[] so parse [0] as an integer
			setStartLevel(Integer.parseInt(args[0]));
		} catch(ArrayIndexOutOfBoundsException e) {
			//if no parameter is entered
			setStartLevel(0);
		} catch(NumberFormatException e) {
			//if parameter cannot be computed to integer
			setStartLevel(0);
		}
		//scan user input, output to var
		//if exception, set it to the default (which is the parameter entered in the CLI)
		try {
			setStartLevel(scanner.nextInt());
		} catch(InputMismatchException e) {
			//tell the user what happened and "catch" the value they typed into a variable
			//this is required or else the next prompt would scan the invalid token.
			//since this one scans it the next prompt doesn't end up with an exception.
			System.out.println();
			if (colorsOn() == true) {
				System.out.println("Either that's not an integer or you tried to be overpowered and gave yourself an experience level above \u001b[32m2^31-1\u001b[0m! Until I implement a better error handler it has been auto-set to \u001b[32m0\u001b[0m for you.");
			} else {
				System.out.println("Either that's not an integer or you tried to be overpowered and gave yourself an experience level above 2^31-1! Until I implement a better error handler it has been auto-set to 0 for you.");
			}
				
			System.out.println();
			@SuppressWarnings("unused")
			String catcher = scanner.next();
		}
		//NEWLINE FOR BETTER READABILITY
		System.out.println();
		
		
		
		//SET STARTING MONEY
		System.out.println("Okay, now let's set your starting money.");
		System.out.print("Input it here: ");
		//because of the initialization here, if an exception occurs the default will be zero
		try {
			//scan what's typed in the console
			//output to var
			setStartMoney(scanner.nextDouble());
		} catch(InputMismatchException e) {
			//tell the user what happened and "catch" the value they typed into a variable
			//this is required or else the next prompt would scan the invalid token.
			//since this one scans it the next prompt doesn't end up with an exception.
			System.out.println();
			if (colorsOn() == true) {
				System.out.println("Either that's not a decimal or whole number, or you've gone above and beyond and typed in a number that's so big it couldn't be written in here even if I used scientififc notation! Until I implement a better error handler it has been auto-set to \u001b[31m0\u001b[0m for you.");
			} else {
				System.out.println("Either that's not a decimal or whole number, or you've gone above and beyond and typed in a number that's so big it couldn't be written in here even if I used scientififc notation! Until I implement a better error handler it has been auto-set to 0 for you.");
			}
		@SuppressWarnings("unused")
		String catcher = scanner.next();
		}
		//NEWLINE FOR BETTER READABILITY
		System.out.println();
	}
	
	
	
	//MAIN METHOD
	public static void main(String args[]) {
		
		//RUN SETUP
		setup(args);
		
		//MAKE PLAYER
		Player player = new Player(getStartLevel(), getStartMoney());
		//printed after the last setup prompt, informing player of their stats
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
