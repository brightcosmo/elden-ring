package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Enemy;
import game.enemies.EnemyFactory;

/**
 * A class that extends spawner and represents a puddle of water
 * will spawn giant crab on the west side of the map and giant crayfish on the east
 * @see game.enemies.GiantCrab
 * @see game.enemies.GiantCrayfish
 * @see Spawner
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */
public class PuddleOfWater extends Spawner {

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR                                                                                    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor.
     */
    public PuddleOfWater() {
        super('~');
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // OVERRIDDEN METHODS                                                                            //
    //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * A method that spawns the associated spawners enemy
     * If the spawn chance check fails, this will just return null
     * @param location The location of the Ground
     * @return the spawners associated enemy or null
     */
    @Override
    public Enemy spawnEnemy(Location location) {
        if (isWest(location) && spawnChanceCheck(2)) { // if were west and pass a spawn check, spawn x
            return EnemyFactory.createGiantCrab(location.map());
        } else if (!isWest(location) && spawnChanceCheck(1)) { // if were east and pass a spawn check, spawn y
            return EnemyFactory.createGiantCrayfish(location.map());
        } else {
            return null; // else spawn nothing
        }
    }
}
