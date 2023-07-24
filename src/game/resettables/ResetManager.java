package game.resettables;

import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    /**
     * Tracks the player's spawn point.
     */
    private static Location playerSpawnPoint;

    /**
     * All the resettables currently in the game
     */
    private static ArrayList<Resettable> resettables;

    /**
     * Resettables to be removed immediately after reset
     */
    private static ArrayList<Resettable> removedResettables;

    /**
     * The single instance of ResetManager
     */
    private static ResetManager instance = null;

    /**
     * Return the single instance of ResetManager, or creates one if it doesn't exist
     * @return a ResetManager instance
     */
    public static ResetManager getInstance(){
        if (instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Constructor
     */
    private ResetManager() {
        resettables = new ArrayList<>();
        removedResettables = new ArrayList<>();
    }

    /**
     * Runs the reset manager to reset all resettables
     * Then, remove any resettables that need to be removed
     * Finally, clear the list of resettables to be removed
     */
    public void run(ResetEvent trigger) {
        for (Resettable resettable: resettables) {
            resettable.reset(trigger);
        }
        for (Resettable resettable: removedResettables){
            resettables.remove(resettable);
        }
        removedResettables.clear();
    }

    /**
     * Add a resettable to the manager
     * @param resettable A resettable object
     */
    public void registerResettable(Resettable resettable) {resettables.add(resettable);}

    /**
     * Add to the removedResettables array (to be removed after the entire reset is run)
     * @param resettable A resettable object
     */
    public void removeResettable(Resettable resettable) {removedResettables.add(resettable);}

    /**
     * Get the player's spawn point
     * @return the location at the spawn point
     */
    public static Location getPlayerSpawnPoint(){
        return playerSpawnPoint;
    }

    /**
     * Update the player's spawn point
     * @param newSpawnPoint The new spawn point
     */
    public static void setPlayerSpawnPoint(Location newSpawnPoint){
        playerSpawnPoint = newSpawnPoint;
    }

    /**
     * Get the list of resettables (used for debugging and testing only)
     */
    public static ArrayList<Resettable> getResettables(){
        return resettables;
    }
}
