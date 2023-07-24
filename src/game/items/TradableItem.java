package game.items;

import edu.monash.fit2099.engine.items.Item;

/**
 * An item which can be bought and sold.
 * Created by:
 * @author Nisha Kannapper
 */
public class TradableItem extends Item {
    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public TradableItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * Cost to purchase a weapon.
     */
    int cost = 0;

    /**
     * Cost to purchase a weapon using an item.
     */
    Item itemCost;

    /**
     * Selling price of a weapon when selling to a trader.
     */
    int sellingPrice = 0;

    /**
     * Get the cost of the weapon
     * @return The buying price
     */
    public int getCost() {
        return cost;
    }

    /**
     * Get the cost of the weapon
     * @return The buying price
     */
    public Item getItemCost() {
        return itemCost;
    }

    /**
     * Get the selling price of the weapon
     * @return The selling price
     */
    public int getSellingPrice() {
        return sellingPrice;
    }

}
