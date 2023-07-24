package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.ItemType;
import game.npcs.Trader;
import game.runes.RuneManager;
import game.items.ItemFactory;

/**
 * An Action to purchase an item from a Trader.
 * @author Nisha Kannapper
 */
public class PurchaseAction extends Action {

    /**
     * The trader selling the weapon
     */
    Trader trader;

    /**
     * The cost of the weapon
     */
    int cost;

    /**
     * The weapon to be purchased
     */
    WeaponItem item;

    /**
     * Constructor for PurchaseAction
     * @param weapon the weapon being purchased by the player
     * @param trader the trader selling the weapon
     */
    public PurchaseAction(ItemType weapon, Trader trader) {
        this.item = ItemFactory.generateWeaponItem(weapon);
        this.cost = ItemFactory.generatePurchasable(weapon).getCost();
        this.trader = trader;
    }

    /**
     * Check if the actor can purchase the item, then subtracts the runes and adds the item to the inventory if they can
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        boolean result = RuneManager.subtractPlayerRunes(this.cost);
        String retString;

        if (result) {
            actor.addWeaponToInventory(item);
            retString = actor + " has purchased " + item + " for " + cost + " runes.";

        } else {
            retString = actor + " does not have " + cost + " runes to purchase " + item;

        }

        return retString;
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + item + " from " + trader +  " for " + cost + " runes.";
    }
}