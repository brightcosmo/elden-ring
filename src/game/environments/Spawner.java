package game.environments;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemies.Enemy;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents a ground object that is capable of spawning an enemy
 * makes use of the enemy factory to spawn most things
 * @see game.enemies.EnemyFactory
 * @see Enemy
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */
public abstract class Spawner extends Ground {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR                                                                                    //
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor.
     * @param displayChar the character representing this ground on the map
     */
    public Spawner(char displayChar) {
        super(displayChar);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // OVERRIDDEN METHODS                                                                             //
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Ground can also experience the joy of time.
     * spawners will add enemies they have spawned to the map on tick
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor()) { // check if the location does not contain an actor

            // receive an enemy object or null
            Enemy enemy = spawnEnemy(location);

            if (enemy != null) { // if the object is not null, spawn the enemy
                location.map().at(location.x(), location.y()).addActor(enemy);
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONCRETE METHODS                                                                               //
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Method to check if a spawner is on the east or west side of the map
     * @param location The location of the Ground
     * @return true if it is west false if east
     */
    public boolean isWest(Location location) {

        // get the current grounds x value and the current game maps max x value
        int curr_x = location.x();
        int max_x = location.map().getXRange().max();

        // if the current x position is greater than the total x value // 2, then it must be west
        return curr_x <= (max_x/2); // true is west, false is east
    }

    /**
     * A method that dice rolls to see if an enemy will spawn or not
     * @param chanceToSpawn the percentage chance for the enemy to spawn
     * @return true if it passes the check, false if it does not
     */
    public boolean spawnChanceCheck(int chanceToSpawn) {

        // generate a random integer from 1 to 100
        int randomInt = RandomNumberGenerator.getRandomInt(1,100);
        return chanceToSpawn >= randomInt; // if our chance to spawn is greater or equal to the number then return true

        // some examples of how this works:
        // if our chance to spawn 1%, then there is only 1 random integer it is >= to, which is 1. Hence, 1/100 spawn chance
        // if our spawn chance is 0%, then there are no random integers it is greater >= to.
        // if our spawn chance is 100% then it is >= to all random integers.
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // ABSTRACT METHODS                                                                               //
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * A method that spawns the associated spawners enemy
     * If the spawn chance check fails, this will just return null
     * @param location The location of the Ground
     * @return the spawners associated enemy or null
     */
    public abstract Enemy spawnEnemy(Location location);
}
