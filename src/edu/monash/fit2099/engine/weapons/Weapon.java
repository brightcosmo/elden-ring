package edu.monash.fit2099.engine.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for weapon items.
 *
 * As well as providing methods needed by weapons, this interface is used in Item to
 * determine whether an item can be used as a weapon.
 */
public interface Weapon {

	/**
	 * The amount of damage the Weapon will inflict
	 *
	 * @return the damage, in hitpoints
	 */
	int damage();

	/**
	 * A verb to use when displaying the results of attacking with this Weapon
	 *
	 * @return String, e.g. "punches", "zaps"
	 */
	String verb();

	/**
	 * A chance to hit the target (this is the dividend of percentage)
	 *
	 * @return the chance, in integer for probability with nextInt()
	 */
	int chanceToHit();

	/**
	 * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
	 * against one targeted Actor (i.e, special attack, heal, stun, etc.).
	 * @param target target actor
	 * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
	 */
	default Action getSkill(Actor target, String direction){
		return new DoNothingAction();
	}

	/**
	 * Get an active skill action from the weapon. This should be used for weapon skills that do not involve a target actor
	 * For instance, healing the holder of the weapon, switching current weapon's attack, e.g. from normal attack to fire attack
	 * @param holder weapon holder
	 * @return a special Action that can be performed by this weapon (heal the player, etc.)
	 */
	default Action getSkill(Actor holder) {
		return null;
	}

}
