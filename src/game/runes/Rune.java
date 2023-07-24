package game.runes;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import game.actions.standardactions.GiveRunesAction;
import game.enums.Status;

/**
 * Class used to represent runes, the in-game currency.
 * This is mainly used when runes have to be dropped and picked up within the same turn (as opposed to RunePile)
 * @see game.runes.RuneManager
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Rune extends Item {

    /**
     * Amount of runes stored in an instance.
     */
    int runeValue;

    /**
     * Constructor
     * @param runeValue The value of runes for the rune object
     */
    public Rune(int runeValue) {
        super("Rune", ' ', true);
        this.runeValue = runeValue;
        this.addCapability(Status.CURRENCY);
    }

    /**
     * Getter for runes
     * @return amount of runes
     */
    public int getRuneValue() {
        return runeValue;
    }

    /**
     * Setter for runes
     * @param runes new amount of runes to be set
     */
    public void setRuneValue(int runes) {
        this.runeValue = runes;
    }

    /**
     * Adds to amount of runes
     * @param runeValue amount to be added
     */
    public void addRunes(int runeValue){this.runeValue += runeValue;}

    /**
     * Subtracts from amount of runes
     * @param runeValue amount to be subtracted
     */
    public void subtractRunes(int runeValue){this.runeValue -= runeValue;}

    /**
     * Provides String representation of Rune instances
     * @return String of numbers showing amount in Rune instance
     */
    @Override
    public String toString() {
        return String.valueOf(runeValue);
    }

    /**
     * Override the drop action with a special drop action
     * @param actor The actor to recieve runes
     * @return A special drop action that provides runes to the actor
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        return new GiveRunesAction(this);
    }
}
