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
 * Yellow: \u001b[33m
 * Reset: \u001b[0m
 */

package top.drewssite.volcano;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {
	
	//VARS
	private static int startLevel;
	private static double startMoney;
	private static ArrayList<Item> startingInventory;
	
	//GETTERS AND SETTERS
	static int getStartLevel() {
		return startLevel;
	}
	
	static double getStartMoney() {
		return startMoney;
	}
	
	//setters only ever used once per var... typed them anyway...
	static void setStartLevel(int newStartLevel) {
		startLevel = newStartLevel;
	}
	
	static void setStartMoney(double newStartMoney) {
		startMoney = newStartMoney;
	}
	
	//STARTING INVENTORY MANAGEMENT
	//THIS WILL (SOMETIMES) BE CALLED BY THE PLAYER SO IT MUST BE EASY TO USE!!
	public static void addItemToInventory(Item item) {
		startingInventory.add(item);
	}
	
	//MAKE SCANNER
	static Scanner scanner = new Scanner(System.in);
	
	//SETUP METHOD
	static void setup() {
		//WELCOME THE PLAYER TO THE GAME
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Welcome to Jump The Volcano! Please enter in your starting level and money to begin.");
		System.out.println("The reccomended values for level and money are 0 and 0, respectively, as a traditional game means you start with no money or experience.");
		System.out.println();
		
		//SET STARTING LEVEL
		setStartLevel(intPrompt("Please enter in starting level here: "));
		
		//SET STARTING MONEY
		System.out.println("Okay, now let's set your starting money.");
		setStartMoney(doublePrompt("Input it here: "));
	}
	
	//PROMPT CODE
	
	//prompts the user to enter one of two options (ex. yes/no question)
	static boolean yesNoPrompt(String prompt, String isTrue, String isFalse) {
		boolean answer = true;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			System.out.print(prompt);
			String response = scanner.next();
			System.out.println();
			if(response.equals(isTrue)) {
				answer = true;
				responseIsValid = true;
			} else if(response.equals(isFalse)) {
				answer = false;
				responseIsValid = true;
			} else {
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
			}
		}
		return answer;
		
	}
	
	//prompts the user to enter an integer
	static int intPrompt(String prompt) {
		int response = 0;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			try {
				System.out.print(prompt);
				response = scanner.nextInt();
				responseIsValid = true;
				System.out.println();
			} catch(InputMismatchException e) {
				System.out.println("That answer is invalid. Please try again.");
				responseIsValid = false;
			}
		}
		return response;
	}
	
	//prompts the user to enter a double
	static double doublePrompt(String prompt) {
		double response = 0;
		boolean responseIsValid = false;
		while(responseIsValid == false) {
			try {
				System.out.print(prompt);
				response = scanner.nextDouble();
				responseIsValid = true;
				System.out.println();
			} catch(InputMismatchException e) {
				System.out.println("That answer is invalid. Please try again.");
				responseIsValid = false;
			}
		}
		return response;
	}
	
	//MAIN METHOD
	public static void main(String args[]) {
		
		//RUN SETUP
		setup();
		
		//MAKE PLAYER
		Player player = new Player("Player", 10, getStartLevel(), getStartMoney(), startingInventory);
		
		//LET'S START THE GAME!
		System.out.println("Great! Let's get started with the game.");
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		/*
		 * MAIN LOOP WILL BE HERE
		 * 
		 * Structure of it:
		 * 
		 * 1. Report info to the player on their level, balance, and important inventory items (DONE!)	
		 * 2. Prompt them on what they would like to do. This prompt has different choices every time
		 * 3. Carry out the action. changing the player's instance vars along the way. This is the only step where the vars are changed.
		 * 	  Report on what has changed.
		 * 4. Repeat from step 1, starting a new turn
		 */
		
		//initialize boolean to track whether we are continuing the loop or not
		//also make a turn counter because it's useful
		boolean continuingGame = true;
		int turns = 0;
		//the loop begins
		while (continuingGame == true) {
			//PHASE 1
			//reported no matter what
			System.out.println("Turn: \u001b[33m" + turns + "\u001b[0m");
			System.out.println("Your level is \u001b[32m" + player.getLevel() + "\u001b[0m...\n...and you have $\u001b[31m" + player.getMoney() + "\u001b[0m in your wallet.");
			System.out.println();
			
			//view inventory?
			boolean viewInventory = yesNoPrompt("Would you like to view your inventory? ", "y", "n");
			if(viewInventory == true) {
				System.out.println("Here it is:");
				try {
					System.out.println(player.inventoryToString());
				} catch(NullPointerException e) {
					System.out.println("Hmm, your inventory is empty right now.");
				}
			} else if(viewInventory == false){
				System.out.println("Okay, let's keep going...");
			}
				
			//NEWLINE FOR READABILITY
			System.out.println();
			
			//PHASE 2
			
			
			
			//PHASE 3
			
			//for testing purposes, stop the loop after one turn
			continuingGame = false;
		}
		
		
		
		//ENDGAME
		System.out.println("Thank you for playing Jump The Volcano. Please play again soon!");
		
		//CLOSE SCANNER
		scanner.close();
	}
}
