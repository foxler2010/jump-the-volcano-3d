package top.drewssite.volcano;

//it's an item that is alive
//it also has some extra alive-stuff-only attributes (health, strength, etc)
abstract class Animal extends Item {

	//VAR
	private int strength;
	
	//GETTER AND SETTER
	int getStrength() {
		return strength;
	}
	
	void setStrength(int strength) {
		this.strength = strength;
	}
	
	//CONSTRUCTOR takes in name and price and sets the type to itemType.PET automatically
	Animal(String name, itemType type, int strength) {
		//this line confused me as i did not understand the 'super' keyword very well,
		//Eclipse added it automatically and I did not know why
		
		//It calls the 'Item' class constructor and gives it the name, price, and type parameters.
		super(name, type);
		
		//don't forget about the new animal-only stuff
		this.strength = strength;
	}
	
	abstract void attack(Animal target);
	
}
