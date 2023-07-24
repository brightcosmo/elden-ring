package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.npcs.Trader;
import game.runes.RuneManager;
import game.utils.ItemNameToType;
import game.items.ItemFactory;

/**
 * An Action to sell an item to a Trader.
 * @author Nisha Kannapper
 */
public class SellingItemAction extends Action {

    /**
     * The trader buying the item
     */
    Trader trader;

    /**
     * The selling price for this item
     */
    int sellingPrice;

    /**
     * The weapon to be sold
     */
    Item item;

    /**
     * Constructor for SellingItemAction
     * @param item the weapon being sold to the trader
     * @param trader the trader buying the weapon
     */
    public SellingItemAction(Item item, Trader trader) {
        this.item = item;
        this.sellingPrice = ItemFactory.generateSellable(ItemNameToType.get(item.toString())).getSellingPrice();
        this.trader = trader;
    }

    /**
     * Sell the item for runes
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string explaining what was sold and its price
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        RuneManager.addPlayerRunes(this.sellingPrice);
        actor.removeItemFromInventory(this.item);

        return actor + " has sold " + item + " for " + sellingPrice + " runes.";
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + item + " to " + trader + " for " + sellingPrice + " runes.";
    }
}
