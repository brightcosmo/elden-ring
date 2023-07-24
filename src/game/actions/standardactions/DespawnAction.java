package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.resettables.ResetManager;

/**
 * An Action to despawn another Actor.
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class DespawnAction extends Action {

    /**
     * despawns the actor from the game
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return The result of the transaction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return String.format("%s despawned", actor);
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("despawn %s", actor);
    }
}
