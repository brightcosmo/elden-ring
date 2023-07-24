package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.standardactions.ConsumeAction;
import game.enums.ItemStatus;
import game.interfaces.Consumable;

/**
 * A sacred tear which, when consumed, increases the potency of healing provided by a player's flasks.
 * It is a one-time use item.
 * [Creative requirement]
 *
 * @see ConsumeAction
 * @see Consumable
 *
 * Created by:
 * @author Nisha Kannapper
 */
public class SacredTear extends ConsumableItem {

    /**
     * Amount of healing added to flask's heal amount when consumed
     */
    private final int ADDED_HEAL = 12;

    /***
     * Constructor.
     */
    public SacredTear() {
        super("Sacred Tear", ',', true);
    }

    @Override
    public void consume(Actor actor) {
        FlaskOfCrimsonTears.getInstance().addHealAmount(ADDED_HEAL);
        actor.removeItemFromInventory(this);
    }

    @Override
    public String getConsumeMessage() {
        return "increase flask potency by " + ADDED_HEAL + " HP.";
    }

    @Override
    public String getMenuMessage() {
        return "(Increase flask potency by " + ADDED_HEAL + ")";
    }
}
