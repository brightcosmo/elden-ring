package game.interfaces;

/**
 * A purchasable interface
 * Created by:
 * @author Nisha Kannapper
 */
public interface Purchasable {

    /**
     * Adds the purchasable capability
     */
    void makePurchasable();

    /**
     * Sets the buying price
     */
    void setCost(int runes);

    /**
     * Gets the buying price
     */
    int getCost();

}
