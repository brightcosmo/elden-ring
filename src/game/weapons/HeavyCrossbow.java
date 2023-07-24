package game.weapons;

import game.enums.ItemStatus;
import game.interfaces.Purchasable;
import game.interfaces.Sellable;

/**
 * Heavy Crossbow weapon item used by Godrick's soldiers
 * It deals 64 damage with 57% hit rate
 * @see game.enemies.GodrickSoldier
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by: Nisha Kannapper 31121993
 *
 */
public class HeavyCrossbow extends TradableWeapon implements Purchasable, Sellable {

    /**
     * Constructor.
     */
    public HeavyCrossbow() {
        super("Heavy Crossbow", '}', 64, "shoots", 57);
        this.setCost(1500);
        this.setSellingPrice(100);
        this.makeSellable();
        this.makePurchasable();
    }

    /**
     * Make the item sellable
     */
    public void makeSellable() {this.addCapability(ItemStatus.SELLABLE_WEAPON);}

    /**
     * Sets the selling price for an item
     * @param runes new selling price
     */
    public void setSellingPrice(int runes) {sellingPrice = runes;}

    /**
     * Make the item purchasable
     */
    public void makePurchasable() {this.addCapability(ItemStatus.PURCHASABLE);}

    /**
     * Sets the cost for an item
     * @param runes new cost
     */
    public void setCost(int runes) {cost = runes;}

}
