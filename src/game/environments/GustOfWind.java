package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Enemy;
import game.enemies.EnemyFactory;

/**
 * A class that extends spawner and represents a gust of wind
 * will spawn lone wolves on the west side of the map and giant dogs on the east
 * @see game.enemies.LoneWolf
 * @see game.enemies.GiantDog
 * @see Spawner
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */
public class GustOfWind extends Spawner {

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR                                                                                    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor.
     */
    public GustOfWind() {
        super('&');
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
        if (isWest(location) && spawnChanceCheck(33)) { // if were west and pass a spawn check, spawn x
            return EnemyFactory.createLoneWolf(location.map());
        } else if (!isWest(location) && spawnChanceCheck(4)) { // if were east and pass a spawn check, spawn y
            return EnemyFactory.createGiantDog(location.map());
        } else {
            return null; // else spawn nothing
        }
    }
}
