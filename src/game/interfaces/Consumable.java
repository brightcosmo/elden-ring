package game.interfaces;

import edu.monash.fit2099.engine.actors.Actor;
import game.actions.standardactions.ConsumeAction;

/**
 * An interface for all items that can be consumed
 * @see ConsumeAction
 * @see game.items
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public interface Consumable {

    /**
     * Method to consume the consumable item
     * @param actor The actor consuming the item
     */
    void consume(Actor actor);

    /**
     * A message for the ConsumeAction
     * @return A string describing the effect to the actor
     */
    String getConsumeMessage();

    /**
     * A message for the consume action
     * @return A string describing the action to be performed
     */
    String getMenuMessage();


}
