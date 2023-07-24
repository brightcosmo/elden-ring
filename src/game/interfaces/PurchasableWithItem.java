package game.interfaces;

import edu.monash.fit2099.engine.items.Item;

public interface PurchasableWithItem {

    /**
     * Adds the purchasable capability
     */
    void makePurchasableWithItem();

    /**
     * Sets the buying price
     */
    void setItemCost(Item cost);

    /**
     * Gets the buying price
     */
    Item getItemCost();

}
