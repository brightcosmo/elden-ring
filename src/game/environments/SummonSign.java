package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.standardactions.RestAction;
import game.actions.standardactions.SummonAction;
import game.enums.Status;

/**
 * A ground that allows the player to summon an NPC.
 * @see game.actions.standardactions.SummonAction
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class SummonSign extends Ground {

    /**
     * Constructor.
     */
    public SummonSign() {
        super('=');
    }

    /**
     * Returns an action list containing a SummonAction.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return An action list containing a SummonAction
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList action = new ActionList();
        action.add(new SummonAction(location));
        return action;
    }
}

