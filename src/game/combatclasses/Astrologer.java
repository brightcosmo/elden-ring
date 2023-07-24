package game.combatclasses;

import game.weapons.AstrologerStaff;

/**
 * The Bandit combat class, which has an Astrologer's staff and 396 HP.
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Astrologer extends CombatClass {
    /**
     * Constructor
     */
    public Astrologer() {
        super(new AstrologerStaff(), 396);
    }
}
