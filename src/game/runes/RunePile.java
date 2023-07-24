package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.*;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.standardactions.RecoverRunesAction;
import game.resettables.ResetEvent;
import game.resettables.ResetManager;
import game.resettables.Resettable;

/**
 * An item dropped during the player's death, which stores the runes they had.
 * If the player dies before picking up this object, it will appear at the
 * latest location of death with the latest rune value of the player.
 *
 * @see game.runes.RuneManager
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class RunePile extends Item implements Resettable {

    /**
     * The value of runes that were dropped
     */
    static int runeValue;

    /**
     * The player's last location
     */
    static Location playerLocation;

    /**
     * The location of the currently existing RunePile (if it exists)
     */
    static Location currentLocation;

    /**
     * The single instance of RunePile
     */
    private static RunePile instance;

    /**
     * Constructor
     */
    private RunePile(){
        super("Runes", '$', true);
        runeValue = 0;
        playerLocation = null;
    }

    /**
     * Return the single instance of RunePile, or creates one if it doesn't exist
     * @return a RunePile instance
     */
    public static RunePile getInstance() {
        if (instance == null) {
            instance = new RunePile();
            ResetManager.getInstance().registerResettable(instance);
        }
        return instance;
    }

    /**
     * Remove the RunePile from its current location
     * This is used if the player recovers the Runes, OR if they died again before doing so
     */
    public static void removeRunePile(){
        if (currentLocation != null){
            currentLocation.removeItem(instance);
        }
    }

    /**
     * Reset the RunePile, giving it a new value, removing it from its old location, and adding it to the new one
     * Note: this is just a reset method but RunePile is not actually a Resettable as it does not change when the player rests
     */
    public void reset(ResetEvent trigger) {
        if (trigger == ResetEvent.DEATH){
            instance.setRuneValue(RuneManager.getPlayerRunes());
            removeRunePile();
            currentLocation = playerLocation;
            currentLocation.addItem(instance);
        }
    }

	/**
	 * Return the custom action when the player tries to pick up the RunePile
	 * 
	 * @return a new RecoverRunesAction
	 */
    @Override
	public PickUpAction getPickUpAction(Actor actor) {
		return new RecoverRunesAction();
	}

    /**
     * Get the player's last location
     * @return the location
     */
    public static Location getPlayerLocation() {
        return playerLocation;
    }

    /**
     * Update the player's last location
     * @param playerLocation The new location
     */
    public static void setPlayerLocation(Location playerLocation) {
        RunePile.playerLocation = playerLocation;
    }

    /**
     * Get the rune value
     */
    public int getRuneValue() {
        return runeValue;
    }

    /**
     * Update the rune value
     * @param runes The new value
     */
    public void setRuneValue(int runes) {
        RunePile.runeValue = runes;
    }

}
