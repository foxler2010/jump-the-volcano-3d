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
    public Inventory() {
        inventory = new ArrayList<ArrayList<Item>>();
    }

    //add item to inventory
    //depending on the type of item, it will go into a different list.
    public void addItem(Item item) {
        
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
    public Item getItem(itemType type, int index) {
        
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
    public void removeItem(itemType type, int index) {
        
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
    public void removeItem(Item item) {
        
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
    public boolean checkForItem(Item item) {

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
    public int indexOfItem(Item item) {

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

    public String toString() {
        
        //initialize string with first sub-list (so it doesn't have to be null)
        String string = inventory.get(0).toString();

        //loop thru all other sub-lists
        for (int i = 1; i <= 6; i++) {
            string = string + inventory.get(i).toString();
        }

        //return result
        return string;

        //I thought that would be harder to code... hopefully it works properly...
    }

    //same as with toString but with integers. a lot easier to deal with if you ask me.
    public int sizeOfInventory() {
        
        int size = inventory.get(0).size();

        for (int i = 1; i <= 6; i++) {
            size = size + inventory.get(i).size();
        }

        return size;

    }

}
