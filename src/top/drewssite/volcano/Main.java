/*
 * COMMENTING FORMAT!
 * 
 * ALL CAPS = new section of code
 * 
 * anything else = notes, small bits i wanted to highlight,
 * 
 * other stuff that would otherwise not make sense w/o a comment, etc.
 */


/*
 * ANSI color codes for me to use when coding
 * Red:   \u001b[31m
 * Green: \u001b[32m
 * Yellow: \u001b[33m
 * Reset: \u001b[0m
 */

package top.drewssite.volcano;
import java.util.*;

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
	
	static void setStartLevel(int newStartLevel) {
		startLevel = newStartLevel;
	}
	
	static void setStartMoney(double newStartMoney) {
		startMoney = newStartMoney;
	}
	
	//MAKE SCANNER
	static Scanner scanner = new Scanner(System.in);
	
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
				System.out.println();
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
				@SuppressWarnings("unused")
				String catcher = scanner.next();
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
				System.out.println();
				System.out.println("That answer is invalid. Please try again.");
				System.out.println();
				responseIsValid = false;
				@SuppressWarnings("unused")
				String catcher = scanner.next();
			}
		}
		return response;
	}
	
	//MAIN METHOD
	public static void main(String args[]) {
		
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
		
		//MAKE PLAYER
		Player player = new Player("Player", 10, getStartLevel(), getStartMoney(), startingInventory);
		
		//MAKE OPTIONS
		Option jumpTheVolcano = new Option("Jump The Volcano");
		Option dumpsterDive = new Option("Dumpster dive");
		Option petStore = new Option("Go to the Pet Store");
		Option arena = new Option("Visit the Arena");
		Option quit = new Option("Exit the game");
		
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
					System.out.println();
					System.out.println("Hmm, your inventory is empty right now.");
				}
			} else if(viewInventory == false){
				System.out.println("Okay, let's keep going...");
			}
				
			//NEWLINE FOR READABILITY
			System.out.println();
			
			//PHASE 2
			//all possible options here. currently they are manually activated but that is going to change.
			//to activate an option simply add it to the 'availableOptions' list
			
			//the 'jumpTheVolcano' option is ALWAYS active so the line adding it to the list will always be here.
			//the others will be active depending on some algorithms that are yet to be coded.
			ArrayList<Option> availableOptions = new ArrayList<Option>();
			availableOptions.add(jumpTheVolcano);
			availableOptions.add(dumpsterDive);
			availableOptions.add(petStore);
			availableOptions.add(arena);
			availableOptions.add(quit);
			
			//I have to declare and initialize these outside of the phase 2 loop.
			//I initialized them with 'jumpTheVolcano' because it is the one option that will always be displayed.
			//There is no way they could possibly exit the phase 2 loop without being assigned to a new option
			//so it is okay to choose any option here
			Option option1 = jumpTheVolcano;
			Option option2 = jumpTheVolcano;
			Option option3 = jumpTheVolcano;
			Option option4 = jumpTheVolcano;
			Option option5 = jumpTheVolcano;
			
			System.out.println("Here are your options for this turn:");
			System.out.println();
			
			//this loop actually displays and assigns every available option to a new var which will be useful later.
			for(int currentOption = 0; currentOption < availableOptions.size(); currentOption++) {
				
				//set whatever option is listed at this number as the option for this number
				//a bit confusing but it is extremely important in order to call the right method when an
				//option is chosen
				switch(currentOption) {
				
				case 0: option1 = availableOptions.get(currentOption);
						break;
				case 1: option2 = availableOptions.get(currentOption);
						break;
				case 2: option3 = availableOptions.get(currentOption);
						break;
				case 3: option4 = availableOptions.get(currentOption);
						break;
				case 4: option5 = availableOptions.get(currentOption);
				}//end switch
				
				//print the option to the screen. and do some cool maths so the numbers are always in ascending order :)
				System.out.println("  " + (currentOption + 1) + ") " + availableOptions.get(currentOption).getOption());
				
				}//end phase2 loop
			
			//newline for readability
			System.out.println();
			//initialize this var with 'jumpTheVolcano' because that's what I've been using for all
			//option-related initializations
			Option chosenOption = jumpTheVolcano;
			//assign 'choosenOption' to the correct value based on the users choice.
			boolean responseIsValid = false;
			while(responseIsValid == false) {
				
				//prompts the user to choose an option
				//arguably the most important line in the game
				int option = intPrompt("Please input the option you would like to carry out: ");
				
				//the following switch converts a # to an Option
				//It uses the 'option1', 'option2', etc vars because they are guaranteed to match the # chosen.
				//the actual options declared at the beginning of the main method are not assigned a #.
				//the 'option1' vars are hard-coded with a number so when the actual options are displayed on-screen they
				//are assigned a number by being given an 'alias' of sorts through the 'option1' vars.
				//then when the user chooses an option, a new Option var is created to signify the users choice ('chosenOption')
				//in Option form instead of int form (option). So overall this a just a bunch of code that just moves vars
				//and their values all over the place
				
				//I hope that was a good enough explanation of phase 2, now on with the code
				
				switch(option) {
				
				case 1: chosenOption = option1;
						responseIsValid = true;
						break;
				case 2: chosenOption = option2;
						responseIsValid = true;
						break;
				case 3: chosenOption = option3;
						responseIsValid = true;
						break;
				case 4: chosenOption = option4;
						responseIsValid = true;
						break;
				case 5: chosenOption = option5;
						responseIsValid = true;
						break;
				default: System.out.println("That answer is invalid. Please try again.");
				
				}//end switch
			}//end while
			
			//and finally, after all that jazz...
			System.out.println("You choose " + chosenOption.getOption());
			System.out.println();
			//we can use the chosen value to do stuff
			
			
			//PHASE 3
			
			//ENGAME PROMPT
			//only occurs every 5 turns
			//will be replaced with an option in phase two sometime later.
			if(turns % 5 == 0) {
				continuingGame = yesNoPrompt("Do you want to continue playing? ", "y", "n");
			}
			
			//Increase turn counter by one at end of turn
			turns++;
			
		}//end main loop
		
		
		
		//ENDGAME
		System.out.println("Thank you for playing Jump The Volcano. Please play again soon!");
		
		//CLOSE SCANNER
		scanner.close();
		
	}//end main method
}//end main class
