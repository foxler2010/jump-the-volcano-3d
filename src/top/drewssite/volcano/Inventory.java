package top.drewssite.volcano;
import java.util.ArrayList;

//bit of a weird class. this is a rework of the inventory system. It used to be a big list, but I found that I could add many of the same items to it,
//and they would all list out individually, like this: "Old Can of Beans, Old Can of Beans, Old Can of Beans, etc."
//So instead of that I wanted it to be like: "Old Can of Beans x23".
//This system is going to sort the items into separate ArrayLists for each type.


//currently not every type is implemented, so this is going to be a work-in-progress until I have added at least one item for every type.


public class Inventory {
    
    //big list
    private ArrayList<ArrayList<Item>> inventory = new ArrayList<ArrayList<Item>>();

    //constructor doesn't do anything yet.
    public Inventory() {
        
    }

    //add item to inventory
    //depending on the type of item, it will go into a different list.
    public void addItem(Item item) {
        
        //find out item type
        itemType type = item.getType();
        
        //use different lists based on type
        switch (type) {
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
            requestedItem = inventory.get(0).get(index);
            break;
            case FOOD:
            requestedItem = inventory.get(1).get(index);
            break;
            case WEAPON:
            requestedItem = inventory.get(2).get(index);
            break;
            case PET:
            requestedItem = inventory.get(3).get(index);
            break;
            case KIT:
            requestedItem = inventory.get(4).get(index);
            break;
            case MONSTER:
            requestedItem = inventory.get(5).get(index);
            break;
            case OTHER:
            requestedItem = inventory.get(6).get(index);
        }

        //return resulting item
        return requestedItem;
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

    //remove and item from the list; based of of the type and item name
    public void removeItem(itemType type, Item item) {
        
        //use different lists based on type
        switch (type) {
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

        //i realize now this could've been done with a for loop. i will implement it that way some other time.
        if (inventory.get(0).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        if (inventory.get(1).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        if (inventory.get(2).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        if (inventory.get(3).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        if (inventory.get(4).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        if (inventory.get(5).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        if (inventory.get(6).contains(item)) {
            itemIsPresent = true;
            return itemIsPresent;
        } else {
            itemIsPresent = false;
        }

        //so that it returns false when the item does not exist anywhere
        return itemIsPresent;
    }

}
