package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enums.ItemType;
import game.npcs.Trader;
import game.utils.ItemNameToType;
import game.items.ItemFactory;

import java.util.List;

/**
 * An Action to purchase an item from a Trader using an item.
 * @author Nisha Kannapper
 */
public class PurchaseWithItemAction extends Action {

    /**
     * The trader selling the weapon
     */
    Trader trader;

    /**
     * The cost of the weapon
     */
    Item cost;

    /**
     * The weapon to be purchased
     */
    WeaponItem item;

    /**
     * Constructor for PurchaseAction
     * @param weapon the weapon being purchased by the player
     * @param trader the trader selling the weapon
     */
    public PurchaseWithItemAction(ItemType weapon, Trader trader) {
        this.item = ItemFactory.generateWeaponItem(weapon);
        this.cost = ItemFactory.generatePurchasableWithItem(weapon).getItemCost();
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

        List<Item> inventory = actor.getItemInventory();
        boolean result = false;
        for (int i = 0; i < inventory.size(); i++){
            if (ItemNameToType.get(inventory.get(i).toString()) == ItemNameToType.get(this.cost.toString())){
                result = true;
                actor.removeItemFromInventory(inventory.get(i));
            }
        }
        String retString;

        if (result) {
            actor.addWeaponToInventory(item);
            retString = actor + " traded for " + item + " in exchange for " + cost + ".";

        } else {
            retString = actor + " does not have " + cost + ", so they cannot trade for " + item;

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
        return actor + " trades for " + item + " from " + trader +  " using " + cost + ".";
    }
}
