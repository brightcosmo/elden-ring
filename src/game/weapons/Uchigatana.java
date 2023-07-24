package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.skills.Unsheathe;
import game.enums.ItemStatus;
import game.interfaces.Purchasable;
import game.interfaces.Sellable;

/**
 * A weapon which can be bought and sold, and has a special skill "Unsheathe".
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 * Modified by: Nisha Kannapper 31121993
 */
public class Uchigatana extends TradableWeapon implements Purchasable, Sellable {

    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slashes", 80);
        this.setSellingPrice(500);
        this.setCost(5000);
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

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     * @param target target actor
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new Unsheathe(target, direction, this);
    }
}
