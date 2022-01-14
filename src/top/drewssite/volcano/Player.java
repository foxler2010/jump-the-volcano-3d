package top.drewssite.volcano;
import java.util.ArrayList;

/**
 *	It's YOU!
 *	This class is special as technically it is an "Item", yet it can hold other Items,
 *	it has a level, money, and among other things you can control it directly.
 *	The class is mainly used to store the player's attributes while giving it Animal properties like the ability to attack

	@author foxler2010
	@see Animal
	@see Item
	@since	v1.0
	@param	name	The "fancy" name of the Player object. Doesn't do anything currently.
	@param	strength	The strength of the player in combat. Does not currently do anything.
	@param	level	The initial experience level of the player. In a regular game this is 0.
	@param	money	The inital amount of money the player has. This is 0 in a regular game.
	@param	startingInventory	This is what the player's inventory will contain when they start the game.
 */
class Player extends Animal {
	
	//VARS
	private int level;
	private double money;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private Inventory inventory2 = new Inventory();
	
	//CONSTRUCTOR
	Player(String name, int strength, int level, double money, ArrayList<Item> startingInventory) {
		super(name, itemType.OTHER, strength, false);
		this.level = level;
		this.money = money;
		this.inventory = startingInventory;

		for (int i = 0; i < startingInventory.size(); i++) {
			inventory2.addItem(startingInventory.get(i));
		}
	}
	
	//GETTERS AND SETTERS
	int getLevel() {
		return level;
	}
	
	double getMoney() {
		return money;
	}
	
	void setLevel(int level) {
		this.level = level;
	}
	
	void setMoney(double money) {
		this.money = money;
	}
	
	//INVENTORY MANAGEMENT
	
	//Returns an item in the inventory.
	//Does NOT remove the item from the list.
	Item getItem(int index) {
		return inventory.get(index);
	}

	Item getItemV2(itemType type, int index) {
		return inventory2.getItem(type, index);
	}
	
	//add an item to the inventory
	void addItem(Item item) {
		inventory.add(item);
	}

	void addItemV2(Item item) {
		inventory2.addItem(item);
	}
	
	//remove something from the inventory
	//shifts everything down one index if the removed item is not the last index
	void removeItem(Item item) {
		inventory.remove(item);
	}

	void removeItemV2(Item item) {
		inventory2.removeItem(item);
	}
	
	void removeItem(int index) {
		inventory.remove(index);
	}

	void removeItemV2(itemType type, int index) {
		inventory2.removeItem(type, index);
	}
	
	//check if the item is in the inventory
	//returns either true or false
	//does not specify the amount of items (if there are multiple copies)
	boolean checkForItem(Item item) {
		return inventory.contains(item);
	}

	boolean checkForItemV2(Item item) {
		return inventory2.checkForItem(item);
	}
	
	//return the index of the inventory item specified
	//if item does not exist, return -1
	//if there are multiple copies of the item in the inventory, return the one with the lowest index
	int indexOfItem(Item item) {
		return inventory.indexOf(item);
	}

	int indexOfItemV2(Item item) {
		return inventory2.indexOfItem(item);
	}
	
	//makes a string with the names of all items in the list
	//this string uses the variable name, not the item's "game name" as specified in the item.name variable
	String inventoryToString() {
		return inventory.toString();
	}

	String inventoryToStringV2() {
		return inventory2.toString();
	}

	String inventoryFancyToString() {
		return inventory2.fancyToString();
	}
	
	int sizeOfInventory() {
		return inventory.size();
	}

	int sizeOfInventoryV2() {
		return inventory2.sizeOfInventory();
	}
	
	//COMBAT
	void attack(Animal target) {
		//not done yet
	}
}
