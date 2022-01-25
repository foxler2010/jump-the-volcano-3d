package top.drewssite.volcano;

public class Food extends Junk {
    
    //VAR
    private int energy;

    //GETTER AND SETTER
	public double getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}

    //CONSTRUCTOR
    public Food(String name, double price, int energy) {

        super(name, price);
        this.energy = energy;
        
    }

}
