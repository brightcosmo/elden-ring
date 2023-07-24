package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.resettables.ResetEvent;
import game.resettables.ResetManager;

/**
 * An action that allows the player to pick up a RunePile, recovering their lost runes from their most recent death.
 * @see game.resettables.ResetManager
 * @see game.resettables.Resettable
 * @see ResetEvent
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class ResetAction extends Action {
    /**
     * The event that caused the reset
     */
    ResetEvent trigger;

    /**
     * Constructor
     *
     * @param trigger the event that caused the reset
     */
    public ResetAction(ResetEvent trigger){
        this.trigger = trigger;
    }

    /**
     * Reset the game, which performs a certain action to all resettables.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String returnStr = "\nThe game has been reset:";
        ResetManager.getInstance().run(trigger);
        if (trigger == ResetEvent.DEATH){
            returnStr += "\n  All allies and invaders have been despawned";
        }
        returnStr += "\n  All enemies have been despawned";
        returnStr += "\n  Tarnished's HP and flask usage has been reset";
        return returnStr;
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
