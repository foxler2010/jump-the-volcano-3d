package top.drewssite.volcano;

abstract class Item {
	
	//VARS
	private String name;
	private itemType type;
	
	//GETTERS & SETTERS
	String getName() {
		return name;
	}
	
	itemType getType() {
		return type;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setType(itemType type) {
		this.type = type;
	}
	
	Item(String name, itemType type) {
		this.name = name;
		this.type = type;
	}
	
}
