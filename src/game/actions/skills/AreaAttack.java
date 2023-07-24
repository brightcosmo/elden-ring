package game.actions.skills;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.standardactions.AttackAction;

/**
 * A class that extends action and represents an area of effect attack.
 * Creates and executes unique attack actions on every actor instance in proximity to the holder
 * @see game.enemies.AoECapable
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */

public abstract class AreaAttack extends Action {

    /**
     * Weapon used in the area attack
     */
    Weapon weapon;

    /**
     * Constructor.
     * @param weapon the weapon used in the area attack
     */
    public AreaAttack(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        StringBuilder result = new StringBuilder();
        result.append(menuDescription(actor));

        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            if (exit.getDestination().containsAnActor()) {
                Actor target = exit.getDestination().getActor();
                result.append("\n").append(new AttackAction(target, exit.getName(), getWeapon()).execute(actor, map));
            }
        }

        // print results
        return result.toString();
    }

    /**
     * Get the weapon used in the area attack
     * @return the weapon being used in the action
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Set the weapon used in the area attack
     * @param weapon the weapon being used in the action
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
