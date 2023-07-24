package game.npcs;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.standardactions.DespawnAction;
import game.behaviours.Behaviour;
import game.enemies.Enemy;
import game.resettables.ResetEvent;
import game.enums.Species;
import game.combatclasses.CombatClass;
import game.resettables.ResetManager;
import game.resettables.Resettable;

/**
 * Invader class - a new type of enemy NPC which only despawns once the player dies.
 * Invaders have a chance to be summoned at any Summoning sign.
 * The invader spawns with a combat class which determines its HP and weapon.
 *
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Invader extends Enemy implements Resettable {
    /**
     * Constructor.
     *
     * @param combatClass the combat class which determines the Invader's HP and weapon
     * @param map the map where the Invader was spawned
     */
    public Invader(CombatClass combatClass, GameMap map) {
        super("Invader", 'ඞ', combatClass.getHp(), Species.INVADER, map);
        addWeaponToInventory(combatClass.getWeapon());
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{1358, 5578};
    }

    /**
     * Select and return an action to perform on the current turn.
     * for enemies, this is done via behaviours so the action list is not accessed at all
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // turn logic here
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }

    /**
     * Reset this invader, despawning it from the map and deregistering it as a resettable
     * This is overridden as Invader only despawns if the player died (unlike enemies)
     */
    @Override
    public void reset(ResetEvent trigger) {
        if (trigger == ResetEvent.DEATH){
            ResetManager.getInstance().removeResettable(this);
            new DespawnAction().execute(this, this.currMap);
        }
    }}
