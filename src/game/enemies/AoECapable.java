package game.enemies;

import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.skills.AreaAttack;

/**
 * An interface that defines an object that is able to perform aoe attacks and actions
 * @see AreaAttack
 * @see game.weapons.GiantWeapon
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public interface AoECapable {

    /**
     * Anything that is aoe capable should be able to supply the weapon that is used to perform the area attack
     * this could be a weapon item that the holder has in its inventory or a weapon that is intrinsic to the holder
     * itself such as a claw or head
     *
     * @return the weapon used in its area attack action
     */
    public Weapon getAoEWeapon();
}
