package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enums.Species;
import game.utils.RandomNumberGenerator;
import game.runes.Rune;

/**
 * an enemy representing a dog in Stormveil castle
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class Dog extends Enemy {

    /**
     * Constructor.
     */
    public Dog(GameMap map) {
        super("Dog", 'a', 104, Species.GODRICK, map);
        addItemToInventory(new Rune(RandomNumberGenerator.getRandomInt(getRuneRange()[0], getRuneRange()[1])));
    }

    /**
     * Creates and returns an intrinsic weapon.
     *
     * @return a freshly-instantiated IntrinsicWeapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * Any enemy that drops runes will override this method with values above 0. (By default, drop no runes)
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{52, 1390};
    }
}