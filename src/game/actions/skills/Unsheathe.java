package game.actions.skills;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.standardactions.DeathAction;
import game.enums.Status;
import game.utils.RandomNumberGenerator;

/**
 * An action representing a unique attack where the attacker deals double damage.
 * @see game.weapons.Uchigatana
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Unsheathe extends Action {

    /**
     * The Actor that is to be attacked
     */
    private final Actor target;

    /**
     * The direction of the attack.
     */
    private final String direction;

    /**
     * Weapon used for the attack
     */
    private final Weapon weapon;


    public Unsheathe(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     *
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!(RandomNumberGenerator.getRandomInt(100) < 60)) {
            return actor + " misses " + target + ".";
        }

        // same as attack action, but damage is multiplied by 2
        int damage = weapon.damage()*2;
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious() && !target.hasCapability(Status.UNDEAD)) {
            result += new DeathAction(actor).execute(target, map);
        }

        return result;
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " unsheathes to attack " + target + " at " + direction + " with " + weapon;
    }
}
