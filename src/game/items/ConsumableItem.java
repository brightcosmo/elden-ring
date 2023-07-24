package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.actions.standardactions.ConsumeAction;
import game.interfaces.Consumable;

/**
 * An abstract class extending Item for Consumable items.
 * @see game.interfaces.Consumable
 * @author Nisha Kannapper
 */
abstract class ConsumableItem extends Item implements Consumable {

    private ConsumeAction consumeAction;

    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public ConsumableItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        consumeAction = new ConsumeAction(this);
        this.addAction(consumeAction);
    }

    /**
     * Return the consumeAction belonging to this consumable.
     *
     * @return
     */
    public ConsumeAction getConsumeAction() {
        return consumeAction;
    }

    /**
     * Set the consume action again, this may be necessary if the item changes.
     *
     * @param consumeAction the new consumeAction
     */
    public void setConsumeAction(ConsumeAction consumeAction) {
        this.consumeAction = consumeAction;
    }
}
