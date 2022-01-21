package top.drewssite.volcano;

abstract class Item {
	
	//VARS
	private String name;
	private itemType type;
	private boolean important;
	
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
	
	boolean isImportant() {
		return important;
	}
	
	void setImportancy(boolean important) {
		this.important = important;
	}
	
	Item(String name, itemType type, boolean important) {
		this.name = name;
		this.type = type;
		this.important = important;
	}
	
}
