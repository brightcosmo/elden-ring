package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.skills.Slam;

/**
 * A class of weapons that utilize the slam action
 * important to note, these are weapons not weapon items, they function similarly to
 * intrinsic weapons but are only returned in aoe capable enemies getAoEWeapon() method
 * @see game.enemies.AoECapable
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */
public abstract class GiantWeapon implements Weapon {

    /**
     * The weapons damage
     */
    private final int damage;
    /**
     * Verb describing the weapons attack action
     */
    private final String verb;
    /**
     * The weapons chance to hit
     */
    private final int hitRate;

    /**
     * Constructor
     * @param damage damage to health
     * @param verb a word that will be printed in the action
     * @param hitRate chance to hit
     */
    public GiantWeapon(int damage, String verb, int hitRate) {
        this.damage = damage;
        this.verb = verb;
        this.hitRate = hitRate; // 50% chance to hit
    }

    /**
     * The amount of damage the Weapon will inflict
     *
     * @return the damage, in hitpoints
     */
    @Override
    public int damage() {
        return damage;
    }

    /**
     * A verb to use when displaying the results of attacking with this Weapon
     *
     * @return String, e.g. "punches", "zaps"
     */
    @Override
    public String verb() {
        return verb;
    }

    /**
     * An integer of how many percent (as dividend/100) the Actor can hit with this weapon.
     * @return a chance to hit.
     */
    @Override
    public int chanceToHit() {
        return hitRate;
    }

    /**
     * Giant weapons have the un-targeted slam skill
     * @param holder weapon holder
     * @return a slam action
     */
    @Override
    public Action getSkill(Actor holder) {
        return new Slam(this);
    }

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     * @param target target actor
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return null;
    }

    /**
     * A description of the weapon
     * @return A description of the weapon as a string
     */
    @Override
    public String toString(){
        return "no weapon";
    }
}
