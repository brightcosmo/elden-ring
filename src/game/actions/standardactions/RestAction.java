package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.resettables.ResetEvent;
import game.enums.Status;
import game.resettables.ResetManager;

/**
 * An action that allows the player to rest, resetting the game.
 * @see game.environments.SiteOfLostGrace
 * @see game.actions.standardactions.ResetAction
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class RestAction extends Action {
	/**
	 * The name of the Site of Lost Grace
	 */
	private final String name;

	/**
	 * Constructor
	 * @param name The name of the Site of Lost Grace
	 */
	public RestAction(String name){
		this.name = name;
	}

	/**
	 * Set the player's spawn point, and reset the game.
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return A string explaining what happened to the game
	 */
	@Override
	public String execute(Actor actor, GameMap map) {
		String result = "";
		if (actor.hasCapability(Status.CAN_REST)) {
			// set the spawn point
			ResetManager.setPlayerSpawnPoint(map.locationOf(actor));
			result += actor + " rests at " + this.name;
			result += new ResetAction(ResetEvent.REST).execute(actor, map);
		}
		return result;
	}

	/**
	 * Returns a descriptive string
	 * @param actor The actor performing the action.
	 * @return the text we put on the menu
	 */
	public String menuDescription(Actor actor) {
        return actor + " rests at " + this.name;
    }
}