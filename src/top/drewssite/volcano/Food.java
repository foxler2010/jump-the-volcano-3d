package top.drewssite.volcano;

public class Food extends Junk {
    
    //VAR
    private int energy;

    public Food(String name, double price, int energy) {

        super(name, price);
        this.energy = energy;
        
    }

}
