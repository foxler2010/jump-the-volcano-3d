package top.drewssite.volcano;

/**
 * This class provides the game wityh liquids, which can be used to fill bottles, bathe in, and soak/wash things in.
 * @author foxler2010
 * @since v1.0
 * @see Food
 * @see Junk
 * @see Item
 */
public class Liquid extends Food {

    /**
     * A liquid may not be bottled unless this is true.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    private boolean isBottleable;

    /**
     * Returns the bottleability of the liquid.
     * @return Whether the liquid is bottleable or not.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    public boolean getBottleability() {
        return isBottleable;
    }

    /**
     * Returns the bottleability of the liquid.
     * @param isBottleable Whether the liquid is bottleable or not.
     * @author foxler2010
     * @since v1.0
     * @see Liquid
     */
    public void setBottleability(boolean isBottleable) {
        this.isBottleable = isBottleable;
    }

    /**
     * Contructs a new Liquid instance.
     * @param name The name of the liquid.
     * @param price The price of the liquid.
     * @param energy The amount of energy the liquid provides.
     * @param isBottleable Whether the loquid can be bottled or not.
     */
    public Liquid(String name, double price, int energy, boolean isBottleable) {

        super(name, price, energy, false);

        this.isBottleable = isBottleable;

    }
    
}
