package top.drewssite.volcano;

class Junk extends Item {
	
	//VAR
	private double price;
	
	
	//GETTER AND SETTER
	double getPrice() {
		return price;
	}
	
	void setPrice(double price) {
		this.price = price;
	}
	
	//CONSTRUCTOR
	Junk(String name, double price) {
		super(name, itemType.JUNK);
		this.price = price;
	}

}
