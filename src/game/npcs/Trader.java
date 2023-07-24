package game.npcs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.standardactions.PurchaseAction;
import game.actions.standardactions.PurchaseWithItemAction;
import game.actions.standardactions.SellingItemAction;
import game.actions.standardactions.SellingWeaponAction;
import game.enums.ItemType;
import game.enums.Species;
import game.enums.Status;
import game.enums.ItemStatus;
import game.utils.ItemNameToType;

import java.util.List;

/**
 * An entity that can sell or purchase items from players.
 * @author Nisha Kannapper
 */
public class Trader extends Actor {

    /**
     *List of items that can be purchased by the player from the trader
     */
    List<ItemType> purchaseList;

    /**
     * List of items that can be sold by the player to the trader
     */
    List<ItemType> sellingList;

    /**
     * List of items that can be purchased by the player from the trader using an item as currency
     */
    List<ItemType> purchaseWithItemList;

    /**
     * Contructor for Trader
     * @param name name of trader
     * @param displayChar character to represent trader on map
     * @param hitPoints hitpoints of trader
     * @param purchaseList list of items player can purchase from trader
     * @param sellingList list of items player can sell to trader
     */
    public Trader(String name, char displayChar, int hitPoints, List<ItemType> purchaseList, List<ItemType> sellingList, List<ItemType> purchaseWithItemList) {
        super(name, displayChar, hitPoints);
        this.purchaseList = purchaseList;
        this.sellingList = sellingList;
        this.purchaseWithItemList = purchaseWithItemList;
        this.addCapability(Species.ALLIED);
        this.addCapability(Status.NPC);
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override // actors will trigger this when they get close to a trader
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        // create a new action list to compile all the actions that can be performed on this actor
        ActionList actions = new ActionList();

        // first check if the otherActor can trade with traders
        if (otherActor.hasCapability(Status.CAN_TRADE)) {

            // generates purchase actions based on what the trader sells
            for (ItemType itemType : purchaseList) {
                actions.add(new PurchaseAction(itemType, this));
            }

            // generates purchase with item actions based on what the trader sells
            for (ItemType itemType : purchaseWithItemList) {
                actions.add(new PurchaseWithItemAction(itemType, this));
            }

            // generates selling actions based on inventory
            List<WeaponItem> playerWeapons = otherActor.getWeaponInventory();
            List<Item> playerItems = otherActor.getItemInventory();

            for (WeaponItem weapon : playerWeapons) {

                if (weapon.hasCapability(ItemStatus.SELLABLE_WEAPON) && ItemNameToType.get(weapon.toString()) != null) {
                    if (this.sellingList.contains(
                            ItemNameToType.get(weapon.toString()))
                    ) {
                        actions.add(new SellingWeaponAction(weapon, this));
                    }
                }

            }

            for (Item item : playerItems) {

                if (item.hasCapability(ItemStatus.SELLABLE_ITEM) && ItemNameToType.get(item.toString()) != null) {
                    if (this.sellingList.contains(
                            ItemNameToType.get(item.toString()))
                    ) {
                        actions.add(new SellingItemAction(item, this));
                    }
                }

            }
        }

        return actions;

    }

    /**
     * Select and return an action to perform on the current turn.
     * Traders do not perform any actions currently during each turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return An action which does nothing
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public void hurt(int points) {
    }

}