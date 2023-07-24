package game.combatclasses;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A combat class that each player must have. This determines the player's hitPoints and weapon.
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public abstract class CombatClass {

    /**
     * The weapon that the player will wield.
     */
    private WeaponItem weapon;

    /**
     * The HP value that the player will have.
     */
    private int hp;

    /**
     * Constructor
     * @param weapon The weapon for the player's combat class
     * @param hp The health for this combat class
     */
    public CombatClass(WeaponItem weapon, int hp) {
        this.weapon = weapon;
        this.hp = hp;
    }

    /**
     * Get the weapon
     * @return the weapon
     */
    public WeaponItem getWeapon() {
        return this.weapon;
    }

    /**
     * Get the HP value
     * @return the hp
     */
    public int getHp() {
        return this.hp;
    }
}