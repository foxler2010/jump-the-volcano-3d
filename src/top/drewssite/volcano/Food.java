package top.drewssite.volcano;

public class Food extends Junk {
    
    //VAR
    private int energy;
    private final boolean cookable;
    private boolean cooked;

    //GETTER AND SETTER
	public double getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}

    //CONSTRUCTOR
    public Food(String name, double price, int energy, boolean cookable) {

        super(name, price);
        this.energy = energy;
        this.cookable = cookable;
        this.cooked = false;
        
    }

    public Food(String name, double price, int energy, boolean cookable, boolean cooked) {

        super(name, price);
        this.energy = energy;
        this.cookable = cookable;
        if (!cookable) {
            cooked = false;
        } else {
            this.cooked = false;
        }
        
    }

}
