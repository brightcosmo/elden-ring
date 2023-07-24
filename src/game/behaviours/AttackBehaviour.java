package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.skills.AreaAttack;
import game.actions.standardactions.AttackAction;
import game.enums.Species;
import game.enums.Status;

/**
 * A class figures out if an actor is able to attack anything in its vicinity
 * @see AttackAction
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Checks to see if there are any valid targets surrounding the actor
     * if there are, returns a new attack action with the actors intrinsic weapon or a weapon item
     * @param actor the attacking actor
     * @param map the game map the attacker and target are on
     * @return an AttackAction that actor can perform, or null if actor can't attack anything.
     */
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {

            if (exit.getDestination().containsAnActor()) {
                Actor currActor = exit.getDestination().getActor();
                if (currActor.hasCapability(Status.HOSTILE_TO_ENEMY) || currActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                    if (!(currActor.findCapabilitiesByType(Species.class).equals(actor.findCapabilitiesByType(Species.class)))) {
                        Weapon weapon = actor.getWeaponInventory().size() == 0 ? actor.getIntrinsicWeapon() : actor.getWeaponInventory().get(0);
                        return new AttackAction(currActor, exit.getName(), weapon);
                    }
                }
            }
        }
        return null;
    }
}
