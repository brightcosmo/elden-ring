package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.skills.Flamethrower;
import game.enums.ItemStatus;
import game.interfaces.PurchasableWithItem;
import game.interfaces.Sellable;
import game.items.RemembranceOfTheGrafted;

/**
 * Godrick's phase two flame weapon, can perform a flamethrower aoe attack
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by: Rys
 *
 */
public class GraftedDragon extends TradableWeapon implements Sellable, PurchasableWithItem {
    /**
     * Constructor.
     */
    public GraftedDragon() {
        super("Grafted Dragon", 'N', 89, "burns", 90);
        this.setSellingPrice(200);
        this.makeSellable();
        this.makePurchasableWithItem();
        this.setItemCost(new RemembranceOfTheGrafted());
    }

    /**
     * Grafted dragon can spit fire in an area using its flamethrower attack
     * @param holder weapon holder
     * @return a flamethrower action
     */
    @Override
    public Action getSkill(Actor holder) {
        return new Flamethrower(this);
    }

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     * @param target target actor
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
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
    public void makePurchasableWithItem() {this.addCapability(ItemStatus.PURCHASABLE_WITH_ITEM);}

    /**
     * Sets the cost for an item
     * @param cost new cost
     */
    public void setItemCost(Item cost) {this.itemCost = cost;}
}