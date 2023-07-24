package game.interfaces;

/**
 * A purchasable interface
 * Created by:
 * @author Nisha Kannapper
 */
public interface Sellable {

    /**
     * Adds the purchasable capability
     */
    void makeSellable();

    /**
     * Sets the buying price
     */
    void setSellingPrice(int runes);

    /**
     * Gets the buying price
     */
    int getSellingPrice();

}
