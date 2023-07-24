package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.interfaces.Consumable;


/**
 * An action that consumes one of the actors' consumable items.
 * @see Consumable
 * @see game.items.FlaskOfCrimsonTears
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 * Modified by: Nisha Kannapper
 */
public class ConsumeAction extends Action {


    /**
     * The item
     */
    private final Consumable consumable;

    /**
     * Constructor
     * @param consumable the item to be consumed
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Consume the item, and return a string describing its effect on the actor
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the effect of consuming the item
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        consumable.consume(actor);
        return actor + " consumed the " + consumable + " to " + consumable.getConsumeMessage();
    }

    /**
     * Describes the item consumed, and, if relevant, the remaining number of uses
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes the " + consumable + ". " + consumable.getMenuMessage();
    }
}
