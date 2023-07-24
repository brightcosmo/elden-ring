package game.actions.standardactions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.runes.Rune;
import game.runes.RuneManager;

/**
 * An action that gives runes to the player when runes are dropped.
 * @see game.runes.RuneManager
 * @see game.enemies.Enemy
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class GiveRunesAction extends DropAction {

    /**
     * The rune object that was dropped
     */
    private final Rune runes;

    /**
     * Constructor.
     * @param runes The rune object that was dropped
     */
    public GiveRunesAction(Rune runes){
        super(runes);
        this.runes = runes;
    }

    /**
     * Add runes to the player, and return the amount received
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The number of runes received by the player
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        RuneManager.addPlayerRunes(runes.getRuneValue());
        return "Tarnished receives " + runes.getRuneValue() + " runes";
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
