package game.weapons;

/**
 * Giant crab claw of the giant crab
 * Only used in its slam attack
 * It deals 208 damage with 90% hit rate
 * @see game.enemies.GiantCrab
 * @see game.actions.skills.Slam
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */
public class GiantCrabClaw extends GiantWeapon {

    /**
     * Constructor.
     */
    public GiantCrabClaw() {
        super(208, "slams", 90);
    }
}
