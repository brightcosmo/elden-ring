package game.actions.standardactions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.resettables.ResetEvent;
import game.enums.Status;
import game.environments.SiteOfLostGrace;
import game.resettables.ResetManager;
import game.utils.FancyMessage;
import game.runes.RuneManager;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Amirul Mohammad Azizol 32619898
 * Brandon Yong Hoong Tak 32025963
 */
public class DeathAction extends Action {

    /**
     * The killer
     */
    private Actor attacker = null;

    /**
     * Constructor.
     * @param actor the targets killer
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    public DeathAction() {};

    /**
     * When the target is killed, the items and weapons carried by target
     * will be dropped to the location in the game map where the target was
     * If the target was the player, reset the game.
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        StringBuilder result = new StringBuilder();

        if (target.hasCapability(Status.HOSTILE_TO_PLAYER) || target.hasCapability(Status.FRIENDLY_TO_PLAYER)){
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getItemInventory())
                if (item.hasCapability(Status.CURRENCY)) {
                    if (!attacker.hasCapability(Status.NPC)){
                        result.append("\n").append(item.getDropAction(target).execute(target, map));
                    }
                }
                else {
                    dropActions.add(item.getDropAction(target));
                }
            if (!target.hasCapability(Status.BOSS)) {
                for (WeaponItem weapon : target.getWeaponInventory())
                    dropActions.add(weapon.getDropAction(target));
            }
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            result.append(System.lineSeparator()).append(menuDescription(target));

            if (target.hasCapability(Status.BOSS)) {
                Location here = map.locationOf(target);
                map.removeActor(target);
                here.setGround(new SiteOfLostGrace("Godrick the Grafted"));
            } else {
                map.removeActor(target);
            }
        }
        else if (!target.hasCapability(Status.NPC)){
            result.append("\n").append(FancyMessage.YOU_DIED);
            result.append("\nTarnished drops ").append(RuneManager.getPlayerRunes()).append(" runes on the ground");
            result.append(new ResetAction(ResetEvent.DEATH).execute(target, map));

            // clear player runes and respawn
            RuneManager.clearPlayerRunes();
            if (!ResetManager.getPlayerSpawnPoint().containsAnActor()) {
                map.moveActor(target, ResetManager.getPlayerSpawnPoint());
            }
        }
    return result.toString();
}

    /**
     * Returns a descriptive string
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        if (attacker != null) {
            return actor + " is killed by " + attacker;
        } else {
            return actor + " is killed";
        }
    }
}
