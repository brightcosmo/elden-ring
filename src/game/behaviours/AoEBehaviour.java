package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.skills.AreaAttack;
import game.enemies.AoECapable;
import game.enums.Species;
import game.enums.Status;
import game.utils.RandomNumberGenerator;

/**
 * A class that figures out if an aoe capable actor is able to perform their aoe attack
 * @see AreaAttack
 * @see AoECapable
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class AoEBehaviour implements Behaviour {

    /**
     * The object performing the aoe attack
     */
    AoECapable holder;

    /**
     * Constructor.
     * @param holder the object performing the aoe attack with a weapon
     */
    public AoEBehaviour(AoECapable holder) {
        this.holder = holder;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                Actor currActor = exit.getDestination().getActor();
                if (currActor.hasCapability(Status.HOSTILE_TO_ENEMY) || (currActor.hasCapability(Status.HOSTILE_TO_PLAYER) && !(currActor.findCapabilitiesByType(Species.class).equals(actor.findCapabilitiesByType(Species.class))))) {
                    int randomInt = RandomNumberGenerator.getRandomInt(1,100);
                    if (50 >= randomInt) {
                        return holder.getAoEWeapon().getSkill(actor);
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
