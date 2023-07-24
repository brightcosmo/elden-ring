package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Enemy;
import game.enemies.EnemyFactory;

public class Barracks extends Spawner {

    /**
     * Constructor.
     */
    public Barracks() {
        super('B');
    }

    @Override
    public Enemy spawnEnemy(Location location) {
        if (spawnChanceCheck(45)) {
            return EnemyFactory.createGodrickSoldier(location.map());
        } else {
            return null;
        }
    }
}
