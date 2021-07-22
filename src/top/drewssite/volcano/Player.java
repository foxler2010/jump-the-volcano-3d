package top.drewssite.volcano;
import java.util.ArrayList;

//It's YOU!
//This class is special as technically it is an "Item", yet it can hold other Items,
//it has a level, money, and among other things you can control it directly.
//The class is mainly used to store the player's attributes while giving it Animal properties like the ability to attack
public class Player extends Animal {
	
	//VARS
	private int level;
	private double money;
	private ArrayList<Item> inventory;
	
	//CONSTRUCTOR
	public Player(String name, int strength, int level, double money, ArrayList<Item> startingInventory) {
		super(name, itemType.OTHER, strength);
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
	
	//return an item in the inventory
	//does NOT remove the item from the list
	public Item getItem(int index) {
		return inventory.get(index);
	}
	
	//add an item to the inventory
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	//remove item from inventory
	//shifts everything down one index if the removed item is not the last index
	public void removeItem(Item item) {
		inventory.remove(item);
	}
	
	//check if the item is in the inventory
	//returns either true or false
	//does not specify the amount of items (if there are multiple copies)
	public boolean checkForItem(Item item) {
		return inventory.contains(item);
	}
	
	//return the index of the inventory item specified
	//if item does not exist, return -1
	//if there are multiple copies of the item in the inventory, return the one with the lowest index
	public int indexOfItem(Item item) {
		return inventory.indexOf(item);
	}
	
	//makes a string with the names of all items in the list
	//this string uses the variable name, not the item's "game name" as specified in the item.name variable
	public String inventoryToString() {
		return inventory.toString();
	}
	
	//COMBAT
	public void attack(Animal target) {
		//not done yet
	}
}
