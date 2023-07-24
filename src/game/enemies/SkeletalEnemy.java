package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.standardactions.DespawnAction;
import game.behaviours.AoEBehaviour;
import game.behaviours.Behaviour;
import game.enums.Species;
import game.enums.Status;
import game.utils.RandomNumberGenerator;
import game.weapons.GiantDogHead;

/**
 * A class of enemies who turn into a pile of bones on death before reviving
 * Also implements AoECapable to perform their spinning attack
 * @see PileOfBones
 * @see AoECapable
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public abstract class SkeletalEnemy extends Enemy implements AoECapable {

    /**
     * Constructor.
     * @param name the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints the Actor's starting hit points
     * @param species the enemies species
     * @param map the map where the enemy is on
     */
    public SkeletalEnemy(String name, char displayChar, int hitPoints, Species species, GameMap map) {
        super(name, displayChar, hitPoints, species, map);
        addCapability(Status.UNDEAD);
        this.behaviours.put(0, new AoEBehaviour(this));
    }

    /**
     * Select and return an action to perform on the current turn.
     * for enemies, this is done via behaviours so the action list is not accessed at all
     * skeletal enemies have the added logic for spawning a pile of bones on their turn if they die
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (!isConscious()) {
            display.println(String.format("%s becomes a pile of bones!", this));
            // get the targets location
            Location location = map.locationOf(this);
            // remove actor
            map.removeActor(this);
            // spawn a pile of bones in its place
            location.map().at(location.x(), location.y()).addActor(EnemyFactory.createPileOfBones(getNewSkeleton(map), map));
            return new DoNothingAction();
        }

        // de-spawn logic here
        int randomInt = RandomNumberGenerator.getRandomInt(1,100);
        if (!this.hasCapability(Status.FOLLOWING) && (10 >= randomInt)) {
            return new DespawnAction();
        }

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
     * Anything that is aoe capable should be able to supply the weapon that is used to perform the area attack
     * this could be a weapon item that the holder has in its inventory or a weapon that is intrinsic to the holder
     * itself such as a claw or head
     *
     * @return the weapon used in its area attack action
     */
    @Override
    public Weapon getAoEWeapon() {
        return getWeaponInventory().get(0);
    }

    public abstract SkeletalEnemy getNewSkeleton(GameMap map);
}
