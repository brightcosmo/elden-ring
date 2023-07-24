package game.actions.standardactions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enums.Status;
import game.runes.RunePile;
import game.runes.RuneManager;

/**
 * An action that allows the player to pick up a RunePile, recovering their lost runes from their most recent death.
 * @see RunePile
 * @see RuneManager
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class RecoverRunesAction extends PickUpAction {

    /**
     * The runepile that was picked up.
     */
    private RunePile runePile;

    public RecoverRunesAction() {
        super(RunePile.getInstance());
        this.runePile = RunePile.getInstance();
    }

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (!actor.hasCapability(Status.NPC)){
            RuneManager.addPlayerRunes(runePile.getRuneValue());
            RunePile.removeRunePile();
            return actor + " retrieves Runes (value: " + runePile.getRuneValue() + ")";
        }
        return "";
    }
}
