package top.drewssite.volcano;

public class Item {
	
	//VARS
	private String name;
	private double price;
	private itemType type;
	
	//GETTERS & SETTERS
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public itemType getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setType(itemType type) {
		this.type = type;
	}
	
	public Item(String name, double price, itemType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
}
