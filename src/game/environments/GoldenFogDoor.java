package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.standardactions.RestAction;
import game.actions.standardactions.TravelAction;
import game.enums.Status;

/**
 * A spawner that spawns Dogs
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class GoldenFogDoor extends Ground {

    /**
     * A string representing the destination
     */
    String destinationString;
    /**
     * The location to send the actor to
     */
    Location destination;

    /**
     * Constructor.
     */
    public GoldenFogDoor(String destinationString, Location destination) {
        super('D');
        this.destinationString = destinationString;
        this.destination = destination;
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList action = new ActionList();
        if (actor.hasCapability(Status.CAN_TRAVEL)) {
            action.add(new TravelAction(destinationString, destination));
        }
        return action;
    }

    /**
     * Override this to implement impassable terrain, or terrain that is only passable if conditions are met.
     *
     * @param actor the Actor to check
     * @return a boolean
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return !actor.hasCapability(Status.NPC);
    }
}

