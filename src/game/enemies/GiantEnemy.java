package game.enemies;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.behaviours.AoEBehaviour;
import game.enums.Species;

/**
 * A class of enemies that implement aoe capable and can perform slam attacks with their giant bodies
 * @see game.actions.skills.Slam
 * @see AoECapable
 *
 * Created by:
 * @author Brandon Yong Hoong Tak 32025963
 * Modified by:
 *
 */
public abstract class GiantEnemy extends Enemy implements AoECapable {

    /**
     * Constructor.
     * @param name the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints the Actor's starting hit points
     * @param species the enemies species
     * @param map the map where the enemy is on
     */
    public GiantEnemy(String name, char displayChar, int hitPoints, Species species, GameMap map) {
        super(name, displayChar, hitPoints, species, map);
        this.behaviours.put(0, new AoEBehaviour(this));
    }
}
