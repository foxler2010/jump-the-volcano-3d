package top.drewssite.volcano;
import java.util.ArrayList;

//bit of a weird class. this is a rework of the inventory system. It used to be a big list, but I found that I could add many of the same items to it,
//and when the inventory is displayed they would all list out individually, like this: "Old Can of Beans, Old Can of Beans, Old Can of Beans, etc."
//So instead of that I wanted it to be like: "Old Can of Beans x23".
//This system is going to sort the items into separate ArrayLists for each type.

//currently not every type is implemented, so I can't test every type. That doesn't mean I need to test every type, though. So far I think I'm good.


public class Inventory {
    
    //list of lists
    private ArrayList<ArrayList<Item>> inventory;

    //used to not do anything. realized I was doing it wrong and made it do what it is supposed to do.
    //view earlier commits to see what was going on under my nose.
    Inventory() {
        //initialize big list
        inventory = new ArrayList<ArrayList<Item>>();
        //initialize little sub-lists inside of big list
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
        inventory.add(new ArrayList<Item>());
    }

    //add item to inventory
    //depending on the type of item, it will go into a different list.
    void addItem(Item item) {
        
        //use different lists based on type
        switch (item.getType()) {
            case JUNK:
            inventory.get(0).add(item);
            break;
            case FOOD:
            inventory.get(1).add(item);
            break;
            case WEAPON:
            inventory.get(2).add(item);
            break;
            case PET:
            inventory.get(3).add(item);
            break;
            case KIT:
            inventory.get(4).add(item);
            break;
            case MONSTER:
            inventory.get(5).add(item);
            break;
            case OTHER:
            inventory.get(6).add(item);
        }
    }

    //return the item at a specified type and index
    Item getItem(itemType type, int index) {
        
        //initialize as null, because it will throw an error if I don't
        Item requestedItem = null;

        //use different lists based on type
        switch (type) {
            case JUNK:
            return requestedItem = inventory.get(0).get(index);
            case FOOD:
            return requestedItem = inventory.get(1).get(index);
            case WEAPON:
            return requestedItem = inventory.get(2).get(index);
            case PET:
            return requestedItem = inventory.get(3).get(index);
            case KIT:
            return requestedItem = inventory.get(4).get(index);
            case MONSTER:
            return requestedItem = inventory.get(5).get(index);
            case OTHER:
            return requestedItem = inventory.get(6).get(index);
            //because it thinks there are more enum states
            default:
            return requestedItem;
        }

    }

    //remove and item from the list; based of of the type and index
    void removeItem(itemType type, int index) {
        
        //use different lists based on type
        switch (type) {
            case JUNK:
            inventory.get(0).remove(index);
            break;
            case FOOD:
            inventory.get(1).remove(index);
            break;
            case WEAPON:
            inventory.get(2).remove(index);
            break;
            case PET:
            inventory.get(3).remove(index);
            break;
            case KIT:
            inventory.get(4).remove(index);
            break;
            case MONSTER:
            inventory.get(5).remove(index);
            break;
            case OTHER:
            inventory.get(6).remove(index);
        }

    }

    //remove an item from the list; based off of item name
    void removeItem(Item item) {
        
        //use different lists based on type
        switch (item.getType()) {
            case JUNK:
            inventory.get(0).remove(item);
            break;
            case FOOD:
            inventory.get(1).remove(item);
            break;
            case WEAPON:
            inventory.get(2).remove(item);
            break;
            case PET:
            inventory.get(3).remove(item);
            break;
            case KIT:
            inventory.get(4).remove(item);
            break;
            case MONSTER:
            inventory.get(5).remove(item);
            break;
            case OTHER:
            inventory.get(6).remove(item);
        }

    }

    //see if an item is in the player's inventory
    boolean checkForItem(Item item) {

        //initialize as false, because it will throw an error if I don't
        boolean itemIsPresent = false;

        //for every sub-list, check for the item.
        //if true, return the result immediately so that the boolean won't get messed with by the other if statements.
        for (int i = 0; i <=6; i++) {
            if (inventory.get(0).contains(item)) {
                itemIsPresent = true;
                return itemIsPresent;
            } else {
                itemIsPresent = false;
            }
        }

        return itemIsPresent;

    }

    //find the index of an item. the index is relative to the sub-list the item is inside of.
    //the type does not have to be given, because we can just look at the attributes of the item to find it.
    //returns -1 if the item is nonexistent.
    int indexOfItem(Item item) {

        //use different lists based on type
        switch (item.getType()) {
            case JUNK:
            return inventory.get(0).indexOf(item);
            case FOOD:
            return inventory.get(1).indexOf(item);
            case WEAPON:
            return inventory.get(2).indexOf(item);
            case PET:
            return inventory.get(3).indexOf(item);
            case KIT:
            return inventory.get(4).indexOf(item);
            case MONSTER:
            return inventory.get(5).indexOf(item);
            case OTHER:
            return inventory.get(6).indexOf(item);
            //because it thinks there are more enum states
            default:
            return -1;
        }

    }

    //has to be public as it inherits the Object class' version of it, which is public.
    //this is guaranteed to work and show all the info, but it might be a bit hard to interpret
    public String toString() {
        
        //initialize string
        String string = "[";

        //loop thru all sub-lists - 1
        for (int i = 0; i <= 5; i++) {
            //loop thru every item in sub-list
            for (int j = 0; j < inventory.get(i).size(); j++) {
                //string = [item name, item name, item name, etc.]
                //the fancy name not the variable name...
                string = string + inventory.get(i).get(j).getName() + ", ";
            }
        }

        //last sub-list, minus the last item
        for (int i = 0; i < inventory.get(6).size() - 1; i++) {
            //same as above
            string = string + inventory.get(6).get(i).getName() + ", ";
        }

        //last item, this must be separate so that it can omit the comma and space at the end
        string = string + inventory.get(6).get(inventory.size() - 1).getName();

        //add closing bracket
        string = string + "]";

        //return result
        return string;

        //I thought that would be easier to code... hopefully it works properly...
    }

    //does not work because it is very complicated and I made some mistakes programming it,
    //but the info will be a LOT easier to understand when it works.
    public String fancyToString() {


        //INITIALIZE VARS


        //the item being counted
        //used to create currentList
        Item currentItem;

        //the amount of the item that has been counted so far
        //used to create currentList
        int amountOfCurrentItem;

        //string representing all the info on all the items in that sub-list (ex. Old Can of Beans x23, Poop Sock x5)
        //this is what is added to finalString
        String currentList;

        //the final output
        //returned at the end of the function
        String finalString = null;


        //MAIN FUNCTION LOOP


        //FOR EVERY SUB-LIST (EXCEPT 6):
        for (int i = 0; i <= 5; i++) {

            //LOOP THRU ALL ITEMS IN SUB-LIST:
            for (int j = 1; j < inventory.get(i).size(); j++) {

                //assign currentItem to the item we are looping thru right now 
                currentItem = inventory.get(i).get(j);

                //right now the prgm knows there is at least 1 of the currentItem,
                //so make amountOfCurrentItem equal to 1
                amountOfCurrentItem = 1;

                //COUNTING LOOP
                //loop thru every item in sub-list (again)
                //(the first one has already been counted so it is skipped)
                for (int k = 1; k < inventory.get(i).size(); k++) {

                    //if the item we are looking at is the same as currentItem then add 1 to amountOfCurrentItems
                    if (inventory.get(i).get(k) == currentItem) {
                        amountOfCurrentItem++;
                    }
                    //if it is not the same then skip it for now

                }

                //add the processed info to a string representing the sub-list
                currentList = currentItem.getName() + " x" + amountOfCurrentItem + ", ";

            }

            //do last item separately,
            //so that currentList is formatted the right way
            //assign currentItem to the last item
            //if the list is empty then set amountOfCurrentItem to 0
            //and make currentItem null so it gets initialized somewhere
            try {
                currentItem = inventory.get(i).get(inventory.get(i).size() - 1);
                amountOfCurrentItem = 1;
            } catch (IndexOutOfBoundsException e) {
                currentItem = null;
                amountOfCurrentItem = 0;
            }

            //COUNTING LOOP
            //loop thru every item in sub-list
            //(the first one has already been counted so it is skipped)
            for (int k = 1; k < inventory.get(i).size(); k++) {

                //if the item we are looking at is the same as currentItem then add 1 to amountOfCurrentItems
                if (inventory.get(i).get(k) == currentItem) {
                    amountOfCurrentItem++;
                }
                //if it is not the same then skip it for now

            }
            
            //add the processed info to a string representing the sub-list
            //comma at end is ommitted; that's the whole reason for separating the last item.
            //if list is empty, the null avalanche turns currentList null too
            try {
                currentList = currentItem.getName() + " x" + amountOfCurrentItem;
            } catch (NullPointerException e) {
                currentList = null;
            }

            //ADD THE SUB-LIST TO THE FINAL STRING
            //this trycatch is the end of the null avalanche
            //finalString will just ignore the list if it is null
            //that will eliminate the nulling of everything
            try {
                finalString = finalString + currentList + ", ";
            } catch (NullPointerException e) {
                //do nothing, finalString is as final as it an get
            }

        }

        //DO LAST SUB-LIST SEPARATELY
        //you guessed it, we gotta remove the comma
        
        //LOOP THRU ALL ITEMS IN SUB-LIST:
        for (int j = 1; j < inventory.get(5).size(); j++) {

            //assign currentItem to the item we are looping thru right now 
            currentItem = inventory.get(5).get(j);

            //right now the prgm knows there is at least 1 of the currentItem,
            //so make amountOfCurrentItem equal to 1
            amountOfCurrentItem = 1;

            //COUNTING LOOP
            //loop thru every item in sub-list (again)
            //(the first one has already been counted so it is skipped)
            for (int k = 1; k < inventory.get(5).size(); k++) {

                //if the item we are looking at is the same as currentItem then add 1 to amountOfCurrentItems
                if (inventory.get(5).get(k) == currentItem) {
                    amountOfCurrentItem++;
                }
                //if it is not the same then skip it for now

            }

            //add the processed info to a string representing the sub-list
            currentList = currentItem.getName() + " x" + amountOfCurrentItem;

        }

        //do last item separately,
        //so that currentList is formatted the right way
        //first, set currentItem to last item in the last list,
        //and use this statement to see if the list is empty or not.
        boolean isEmpty = false;
        try {
            //this throws IndexOutOfBoundException if the list is empty
            currentItem = inventory.get(5).get(inventory.get(5).size() - 1);
        } catch (IndexOutOfBoundsException e) {
            //set isEmpty to false if we get an exception
            isEmpty = true;
            //set currentItem to null so the code in the if statement doesn't get confused
            currentItem = null;
        }

        //the last item is only processed if it exists
        //if the list is empty this block of code is not run
        if (isEmpty == false) {
            
            //used to be in an above statement, but it was moved down here because sometimes the last item doesn't exist, so a comma is not needed.
            currentList = null;
            currentList = currentList + ", ";

            //right now the prgm knows there is at least 1 of the currentItem,
            //so make amountOfCurrentItem equal to 1
            amountOfCurrentItem  = 1;

            //COUNTING LOOP
            //loop thru every item in sub-list
            //(the first one has already been counted so it is skipped)
            for (int k = 1; k < inventory.get(5).size(); k++) {

                //if the item we are looking at is the same as currentItem then add 1 to amountOfCurrentItems
                if (inventory.get(5).get(k) == currentItem) {
                    amountOfCurrentItem++;
                }
                //if it is not the same then skip it for now

            }
        
            //add the processed info to a string representing the sub-list
            //comma at end is ommitted; that's the whole reason for separating the last item.
            currentList = currentItem.getName() + " x" + amountOfCurrentItem;
        }
        
        //ADD THE SUB-LIST TO THE FINAL STRING
        currentList = null;
        finalString = finalString + currentList;

        //return result
        return finalString;

    }

    //same as with toString but with integers. a lot easier to deal with if you ask me.
    int sizeOfInventory() {
        
        int size = inventory.get(0).size();

        for (int i = 1; i < 6; i++) {
            size = size + inventory.get(i).size();
        }

        return size;

    }

}
