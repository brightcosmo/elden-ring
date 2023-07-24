package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.Species;
import game.runes.Rune;
import game.utils.RandomNumberGenerator;

/**
 * BEHOLD, DOG!
 * Enemy that represents a Lone wolf
 * spawns from gust of wind on the west side of the map
 * won't attack other canines
 * @see game.environments.GustOfWind
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Brandon Yong Hoong Tak 32025963
 *
 */
public class LoneWolf extends Enemy {

    /**
     * Constructor.
     * @param map the map that the enemy is on
     */
    public LoneWolf(GameMap map) {
        super("Lone Wolf", 'h', 102, Species.CANINE, map);
        addItemToInventory(new Rune(RandomNumberGenerator.getRandomInt(getRuneRange()[0], getRuneRange()[1])));
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{55, 1470};
    }
}
