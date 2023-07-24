package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Enemy;
import game.enemies.EnemyFactory;

/**
 * A spawner that spawns Dogs
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class Cage extends Spawner {

    /**
     * Constructor.
     */
    public Cage() {
        super('<');
    }

    /**
     * A method that spawns the associated spawners enemy
     * If the spawn chance check fails, this will just return null
     * @param location The location of the Ground
     * @return the spawners associated enemy or null
     */
    @Override
    public Enemy spawnEnemy(Location location) {
        if (spawnChanceCheck(37)) {
            return EnemyFactory.createDog(location.map());
        } else {
            return null;
        }
    }
}

