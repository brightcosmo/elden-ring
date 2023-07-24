package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import game.actions.skills.SpinningAttack;

/**
 * A class of weapon items that utilize the spinning attack action
 * @see game.enemies.AoECapable
 * @see SpinningAttack
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by: Nisha Kannapper 31121993
 *
 */
public abstract class Sword extends TradableWeapon {

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public Sword(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * Swords have the un-targeted spinning attack skill
     * @param holder weapon holder
     * @return a spinning attack action
     */
    @Override
    public Action getSkill(Actor holder) {
        return new SpinningAttack(this);
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
}
