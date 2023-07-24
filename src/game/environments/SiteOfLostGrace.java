package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actions.standardactions.RestAction;
import game.enums.Status;

/**
 * A special ground which allows the player to rest
 * @see game.actions.standardactions.RestAction
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class SiteOfLostGrace extends Ground {
    /**
     * The name of the Site of Lost Grace
     */
    private String name;

    /**
     * Constructor
     * @param name The name of the Site of Lost Grace
     */
    public SiteOfLostGrace(String name) {
        super('U');
        this.name = name;
    }

    /**
     * Returns the rest action that an actor can use (if they are restable)
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return An action list containing a rest action
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList action = new ActionList();
        if (actor.hasCapability(Status.CAN_REST)) {
            action.add(new RestAction(name));
        }
        return action;
    }

    /**
     * Checks if an actor can enter this ground (only non-NPCs can).
     *
     * @param actor the Actor to check
     * @return
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return !actor.hasCapability(Status.NPC);
    }
}
