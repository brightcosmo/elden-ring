package game.weapons;

import game.enums.ItemStatus;
import game.interfaces.Purchasable;
import game.interfaces.Sellable;

/**
 * Scimitar weapon item used by skeletal bandits
 * It deals 118 damage with 88% hit rate
 * also can be used to perform a spinning attack
 * @see game.enemies.SkeletonBandit
 * @see game.actions.skills.SpinningAttack
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by: Nisha Kannapper 31121993
 *
 */
public class Scimitar extends Sword implements Purchasable, Sellable {

    /**
     * Constructor.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "slices", 88);
        this.setCost(600);
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