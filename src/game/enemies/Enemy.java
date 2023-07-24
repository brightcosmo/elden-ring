package game.enemies;

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
import game.resettables.ResetManager;
import game.resettables.Resettable;
import game.utils.RandomNumberGenerator;

import java.util.HashMap;
import java.util.Map;

public abstract class Enemy extends Actor implements Resettable {

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // INSTANCE VARS                                                                                  //
    ////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * A hashmap of behaviours and priorities
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * The current map that the enemy is on
     */
    protected GameMap currMap;

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR                                                                                    //
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Constructor.
     * @param name the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints the Actor's starting hit points
     * @param species the enemies species
     * @param map the map that the enemy is on
     */
    public Enemy(String name, char displayChar, int hitPoints, Species species, GameMap map) {
        super(name, displayChar, hitPoints);
        addCapability(species);
        addCapability(Status.HOSTILE_TO_PLAYER);
        addCapability(Status.NPC);
        // common behaviours
        behaviours.put(1, new AttackBehaviour());
        behaviours.put(999, new WanderBehaviour());
        this.currMap = map;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // OVERRIDDEN METHODS                                                                            //
    //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    @Override // this kind of acts as a pulse, enemies will trigger this when they get close to this enemy
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {

        //////////////////////////////////STUFF FOR THIS ACTOR///////////////////////////////////////////

        // first check if the otherActor is the player
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            behaviours.put(2, new FollowBehaviour(otherActor));
            addCapability(Status.FOLLOWING);
        }

        //////////////////////////////////STUFF FOR THE OTHER ACTOR//////////////////////////////////////

        // create a new action list to compile all the actions that can be performed on this actor
        ActionList actions = new ActionList();

        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {

            otherActor.addCapability(Status.IN_COMBAT);
            // create an attack action on this actor with all weapons in the other actors inventory
            // helps enforce the rule that enemies attack with the first weapon in their inventory
            for (WeaponItem weapon : otherActor.getWeaponInventory()) {
                actions.add(new AttackAction(this, direction, weapon));
                if (weapon.getSkill(this, direction) != null) {
                    actions.add(weapon.getSkill(this, direction)); // this adds all targeted skills
                }
            }
            actions.add(new AttackAction(this, direction)); // add an attack action with the intrinsic weapon
        }

        // we may also want to present the option to use skills to the other actor
        return actions;
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CONCRETE METHODS                                                                              //
    //////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Reset this enemy, despawning it from the map and deregistering it as a resettable
     */
    public void reset(ResetEvent trigger) {
        ResetManager.getInstance().removeResettable(this);
        new DespawnAction().execute(this, this.currMap);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // GETTERS AND SETTERS                                                                           //
    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Get this enemies behaviour map
     * @return the enemies behaviour map
     */
    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }

    /**
     * Sets the enemies behaviour map to a new one
     * @param behaviours a new behaviour map
     */
    public void setBehaviours(Map<Integer, Behaviour> behaviours) {
        this.behaviours = behaviours;
    }

    /**
     * Get the range of runes to give to the player if they killed us.
     * Any enemy that drops runes will override this method with values above 0. (By default, drop no runes)
     * @return an array of the integers with the lower and upper bound
     */
    public int[] getRuneRange(){
        return new int[]{0, 0};
    };
}
