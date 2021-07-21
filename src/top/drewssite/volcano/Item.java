package top.drewssite.volcano;

public abstract class Item {
	
	//VARS
	private String name;
	private itemType type;
	
	//GETTERS & SETTERS
	public String getName() {
		return name;
	}
	
	public itemType getType() {
		return type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setType(itemType type) {
		this.type = type;
	}
	
	public Item(String name, itemType type) {
		this.name = name;
		this.type = type;
	}
	
}
