package top.drewssite.volcano;

public class Player {
	
	private int level;
	private double money;
	
	public Player(int level, double money) {
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
}
