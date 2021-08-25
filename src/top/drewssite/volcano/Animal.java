package top.drewssite.volcano;

//it's an item that is alive
//it also has some extra alive-stuff-only attributes (health, strength, etc)
abstract class Animal extends Item {

	//VAR
	private int strength;
	private int health;
	
	//GETTERS AND SETTERS
	int getStrength() {
		return strength;
	}
	
	void setStrength(int strength) {
		this.strength = strength;
	}
	
	int getHealth() {
		return health;
	}
	
	void setHealth(int health) {
		//big attacks don't give you negative health
		if (health >= 0) {
			this.health = health;
		} else {
			this.health = 0;
		}
	}
	
	//CONSTRUCTOR takes in name and price and sets the type to itemType.PET automatically
	Animal(String name, itemType type, int strength, boolean important) {
		//this line confused me as i did not understand the 'super' keyword very well,
		//Eclipse added it automatically and I did not know why
		
		//It calls the 'Item' class constructor and gives it the name, price, and type parameters.
		super(name, type, important);
		
		//don't forget about the new animal-only stuff
		this.strength = strength;
		this.health = 100;
	}
	
	abstract void attack(Animal target);
	
}
