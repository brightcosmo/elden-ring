package game.actions.skills;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * A class that extends AreaAttack and represents an area attack using an actors giant weapon
 * @see AreaAttack
 * @see game.weapons.GiantWeapon
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class Slam extends AreaAttack {

    /**
     * Constructor.
     * @param weapon the weapon used in the area attack
     */
    public Slam(Weapon weapon) {
        super(weapon);
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s slams everything!", actor);
    }
}
