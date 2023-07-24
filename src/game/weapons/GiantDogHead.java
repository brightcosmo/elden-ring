package game.weapons;

/**
 * Giant head of the giant dog
 * Only used in its slam attack
 * It deals 314 damage with 90% hit rate
 * @see game.enemies.GiantDog
 * @see game.actions.skills.Slam
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */
public class GiantDogHead extends GiantWeapon {

    /**
     * Constructor.
     */
    public GiantDogHead() {
        super(314, "slams", 90);
    }
}
