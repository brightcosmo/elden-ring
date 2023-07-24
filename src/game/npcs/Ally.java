package game.npcs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.standardactions.AttackAction;
import game.actions.standardactions.DespawnAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.resettables.ResetEvent;
import game.enums.Species;
import game.enums.Status;
import game.combatclasses.CombatClass;
import game.resettables.ResetManager;
import game.resettables.Resettable;

import java.util.HashMap;
import java.util.Map;

/**
 * Ally class - a friendly NPC which attacks other enemies, but not the player.
 * Allies have a chance to be summoned at any Summoning sign.
 * The ally spawns with a combat class which determines its HP and weapon.
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Ally extends Actor implements Resettable {
    /**
     * The map where the Ally was spawned
     */
    GameMap map;

    /**
     * A hashmap of behaviours and priorities
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor.
     *
     * @param combatClass the combat class which determines the Ally's HP and weapon
     * @param map the map where the Ally was spawned
     */
    public Ally(CombatClass combatClass, GameMap map) {
        super("Ally", 'A', combatClass.getHp());
        addWeaponToInventory(combatClass.getWeapon());
        addCapability(Status.HOSTILE_TO_ENEMY);
        addCapability(Status.FRIENDLY_TO_PLAYER);
        addCapability(Status.NPC);
        addCapability(Species.ALLIED);
        behaviours.put(1, new AttackBehaviour());
        behaviours.put(999, new WanderBehaviour());
        this.map = map;
    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        // follow enemies
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            behaviours.put(2, new FollowBehaviour(otherActor));
            addCapability(Status.FOLLOWING);
        }

        return new ActionList();
    }

    /**
     * Reset this ally, despawning it from the map and deregistering it as a resettable
     */
    public void reset(ResetEvent trigger) {
        if (trigger == ResetEvent.DEATH){
            ResetManager.getInstance().removeResettable(this);
            new DespawnAction().execute(this, this.map);
        }
    }
}
