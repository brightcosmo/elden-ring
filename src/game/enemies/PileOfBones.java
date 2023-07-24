package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.enums.Species;
import game.runes.Rune;
import game.utils.RandomNumberGenerator;

/**
 * An enemy that represents a Pile of bones
 * spawned by skeletal enemies on death, does nothing for 3 turns before reviving into a new skeletal enemy
 * @see SkeletalEnemy
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class PileOfBones extends Enemy {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSTANCE VARS                                                                                  //
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * A counter representing the number of turns to spawn
     */
    private int counter = 3;
    /**
     * The skeletal enemy to spawn
     */
    private SkeletalEnemy spawnedEnemy;

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR                                                                                   //
    //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor.
     * @param spawnedEnemy the skeletal enemy to spawn after 3 turns
     * @param map the map that the enemy is on
     */
    public PileOfBones(SkeletalEnemy spawnedEnemy, GameMap map) {
        super("Pile Of Bones", 'X', 1, Species.SKELETAL, map);
        this.spawnedEnemy = spawnedEnemy;
        addItemToInventory(spawnedEnemy.getWeaponInventory().get(0));
        addItemToInventory(new Rune(RandomNumberGenerator.getRandomInt(getRuneRange()[0], getRuneRange()[1])));
    }

    /**
     * Select and return an action to perform on the current turn.
     * In the case of pile of bones, it does nothing for 3 turns before spawning a new skeletal enemy in its place
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (counter == 0) {
            Location here = map.locationOf(this);
            map.removeActor(this);
            here.addActor(spawnedEnemy);
        } else {
            counter -= 1;
        }
        return new DoNothingAction();
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{35, 892};
    }
}
