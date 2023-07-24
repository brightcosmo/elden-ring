package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.standardactions.ConsumeAction;
import game.enums.ItemStatus;
import game.interfaces.Consumable;

/**
 * A golden seed which, when consumed, increases the maximum amount of flasks a player can have.
 * It is a one-time use item.
 * [Creative requirement]
 *
 * @see ConsumeAction
 * @see Consumable
 *
 * Created by:
 * @author Nisha Kannapper
 */
public class GoldenSeed extends ConsumableItem {

    /**
     * Number of flasks added when item is consumed.
     */
    private final int ADDED_FLASKS = 2;

    /***
     * Constructor.
     */
    public GoldenSeed() {
        super("Golden Seed", ',', true);
    }

    @Override
    public void consume(Actor actor) {
        FlaskOfCrimsonTears.getInstance().addMaxUses(ADDED_FLASKS);
        actor.removeItemFromInventory(this);
    }

    @Override
    public String getConsumeMessage() {
        return "increase flask limit by " + ADDED_FLASKS + " flasks.";
    }

    @Override
    public String getMenuMessage() {
        return "(Increase flask limit by " + ADDED_FLASKS + ")";
    }
}
