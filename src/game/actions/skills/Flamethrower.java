package game.actions.skills;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * An Action to perform an area attack with a flame weapon.
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class Flamethrower extends AreaAttack {

    /**
     * Constructor.
     *
     * @param weapon the weapon used in the area attack
     */
    public Flamethrower(Weapon weapon) {
        super(weapon);
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s uses flamethrower with %s!", actor, getWeapon());
    }
}
