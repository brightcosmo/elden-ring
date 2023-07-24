package game.weapons;

import game.enums.ItemStatus;
import game.interfaces.Sellable;

/**
 * Grossmesser weapon item used by heavy skeletal swordsmen
 * It deals 115 damage with 85% hit rate
 * also can be used to perform a spinning attack
 * @see game.enemies.HeavySkeletalSwordsman
 * @see game.actions.skills.SpinningAttack
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by: Nisha Kannapper 31121993
 *
 */
public class Grossmesser extends Sword implements Sellable {
    /**
     * Constructor.
     */
    public Grossmesser() {

        super("Grossmesser", '?', 115, "slashes", 85);
        this.setSellingPrice(100);
        this.makeSellable();

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

}