package game.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.behaviours.AoEBehaviour;
import game.behaviours.Behaviour;
import game.resettables.ResetEvent;
import game.enums.Species;
import game.enums.Status;
import game.items.RemembranceOfTheGrafted;
import game.runes.Rune;
import game.utils.RandomNumberGenerator;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;

/**
 * An enemy representing the boss Godrick the Grafted, 2 phase fight that triggers when enemy reaches half hp
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public class GodrickTheGrafted extends Enemy implements AoECapable {

    /**
     * phase one weapon for Godrick, saved, so it can be removed later
     */
    AxeOfGodrick phaseOneWeapon = new AxeOfGodrick();

    /**
     * Constructor.
     */
    public GodrickTheGrafted(GameMap map) {
        super("Godrick the Grafted", 'Y', 6080, Species.GODRICK, map);
        addCapability(Status.BOSS);
        addWeaponToInventory(phaseOneWeapon);
        addItemToInventory(new RemembranceOfTheGrafted());
        addItemToInventory(new Rune(RandomNumberGenerator.getRandomInt(getRuneRange()[0], getRuneRange()[1])));
        this.behaviours.put(0, new AoEBehaviour(this));
    }

    /**
     * Select and return an action to perform on the current turn.
     * for enemies, this is done via behaviours so the action list is not accessed at all
     * For Godrick, involves a check for the bosses hp and the necessary logic to swap weapons
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (hitPoints <= (6080/2)) {
            removeWeaponFromInventory(phaseOneWeapon);
            addWeaponToInventory(new GraftedDragon());
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
     * Get the range of runes to give to the player if they killed us.
     * Any enemy that drops runes will override this method with values above 0. (By default, drop no runes)
     * @return an array of the integers with the lower and upper bound
     */
    @Override
    public int[] getRuneRange(){
        return new int[]{20000, 20000};
    }

    /**
     * Reset this enemy, resetting its hp and location
     */
    @Override
    public void reset(ResetEvent trigger) {
        if (isConscious()) {
            resetMaxHp(6080);
            Location here = currMap.locationOf(this);
            if (!here.containsAnActor()) {
                currMap.moveActor(this, currMap.at(24, 7));
            }
        };
    }

    /**
     * Anything that is aoe capable should be able to supply the weapon that is used to perform the area attack
     * this could be a weapon item that the holder has in its inventory or a weapon that is intrinsic to the holder
     * itself such as a claw or head. In Godrick's case, he returns his current phases weapon.
     *
     * @return the weapon used in its area attack action
     */
    @Override
    public Weapon getAoEWeapon() {
        return getWeaponInventory().get(0);
    }
}

