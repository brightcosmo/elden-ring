package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enums.Species;
import game.runes.Rune;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantCrayfishPincer;

/**
 * An enemy that represents a Giant crayfish
 * spawns from puddle of water on the east side of the map and is capable of performing a slam attack
 * won't attack other crustaceans
 * @see game.actions.skills.Slam
 * @see game.environments.PuddleOfWater
 * @see GiantCrayfishPincer
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class GiantCrayfish extends GiantEnemy {

    /**
     * Constructor.
     * @param map the map that the enemy is on
     */
    public GiantCrayfish(GameMap map) {
        super("Giant Crayfish", 'R', 4803, Species.CRUSTACEAN, map);
        addItemToInventory(new Rune(RandomNumberGenerator.getRandomInt(getRuneRange()[0], getRuneRange()[1])));
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(527, "slams", 100);
    }

    /**
     * Anything that is aoe capable should be able to supply the weapon that is used to perform the area attack
     * this could be a weapon item that the holder has in its inventory or a weapon that is intrinsic to the holder
     * itself such as a claw or head
     *
     * @return the weapon used in its area attack action
     */
    @Override
    public Weapon getAoEWeapon() {
        return new GiantCrayfishPincer();
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{500, 2374};
    }
}
