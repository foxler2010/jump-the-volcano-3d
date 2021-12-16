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

}
