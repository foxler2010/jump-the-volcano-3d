package top.drewssite.volcano;

/**
 * Here is where all the options and their code is stored. I am putting option docs here as I don't have anywhere else to put them for now
 * To make a new option, add a new enum constant to the list below and put its fancy name in parentheses,
 * along with the code for the option in a method called "opCode()",
 * which should be located in brackets as part of the enum constant.
 * 
 * I have not worked out a way to dynamically add and remove options each turn,
 * other than modifying the main method's code. If you do add a new option, it will not be shown
 * and its code will not be ran until you add in some phrases to the main method in the "PHASE 2" section.
 * If you recieved the game as a binary, you must go download the source code to do this.
 * 
 * After making your option and adding it to the main method, you will have to recompile
 * the game. If using a locally installed JRE, this will not take long. If you would like a system binary,
 * you will have to use some extra tools and things and do it manually, as I have not written a Gradle build script
 * to do it for me.
 * 
 * I will have documentation for how I do it soon.
 * 
 * @author foxler2010
 * @since v1.0
 * @see Main
 * @see Data
 */
public enum Option {
    
    /**
     * This is the code for the "Jump the Volcano" option you get every turn.
     * 
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     * @see Main
     */
    JUMP_THE_VOLCANO("Jump the Volcano") {

        @Override
        public void opCode() {

            //inrcease # of visits by 1
            Data.numOfVolcanoVisits++;

            //gen random boolean to decide between whether you successfully jump the volcano or not.
            //10% chance of success per attempt
			if(Data.random.nextInt(100) > 89) { //success: # between 90 and 99, 10 numbers out of 100 possible = 10%

				System.out.println("You jump over the volcano");

			} else {

				System.out.println("You fall into the volcano and die. *in the distance trombone sounds* Wah wah wahhhhh.");
				System.out.println();

				//oh no you have to restart
				Data.player.setHealth(0);

			}

        }

        @Override
        public boolean isAvailable() {
            return true;
        }

    },

    /**
     * This is the code for the "Dumpster Dive" option you get when you have a small amount of items.
     * 
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     * @see Main
     */
    DUMPSTER_DIVE("Dumpster Dive") {

        @Override
        public void opCode() {

            //inrcease # of visits by 1
            Data.numOfDumpsterVisits++;

            //choose random item from list of items that are in the dumpster
		    Junk randomJunk = Data.junkItems[Data.random.nextInt(Data.junkItems.length)];

		    //add it to player's inventory
		    Data.player.addItem(randomJunk);

		    //tell player what they got
		    System.out.println("You got a " + randomJunk.getName());
		    System.out.println();

        }

        @Override
        public boolean isAvailable() {
            if (Data.player.sizeOfInventory() < 10) {
                return true;
            } else {
                return false;
            }
        }

    },

    SHOP("Go to the Shop") {

        @Override
        public void opCode() {
            
            //inrcease # of visits by 1
            Data.numOfShopVisits++;

        }
    },

    PET_STORE("Go to the Pet Store") {

        @Override
        public void opCode() {
            
            //inrcease # of visits by 1
            Data.numOfPetStoreVisits++;

        }
        
    },

    PET_STORE_NEW("(NEW!) Go to the Pet Store") {

        @Override
        public void opCode() {
            
            //inrcease # of visits by 1
            Data.numOfPetStoreVisits++;

        }
        
    },

    ARENA("Visit the Arena") {

        @Override
        public void opCode() {
            
            //inrcease # of visits by 1
            Data.numOfArenaVisits++;

        }
        
    },

    ARENA_NEW("(NEW!) Visit the Arena") {

        @Override
        public void opCode() {
            
            //inrcease # of visits by 1
            Data.numOfArenaVisits++;
            
        }
        
    },

    QUIT("Exit the game") {

        @Override
        public void opCode() {
            
            Data.continuingGame = Data.yesNoPrompt("Do you want to continue playing? [y/n] ", "y", "n");
            
        }
        
    };
    
    private String name;
    
    private Option(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void opCode() {
        System.out.println("This option does not have any code yet.");
    }

    public boolean isAvailable() {
        System.out.println("WARNING: The option '" + this.getName() + "' does not have any availability code yet, availability defaulting to true.");
        System.out.println("If you would like to supress this message, add an empty isAvailable() method to the '" + this.getName() + "' option.");
        return true;
    }

}
