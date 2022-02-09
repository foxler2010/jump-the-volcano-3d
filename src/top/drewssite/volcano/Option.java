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

            //increase # of visits by 1
            Data.player.setNumOfVolcanoVisits(Data.player.getNumOfVolcanoVisits() + 1);

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

            //increase # of visits by 1
            Data.player.setNumOfDumpsterVisits(Data.player.getNumOfDumpsterVisits() + 1);

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
            
            //increase # of visits by 1
            Data.player.setNumOfShopVisits(Data.player.getNumOfShopVisits() + 1);

            System.out.println("You visit the shop and sell nothing because you are a hoarder.");
            
        }
        
        @Override
        public boolean isAvailable() {
            if (Data.player.sizeOfInventory() >= 5 || Data.player.getMoney() >= 1 || Data.player.getLevel() >= 10 && Data.player.getNumOfShopVisits() > 0) {
                return true;
            } else {
                return false;
            }
        }
    },
    
    SHOP_NEW("(NEW!) Go to the Shop") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.setNumOfShopVisits(Data.player.getNumOfShopVisits() + 1);

        }

        @Override
        public boolean isAvailable() {
            if (Data.player.sizeOfInventory() >= 5 || Data.player.getMoney() >= 1 || Data.player.getLevel() >= 10 && Data.player.getNumOfShopVisits() == 0) {
                return true;
            } else {
                return false;
            }
        }
    },

    PET_STORE("Go to the Pet Store") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.setNumOfPetStoreVisits(Data.player.getNumOfPetStoreVisits() + 1);

        }

        @Override
        public boolean isAvailable() {
            if (Data.player.getMoney() >= 500 && Data.player.getNumOfPetStoreVisits() > 0) {
                return true;
            } else {
                return false;
            }
        }
        
    },

    PET_STORE_NEW("(NEW!) Go to the Pet Store") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.setNumOfPetStoreVisits(Data.player.getNumOfPetStoreVisits() + 1);

        }

        @Override
        public boolean isAvailable() {
            if (Data.player.getMoney() >= 500 && Data.player.getNumOfPetStoreVisits() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
    },

    ARENA("Visit the Arena") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.setNumOfArenaVisits(Data.player.getNumOfArenaVisits() + 1);

        }

        @Override
        public boolean isAvailable() {
            if (Data.turns > 0) {
                return true;
            } else {
                return false;
            }
        }
        
    },

    ARENA_NEW("(NEW!) Visit the Arena") {

        @Override
        public void opCode() {
            
            //increase # of visits by 1
            Data.player.setNumOfArenaVisits(Data.player.getNumOfArenaVisits() + 1);
            
        }

        @Override
        public boolean isAvailable() {
            if (Data.turns == 0) {
                return true;
            } else {
                return false;
            }
        }
        
    },

    QUIT("Exit the game") {

        @Override
        public void opCode() {
            
            Data.continuingGame = Data.yesNoPrompt("Do you want to continue playing? [y/n] ", "y", "n");
            
        }

        @Override
        public boolean isAvailable() {
            return true;
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
    
    /**
     * This method is unique to every value in the Option enum, and when executed runs the code for that Option.
     * If the value in Option does not contain an opCode() method, a default message will be displayed.
     * This default message will never be displayed in the base game, and well-put-together mods should contain an opCode()
     * for every value in Option. If you (the player) are using mods, please consult with the mod's creator for support if you
     * see the default message. It would also wise to examine the code inside the Option enum, as it contains some very important functions.
     * Mod makers, please see the modding documentation at https://drewssite.top/jump-the-volcano/mods
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     */
    public void opCode() {
        System.out.println("WARNING: The option '" + this.getName() + "' option does not have any code yet.");
        System.out.println("It is reccomended to not use this Option as it doesn't do anything. If this Option is intentionally empty, then");
        System.out.println("add an empty opCode() method to this Option's enum value.");
    }

    /**
     * Returns true if the option should be displayed this turn, false otherwise.
     * Modders should create one of these for every option, or else the warning in the super implmentation will be displayed,
     * and the option will be displayed every turn.
     * @author foxler2010
     * @since v1.0
     * @see Option
     * @see Data
     */
    public boolean isAvailable() {
        System.out.println("WARNING: The option '" + this.getName() + "' does not have any availability code yet, availability defaulting to true.");
        System.out.println("If you would like to supress this message, add an empty isAvailable() method to the '" + this.getName() + "' option.");
        return true;
    }

}
