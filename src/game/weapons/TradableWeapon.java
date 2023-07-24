package game.weapons;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A weapon which can be bought and sold.
 * Created by:
 * @author Nisha Kannapper
 */
public abstract class TradableWeapon extends WeaponItem {
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public TradableWeapon(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
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
