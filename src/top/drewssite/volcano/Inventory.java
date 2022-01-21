package top.drewssite.volcano;
import java.util.ArrayList;

//Unlike a traditional ArrayList, this one sorts everything into sub-lists.
//The class is more of a wrapper than an object, as it only contains 1 internal variable,
//but it does all the sorting and things automatically, pretty much pretending to be a regualar list.

public class Inventory {
    
    //list of lists
    private ArrayList<ArrayList<Item>> inventory;

    //fills up the newly created ArrayList<ArrayList<Item>> with 7 sub-lists corresponding to the 7 types of items
    Inventory() {
        //initialize big list
        inventory = new ArrayList<ArrayList<Item>>();
        //initialize the sub-lists inside of big list
        inventory.add(new ArrayList<Item>());
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

    //new version in progress
    public String toString() {
        
        //initialize the finalString variable
        String finalString = "";

        //STRUCTURE:
        //loop thru the sub-lists {
            //loop thru each item {
                //add item to finalString
            //}
        //}

        for (int i = 0; i < 6; i++) {

            //each iteration is a different sub-list

            for (int j = 0; j < inventory.get(i).size(); j++) {
                
                //each iteration is a different item

                //fetch the item we are working with, and add its "fancy name" to finalString
                finalString = finalString + inventory.get(i).get(j).getName();

                //add a comma and space, so the next item isn't "hugging" the first
                finalString = finalString + ", ";

            }

        }

        //remove comma + space at the end
        //this singular line took about ~1 month of effort to get right
        finalString = finalString.substring(0, finalString.length() - 2);

        return finalString;

    }

    //new version in progress
    public String fancyToString() {

        //initialize the finalString variable
        String finalString = "";

        //loop thru sub-lists
        for (int i = 0; i < inventory.size(); i++) {

            //initialize alreadyCounted variable
            ArrayList<Item> alreadyCounted = new ArrayList<Item>();

            //loop thru items in sub-lists
            for (int j = 0; j < inventory.get(i).size(); j++) {

                //only run the code if the item could not be found in this list
                if (alreadyCounted.indexOf(inventory.get(i).get(j)) == -1) {
                    
                    //initialize the amountOfItem variable
                    int amountOfItem = 0;

                    //count how many instances of the item are in the sub-list
                    //this includes the one we are looping through
                    for (int k = 0; k < inventory.get(i).size(); k++) {

                        //check if the item with index k is the same as the item we are counting
                        if (inventory.get(i).get(k) == inventory.get(i).get(j)) {
                            amountOfItem++;
                        }

                    }

                    //compile the info we've gathered into a string and add it to finalString
                    //if amountOfItem = 1, exclude the "x1" that would normally be included.
                    if (amountOfItem == 1) {
                        finalString = finalString + inventory.get(i).get(j).getName() + ", ";
                    } else {
                        finalString = finalString + inventory.get(i).get(j).getName() + " x" + amountOfItem + ", ";
                    }
                
                    //add the item to the alreadyCounted list, to make sure we don't count the item again
                    alreadyCounted.add(inventory.get(i).get(j));

                }
                
            }
                
        }

        //remove the comma + space at the end of finalString (since there is no item after it; correct grammar y'know)
        //this singular line took about ~1 month of effort to get right
        //copied from above non-fancy method
        finalString = finalString.substring(0, finalString.length() - 2);

        //return final result
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
