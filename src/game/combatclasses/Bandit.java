package game.combatclasses;

import game.weapons.GreatKnife;

/**
 * The Bandit combat class, which has a Great Knife and 414 HP.
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Bandit extends CombatClass {
    /**
     * Constructor
     */
    public Bandit() {
        super(new GreatKnife(), 414);
    }
}
