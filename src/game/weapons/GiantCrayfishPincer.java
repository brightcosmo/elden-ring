package game.weapons;

/**
 * Giant pincer of the giant crayfish
 * Only used in its slam attack
 * It deals 527 damage with 100% hit rate
 * @see game.enemies.GiantCrayfish
 * @see game.actions.skills.Slam
 *
 * Created by:
 * @author Brandon Yong Hoon Tak 32025963
 * Modified by:
 *
 */

public class GiantCrayfishPincer extends GiantWeapon {

    /**
     * Constructor.
     */
    public GiantCrayfishPincer() {
        super(527, "slams", 100);
    }
}
