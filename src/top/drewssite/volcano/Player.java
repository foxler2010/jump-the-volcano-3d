package top.drewssite.volcano;

/**
 *	It's YOU!
 *	This class is special as technically it is an "Item", yet it can hold other Items,
 *	it has a level, money, and among other things you can control it directly.
 *	The class is mainly used to store the player's attributes while giving it Animal properties like the ability to attack
 *	@author foxler2010
 *	@see Animal
 *	@see Item
 *	@since	v1.0
 */
class Player extends Animal {
	
	//VARS
	private int level;
	private double money;
	private Inventory inventory = new Inventory();
	
	/**
	 * The constructor for the Player class
	 * @author foxler2010
	 * @see Player
	 * @since v1.0
	 * @param name	The "fancy" name of the Player object. Doesn't do anything currently.
	 * @param strength	The strength of the player in combat. Does not currently do anything.
	 * @param level	The initial experience level of the player. In a regular game this is 0.
	 * @param money	The inital amount of money the player has. This is 0 in a regular game.
	 * @param startingInventory	This is what the player's inventory will contain when they start the game.
	 */
	public Player(String name, int strength, int level, double money, Inventory startingInventory) {
		super(name, ItemType.OTHER, strength, false);
		this.level = level;
		this.money = money;
		this.inventory = startingInventory;
	}
	
	//GETTERS AND SETTERS
	public int getLevel() {
		return level;
	}
	
	public double getMoney() {
	return money;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	//INVENTORY MANAGEMENT
	
	//Returns an item in the inventory.
	//Does NOT remove the item from the list.
	public Item getItem(ItemType type, int index) {
		return inventory.getItem(type, index);
	}
	
	//add an item to the inventory
	public void addItem(Item item) {
		inventory.addItem(item);
	}
	
	//remove something from the inventory
	//shifts everything in the sub-list down one index if the removed item is not the last index
	public void removeItem(Item item) {
		inventory.removeItem(item);
	}

	public void removeItem(ItemType type, int index) {
		inventory.removeItem(type, index);
	}

	public void removeItem(int typeIndex, int index) {
		inventory.removeItem(typeIndex, index);
	}
	
	//check if the item is in the inventory
	//returns either true or false
	//does not specify the amount of items (if there are multiple copies)
	public boolean checkForItem(Item item) {
		return inventory.checkForItem(item);
	}
	
	//return the index of the inventory item specified
	//if item does not exist, return -1
	//if there are multiple copies of the item in the inventory, return the one with the lowest index
	public int indexOfItem(Item item) {
		return inventory.indexOfItem(item);
	}
	
	//makes a string with the names of all items in the inventory
	public String inventoryToString() {
		return inventory.toString();
	}

	//same as above method, but the String lists two items as "itemName x2", instead of "itemName, itemName, etc."
	//almost always more useful
	public String inventoryFancyToString() {
		return inventory.fancyToString();
	}

	//returns the number of items in the inventory
	public int sizeOfInventory() {
		return inventory.sizeOfInventory();
	}

	public int sizeOfSubList(int subListIndex) {
		return inventory.sizeOfSubList(subListIndex);
	}
	
	//COMBAT
	public void attack(Animal target) {
		//not done yet
	}
}
