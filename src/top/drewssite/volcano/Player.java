package top.drewssite.volcano;

//It's YOU!
//This class is special as technically it is an "Item", yet it can hold other Items,
//it has a level, money, and among other things you can control it directly.
//The class is mainly used to store the player's attributes while giving it Animal properties like the ability to attack
public class Player extends Animal {
	
	private int level;
	private double money;
	
	public Player(String name, int strength, int level, double money) {
		super(name, itemType.OTHER, strength);
		this.level = level;
		this.money = money;
	}
	
	//getters and setters
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

	public void attack(Animal target) {
		//not done yet
	}
}
