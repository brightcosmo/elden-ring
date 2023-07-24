package game.runes;

/**
 * Class used to represent runes, the in-game currency.
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class RuneManager {

    /**
     * Gets the player's runes
     */
    private static int playerRunes;

    /**
     * Gets the player's runes
     * @return The player's runes
     */
    public static int getPlayerRunes(){
        return playerRunes;
    }

    /**
     * Adds to the player's runes
     * @param playerRunes value to add
     */
    public static void addPlayerRunes(int playerRunes){
        RuneManager.playerRunes += playerRunes;
    }

    /**
     * Subtracts the player's runes, unless the value exceeds their current runes
     * @param playerRunes value to subtract
     * @return boolean value showing whether the subtraction was successful
     */
    public static boolean subtractPlayerRunes(int playerRunes){
        if (RuneManager.playerRunes >= playerRunes){
            RuneManager.playerRunes -= playerRunes;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Sets the player's rune count to 0
     */
    public static void clearPlayerRunes(){
        RuneManager.playerRunes = 0;
    }


    /**
     * Returns the single RunePile instance
     * @return the RunePile instance
     */
    public static RunePile getRunePile() {return RunePile.getInstance();}
}
