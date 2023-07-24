package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.standardactions.DeathAction;
import game.enemies.Enemy;
import game.enums.Status;

/**
 * A Ground that kills the player when they step off it
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class Cliff extends Ground {

    /**
     * Constructor.
     */
    public Cliff() {
        super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return !actor.hasCapability(Status.NPC);
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()) { // check if the location contains an actor
            new Display().println(new DeathAction().execute(location.getActor(), location.map()));
        }
    }
}

