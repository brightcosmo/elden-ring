package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Species;
import game.runes.Rune;
import game.utils.RandomNumberGenerator;
import game.weapons.HeavyCrossbow;

/**
 * An enemy reprsenting a Godrick solder from Stormveil castle
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class GodrickSoldier extends Enemy {

    /**
     * Constructor.
     */
    public GodrickSoldier(GameMap map) {
        super("Godrick Soldier", 'p', 198, Species.GODRICK, map);
        addItemToInventory(new Rune(RandomNumberGenerator.getRandomInt(getRuneRange()[0], getRuneRange()[1])));
        addWeaponToInventory(new HeavyCrossbow());
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * Any enemy that drops runes will override this method with values above 0. (By default, drop no runes)
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{38, 70};
    }
}

