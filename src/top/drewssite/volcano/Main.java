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
	private static ArrayList<Item> startingInventory = new ArrayList<Item>();
	
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
		String jumpTheVolcano = "Jump The Volcano";
		String dumpsterDive = "Dumpster dive (money+1)";
		String petStore = "Go to the Pet Store (level+1)";
		String arena = "Visit the Arena (inventory+1canOfBeans)";
		String quit = "Exit the game";
		
		//MAKE RANDOM
		//random random random random random random random random random random
		Random random = new Random();
		
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
		 * 2. Prompt them on what they would like to do. This prompt has different choices every time (DONE!)
		 * 3. Carry out the action. changing the player's instance vars along the way. This is the only step where the vars are changed.
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
			//depends on prompt
			if(viewInventory == true) {
				//before printing it
				int currentItem;
				int size = player.sizeOfInventory();
				//check for emptiness
				if(size == 0) {
					System.out.println("You inventory is currently empty.");
				} else {
					System.out.println("Here it is:");
					System.out.println();
					//loop thru all the items but 1
					for(currentItem = 0; currentItem < size - 1; currentItem++) {
						//print an item's name, add comma after
						System.out.print(player.getItem(currentItem).getName() + ", ");
					}//end inventory for
					//last item, no comma after it
					System.out.print(player.getItem(currentItem).getName());
					//newline for readability
					System.out.println();
				}//end inventory size if
			} else if(viewInventory == false){
				System.out.println("Okay, let's keep going...");
			}//end inventory if
				
			//NEWLINE FOR READABILITY
			System.out.println();
			
			//PHASE 2
			//all possible options here. currently they are manually activated but that is going to change.
			//to activate an option simply add it to the 'availableOptions' list
			
			//the 'jumpTheVolcano' option is ALWAYS active so the line adding it to the list will always be here.
			//the others will be active depending on some algorithms that are yet to be coded.
			ArrayList<String> availableOptions = new ArrayList<String>();
			availableOptions.add(jumpTheVolcano);
			availableOptions.add(dumpsterDive);
			availableOptions.add(petStore);
			availableOptions.add(arena);
			availableOptions.add(quit);
			
			//I have to declare and initialize these outside of the phase 2 loop.
			//I initialized them with 'jumpTheVolcano' because it is the one option that will always be displayed.
			//There is no way they could possibly exit the phase 2 loop without being assigned to a new option
			//so it is okay to choose any option here
			String option1 = jumpTheVolcano;
			String option2 = jumpTheVolcano;
			String option3 = jumpTheVolcano;
			String option4 = jumpTheVolcano;
			String option5 = jumpTheVolcano;
			
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
				System.out.println("  " + (currentOption + 1) + ") " + availableOptions.get(currentOption));
				
				}//end phase2 loop
			
			//newline for readability
			System.out.println();
			//initialize this var with 'jumpTheVolcano' because that's what I've been using for all
			//option-related initializations
			String chosenOption = jumpTheVolcano;
			//assign 'choosenOption' to the correct value based on the users choice.
			boolean responseIsValid = false;
			while(responseIsValid == false) {
				
				//prompts the user to choose an option
				//arguably the most important line in the game
				int option = intPrompt("Please input the option you would like to carry out: ");
				
				//the following switch converts a # to a String
				//It uses the 'option1', 'option2', etc vars because they are guaranteed to match the # chosen.
				//the actual Strings declared at the beginning of the main method are not assigned a #.
				//the 'option1' vars are "hard-coded" with a number,
				//so when the actual options are displayed on-screen they
				//are assigned a number by being given an 'alias' of sorts through the 'option1' vars.
				//then when the user chooses an option, a new String var is created to signify the users choice ('chosenOption')
				//in String form instead of int form (option). So overall this a just a bunch of code that just moves vars
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
						 System.out.println();
				
				}//end switch
			}//end while
			
			//and finally, after all that jazz...
			System.out.println("You choose " + chosenOption);
			System.out.println();
			//we can use the chosen value to do stuff
			
			
			//PHASE 3
			//contains code for what to do no matter what option is chosen.
			
			//if you try to jump the volcano
			if(chosenOption == jumpTheVolcano) {
				//gen random boolean to decide between whether you successfully jump the volcano or not.
				if(random.nextInt(99) > 79) {
					System.out.println("You jump over the volcano");
				} else {
					System.out.println("You fall into the volcano and die. Wah wah wahhhhh.");
					System.out.println();
					//oh no you have to restart
					player.setHealth(0);
				}
			}//end jump the volcano if
			
			//you dive into the dumpster in search of random items people threw away
			if(chosenOption == dumpsterDive) {
				//choose random item from list of items that are in the dumpster
				
				
				
				System.out.println("test, money+1");
				player.setMoney(player.getMoney() + 1);
			}//end dumpster dive if
			
			if(chosenOption == petStore) {
				System.out.println("test, level+1");
				player.setLevel(player.getLevel() + 1);
			}//end pet store if
			
			if(chosenOption == arena) {
				System.out.println("test, inventory+oldCanOfBeans");
				try {
					player.addItem(Data.oldCanOfBeans);
				} catch(NullPointerException e) {
					
				}
			}//end arena if
			
			if(chosenOption == quit) {
				continuingGame = yesNoPrompt("Do you want to continue playing? ", "y", "n");
			}//end quit if
			
			//HEALTHCHECK
			if(player.getHealth() == 0) {
				System.out.println("It seems you have died. Agoostafus, the angel of ressurection,\nhas offered to ressurect you, but you must lose all your earthly\npossesions and start life from the beggining again.");
				System.out.println();
				continuingGame = yesNoPrompt("Do you accept Agoostafus' offer? ", "y", "n");
				if(continuingGame == true) {
					System.out.println("Okay, please standby. You will be ressurected shortly.");
					player.setMoney(0);
					player.setLevel(0);
					player.setHealth(100);
					boolean inventoryEmpty = false;
					while(inventoryEmpty == false) {
						try {
							player.removeItem(0);
							player.getItem(0);
						} catch(IndexOutOfBoundsException e) {
							inventoryEmpty = true;
						} catch(NullPointerException e) {
							inventoryEmpty = true;
						}//end inventory try-catch
					}//end inventory while
				} else {
					System.out.println("Too bad. I thought it was a good deal, but I guess it is your call...");
					System.out.println("Have fun dying.");
					System.out.println();
				}//end resurrection if-else
			}//end healthcheck
			
			if(continuingGame == true) {
				//MARKS END OF TURN
				//only shown if you didn't quit.
				System.out.println("--------------------------------------------------------------------------");
				System.out.println();
			}//end turnmarker if
			
			//Increase turn counter by one at end of turn
			turns++;
			
		}//end main loop
		
		
		
		//ENDGAME
		System.out.println("Thank you for playing Jump The Volcano. Please play again soon!");
		
		//CLOSE SCANNER
		scanner.close();
		
	}//end main method
}//end main class
