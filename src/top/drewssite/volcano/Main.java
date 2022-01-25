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

import java.util.ArrayList;

/**
 * This is where the main method is located. When the program starts, the methods in here are executed.
 * @author foxler2010
 * @since v1.0
 * @see Data
 * @see Data
 */
class Main {
	
	/**
	 * This is the main method. When the program is executed, this is the method that is called
	 * @param args Arguments from the shell. Currently not used for anything, but that could change.
	 */
	public static void main(String args[]) {
		
		//WELCOME THE PLAYER TO THE GAME
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Welcome to Jump The Volcano!");
		System.out.println();
		
		//LET'S START THE GAME!
		System.out.println("Your level is \u001b[32m" + Data.player.getLevel() + "\u001b[0m and you have $\u001b[31m" + Data.player.getMoney() + "\u001b[0m in your wallet.");
		System.out.println();
		System.out.println("Let's get started with the game!");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();

		//SET firstTurn TO TRUE
		//the next loop will be the first turn of the game, so this must be true.
		
		/*
		 * MAIN LOOP STARTS HERE
		 * 
		 * Structure of it:
		 * 
		 * PHASE 1: Report info to the player on their level, balance, and important inventory items (DONE!)	
		 * PHASE 2: Prompt them on what they would like to do. This prompt has different choices every time (DONE!)
		 * PHASE 3: Carry out the action. changing the player's instance vars along the way. This is the only step where the vars are changed.
		 * PHASE 4: Repeat from step 1, starting a new turn
		 */
		
		//initialize boolean to track whether we are continuing the loop or not
		//also make a turn counter because it's useful
		int turns = 0;

		//the loop begins
		while (Data.continuingGame) {
			//PHASE 1
			//reported no matter what
			System.out.println("Turn: \u001b[33m" + turns + "\u001b[0m");
			System.out.println("Your level is \u001b[32m" + Data.player.getLevel() + "\u001b[0m...\n...and you have $\u001b[31m" + Data.player.getMoney() + "\u001b[0m in your wallet.");
			System.out.println();
			
			//view inventory?
			if(Data.yesNoPrompt("Would you like to view your inventory? [y/n] ", "y", "n")) {

				//check for emptiness
				if(Data.player.sizeOfInventory() == 0) {

					System.out.println("You inventory is currently empty.");

				} else {

					System.out.println("Here it is:");
					System.out.println();

					System.out.print(Data.player.inventoryFancyToString()); //workhorse command, does majority of the work

					//newline for readability
					System.out.println();

				}

			} else {

				System.out.println("Okay, let's keep going...");

			}

			//NEWLINE FOR READABILITY
			System.out.println();
			
			//PHASE 2
			//display options

			//yup new dynamic system coming soon...
			//even more dynamic than this system
			ArrayList<Option> availableOptions = new ArrayList<Option>();

			//you can always jump the volcano
			availableOptions.add(Option.JUMP_THE_VOLCANO);

			//you can't dumpster dive if you have 10 or more items in your inventory.
			if (Data.player.sizeOfInventory() < 10) {
				availableOptions.add(Option.DUMPSTER_DIVE);
			}

			//you can only visit the pet store once you have $500
			//the first time you see the pet store option it will say "(NEW!)" in front.
			if (Data.player.getMoney() >= 500 && Data.numOfPetStoreVisits == 0) {
				availableOptions.add(Option.PET_STORE_NEW);
			}

			//you can only visit the pet store if you have $500 or more
			if (Data.player.getMoney() >= 500) {
				availableOptions.add(Option.PET_STORE);
			}

			//you can only visit the arena once you have reached turn 50
			//the first time you see the arena option it will say "(NEW!)" in front.
			if (turns == 50) {
				availableOptions.add(Option.ARENA_NEW);
			}

			//use the regular option name after turn 50
			if (turns > 50) {
				availableOptions.add(Option.ARENA);
			}

			//you can always quit the game.
			availableOptions.add(Option.QUIT);
			
			ArrayList<Option> optionsInOrder = new ArrayList<Option>();
			
			System.out.println("Here are your options for this turn:");
			System.out.println();
			
			//this loop displays the options and adds them to an ordered list
			for (int i = 0; i < availableOptions.size(); i++) {
				
				//print the option to the screen. and do some cool maths so the numbers are always in ascending order :)
				System.out.println("  " + (i + 1) + ") " + availableOptions.get(i).getName());
				
				//add the option to this list. It must be in order.
				optionsInOrder.add(availableOptions.get(i));
				
			}
			
			//newline for readability
			System.out.println();
			
			//PHASE 3
			//choose options and change player stats

			boolean responseIsValid = false;

			while(responseIsValid == false) {
				
				//prompts the user to choose an option
				//arguably the most important line of user input in the game
				int option = Data.intPrompt("Please input the option you would like to carry out: ");
				
				//if user input is an index in the list
				//loop thru and find out which index the user input is
				if (option <= optionsInOrder.size() && option > 0) {
					
					for (int i = 0; i < optionsInOrder.size(); i++) {
						
						if (option == i + 1) { // +1 is because user input will be 1 greater than the index
							
							//lets player know what they chose
							System.out.println("You choose " + optionsInOrder.get(i).getName());
							System.out.println();

							//executes the option's opCode() method
							//this is the ONLY time player stats EVER change!!!
							optionsInOrder.get(i).opCode();

							//ends the while loop
							responseIsValid = true;

						}

					}

				} else { //if user input is out of bounds
					
					System.out.println("That answer is invalid. Please try again.");
					System.out.println();

					//makes loop run again
					responseIsValid= false;

				}

			}
			
			//HEALTHCHECK
			if(Data.player.getHealth() == 0) {
				System.out.println("It seems you have died. Agoostafus, the angel of ressurection,\nhas offered to ressurect you, but you must lose all your earthly\npossesions and start life from the beggining again.");
				System.out.println();
				Data.continuingGame = Data.yesNoPrompt("Do you accept Agoostafus' offer? [y/n] ", "y", "n");
				if(Data.continuingGame) {
					System.out.println("Okay, please standby. You will be ressurected shortly.");
					System.out.println();
					Data.player.setMoney(0);
					Data.player.setLevel(0);
					Data.player.setHealth(100);
					//clear inventory
					for (int i = 0; i <= 6; i++) {
						for (int j = 0; j < Data.player.sizeOfSubList(i); j++) {
							Data.player.removeItem(i, j);
						}
					}
				} else {
					System.out.println("Too bad. I thought it was a good deal, but I guess it is your call...");
					System.out.println("Have fun dying.");
					System.out.println();
					System.out.println("--------------------------------------------------------------------------");
					System.out.println();
				}//end resurrection if-else
			}//end healthcheck
			
			if(Data.continuingGame) {
				//MARKS END OF TURN
				//only shown if you didn't quit or if you die.
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
			}//end turnmarker if
			
			//Increase turn counter by one at end of turn
			turns++;
			
		}//end main loop	
		
		//ENDGAME
		System.out.println("Thank you for playing Jump The Volcano. Please play again soon!");

		//CLOSE SCANNER
		Data.scanner.close();
		
	}//end main method
}//end main class
