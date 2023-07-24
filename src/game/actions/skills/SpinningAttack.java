package game.actions.skills;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * A class that extends AreaAttack and represents an area attack using a sword weapon item
 * @see AreaAttack
 * @see game.weapons.Sword
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class SpinningAttack extends AreaAttack {

    /**
     * Constructor.
     * @param weapon the weapon used in the area attack
     */
    public SpinningAttack(Weapon weapon) {
        super(weapon);
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s uses spinning attack with %s!", actor, getWeapon());
    }
}
