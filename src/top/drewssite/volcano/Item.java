package top.drewssite.volcano;

public abstract class Item {
	
	//VARS
	private String name;
	private itemType type;
	private boolean important;
	
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
	
	public boolean isImportant() {
		return important;
	}
	
	public void setImportancy(boolean important) {
		this.important = important;
	}
	
	public Item(String name, itemType type, boolean important) {
		this.name = name;
		this.type = type;
		this.important = important;
	}
	
}
