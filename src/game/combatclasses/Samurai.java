package game.combatclasses;

import game.weapons.Uchigatana;

/**
 * The Samurai combat class, which has an Uchigatana and 455 HP.
 * Created by:
 * @author Amirul Mohammad Azizol 32619898
 */
public class Samurai extends CombatClass {
    /**
     * Constructor
     */
    public Samurai() {
        super(new Uchigatana(), 455);
    }
}
