package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An Action to send an actor to another location or map.
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class TravelAction extends Action {

    /**
     * A string representing the destination
     */
    private String destinationString;
    /**
     * The location to send the actor to
     */
    private Location destination;

    /**
     * Constructor.
     * @param destinationString the name of the destination
     * @param destination a location to travel to
     */
    public TravelAction(String destinationString, Location destination) {
        this.destinationString = destinationString;
        this.destination = destination;
    }

    /**
     * Moves the actor to a preset destination
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, destination);
        return actor + " arrives at " + destinationString;
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels through fog door to " + destinationString;
    }
}

