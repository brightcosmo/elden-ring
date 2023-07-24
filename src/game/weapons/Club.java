package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.enums.ItemStatus;
import game.interfaces.Purchasable;
import game.interfaces.Sellable;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Nisha Kannapper 31121993
 *
 */
public class Club extends TradableWeapon implements Purchasable, Sellable {

    /**
     * Constructor
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
        this.setCost(600);
        this.setSellingPrice(100);
        this.makeSellable();
        this.makePurchasable();
    }

    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
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
